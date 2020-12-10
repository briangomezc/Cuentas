/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jp.cxc.facade;

import com.jp.cxc.entity.Transacciones;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.jp.cxc.entity.Transacciones_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.jp.cxc.entity.Cliente;
import com.jp.cxc.entity.Tipodocumentos;
import com.jp.cxc.entity.Tipomovimientos;

/**
 *
 * @author Brian Gomez
 */
@Stateless
public class TransaccionesFacade extends AbstractFacade<Transacciones> {

    @PersistenceContext(unitName = "CuentasxCPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransaccionesFacade() {
        super(Transacciones.class);
    }

    public boolean isIDClienteEmpty(Transacciones entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Transacciones> transacciones = cq.from(Transacciones.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(transacciones, entity), cb.isNotNull(transacciones.get(Transacciones_.iDCliente)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Cliente findIDCliente(Transacciones entity) {
        return this.getMergedEntity(entity).getIDCliente();
    }

    public boolean isIDTipoDocumentoEmpty(Transacciones entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Transacciones> transacciones = cq.from(Transacciones.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(transacciones, entity), cb.isNotNull(transacciones.get(Transacciones_.iDTipoDocumento)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Tipodocumentos findIDTipoDocumento(Transacciones entity) {
        return this.getMergedEntity(entity).getIDTipoDocumento();
    }

    public boolean isIDTipoMovimientoEmpty(Transacciones entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Transacciones> transacciones = cq.from(Transacciones.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(transacciones, entity), cb.isNotNull(transacciones.get(Transacciones_.iDTipoMovimiento)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Tipomovimientos findIDTipoMovimiento(Transacciones entity) {
        return this.getMergedEntity(entity).getIDTipoMovimiento();
    }
    
}
