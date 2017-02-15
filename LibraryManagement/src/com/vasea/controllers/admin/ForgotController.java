package com.vasea.controllers.admin;

import java.io.IOException;
import java.sql.SQLException;

import com.vasea.daoImpl.UserImpl;
import com.vasea.daoIntf.UserIntf;
import com.vasea.entities.Users;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ForgotController {

	@FXML
	 private TextField name;
	@FXML
	 private TextField username;
	@FXML
	 private TextField password;
	@FXML
	 private TextField repeatPassword;
	@FXML
	 private TextField securityQuestion;
	@FXML
	 private TextField answer;
	@FXML
	 private TextField yourPassword;
	@FXML
	 private Button search;
	@FXML
	 private Button retrive;
	@FXML
	 private Button back;
	
	
	@FXML
	 private void handleSearch(ActionEvent event) throws IOException, SQLException {
		UserIntf userDao= new UserImpl(); 
		Users user=new Users();
		user=userDao.finfByUsername(username.getText());
		if(user.getUsername().isEmpty()){
			WarningComunication.message="Username is incorrect";
      	  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Warning.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Warning");
            stage.setScene(new Scene(root1));
            stage.show();
            username.clear();
			name.clear();
			securityQuestion.clear();
			answer.clear();
			yourPassword.clear();
		}else{
			username.setText(user.getUsername());
			name.setText(user.getName());
			securityQuestion.setText(user.getSecurityQuestion());
			answer.clear();
			yourPassword.clear();
		}
		
	     }
	@FXML
	 private void handleRetrive(ActionEvent event) throws IOException, SQLException {
			UserIntf userDao= new UserImpl(); 
			Users user=new Users();
			user=userDao.finfByUsername(username.getText());
			if((user.getAnswer()).equals(answer.getText())){
				yourPassword.setText(user.getPassword());
			}else{
				WarningComunication.message="Your answer is incorrect";
		      	  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Warning.fxml"));
		            Parent root1 = (Parent) fxmlLoader.load();
		            Stage stage = new Stage();
		            stage.setTitle("Warning");
		            stage.setScene(new Scene(root1));
		            stage.show();
			}
	     }
	@FXML
	 private void handleBack(ActionEvent event) throws IOException, SQLException {
		 try {

	            ((Node) event.getSource()).getScene().getWindow().hide();
	            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
	            Parent root1 = (Parent) fxmlLoader.load();
	            Stage stage = new Stage();
	            stage.setTitle("Login");
	            stage.setScene(new Scene(root1));
	            stage.show();

	        } catch (Exception e) {
	           // LOG.warning("Con't open the aplication");
	        }
	     }
	
}
