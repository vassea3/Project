package com.vasea.controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private void handleSingup(ActionEvent event) throws IOException {
        try {

            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Singup.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Computer voice comander");
            stage.setScene(new Scene(root1));
            stage.show();

        } catch (Exception e) {
           // LOG.warning("Con't open the aplication");
        }
    }
        @FXML
        private void handleLogin(ActionEvent event) throws IOException {
            try {

                ((Node) event.getSource()).getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Singup.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Computer voice comander");
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
