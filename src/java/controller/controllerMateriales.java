/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import Model.Materiales;
import service.MaterialesFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;

/**
 *
 * @author Dell
 */
@Named(value = "controllerMateriales")
@SessionScoped

public class controllerMateriales implements Serializable {

    /**
     * Creates a new instance of cotrollerOrdenSalida
     */
    public controllerMateriales() {
    }

    //creacion de las variables
    private String message;

    private Materiales material = new Materiales();
    
    @EJB

    private MaterialesFacade materialfacade;

    //crud materiales
    public List<Materiales> getALLMateriales() {
        return getMaterialfacade().findAll();
    }

    public void delete(int id) {
        Materiales materiales = new Materiales();
        materiales.setIdMateriales(id);
        getMaterialfacade().remove(getMaterial());
        setMessage("Se elimino material correctamente");
    }

    public void create() {
        getMaterialfacade().create(getMaterial());
        setMessage("se creo correctamente");
    }

    public void update(int id) {

        getMaterial().setIdMateriales(id);
        getMaterialfacade().edit(getMaterial());
      
        setMessage("Se actualizo material correctamente");

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
     * @return the material
     */
    public Materiales getMaterial() {
        return material;
    }

    /**
     * @param material the material to set
     */
    public void setMaterial(Materiales material) {
        this.material = material;
    }

    /**
     * @return the materialfacade
     */
    public MaterialesFacade getMaterialfacade() {
        return materialfacade;
    }

    /**
     * @param materialfacade the materialfacade to set
     */
    public void setMaterialfacade(MaterialesFacade materialfacade) {
        this.materialfacade = materialfacade;
    }

    
   
}
