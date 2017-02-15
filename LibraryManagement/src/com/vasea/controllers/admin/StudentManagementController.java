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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StudentManagementController implements Initializable {
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
	private String checkUsername;
	@FXML
	private TextField usernameSearch;
	@FXML
	 private TextField nameEdit;
	@FXML
	 private TextField usernameEdit;
	@FXML
	 private TextField passwordEdit;
	@FXML
	 private TextField repeatPasswordEdit;
	@FXML
	 private ComboBox<String> questionEdit;
	@FXML
	 private TextField answerEdit;
	@FXML
	private Label nameDelete;
	@FXML
	private TextField usernameSerchDelete;
	@FXML
	private Label usernameDelete;
	private int userId;
	private static String usernameStat;
	 @FXML
	    private void handleSave(ActionEvent event) throws IOException, SQLException {
				
	        Users user= new Users();
	        UserIntf userDao=new UserImpl();
	        List<String> usernameList= new ArrayList<String>();
	       
	        usernameList=userDao.findUsername();
	        
	        user=readForm();
	       if(usernameList.contains(user.getUsername())){
	    	   WarningComunication.message="This username is used";
    		   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Warning.fxml"));
                  Parent root1 = (Parent) fxmlLoader.load();
                  Stage stage = new Stage();
                  stage.setTitle("Warning");
                  stage.setScene(new Scene(root1));
                  stage.show();
	        }else{
	    	   if(user.getAnswer().isEmpty() ||user.getName().isEmpty() || user.getPassword().isEmpty() ||securityQuestion.getValue().equals("Select a question")|| user.getUsername().isEmpty()){
	    		   WarningComunication.message="Complete all fields";
	    		   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Warning.fxml"));
	                  Parent root1 = (Parent) fxmlLoader.load();
	                  Stage stage = new Stage();
	                  stage.setTitle("Warning");
	                  stage.setScene(new Scene(root1));
	                  stage.show();
	    	   }else if(password.getText().equals(repeatPassword.getText())){
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
	               
	               
	    	   }else{
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
	 @FXML
	 private void handleBack(ActionEvent event) throws IOException, SQLException {
		 try {

	            ((Node) event.getSource()).getScene().getWindow().hide();
	            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Home.fxml"));
	            Parent root1 = (Parent) fxmlLoader.load();
	            Stage stage = new Stage();
	            stage.setTitle("Lybrary management");
	            stage.setScene(new Scene(root1));
	            stage.show();

	        } catch (Exception e) {
	           // LOG.warning("Con't open the aplication");
	        }
	     }
	 @FXML
	 private void handleSearchEdit(ActionEvent event) throws IOException, SQLException {
		 	UserIntf userDao= new UserImpl();
		 	Users user= new Users();
		 	user=userDao.finfByUsername(usernameSearch.getText());
		 	if(user!=null){
			 	userId=user.getIdUser();
			 	nameEdit.setText(user.getName());
			 	usernameEdit.setText(user.getUsername());
			 	passwordEdit.setText(user.getPassword());
			 	repeatPasswordEdit.setText(user.getPassword());
			 	questionEdit.setValue(user.getSecurityQuestion());
			 	answerEdit.setText(user.getAnswer());
			 	usernameStat=user.getUsername();
		 	}else{
		 	 	WarningComunication.message="We do not have user \n with this username";
		 	 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Warning.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Warning");
                stage.setScene(new Scene(root1));
                stage.show();
	     }
	     }
	 @FXML
	    private void handleSaveEdit(ActionEvent event) throws IOException, SQLException {
				
	        Users user= new Users();
	        UserIntf userDao=new UserImpl();
	        List<String> usernameList= new ArrayList<String>();
	       
	        usernameList=userDao.findUsername();
	        if(nameEdit.getText().isEmpty() ||usernameEdit.getText().isEmpty() || passwordEdit.getText().isEmpty() || questionEdit.getValue().equals("Select a question")|| usernameEdit.getText().isEmpty()){
	    		   WarningComunication.message="Complete all fields";
	    		   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Warning.fxml"));
	                  Parent root1 = (Parent) fxmlLoader.load();
	                  Stage stage = new Stage();
	                  stage.setTitle("Warning");
	                  stage.setScene(new Scene(root1));
	                  stage.show();
	        }else if(!repeatPasswordEdit.getText().equals(passwordEdit.getText())){
	        	WarningComunication.message="Password and Repeat Password \n are not the same";
	    		   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Warning.fxml"));
	                  Parent root1 = (Parent) fxmlLoader.load();
	                  Stage stage = new Stage();
	                  stage.setTitle("Warning");
	                  stage.setScene(new Scene(root1));
	                  stage.show();
	        }
	        else if(usernameStat.equals(usernameEdit.getText())){
	        	user=readFormEdit();
		        userDao.update(user);
		        WarningComunication.messageOk="User was edited ";
		    	   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Succes.fxml"));
	               Parent root1 = (Parent) fxmlLoader.load();
	               Stage stage = new Stage();
	               stage.setTitle("Success");
	               stage.setScene(new Scene(root1));
	               stage.show();
	               nameEdit.clear();
	               usernameEdit.clear();
	               passwordEdit.clear();
	               repeatPasswordEdit.clear();
	               answerEdit.clear();
	               usernameSearch.clear();
	         }else if(usernameList.contains(usernameEdit.getText())){
	        	 WarningComunication.message="This username is used";
	    		   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Warning.fxml"));
	                  Parent root1 = (Parent) fxmlLoader.load();
	                  Stage stage = new Stage();
	                  stage.setTitle("Warning");
	                  stage.setScene(new Scene(root1));
	                  stage.show();
	        }else{
		        user=readFormEdit();
		        userDao.update(user);
		        WarningComunication.messageOk="User was edited ";
		    	   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Succes.fxml"));
	               Parent root1 = (Parent) fxmlLoader.load();
	               Stage stage = new Stage();
	               stage.setTitle("Success");
	               stage.setScene(new Scene(root1));
	               stage.show();
	               nameEdit.clear();
	               usernameEdit.clear();
	               passwordEdit.clear();
	               repeatPasswordEdit.clear();
	               answerEdit.clear();
	        }
	 }
	 @FXML
	 private void handleSearchDelete(ActionEvent event) throws IOException, SQLException {
		 	
		 UserIntf userDao= new UserImpl();
		 	Users user= new Users();
		 	user=userDao.finfByUsername(usernameSerchDelete.getText());
		 	if(user!=null){
		 		userId=user.getIdUser();
			 	nameDelete.setText(user.getName());
			 	usernameDelete.setText(user.getUsername());
		 	}else{
		 	 	WarningComunication.message="We do not have user \n with this username";
		 	 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Warning.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Warning");
                stage.setScene(new Scene(root1));
                stage.show();
	     }
	     }
	 @FXML
	 private void handleDelete(ActionEvent event) throws IOException, SQLException {
		 	UserIntf userDao= new UserImpl();
		 	if(userId!=1){
			 	userDao.delete(userId);
			 	WarningComunication.messageOk="User was removed ";
		    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Succes.fxml"));
	            Parent root1 = (Parent) fxmlLoader.load();
	            Stage stage = new Stage();
	            stage.setTitle("Success");
	            stage.setScene(new Scene(root1));
	            stage.show();
	            nameDelete.setText("");
	            usernameDelete.setText("");
	            usernameSerchDelete.clear();
		 	}else{
		 		WarningComunication.message="You can't remove administrator user";
		 	 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Warning.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Warning");
                stage.setScene(new Scene(root1));
                stage.show();
		 	}
		 	
	     }
	 private Users readFormEdit(){
		 Users user= new Users();
		 user.setIdUser(userId);
        user.setName(nameEdit.getText());
        user.setUsername(usernameEdit.getText());
        user.setPassword(passwordEdit.getText());
        user.setSecurityQuestion(questionEdit.getValue());
        user.setAnswer(answerEdit.getText());
        return user;
 }
	 private Users readForm(){
		 Users user= new Users();
		 user.setIdUser(userId);
        user.setName(name.getText());
        user.setUsername(username.getText());
        user.setPassword(password.getText());
        user.setSecurityQuestion(securityQuestion.getValue());
        user.setAnswer(answer.getText());
        return user;
 }
	  
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		securityQuestion.setItems(securityQuestionList);
		securityQuestion.setValue("Select a question");
		questionEdit.setItems(securityQuestionList);
	}

}
