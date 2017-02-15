package com.vasea.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.vasea.daoImpl.UserImpl;
import com.vasea.daoIntf.UserIntf;
import com.vasea.entities.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


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
	
	 @FXML
	    private void handleSave(ActionEvent event) throws IOException, SQLException {
	        Users user1= new Users();
	        UserIntf userDao= new UserImpl();
	         user1 = readForm();
	     userDao.save(user1);
	        System.out.println(user1);
    
	    }
	  private Users readForm() {
	        Users user = new Users();
	       user.setIdUser(1111);
	        user.setName(name.getText());
	        user.setUsername(username.getText());
	        user.setPassword(password.getText());
	        user.setSecurityQuestion(securityQuestion.getValue());
	        user.setAnswer(answer.getText());
	      

	        return user;
	    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		securityQuestion.setItems(securityQuestionList);
	}

}
