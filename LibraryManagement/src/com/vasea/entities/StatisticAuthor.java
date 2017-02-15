package com.vasea.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="statisticAuthor")
public class StatisticAuthor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int authorStatistic;
	private String author;
	
	public StatisticAuthor() {
		super();
	}

	public StatisticAuthor(int id, int authorStatistic, String author) {
		this.id = id;
		this.authorStatistic = authorStatistic;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAuthorStatistic() {
		return authorStatistic;
	}

	public void setAuthorStatistic(int authorStatistic) {
		this.authorStatistic = authorStatistic;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "StatisticAuthor [id=" + id + ", authorStatistic=" + authorStatistic + ", author=" + author + "]";
	}
	
	
}
