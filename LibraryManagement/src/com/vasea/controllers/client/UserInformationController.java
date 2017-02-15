package com.vasea.controllers.client;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.vasea.controllers.admin.UserComunication;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class UserInformationController implements Initializable {
	@FXML
	private Label name;
	@FXML
	private Label username;
	@FXML
	private Label question;
	@FXML
	private Label answer;
	
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		name.setText(UserComunication.user.getName());
		username.setText(UserComunication.user.getUsername());
		question.setText(UserComunication.user.getSecurityQuestion());
		answer.setText(UserComunication.user.getAnswer());
		
	}
}
