/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;


import Model.OrdenEntrada;
import service.OrdenEntradaFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Dell
 */
@Named(value = "controllerOrdenEntrada")
@SessionScoped
public class ControllerOrdenEntrada implements Serializable {

    /**
     * Definicion de variables
     */
    private String message;
    private OrdenEntrada entrada = new OrdenEntrada();
    
    @EJB
    
    private OrdenEntradaFacade entradafacade;
    
   
    //crud orden de Entrada
    public List<OrdenEntrada> getALLOrdenEntrada() {
        return getEntradafacade().findAll();
    }

    public void eliminar(int id) {
        OrdenEntrada ordenEntrada = new OrdenEntrada();
        ordenEntrada.setIdOrdenEntrada(id);
        getEntradafacade().remove(ordenEntrada);
        
       
    }

    public void create() {
        getEntradafacade().create(getEntrada());

        
    }

    public void update(int id) {
        getEntrada().setIdOrdenEntrada(id);
        getEntradafacade().edit(getEntrada());
        setMessage("Se actualizo orden entrada correctamente");
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
     * @return the entrada
     */
    public OrdenEntrada getEntrada() {
        return entrada;
    }

    /**
     * @param entrada the entrada to set
     */
    public void setEntrada(OrdenEntrada entrada) {
        this.entrada = entrada;
    }

    /**
     * @return the entradafacade
     */
    public OrdenEntradaFacade getEntradafacade() {
        return entradafacade;
    }

    /**
     * @param entradafacade the entradafacade to set
     */
    public void setEntradafacade(OrdenEntradaFacade entradafacade) {
        this.entradafacade = entradafacade;
    }


  

       
    }
