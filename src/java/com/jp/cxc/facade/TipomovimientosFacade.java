/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jp.cxc.facade;

import com.jp.cxc.entity.Tipomovimientos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.jp.cxc.entity.Tipomovimientos_;
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
public class TipomovimientosFacade extends AbstractFacade<Tipomovimientos> {

    @PersistenceContext(unitName = "CuentasxCPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipomovimientosFacade() {
        super(Tipomovimientos.class);
    }

    public boolean isTransaccionesCollectionEmpty(Tipomovimientos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Tipomovimientos> tipomovimientos = cq.from(Tipomovimientos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tipomovimientos, entity), cb.isNotEmpty(tipomovimientos.get(Tipomovimientos_.transaccionesCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Transacciones> findTransaccionesCollection(Tipomovimientos entity) {
        Tipomovimientos mergedEntity = this.getMergedEntity(entity);
        Collection<Transacciones> transaccionesCollection = mergedEntity.getTransaccionesCollection();
        transaccionesCollection.size();
        return transaccionesCollection;
    }
    
}
