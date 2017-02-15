package com.vasea.controllers.client;
	import java.io.IOException;
	import javafx.application.Platform;
	import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.fxml.FXMLLoader;
	import javafx.scene.Node;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
	import javafx.scene.control.MenuBar;
	import javafx.scene.control.MenuItem;
	import javafx.stage.Stage;


public class ClientHomeController {
	
		@FXML
		private MenuItem itemLogout;
		@FXML
		private MenuBar menuBar;
		
		 @FXML
	     private void handleExit(ActionEvent event) throws IOException {
			 Platform.exit();   
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
	     private void handleViewAllBooks(ActionEvent event) throws IOException{
			
			 ((Node) event.getSource()).getScene().getWindow().hide();
	         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/client/AllBooks.fxml"));
	         Parent root1 = (Parent) fxmlLoader.load();
	         Stage stage = new Stage();
	         stage.setTitle("All Books");
	         stage.setScene(new Scene(root1));
	         stage.show();
		 }@FXML
	     private void handleUserInformation(ActionEvent event) throws IOException{
			
			 ((Node) event.getSource()).getScene().getWindow().hide();
	         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/client/UserInformation.fxml"));
	         Parent root1 = (Parent) fxmlLoader.load();
	         Stage stage = new Stage();
	         stage.setTitle("User Information");
	         stage.setScene(new Scene(root1));
	         stage.show();
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
	     private void handleSettings(ActionEvent event) throws IOException{
			 ((Node) event.getSource()).getScene().getWindow().hide();
	         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/client/Settings.fxml"));
	         Parent root1 = (Parent) fxmlLoader.load();
	         Stage stage = new Stage();
	         stage.setTitle("Settings");
	         stage.setScene(new Scene(root1));
	         stage.show();
		 }

		

}
