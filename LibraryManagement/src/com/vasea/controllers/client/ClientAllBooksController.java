package com.vasea.controllers.client;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.vasea.controllers.admin.WarningComunication;
import com.vasea.daoImpl.BookImpl;
import com.vasea.daoImpl.StatisticAuthorImpl;
import com.vasea.daoImpl.StatisticBookImpl;
import com.vasea.daoIntf.BookIntf;
import com.vasea.daoIntf.StatisticAuthorIntf;
import com.vasea.daoIntf.StatisticBookIntf;
import com.vasea.entities.Authors;
import com.vasea.entities.Books;
import com.vasea.entities.Genres;
import com.vasea.entities.StatisticAuthor;
import com.vasea.entities.StatisticBook;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ClientAllBooksController implements Initializable{
	@FXML
	private TableView<Books> tableBooks;
	@FXML
	private TableColumn<Books, Integer> nrColumn;
	@FXML
	private TableColumn<Books, String> bookNameColumn;
	@FXML
	private TableColumn<Books, String> editionColumn;
	@FXML
	private TableColumn<Books, Genres> genresColumn;
	@FXML
	private TableColumn<Books,Authors> authorColumn;
	@FXML
	private TableColumn<Books, String> pagesColumn;
	@FXML
	private TableColumn<Books, String> file;
	@FXML
	private TextField search;
	@FXML
	private Button showAll;
	
	public void showAllBooks(){
		BookIntf bookDao=new BookImpl();
		
		ObservableList<Books> bookList= FXCollections.observableArrayList();
		
		bookList.addAll(bookDao.findAll());
		
		tableBooks.setItems(bookList);
		
		nrColumn.setCellValueFactory(new PropertyValueFactory<>("idBook"));
		bookNameColumn.setCellValueFactory(new PropertyValueFactory<>("bookName"));
		editionColumn.setCellValueFactory(new PropertyValueFactory<>("edition"));
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
		pagesColumn.setCellValueFactory(new PropertyValueFactory<>("pages"));
		genresColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
		file.setCellValueFactory(new PropertyValueFactory<>("fileName"));
	}
	@FXML
    private void handleOpenFile (ActionEvent event) throws IOException{
		
		Books book= new Books();
		book= tableBooks.getSelectionModel().getSelectedItems().get(0);
		if(book.getFileName().equals("File do not exits")){
			 WarningComunication.message="In database do not exist books \n with this name or with this author";
	    	 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Warning.fxml"));
             Parent root1 = (Parent) fxmlLoader.load();
             Stage stage = new Stage();
             stage.setTitle("Warning");
             stage.setScene(new Scene(root1));
             stage.show();
		}else{
			File file= new File("a.pdf");	 
			FileOutputStream fis= new FileOutputStream(file);
			fis.write(book.getFileByte());
			fis.close();
			Desktop.getDesktop().open(file);
		}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		showAll.setVisible(false);
		showAllBooks();
	}
	@FXML
    private void handleBack(ActionEvent event) throws IOException{
		 ((Node) event.getSource()).getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/client/ClientHome.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Lybrary management");
        stage.setScene(new Scene(root1));
        stage.show();
	 }
	@FXML
    private void handleSearch(ActionEvent event) throws IOException{
		
		BookIntf bookDao=new BookImpl();
		ObservableList<Books> bookList= FXCollections.observableArrayList();
		bookList.add(bookDao.findByBookName(search.getText()));	
		
		if(bookList.get(0).getBookName().isEmpty()){
			bookList.clear();
			bookList.addAll(bookDao.findByAuthorName(search.getText()));
			System.out.println(bookList.get(0).getBookName());
			if(bookList.get(0).getBookName().isEmpty()){
				 WarningComunication.message="In database do not exist books \n with this name or with this author";
		    	  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Warning.fxml"));
	              Parent root1 = (Parent) fxmlLoader.load();
	              Stage stage = new Stage();
	              stage.setTitle("Warning");
	              stage.setScene(new Scene(root1));
	              stage.show();
			}else{
				tableBooks.setItems(bookList);
				search.clear();
				showAll.setVisible(true);
				StatisticAuthorIntf statAuthorDao= new StatisticAuthorImpl();
				StatisticAuthor statisticAuthor= new StatisticAuthor();
				if(statAuthorDao.findByAuthor(bookList.get(0).getAuthor().getAuthorName()).isEmpty()){
					statisticAuthor.setAuthor(bookList.get(0).getAuthor().getAuthorName());
					statisticAuthor.setAuthorStatistic(1);
					statAuthorDao.save(statisticAuthor);
				}else{
					statisticAuthor=statAuthorDao.findByAuthor(bookList.get(0).getAuthor().getAuthorName()).get(0);
					statisticAuthor.setAuthorStatistic(statisticAuthor.getAuthorStatistic()+1);
					statAuthorDao.update(statisticAuthor);
				}
			}
		}else{
			tableBooks.setItems(bookList);
			showAll.setVisible(true);
			StatisticBookIntf statBookDao = new StatisticBookImpl();
			StatisticBook statBook= new StatisticBook();
			search.clear();
			if(statBookDao.findByBook(bookList.get(0).getBookName()).isEmpty()){
				statBook.setBook(bookList.get(0).getBookName());
				statBook.setBooksStatistic(1);
				statBookDao.save(statBook);
			}else{
				statBook=statBookDao.findByBook(bookList.get(0).getBookName()).get(0);
				statBook.setBooksStatistic(statBook.getBooksStatistic()+1);
				statBookDao.update(statBook);
			}
		
		}
			nrColumn.setCellValueFactory(new PropertyValueFactory<>("idBook"));
			bookNameColumn.setCellValueFactory(new PropertyValueFactory<>("bookName"));
			editionColumn.setCellValueFactory(new PropertyValueFactory<>("edition"));
			authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
			pagesColumn.setCellValueFactory(new PropertyValueFactory<>("pages"));
			genresColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
			
	 }
	
	@FXML
    private void handleShowAll(ActionEvent event) throws IOException{
		showAllBooks();
	}

}

