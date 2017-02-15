package com.vasea.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.vasea.daoIntf.StatisticAuthorIntf;
import com.vasea.entities.StatisticAuthor;

public class StatisticAuthorImpl implements StatisticAuthorIntf{

	private static EntityManager getEM(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnitName");
		return emf.createEntityManager();
	}
	EntityManager em= getEM();
	@Override
	public void save(StatisticAuthor statistic) {
		em.getTransaction().begin();
		em.persist(statistic);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void update(StatisticAuthor statistic) {
		StatisticAuthor stat= new StatisticAuthor();
		stat=findByAuthor(statistic.getAuthor()).get(0);
		stat.setAuthor(statistic.getAuthor());
		stat.setAuthorStatistic(statistic.getAuthorStatistic());
		em.getTransaction().begin();
		em.persist(stat);
		em.getTransaction().commit();
		em.close();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<StatisticAuthor> findByAuthor(String author) {
		Query findAuthor= em.createNativeQuery("SELECT * FROM statisticauthor where AUTHOR like ?",StatisticAuthor.class).setParameter(1, author);
		return findAuthor.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<StatisticAuthor> findAll() {
		Query findAuthor= em.createNativeQuery("select * from statisticauthor",StatisticAuthor.class);
		return findAuthor.getResultList();
	}

}
