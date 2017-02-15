package com.vasea.daoImpl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.vasea.daoIntf.UserIntf;
import com.vasea.entities.Users;

public class UserImpl implements UserIntf {

	private EntityManager getEM(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnitName");
		return emf.createEntityManager();
	}
	private EntityManager em= getEM();
	@Override
	public void save(Users users) {
		
		em.getTransaction().begin();
		em.persist(users);
		em.getTransaction().commit();
		em.close();
		System.out.println("salvat");
		
	}

	@Override
	public void update(Users users) {
		Users user= new Users();
		user=em.find(Users.class, users.getIdUser());
		System.out.println();
		em.getTransaction().begin();
		user.setName(users.getName());
		user.setUsername(users.getUsername());
		user.setPassword(users.getPassword());
		user.setSecurityQuestion(users.getSecurityQuestion());
		user.setAnswer(users.getAnswer());
		em.persist(user);
		em.getTransaction().commit();
		em.close();
		System.out.println("editat");
	}
	@Override
	public void delete(int id) {
		em.getTransaction().begin();
		em.remove(findById(id));
		em.getTransaction().commit();
		em.close();
		System.out.println("salvat");		
	}
	@Override
	public Users findById(int id) {
		Users user= new Users();
		user=em.find(Users.class, id);
		return user;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Users> findAll() {
		List<Users> usernameList= new ArrayList<>(); 
		Query findUsernames= em.createNativeQuery("select * from users");
		usernameList=findUsernames.getResultList();
		return usernameList;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<String> findUsername() {
		Query findUsernames= em.createNativeQuery("select username from users");
		return findUsernames.getResultList();
	}

	@Override
	public Users finfByUsername(String username) {
		Users user= new Users();
		Query findUsernames= em.createNativeQuery("SELECT * FROM users where username like ?",Users.class).setParameter(1, username);	
		
		if(findUsernames.getResultList().size()>=1){
			user=  (Users) findUsernames.getResultList().get(0);
		  }else{
			  user.setUsername("");;
		  }
	
		return user;
	}

	



}
