package com.vasea.daoIntf;

import java.util.List;

import com.vasea.entities.StatisticAuthor;

public interface StatisticAuthorIntf {
	public void save(StatisticAuthor statistic);
	public void update(StatisticAuthor statistic);
	public List<StatisticAuthor> findByAuthor(String author);
	public List<StatisticAuthor> findAll();
}
