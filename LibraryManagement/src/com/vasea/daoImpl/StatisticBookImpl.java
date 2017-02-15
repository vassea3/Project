package com.vasea.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.vasea.daoIntf.StatisticBookIntf;
import com.vasea.entities.StatisticBook;

public class StatisticBookImpl implements StatisticBookIntf{
	private static EntityManager getEM(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnitName");
		return emf.createEntityManager();
	}
	EntityManager em= getEM();
	@Override
	public void save(StatisticBook statistic) {
		em.getTransaction().begin();
		em.persist(statistic);
		em.getTransaction().commit();
		em.close();
		
	}
	@Override
	public void update(StatisticBook statistic) {
		StatisticBook stat= new StatisticBook();
		stat=findByBook(statistic.getBook()).get(0);
		stat.setBook(statistic.getBook());
		stat.setBooksStatistic(statistic.getBooksStatistic());
		em.getTransaction().begin();
		em.persist(stat);
		em.getTransaction().commit();
		em.close();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<StatisticBook> findByBook(String book) {
		Query findBook= em.createNativeQuery("SELECT * FROM statisticbook where BOOK like ?",StatisticBook.class).setParameter(1, book);
		return findBook.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<StatisticBook> findAll() {
		Query findBook= em.createNativeQuery("select * from statisticbook",StatisticBook.class);
		return findBook.getResultList();
	}
	@Override
	public void delete(String book) {
		Query findBook= em.createNativeQuery("SELECT * FROM statisticbook where BOOK like ?",StatisticBook.class).setParameter(1, book);
		StatisticBook statBook= new StatisticBook();
		statBook=(StatisticBook) findBook.getResultList().get(0);
		em.getTransaction().begin();
		  em.remove(statBook);	  
		  em.getTransaction().commit();
		
	}

}
