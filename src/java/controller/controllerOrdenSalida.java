/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import Model.OrdenSalida;
import service.OrdenSalidaFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Admin
 */
@Named(value = "controllerOrdenSalida")
@SessionScoped
public class controllerOrdenSalida implements Serializable {

    /**
     * Creates a new instance of cotrollerOrdenSalida
     */
    public controllerOrdenSalida() {
    }
    
    //creacion de las variables

    private String message;

    private OrdenSalida orden = new OrdenSalida();

    @EJB

    private OrdenSalidaFacade ordensalida;
    
    
    //crud orden de salida

    public List<OrdenSalida> getALLOrdenSalida() {
        return getOrdensalida().findAll();
    }

    public void delete(int id) {

        OrdenSalida Salida = new OrdenSalida();
        Salida.setIdOrden(id);
        getOrdensalida().remove(Salida);
        setMessage("se elimino correctamente");
    }

    public void create() {
        getOrdensalida().create(getOrden());
        setMessage("se creo correctamente");
    }

    public void update(int id) {

        getOrden().setIdOrden(id);
        getOrdensalida().edit(getOrden());
        setMessage("se actualizo correctamente");

    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the orden
     */
    public OrdenSalida getOrden() {
        return orden;
    }

    /**
     * @param orden the orden to set
     */
    public void setOrden(OrdenSalida orden) {
        this.orden = orden;
    }

    /**
     * @return the ordensalida
     */
    public OrdenSalidaFacade getOrdensalida() {
        return ordensalida;
    }

    /**
     * @param ordensalida the ordensalida to set
     */
    public void setOrdensalida(OrdenSalidaFacade ordensalida) {
        this.ordensalida = ordensalida;
    }
    
    
    

}
