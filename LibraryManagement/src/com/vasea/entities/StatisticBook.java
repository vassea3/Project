package com.vasea.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="statisticBook")
public class StatisticBook {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int booksStatistic;
	private String book;
	
	public StatisticBook() {
		super();
	}
	public StatisticBook(int id, int booksStatistic, String book) {
		this.id = id;
		this.booksStatistic = booksStatistic;
		this.book = book;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBooksStatistic() {
		return booksStatistic;
	}
	public void setBooksStatistic(int booksStatistic) {
		this.booksStatistic = booksStatistic;
	}
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "Statistic [id=" + id + ", booksStatistic=" + booksStatistic + ", book=" + book + "]";
	}

	
	
}
