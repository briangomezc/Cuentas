/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jp.cxc.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Brian Gomez
 */
@Entity
@Table(name = "transacciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transacciones.findAll", query = "SELECT t FROM Transacciones t")
    , @NamedQuery(name = "Transacciones.findById", query = "SELECT t FROM Transacciones t WHERE t.id = :id")
    , @NamedQuery(name = "Transacciones.findByNumeroDocumento", query = "SELECT t FROM Transacciones t WHERE t.numeroDocumento = :numeroDocumento")
    , @NamedQuery(name = "Transacciones.findByFecha", query = "SELECT t FROM Transacciones t WHERE t.fecha = :fecha")
    , @NamedQuery(name = "Transacciones.findByMonto", query = "SELECT t FROM Transacciones t WHERE t.monto = :monto")
    , @NamedQuery(name = "Transacciones.findByTipoMovimiento", query = "SELECT t FROM Transacciones t WHERE t.tipoMovimiento = :tipoMovimiento")})
public class Transacciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NumeroDocumento")
    private int numeroDocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Monto")
    private int monto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "TipoMovimiento")
    private String tipoMovimiento;
    @JoinColumn(name = "ID_Cliente", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Cliente iDCliente;
    @JoinColumn(name = "ID_TipoDocumento", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Tipodocumentos iDTipoDocumento;
    @JoinColumn(name = "ID_TipoMovimiento", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Tipomovimientos iDTipoMovimiento;

    public Transacciones() {
    }

    public Transacciones(Integer id) {
        this.id = id;
    }

    public Transacciones(Integer id, int numeroDocumento, Date fecha, int monto, String tipoMovimiento) {
        this.id = id;
        this.numeroDocumento = numeroDocumento;
        this.fecha = fecha;
        this.monto = monto;
        this.tipoMovimiento = tipoMovimiento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Cliente getIDCliente() {
        return iDCliente;
    }

    public void setIDCliente(Cliente iDCliente) {
        this.iDCliente = iDCliente;
    }

    public Tipodocumentos getIDTipoDocumento() {
        return iDTipoDocumento;
    }

    public void setIDTipoDocumento(Tipodocumentos iDTipoDocumento) {
        this.iDTipoDocumento = iDTipoDocumento;
    }

    public Tipomovimientos getIDTipoMovimiento() {
        return iDTipoMovimiento;
    }

    public void setIDTipoMovimiento(Tipomovimientos iDTipoMovimiento) {
        this.iDTipoMovimiento = iDTipoMovimiento;
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
        if (!(object instanceof Transacciones)) {
            return false;
        }
        Transacciones other = (Transacciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jp.cxc.entity.Transacciones[ id=" + id + " ]";
    }
    
}
