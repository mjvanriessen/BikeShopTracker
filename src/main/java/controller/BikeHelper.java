/**
 * Michael Van Riessen - mjvanriessen
 * CIS175 - Spring 2023
 * Mar 3, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Bike;

public class BikeHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BikeShopTracker");
	
	public void insertBike(Bike b) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Bike> showAllBikes() {
		EntityManager em = emfactory.createEntityManager();
		List<Bike> allBikes = em.createQuery("SELECT b FROM Bike b").getResultList();
		return allBikes;
	}
	
	public void deleteTeam(Bike toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Bike> typedQuery = em.createQuery("select b from Bike b where b.bikeModel = :selectedBikeModel and b.bikeUse = :selectedBikeUse and b.bikePrice = :selectedBikePrice", Bike.class);
		typedQuery.setParameter("selectedBikeModel", toDelete.getBikeModel());
		typedQuery.setParameter("selectedBikeUse", toDelete.getBikeUse());
		typedQuery.setParameter("selectedBikePrice", toDelete.getBikePrice());
		typedQuery.setMaxResults(1);
		Bike result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public Bike searchForTeamById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Bike foundTeam = em.find(Bike.class, idToEdit);
		em.close();
		return foundTeam;
	}
	
	public void updateTeam(Bike toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp() {
		emfactory.close();
	}

}
