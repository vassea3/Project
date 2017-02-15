package com.vasea.controllers.admin;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class SingupController implements Initializable {
	ObservableList<String> securityQuestionList= FXCollections.observableArrayList("How old are you?","What is name of your mother?");
	
	@FXML
	 private TextField name;
	@FXML
	 private TextField username;
	@FXML
	 private TextField password;
	@FXML
	 private TextField repeatPassword;
	@FXML
	 private ComboBox<String> securityQuestion;
	@FXML
	 private TextField answer;
	@FXML
	 private Button create;
	@FXML
	 private Button back;
	private boolean checkPassword;
	
	
	 @FXML
	    private void handleSave(ActionEvent event) throws IOException, SQLException {
		
	        Users user= new Users();
	        UserIntf userDao=new UserImpl();
	        List<String> usernameList= new ArrayList<String>();
	        usernameList=userDao.findUsername();
	       
	        user = readForm();
	        if(user.getAnswer().isEmpty() ||user.getName().isEmpty() || user.getPassword().isEmpty() || user.getSecurityQuestion()=="Select a question" || user.getUsername().isEmpty()){
	        	 WarningComunication.message="Complete all fields";
	    		   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Warning.fxml"));
	                  Parent root1 = (Parent) fxmlLoader.load();
	                  Stage stage = new Stage();
	                  stage.setTitle("Warning");
	                  stage.setScene(new Scene(root1));
	                  stage.show();
	        }else{
		       if(usernameList.contains(user.getUsername())){
		    	   WarningComunication.message="This username is used";
		    	   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Warning.fxml"));
	               Parent root1 = (Parent) fxmlLoader.load();
	               Stage stage = new Stage();
	               stage.setTitle("Warning");
	               stage.setScene(new Scene(root1));
	               stage.show();
		       }else{
		    	   if(checkPass(password.getText(), repeatPassword.getText())){
			    	   userDao.save(user);
			    	   WarningComunication.messageOk="User was saved ";
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
		              
		    	   } else{
		    		   WarningComunication.message="Password and Repeat Password \n are not the same";
		    		   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Warning.fxml"));
		                  Parent root1 = (Parent) fxmlLoader.load();
		                  Stage stage = new Stage();
		                  stage.setTitle("Warning");
		                  stage.setScene(new Scene(root1));
		                  stage.show();
		    	   }
		    }
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
	 
	  private Users readForm() {
	        Users user = new Users();
	       
	        user.setName(name.getText());
	        user.setUsername(username.getText());
	        user.setPassword(password.getText());
	        user.setSecurityQuestion(securityQuestion.getValue());
	        user.setAnswer(answer.getText());
	        return user;
	    }
	private Boolean checkPass(String password, String repeatPassword){
		
		if(password.equals(repeatPassword)){
			checkPassword=true;
		}else{
			checkPassword=false;
		}
		return checkPassword;
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		securityQuestion.setItems(securityQuestionList);
		securityQuestion.setValue("Select a question");
	}
	}
