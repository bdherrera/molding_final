/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import Model.Clientes;
import service.ClientesFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Admin
 */
@Named(value = "controllerClientes")
@SessionScoped
public class controllerClientes implements Serializable {

    //definicion de variables
    private String mensaje;
    private Clientes clientes = new Clientes();
    @EJB
    private ClientesFacade clientesfacade;

    //crud
    public List<Clientes> getALLClientes() {
        return getClientesfacade().findAll();
    }

    public void eliminar(int id) {
        Clientes cliente = new Clientes();
        cliente.setIdclientes(id);
        clientesfacade.remove(cliente);

    }

    public void create() {
        clientesfacade.create(clientes);

        mensaje=("se creo correctamente");

    }

      public void update(int id) {
        clientes.setIdclientes(id);
        clientesfacade.edit(clientes);
        mensaje = " se acatualizo correctamente"; 
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the clientes
     */
    public Clientes getClientes() {
        return clientes;
    }

    /**
     * @param clientes the clientes to set
     */
    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    /**
     * @return the clientesfacade
     */
    public ClientesFacade getClientesfacade() {
        return clientesfacade;
    }

    /**
     * @param clientesfacade the clientesfacade to set
     */
    public void setClientesfacade(ClientesFacade clientesfacade) {
        this.clientesfacade = clientesfacade;
    }
}
    
//finalizacion del crud
