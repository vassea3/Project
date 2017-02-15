package com.vasea.daoIntf;

import java.util.List;

import com.vasea.entities.StatisticBook;

public interface StatisticBookIntf {
	
	public void save(StatisticBook statistic);
	public void update(StatisticBook statistic);
	public List<StatisticBook> findByBook(String book);
	public List<StatisticBook> findAll();
	public void delete(String book);
}
