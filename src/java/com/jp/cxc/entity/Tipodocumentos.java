/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jp.cxc.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Brian Gomez
 */
@Entity
@Table(name = "tipodocumentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipodocumentos.findAll", query = "SELECT t FROM Tipodocumentos t")
    , @NamedQuery(name = "Tipodocumentos.findById", query = "SELECT t FROM Tipodocumentos t WHERE t.id = :id")
    , @NamedQuery(name = "Tipodocumentos.findByDescripcion", query = "SELECT t FROM Tipodocumentos t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "Tipodocumentos.findByCuentaContable", query = "SELECT t FROM Tipodocumentos t WHERE t.cuentaContable = :cuentaContable")
    , @NamedQuery(name = "Tipodocumentos.findByEstado", query = "SELECT t FROM Tipodocumentos t WHERE t.estado = :estado")})
public class Tipodocumentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cuenta_Contable")
    private int cuentaContable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Estado")
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDTipoDocumento")
    private Collection<Transacciones> transaccionesCollection;

    public Tipodocumentos() {
    }

    public Tipodocumentos(Integer id) {
        this.id = id;
    }

    public Tipodocumentos(Integer id, String descripcion, int cuentaContable, boolean estado) {
        this.id = id;
        this.descripcion = descripcion;
        this.cuentaContable = cuentaContable;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCuentaContable() {
        return cuentaContable;
    }

    public void setCuentaContable(int cuentaContable) {
        this.cuentaContable = cuentaContable;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Transacciones> getTransaccionesCollection() {
        return transaccionesCollection;
    }

    public void setTransaccionesCollection(Collection<Transacciones> transaccionesCollection) {
        this.transaccionesCollection = transaccionesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipodocumentos)) {
            return false;
        }
        Tipodocumentos other = (Tipodocumentos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jp.cxc.entity.Tipodocumentos[ id=" + id + " ]";
    }
    
}
