package com.vasea.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserTest {
	public static void main(String []args){
		
		Users user=new Users();
		user.setName("Vasea");
		user.setUsername("vassea3");
		user.setPassword("1111");
		user.setSecurityQuestion("Citi ani ai?");
		user.setAnswer("232");
		 
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("persistenceUnitName");
		EntityManager em=emf.createEntityManager();
	
		
		
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();

	}

}
