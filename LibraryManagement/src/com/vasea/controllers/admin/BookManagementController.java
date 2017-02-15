package com.vasea.controllers.admin;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.vasea.daoImpl.BookImpl;
import com.vasea.daoIntf.BookIntf;
import com.vasea.entities.Authors;
import com.vasea.entities.Books;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class BookManagementController implements Initializable {

	@FXML
	private MenuItem itemLogout;
	@FXML
	private MenuBar menuBar;
	@FXML
	private TextField bookName;
	@FXML
	private TextField authorName;
	@FXML
	private TextField genre;
	@FXML
	private TextField edition;
	@FXML
	private TextField pages;
	@FXML
	private TextField bookNameEdit;
	@FXML
	private TextField authorNameEdit;
	@FXML
	private TextField genreEdit;
	@FXML
	private TextField editionEdit;
	@FXML
	private TextField pagesEdit;
	@FXML
	private TextField searchEdit;
	@FXML
	private Label bookNameDelete;
	@FXML 
	private TextField searchDelete;
	public static File selectedFile;
	public static int bookId=0;
	public static String fileName="File do not exits";
	
	@FXML
    private void handleBack(ActionEvent event) throws IOException{
		 ((Node) event.getSource()).getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Home.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Lybrary management");
        stage.setScene(new Scene(root1));
        stage.show();
	 } 
	@FXML
    private void handleSelectFile(ActionEvent event) throws IOException{
		 FileChooser fc= new FileChooser();
		 fc.setTitle("Select book file");
		 FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.pdf");
	     fc.getExtensionFilters().add(extFilter);
	     
		 if(fc.showOpenDialog(null)!=null){
			selectedFile=fc.showOpenDialog(null);
			 fileName=selectedFile.getName();
		 }
	 } 

	 @FXML
     private void handleSave(ActionEvent event) throws IOException{
		  Books book=new Books();
	      Authors author= new Authors();
	      if(bookName.getText().isEmpty() || authorName.getText().isEmpty() || edition.getText().isEmpty() || pages.getText().isEmpty() || GenresComunication.genreList.isEmpty() ){
	    	  WarningComunication.message="Complete all fields";
	    	  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Warning.fxml"));
              Parent root1 = (Parent) fxmlLoader.load();
              Stage stage = new Stage();
              stage.setTitle("Warning");
              stage.setScene(new Scene(root1));
              stage.show();
	      }else{
	    	
		    	  book.setBookName(bookName.getText());
		    	  author.setAuthorName(authorName.getText());
		          book.setAuthor(author);
		          book.setEdition(edition.getText());
		          book.setPages(pages.getText());
		          book.setFileName(fileName);
		          BookIntf bookDao=new BookImpl();
		          
			      bookDao.save(book,author,GenresComunication.genreList,selectedFile);
			      GenresComunication.genreList.clear();
			      fileName="";
			      WarningComunication.messageOk="Book was saved ";
		    	   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Succes.fxml"));
	               Parent root1 = (Parent) fxmlLoader.load();
	               Stage stage = new Stage();
	               stage.setTitle("Success");
	               stage.setScene(new Scene(root1));
	               stage.show();
	               bookName.clear();
	               authorName.clear();
	  		       edition.clear();
	  		       pages.clear();
	  		 	 
	      
	    	  }

	 }
	 @FXML
     private void handleUpdate(ActionEvent event) throws IOException{
		 Books book=new Books();
	      Authors author= new Authors();
	      book.setIdBook(bookId);
	      if(bookNameEdit.getText().isEmpty() || authorNameEdit.getText().isEmpty() || editionEdit.getText().isEmpty() || pagesEdit.getText().isEmpty() || GenresComunication.genreList.isEmpty() ){
	    	  WarningComunication.message="Complete all fields";
	    	  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Warning.fxml"));
              Parent root1 = (Parent) fxmlLoader.load();
              Stage stage = new Stage();
              stage.setTitle("Warning");
              stage.setScene(new Scene(root1));
              stage.show();
	      }else{
	    	 
	    	  
			     book.setBookName(bookNameEdit.getText());
		         author.setAuthorName(authorNameEdit.getText());
		         book.setAuthor(author);
		         book.setEdition(editionEdit.getText());
		         book.setPages(pagesEdit.getText());
		         book.setFileName(fileName);
		         BookIntf bookDao=new BookImpl();
		         bookDao.update(book,author,GenresComunication.genreList,selectedFile);
		         GenresComunication.genreList.clear();
		         fileName="";
		         WarningComunication.messageOk="Book was edited ";
		    	   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Succes.fxml"));
	               Parent root1 = (Parent) fxmlLoader.load();
	               Stage stage = new Stage();
	               stage.setTitle("Success");
	               stage.setScene(new Scene(root1));
	               stage.show();
	               bookNameEdit.clear();
	  		       authorNameEdit.clear();
	  		       editionEdit.clear();
	  		       pagesEdit.clear();
	  		       searchEdit.clear();
	      }
	      
	 }
	 @FXML
	 private void handleAddGenres(ActionEvent event) throws IOException{
		 
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Genres.fxml"));
         Parent root1 = (Parent) fxmlLoader.load();
         Stage stage = new Stage();
         stage.setTitle("Add Genres");
         stage.setScene(new Scene(root1));
         stage.show();
	 }
	 @FXML
     private void handleSearchEdit(ActionEvent event) throws IOException{
		 Books book=new Books();
		 BookIntf bookDao=new BookImpl();
	     book= bookDao.findByBookName(searchEdit.getText());
	     if(book!=null){
	    	GenresComunication.genreList.addAll(book.getGenre());
		     bookNameEdit.setText( book.getBookName());
		     authorNameEdit.setText(book.getAuthor().getAuthorName());
		     editionEdit.setText(book.getEdition());
		     pagesEdit.setText(book.getPages());
		 	 bookId=book.getIdBook();
		 	 fileName=book.getFileName();
	     }else{
		 	 	WarningComunication.message="We do not have book \n with this name";
		 	 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Warning.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Warning");
                stage.setScene(new Scene(root1));
                stage.show();
	     }
	 }
	 @FXML
     private void handleSearchDelete(ActionEvent event) throws IOException{
		 Books book=new Books();
		 BookIntf bookDao=new BookImpl();
	     book= bookDao.findByBookName(searchDelete.getText());
	     if(book!=null){
	    	 bookNameDelete.setText( book.getBookName());
	     }else{
	    	 WarningComunication.message="We do not have book \n with this name";
		 	 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Warning.fxml"));
             Parent root1 = (Parent) fxmlLoader.load();
             Stage stage = new Stage();
             stage.setTitle("Warning");
             stage.setScene(new Scene(root1));
             stage.show();
	     }

	 }
	 @FXML
	 private void handleDelete(ActionEvent event) throws IOException{
		 Books book=new Books();
		 BookIntf bookDao=new BookImpl();
		 book= bookDao.findByBookName(bookNameDelete.getText());
	     bookDao.delete(book);
	     
	     WarningComunication.messageOk="Book was removed ";
  	   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Succes.fxml"));
         Parent root1 = (Parent) fxmlLoader.load();
         Stage stage = new Stage();
         stage.setTitle("Success");
         stage.setScene(new Scene(root1));
         stage.show();
         bookNameDelete.setText("");
         searchDelete.clear();
	 }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
}
