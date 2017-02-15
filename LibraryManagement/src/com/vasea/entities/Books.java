package com.vasea.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="books")

public class Books {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBook;
	private String bookName;
	private String edition;
	private String pages;
	private String fileName;
	private byte[] fileByte;
	@ManyToOne
    @JoinColumn(name="AUTHOR_IDAUTHOR",referencedColumnName="IDAUTHOR")
	private Authors author;
	private List<Genres> genre= new ArrayList<Genres>();
	
	public Books() {
		super();
	}

	public Books(int idBook, String bookName, String edition, String pages, String fileName, byte[] fileByte,
			Authors author, List<Genres> genre) {
		super();
		this.idBook = idBook;
		this.bookName = bookName;
		this.edition = edition;
		this.pages = pages;
		this.fileName = fileName;
		this.fileByte = fileByte;
		this.author = author;
		this.genre = genre;
	}

	public Books(int idBook, String bookName, String edition, String pages, Authors author, List<Genres> genre) {
		super();
		this.idBook = idBook;
		this.bookName = bookName;
		this.edition = edition;
		this.pages = pages;
		this.author = author;
		this.genre = genre;
	}
	public Books(int idBook, String bookName, String edition, String pages, Authors author) {
		super();
		this.idBook = idBook;
		this.bookName = bookName;
		this.edition = edition;
		this.pages = pages;
		this.author = author;
		
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getFileByte() {
		return fileByte;
	}

	public void setFileByte(byte[] fileByte) {
		this.fileByte = fileByte;
	}

	public int getIdBook() {
		return idBook;
	}

	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public Authors getAuthor() {
		return author;
	}

	public void setAuthor(Authors author) {
		this.author = author;
	}
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="bookGenre", 
	joinColumns={@JoinColumn(name="idBook")},
	inverseJoinColumns={@JoinColumn(name="idGenre")})
	public List<Genres> getGenre() {
		return genre;
	}

	public void setGenre(List<Genres> genre) {
		this.genre = genre;
	}

	


	@Override
	public String toString() {
		return "Books [idBook=" + idBook + ", bookName=" + bookName + ", edition=" + edition + ", pages=" + pages
				+ ", fileName=" + fileName + ", fileByte=" + Arrays.toString(fileByte) + ", author=" + author
				+ ", genre=" + toListaString1() + "]";
	}

	public String toListaString(){
		return author.getAuthorName();
	}
	public List<String> toListaString1(){
		List<String> list= new ArrayList<>();
		for(int i=0; i<genre.size(); i++){
			list.add(genre.get(i).getGenre());
		}
		return list;
	}
	
	
}
