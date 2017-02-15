package com.vasea.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="genres")
public class Genres {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idGenre;
	private String genre;
	
    private List<Books> book=new ArrayList<Books>();
	public Genres() {
		super();
		
	}
	public Genres(int idGenre, String genre, List<Books> book) {
		super();
		this.idGenre = idGenre;
		this.genre = genre;
		this.book = book;
	}
	public int getIdGenre() {
		return idGenre;
	}
	public void setIdGenre(int idGenre) {
		this.idGenre = idGenre;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@ManyToMany
	
	public List<Books> getBook() {
		return book;
	}
	public void setBook(List<Books> book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return  genre;
	}
		

}
