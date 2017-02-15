package com.vasea.controllers.admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;



public class HomeController implements Initializable{
	@FXML
	private MenuItem itemLogout;
	@FXML
	private MenuBar menuBar;
	
	 @FXML
     private void handleExit(ActionEvent event) throws IOException {
		 Platform.exit();   
	 }
	 
	 @FXML
     private void handleLogout(ActionEvent event) throws IOException{
		 Stage stage1 = (Stage) menuBar.getScene().getWindow();
		 stage1.hide();
		 System.out.println(stage1.getTitle());

				
             FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
             Parent root1 = (Parent) fxmlLoader.load();
             Stage stage = new Stage();
             stage.setTitle("Login");
             stage.setScene(new Scene(root1));
             stage.show();             
          
	 }
	 @FXML
     private void handleAbout(ActionEvent event) throws IOException{
			// Stage stage1 = (Stage) menuBar.getScene().getWindow();
			// stage1.hide();
             FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/About.fxml"));
             Parent root1 = (Parent) fxmlLoader.load();
             Stage stage = new Stage();
             stage.setTitle("About");
             stage.setScene(new Scene(root1));
             stage.show();             
          
	 }
	 @FXML
     private void handleBookManage(ActionEvent event) throws IOException{
		
		 ((Node) event.getSource()).getScene().getWindow().hide();
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/BookManagement.fxml"));
         Parent root1 = (Parent) fxmlLoader.load();
         Stage stage = new Stage();
         stage.setTitle("Books Management");
         stage.setScene(new Scene(root1));
         stage.show();
	 }
	 @FXML
     private void handleStatistic(ActionEvent event) throws IOException{
		
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Statistic.fxml"));
         Parent root1 = (Parent) fxmlLoader.load();
         Stage stage = new Stage();
         stage.setTitle("Books and authors statistic");
         stage.setScene(new Scene(root1));
         stage.show();
	 }
	 @FXML
     private void handleStudentManage(ActionEvent event) throws IOException{
		
		 ((Node) event.getSource()).getScene().getWindow().hide();
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/StudentManagement.fxml"));
         Parent root1 = (Parent) fxmlLoader.load();
         Stage stage = new Stage();
         stage.setTitle("Users Management");
         stage.setScene(new Scene(root1));
         stage.show();
	 }
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	 
}
