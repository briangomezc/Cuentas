/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jp.cxc.facade;

import com.jp.cxc.entity.Cliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.jp.cxc.entity.Cliente_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.jp.cxc.entity.Balances;
import com.jp.cxc.entity.Transacciones;
import java.util.Collection;

/**
 *
 * @author Brian Gomez
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "CuentasxCPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }

    public boolean isBalancesCollectionEmpty(Cliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> cliente = cq.from(Cliente.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cliente, entity), cb.isNotEmpty(cliente.get(Cliente_.balancesCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Balances> findBalancesCollection(Cliente entity) {
        Cliente mergedEntity = this.getMergedEntity(entity);
        Collection<Balances> balancesCollection = mergedEntity.getBalancesCollection();
        balancesCollection.size();
        return balancesCollection;
    }

    public boolean isTransaccionesCollectionEmpty(Cliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> cliente = cq.from(Cliente.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cliente, entity), cb.isNotEmpty(cliente.get(Cliente_.transaccionesCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Transacciones> findTransaccionesCollection(Cliente entity) {
        Cliente mergedEntity = this.getMergedEntity(entity);
        Collection<Transacciones> transaccionesCollection = mergedEntity.getTransaccionesCollection();
        transaccionesCollection.size();
        return transaccionesCollection;
    }
    
}
