/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Pedido;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Cheng
 */
@Stateless
public class PedidoFacade extends AbstractFacade<Pedido> {

    @PersistenceContext(unitName = "examenJunioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PedidoFacade() {
        super(Pedido.class);
    }

    public Pedido findById(String id) {
        try {
            Query query;
            query = this.em.createQuery("SELECT p FROM Pedido p WHERE p.pedidoId = :pedidoId", Pedido.class
            );
            query.setParameter("pedidoId", Integer.parseInt(id));
            return (Pedido) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }

}
