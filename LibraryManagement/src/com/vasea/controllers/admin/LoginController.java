package com.vasea.controllers.admin;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.vasea.daoImpl.UserImpl;
import com.vasea.daoIntf.UserIntf;
import com.vasea.entities.Users;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;


public class LoginController implements Initializable {

	
	@FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button login;

    @FXML
    private Button singup;
    
    @FXML
    private Label usernameValidat;
    @FXML
    private Label passwordValidat;
    
    @FXML
        private void handleLogin(ActionEvent event) throws IOException {
        	 UserIntf userDao=new UserImpl();
             Users user= new Users();
             user=userDao.finfByUsername(username.getText());
            
             if(user!=null && username.getText().equals(user.getUsername()) && password.getText().equals(user.getPassword())){
            	 try {
            		 
                     ((Node) event.getSource()).getScene().getWindow().hide();
                     FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Loading.fxml"));
                     Parent root1 = (Parent) fxmlLoader.load();
                     Stage stage = new Stage();
                     stage.setTitle("Loading");
                     stage.setScene(new Scene(root1));
                     stage.show();
            		
            		 UserComunication.user=user;
                     //stage.addEventHandler(ActionEvent event,ActionEvent handleLoad);

                 } catch (Exception e) {
                    // LOG.warning("Con't open the aplication");
                 } 
            	 
             }else{
            	 WarningComunication.message="Password or username is incorrect";
            	  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Warning.fxml"));
                  Parent root1 = (Parent) fxmlLoader.load();
                  Stage stage = new Stage();
                  stage.setTitle("Warning");
                  stage.setScene(new Scene(root1));
                  stage.show();
                  username.clear();
                  password.clear();
             }
    }
    @FXML
    private void handleSingup(ActionEvent event) throws IOException {
        try {

            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Singup.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("New Account");
            stage.setScene(new Scene(root1));
            stage.show();

        } catch (Exception e) {
           // LOG.warning("Con't open the aplication");
        }
    }
    @FXML
    private void handleForgot(ActionEvent event) throws IOException {
        try {

            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Forgot.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Forgot Password");
            stage.setScene(new Scene(root1));
            stage.show();

        } catch (Exception e) {
           // LOG.warning("Con't open the aplication");
        }
    }
        


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
