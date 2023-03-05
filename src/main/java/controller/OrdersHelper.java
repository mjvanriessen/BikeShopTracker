/**
 * Michael Van Riessen - mjvanriessen
 * CIS175 - Spring 2023
 * Mar 4, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Orders;

public class OrdersHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BikeShopTracker");
	
	public void insertNewOrders(Orders o) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Orders> getOrders(){
		EntityManager em = emfactory.createEntityManager();
		List<Orders> allOrders = em.createQuery("SELECT o FROM Orders o").getResultList();
		return allOrders;
	}
	
	public void deleteOrder(Orders o) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Orders> typedQuery = em.createQuery("select o from Orders o where o.id = :selectedId", Orders.class);
		typedQuery.setParameter("selectedId", o.getId());
		typedQuery.setMaxResults(1);
		Orders result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public Orders searchForOrderById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Orders found = em.find(Orders.class, tempId);
		return found;
	}
	
	public void updateOrder(Orders o) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();
		em.close();
	}

}
