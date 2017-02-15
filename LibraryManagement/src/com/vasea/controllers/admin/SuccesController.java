package com.vasea.controllers.admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;

public class SuccesController implements Initializable {

	@FXML 
	private Label messageOk;
	
	@FXML
    private void handleOk(ActionEvent event) throws IOException{
		 ((Node) event.getSource()).getScene().getWindow().hide();
       
	 }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		messageOk.setText(WarningComunication.messageOk);
		
	} 
}
