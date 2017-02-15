package com.vasea.daoImpl;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;
import com.vasea.daoIntf.BookIntf;
import com.vasea.entities.Authors;
import com.vasea.entities.Books;
import com.vasea.entities.Genres;

@Transactional
public class BookImpl implements BookIntf{
	
	private static EntityManager getEM(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnitName");
		return emf.createEntityManager();
	}
	EntityManager em= getEM();
	@SuppressWarnings("unchecked")
	public List<Authors> findAuthorByName(String authorName){
		Query findAuthor= em.createNativeQuery("SELECT * FROM authors where AUTHORNAME like ?", Authors.class).setParameter(1, authorName);		
		return findAuthor.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Genres> findBookByGenre(String genre){
		Query findGenre= em.createNativeQuery("SELECT * FROM genres where genre like ?", Genres.class).setParameter(1, genre);	
		return findGenre.getResultList();
	}
	
	@Override	
	public void save(Books book, Authors author, List<Genres> genres, File file){
		
		em.getTransaction().begin();		
		
		if(findAuthorByName(author.getAuthorName()).isEmpty()){
			em.persist(author);	
			
		}else{
			author=findAuthorByName(author.getAuthorName()).get(0);
			book.setAuthor(author);			
		}
		List<Genres> genList= new ArrayList<>();
		for(int i=0; i<genres.size(); i++){
			Genres gen= new Genres();
			//gen.setIdGenre(i);
			gen=genres.get(i);

			if(findBookByGenre(gen.getGenre()).isEmpty()){
				em.persist(gen);	
			}else{
				gen=findBookByGenre(gen.getGenre()).get(0);		
			}
			genList.add(gen);
		}
		
		if(!(book.getFileName().equals("File do not exits"))){
			book.setFileName(file.getName());
			book.setFileByte(readByte(file));
		}
		
		book.getGenre().addAll(genList);
			em.persist(book);
			em.getTransaction().commit();
			System.out.println("Salvat book");
			em.close();
		}
	@Override
		public byte[] readByte(File file){
			 FileInputStream fis = null;                        
		        byte[] bytes = null;
		        try{               
		            fis = new FileInputStream (file.getAbsolutePath());            
		            bytes = new byte[fis.available()];
		            fis.read(bytes);  
		            fis.close();
		            
		        }catch (Exception e) {
					
				}return bytes;
		}
	
	@Override
	public Books findByBookName(String bookName) {
		Books book= new Books();
		Query findBook= em.createNativeQuery("SELECT * FROM books where BOOKNAME like ?",Books.class).setParameter(1, bookName);
		if(findBook.getResultList().size()>=1){
			book=  (Books) findBook.getResultList().get(0);
		  }else{
			  book.setBookName("");
		  }
		return book;
	}
	@Override
	public void delete(Books book){
		em.getTransaction().begin();
		em.remove(book);
		em.getTransaction().commit();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Books> findAll() {
		
		Query findAllBooks= em.createNativeQuery("select * from books",Books.class);
		
		return new ArrayList<Books>( findAllBooks.getResultList());
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Books> findByAuthorName(String authorName) {
		Query findAuthor= em.createNativeQuery("SELECT * FROM authors where AUTHORNAME like ?",Authors.class).setParameter(1, authorName);
		Authors author= new Authors();
		Books book= new Books();
		book.setBookName("");
		List<Books> bookList=new ArrayList<>();
		if(findAuthor.getResultList().size()>=1){
			author=(Authors) findAuthor.getResultList().get(0);
			Query findBook= em.createNativeQuery("SELECT * FROM books where AUTHOR_IDAUTHOR like ?",Books.class).setParameter(1, author.getIdAuthor());
			bookList.addAll(findBook.getResultList());
		}else{
			bookList.add(book);
		}
		return bookList;
	}
	@Override
	public void update(Books book, Authors author, List<Genres> genres, File file) {
		Books books= new Books();
		em.getTransaction().begin();
		books= em.find(Books.class, book.getIdBook());
		
		books.setBookName(book.getBookName());
		books.setEdition(book.getEdition());
		books.setPages(book.getPages());

		if(findAuthorByName(author.getAuthorName()).isEmpty()){
			em.persist(author);
			books.setAuthor(author);
			
		}else{
			author=findAuthorByName(author.getAuthorName()).get(0);
			books.setAuthor(author);			
		}
		List<Genres> genList= new ArrayList<>();
		for(int i=0; i<genres.size(); i++){
			Genres gen= new Genres();
			//gen.setIdGenre(i);
			gen=genres.get(i);

			if(findBookByGenre(gen.getGenre()).isEmpty()){
				em.persist(gen);	
			}else{
				gen=findBookByGenre(gen.getGenre()).get(0);		
			}
			genList.add(gen);
		}
		books.getGenre().clear();
		if(!(book.getFileName().equals(books.getFileName()))){
			books.setFileName(file.getName());
			books.setFileByte(readByte(file));
		}
		
		books.getGenre().addAll(genList);
	
			em.persist(books);
			em.getTransaction().commit();
			System.out.println("Editat book");
			em.close();
		
	}

}
