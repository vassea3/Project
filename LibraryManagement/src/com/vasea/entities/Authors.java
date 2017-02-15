package com.vasea.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="authors")
public class Authors {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@OneToMany
	private int idAuthor;
	private String authorName;
	public Authors() {
		super();
		
	}
	public Authors(int idAuthor, String authorName) {
		
		this.idAuthor = idAuthor;
		this.authorName = authorName;
	}
	public int getIdAuthor() {
		return idAuthor;
	}
	public void setIdAuthor(int idAuthor) {
		this.idAuthor = idAuthor;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	@Override
	public String toString() {
		return authorName ;
	}
	
	
}
