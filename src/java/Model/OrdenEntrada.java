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
@Table(name = "orden_entrada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenEntrada.findAll", query = "SELECT o FROM OrdenEntrada o"),
    @NamedQuery(name = "OrdenEntrada.findByIdOrdenEntrada", query = "SELECT o FROM OrdenEntrada o WHERE o.idOrdenEntrada = :idOrdenEntrada"),
    @NamedQuery(name = "OrdenEntrada.findByFechaCompra", query = "SELECT o FROM OrdenEntrada o WHERE o.fechaCompra = :fechaCompra"),
    @NamedQuery(name = "OrdenEntrada.findByNombreMaterial", query = "SELECT o FROM OrdenEntrada o WHERE o.nombreMaterial = :nombreMaterial"),
    @NamedQuery(name = "OrdenEntrada.findByNombreProveedor", query = "SELECT o FROM OrdenEntrada o WHERE o.nombreProveedor = :nombreProveedor"),
    @NamedQuery(name = "OrdenEntrada.findByPago", query = "SELECT o FROM OrdenEntrada o WHERE o.pago = :pago"),
    @NamedQuery(name = "OrdenEntrada.findByUbicacion", query = "SELECT o FROM OrdenEntrada o WHERE o.ubicacion = :ubicacion")})
public class OrdenEntrada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_orden_entrada")
    private Integer idOrdenEntrada;
    @Size(max = 255)
    @Column(name = "fecha_compra")
    private String fechaCompra;
    @Size(max = 255)
    @Column(name = "nombre_material")
    private String nombreMaterial;
    @Size(max = 255)
    @Column(name = "nombre_proveedor")
    private String nombreProveedor;
    @Size(max = 255)
    @Column(name = "pago")
    private String pago;
    @Size(max = 255)
    @Column(name = "ubicacion")
    private String ubicacion;

    public OrdenEntrada() {
    }

    public OrdenEntrada(Integer idOrdenEntrada) {
        this.idOrdenEntrada = idOrdenEntrada;
    }

    public Integer getIdOrdenEntrada() {
        return idOrdenEntrada;
    }

    public void setIdOrdenEntrada(Integer idOrdenEntrada) {
        this.idOrdenEntrada = idOrdenEntrada;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenEntrada != null ? idOrdenEntrada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenEntrada)) {
            return false;
        }
        OrdenEntrada other = (OrdenEntrada) object;
        if ((this.idOrdenEntrada == null && other.idOrdenEntrada != null) || (this.idOrdenEntrada != null && !this.idOrdenEntrada.equals(other.idOrdenEntrada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.OrdenEntrada[ idOrdenEntrada=" + idOrdenEntrada + " ]";
    }
    
}
