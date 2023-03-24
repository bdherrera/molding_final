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
@Table(name = "proveedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedores.findAll", query = "SELECT p FROM Proveedores p"),
    @NamedQuery(name = "Proveedores.findByCodproveedores", query = "SELECT p FROM Proveedores p WHERE p.codproveedores = :codproveedores"),
    @NamedQuery(name = "Proveedores.findByCantidadmaterial", query = "SELECT p FROM Proveedores p WHERE p.cantidadmaterial = :cantidadmaterial"),
    @NamedQuery(name = "Proveedores.findByCodmaterial", query = "SELECT p FROM Proveedores p WHERE p.codmaterial = :codmaterial"),
    @NamedQuery(name = "Proveedores.findByDireccionproveedor", query = "SELECT p FROM Proveedores p WHERE p.direccionproveedor = :direccionproveedor"),
    @NamedQuery(name = "Proveedores.findByNombrematerial", query = "SELECT p FROM Proveedores p WHERE p.nombrematerial = :nombrematerial"),
    @NamedQuery(name = "Proveedores.findByNombreproveedor", query = "SELECT p FROM Proveedores p WHERE p.nombreproveedor = :nombreproveedor"),
    @NamedQuery(name = "Proveedores.findByPreciosmaterial", query = "SELECT p FROM Proveedores p WHERE p.preciosmaterial = :preciosmaterial"),
    @NamedQuery(name = "Proveedores.findByTelefonoproveedor", query = "SELECT p FROM Proveedores p WHERE p.telefonoproveedor = :telefonoproveedor")})
public class Proveedores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODPROVEEDORES")
    private Integer codproveedores;
    @Size(max = 255)
    @Column(name = "CANTIDADMATERIAL")
    private String cantidadmaterial;
    @Size(max = 255)
    @Column(name = "CODMATERIAL")
    private String codmaterial;
    @Size(max = 255)
    @Column(name = "DIRECCIONPROVEEDOR")
    private String direccionproveedor;
    @Size(max = 255)
    @Column(name = "NOMBREMATERIAL")
    private String nombrematerial;
    @Size(max = 255)
    @Column(name = "NOMBREPROVEEDOR")
    private String nombreproveedor;
    @Size(max = 255)
    @Column(name = "PRECIOSMATERIAL")
    private String preciosmaterial;
    @Size(max = 255)
    @Column(name = "TELEFONOPROVEEDOR")
    private String telefonoproveedor;

    public Proveedores() {
    }

    public Proveedores(Integer codproveedores) {
        this.codproveedores = codproveedores;
    }

    public Integer getCodproveedores() {
        return codproveedores;
    }

    public void setCodproveedores(Integer codproveedores) {
        this.codproveedores = codproveedores;
    }

    public String getCantidadmaterial() {
        return cantidadmaterial;
    }

    public void setCantidadmaterial(String cantidadmaterial) {
        this.cantidadmaterial = cantidadmaterial;
    }

    public String getCodmaterial() {
        return codmaterial;
    }

    public void setCodmaterial(String codmaterial) {
        this.codmaterial = codmaterial;
    }

    public String getDireccionproveedor() {
        return direccionproveedor;
    }

    public void setDireccionproveedor(String direccionproveedor) {
        this.direccionproveedor = direccionproveedor;
    }

    public String getNombrematerial() {
        return nombrematerial;
    }

    public void setNombrematerial(String nombrematerial) {
        this.nombrematerial = nombrematerial;
    }

    public String getNombreproveedor() {
        return nombreproveedor;
    }

    public void setNombreproveedor(String nombreproveedor) {
        this.nombreproveedor = nombreproveedor;
    }

    public String getPreciosmaterial() {
        return preciosmaterial;
    }

    public void setPreciosmaterial(String preciosmaterial) {
        this.preciosmaterial = preciosmaterial;
    }

    public String getTelefonoproveedor() {
        return telefonoproveedor;
    }

    public void setTelefonoproveedor(String telefonoproveedor) {
        this.telefonoproveedor = telefonoproveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codproveedores != null ? codproveedores.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedores)) {
            return false;
        }
        Proveedores other = (Proveedores) object;
        if ((this.codproveedores == null && other.codproveedores != null) || (this.codproveedores != null && !this.codproveedores.equals(other.codproveedores))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Proveedores[ codproveedores=" + codproveedores + " ]";
    }

    public void setIdproveedores(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
