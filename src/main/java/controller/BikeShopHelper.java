/**
 * Michael Van Riessen - mjvanriessen
 * CIS175 - Spring 2023
 * Mar 4, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.BikeShop;

public class BikeShopHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BikeShopTracker");
	
	public void insertBikeShop(BikeShop s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<BikeShop> showAllBikeShops(){
		EntityManager em = emfactory.createEntityManager();
		List<BikeShop> allBikeShops = em.createQuery("SELECT s FROM BikeShop s").getResultList();
		return allBikeShops;
	}
	
	public BikeShop findBikeShop(String ownerLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<BikeShop> typedQuery = em.createQuery("select bs from BikeShop bs where bs.bikeShopOwner = :selectedOwner", BikeShop.class);
		typedQuery.setParameter("selectedOwner", ownerLookUp);
		typedQuery.setMaxResults(1);
		BikeShop foundBikeShop;
		try {
			foundBikeShop = typedQuery.getSingleResult();
		} catch(NoResultException e) {
			foundBikeShop = new BikeShop(ownerLookUp);
		}
		em.close();
		return foundBikeShop;
	}

}
