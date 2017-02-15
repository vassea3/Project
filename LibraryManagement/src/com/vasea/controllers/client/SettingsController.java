package com.vasea.controllers.client;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.vasea.controllers.admin.UserComunication;
import com.vasea.controllers.admin.WarningComunication;
import com.vasea.daoImpl.UserImpl;
import com.vasea.daoIntf.UserIntf;
import com.vasea.entities.Users;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SettingsController implements Initializable {
	@FXML
	private TextField name;
	@FXML
	private TextField username;
	@FXML
	private TextField password;
	@FXML
	private TextField newPassword;
	@FXML
	private TextField repeatPassword;
	@FXML
	private ComboBox<String> question;
	@FXML
	private TextField answer;

	ObservableList<String> securityQuestionList= FXCollections.observableArrayList("How old are you?","What is name of your mother?");

	
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
	private void handleSave(ActionEvent event) throws IOException{
		
			
		        Users user= new Users();
		        UserIntf userDao=new UserImpl();
		        List<String> usernameList= new ArrayList<String>();
		        usernameList=userDao.findUsername();
		       
		        user = readForm();
		        if(!UserComunication.user.getPassword().equals(password.getText())){
		        	WarningComunication.message="Your password it is worng";
		    		   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Warning.fxml"));
		                  Parent root1 = (Parent) fxmlLoader.load();
		                  Stage stage = new Stage();
		                  stage.setTitle("Warning");
		                  stage.setScene(new Scene(root1));
		                  stage.show();
		        }
		        else if(checkPass()){
		        	if(user.getAnswer().isEmpty() ||user.getName().isEmpty() || user.getPassword().isEmpty() || question.getValue().equals("Select a question")|| user.getUsername().isEmpty()){
		        		WarningComunication.message="Complete all fields";
			    		   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Warning.fxml"));
			                  Parent root1 = (Parent) fxmlLoader.load();
			                  Stage stage = new Stage();
			                  stage.setTitle("Warning");
			                  stage.setScene(new Scene(root1));
			                  stage.show();
		        	}
		        	else if(UserComunication.user.getUsername().equals(username.getText())){
		        		userDao.update(user);
		        		UserComunication.user=user;
		        		WarningComunication.messageOk="Your profile was edited ";
				    	   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Succes.fxml"));
			               Parent root1 = (Parent) fxmlLoader.load();
			               Stage stage = new Stage();
			               stage.setTitle("Success");
			               stage.setScene(new Scene(root1));
			               stage.show();
			               name.clear();
			               username.clear();
			               password.clear();
			               repeatPassword.clear();
			               answer.clear();
				    }
		        	else if(usernameList.contains(user.getUsername())){
		        		WarningComunication.message="This username is used";
			    		   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Warning.fxml"));
			                  Parent root1 = (Parent) fxmlLoader.load();
			                  Stage stage = new Stage();
			                  stage.setTitle("Warning");
			                  stage.setScene(new Scene(root1));
			                  stage.show();
				       }
		        	else{

				    		   userDao.update(user);
				    		   UserComunication.user=user;
				    		   WarningComunication.messageOk="Your profile was edited ";
					    	   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Succes.fxml"));
				               Parent root1 = (Parent) fxmlLoader.load();
				               Stage stage = new Stage();
				               stage.setTitle("Success");
				               stage.setScene(new Scene(root1));
				               stage.show();
				               name.clear();
				               username.clear();
				               password.clear();
				               repeatPassword.clear();
				               answer.clear();
				       }   
		        }else{
		        	WarningComunication.message="New password and repeat password \n are not the same";
		    		   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Warning.fxml"));
		                  Parent root1 = (Parent) fxmlLoader.load();
		                  Stage stage = new Stage();
		                  stage.setTitle("Warning");
		                  stage.setScene(new Scene(root1));
		                  stage.show();
	 }
	}
	 private Users readForm() {
	        Users user = new Users();
	        user.setIdUser(UserComunication.user.getIdUser());
	        user.setName(name.getText());
	        user.setUsername(username.getText());
	        user.setPassword(newPassword.getText());
	        user.setSecurityQuestion(question.getValue());
	        user.setAnswer(answer.getText());
	
	        return user;
	    }
	private Boolean checkPass(){
		Boolean checkPassword;
		if((newPassword.getText()).equals(repeatPassword.getText())){
			checkPassword=true;
			System.out.println("pasBun");
		}else{
			checkPassword=false;
		}
		return checkPassword;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		name.setText(UserComunication.user.getName());
		username.setText(UserComunication.user.getUsername());
		question.setValue(UserComunication.user.getSecurityQuestion());
		answer.setText(UserComunication.user.getAnswer());
		question.setItems(securityQuestionList);
		
	}
}
