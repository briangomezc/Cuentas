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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Brian Gomez
 */
@Entity
@Table(name = "balances")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Balances.findAll", query = "SELECT b FROM Balances b")
    , @NamedQuery(name = "Balances.findById", query = "SELECT b FROM Balances b WHERE b.id = :id")
    , @NamedQuery(name = "Balances.findByFechaCorte", query = "SELECT b FROM Balances b WHERE b.fechaCorte = :fechaCorte")
    , @NamedQuery(name = "Balances.findByPromedioSaldo", query = "SELECT b FROM Balances b WHERE b.promedioSaldo = :promedioSaldo")
    , @NamedQuery(name = "Balances.findByMonto", query = "SELECT b FROM Balances b WHERE b.monto = :monto")})
public class Balances implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_Corte")
    @Temporal(TemporalType.DATE)
    private Date fechaCorte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Promedio_Saldo")
    private long promedioSaldo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Monto")
    private int monto;
    @JoinColumn(name = "ID_Cliente", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Cliente iDCliente;

    public Balances() {
    }

    public Balances(Integer id) {
        this.id = id;
    }

    public Balances(Integer id, Date fechaCorte, long promedioSaldo, int monto) {
        this.id = id;
        this.fechaCorte = fechaCorte;
        this.promedioSaldo = promedioSaldo;
        this.monto = monto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaCorte() {
        return fechaCorte;
    }

    public void setFechaCorte(Date fechaCorte) {
        this.fechaCorte = fechaCorte;
    }

    public long getPromedioSaldo() {
        return promedioSaldo;
    }

    public void setPromedioSaldo(long promedioSaldo) {
        this.promedioSaldo = promedioSaldo;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Cliente getIDCliente() {
        return iDCliente;
    }

    public void setIDCliente(Cliente iDCliente) {
        this.iDCliente = iDCliente;
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
        if (!(object instanceof Balances)) {
            return false;
        }
        Balances other = (Balances) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jp.cxc.entity.Balances[ id=" + id + " ]";
    }
    
}
