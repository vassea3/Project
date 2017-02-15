package com.vasea.daoIntf;

import java.io.File;
import java.util.List;

import com.vasea.entities.Authors;
import com.vasea.entities.Books;
import com.vasea.entities.Genres;

public interface BookIntf {

	public void save(Books book, Authors author, List<Genres> genres, File file);
	public Books findByBookName(String bookName);
	public List<Books> findByAuthorName(String authorName);
	public void delete(Books book);
	public List<Books> findAll();
	public byte[] readByte(File file);
	public void update(Books book, Authors author, List<Genres> genres, File file);
}
