/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "orden_salida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenSalida.findAll", query = "SELECT o FROM OrdenSalida o"),
    @NamedQuery(name = "OrdenSalida.findByIdOrden", query = "SELECT o FROM OrdenSalida o WHERE o.idOrden = :idOrden"),
    @NamedQuery(name = "OrdenSalida.findByNombreMaterial", query = "SELECT o FROM OrdenSalida o WHERE o.nombreMaterial = :nombreMaterial"),
    @NamedQuery(name = "OrdenSalida.findByNombreContratista", query = "SELECT o FROM OrdenSalida o WHERE o.nombreContratista = :nombreContratista"),
    @NamedQuery(name = "OrdenSalida.findByCantidad", query = "SELECT o FROM OrdenSalida o WHERE o.cantidad = :cantidad"),
    @NamedQuery(name = "OrdenSalida.findByFechaSalida", query = "SELECT o FROM OrdenSalida o WHERE o.fechaSalida = :fechaSalida"),
    @NamedQuery(name = "OrdenSalida.findByFechaEntrada", query = "SELECT o FROM OrdenSalida o WHERE o.fechaEntrada = :fechaEntrada"),
    @NamedQuery(name = "OrdenSalida.findByDireccion", query = "SELECT o FROM OrdenSalida o WHERE o.direccion = :direccion")})
public class OrdenSalida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_orden")
    private Integer idOrden;
    @Size(max = 45)
    @Column(name = "nombre_material")
    private String nombreMaterial;
    @Size(max = 45)
    @Column(name = "nombre_contratista")
    private String nombreContratista;
    @Size(max = 45)
    @Column(name = "cantidad")
    private String cantidad;
    @Size(max = 45)
    @Column(name = "fecha_salida")
    private String fechaSalida;
    @Size(max = 45)
    @Column(name = "fecha_entrada")
    private String fechaEntrada;
    @Size(max = 45)
    @Column(name = "direccion")
    private String direccion;

    public OrdenSalida() {
    }

    public OrdenSalida(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public String getNombreContratista() {
        return nombreContratista;
    }

    public void setNombreContratista(String nombreContratista) {
        this.nombreContratista = nombreContratista;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrden != null ? idOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenSalida)) {
            return false;
        }
        OrdenSalida other = (OrdenSalida) object;
        if ((this.idOrden == null && other.idOrden != null) || (this.idOrden != null && !this.idOrden.equals(other.idOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.OrdenSalida[ idOrden=" + idOrden + " ]";
    }
    
}
