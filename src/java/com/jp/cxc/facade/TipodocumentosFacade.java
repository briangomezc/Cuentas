/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jp.cxc.facade;

import com.jp.cxc.entity.Tipodocumentos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.jp.cxc.entity.Tipodocumentos_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.jp.cxc.entity.Transacciones;
import java.util.Collection;

/**
 *
 * @author Brian Gomez
 */
@Stateless
public class TipodocumentosFacade extends AbstractFacade<Tipodocumentos> {

    @PersistenceContext(unitName = "CuentasxCPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipodocumentosFacade() {
        super(Tipodocumentos.class);
    }

    public boolean isTransaccionesCollectionEmpty(Tipodocumentos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Tipodocumentos> tipodocumentos = cq.from(Tipodocumentos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tipodocumentos, entity), cb.isNotEmpty(tipodocumentos.get(Tipodocumentos_.transaccionesCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Transacciones> findTransaccionesCollection(Tipodocumentos entity) {
        Tipodocumentos mergedEntity = this.getMergedEntity(entity);
        Collection<Transacciones> transaccionesCollection = mergedEntity.getTransaccionesCollection();
        transaccionesCollection.size();
        return transaccionesCollection;
    }
    
}
