/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import Model.Proveedores;
import service.ProveedoresFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author kevv_
 */
@Named(value = "controllerProveedores")
@SessionScoped
public class controllerProveedores implements Serializable {

    //ingreso de variables
    private Proveedores proveedores = new Proveedores();
    @EJB
    private ProveedoresFacade proveedoresfacade;

    //crud 
    public List<Proveedores> getALLProveedores() {
        return getProveedoresfacade().findAll();
    }

    public void create() {
        getProveedoresfacade().create(getProveedores());

    }

    public void Delete(int id) {
        Proveedores proveedor = new Proveedores();
        proveedor.setCodproveedores(id); 
        getProveedoresfacade().remove(proveedor);
    } 
    public void update(int id){
        getProveedores().setCodproveedores(id);
        getProveedoresfacade().edit(getProveedores());    
        
    } 
    

    public controllerProveedores() {

    }

    /**
     * @return the proveedores
     */
    public Proveedores getProveedores() {
        return proveedores;
    }

    /**
     * @param proveedores the proveedores to set
     */
    public void setProveedores(Proveedores proveedores) {
        this.proveedores = proveedores;
    }

    /**
     * @return the proveedoresfacade
     */
    public ProveedoresFacade getProveedoresfacade() {
        return proveedoresfacade;
    }

    /**
     * @param proveedoresfacade the proveedoresfacade to set
     */
    public void setProveedoresfacade(ProveedoresFacade proveedoresfacade) {
        this.proveedoresfacade = proveedoresfacade;
    }

}
