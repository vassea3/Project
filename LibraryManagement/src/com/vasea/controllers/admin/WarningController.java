package com.vasea.controllers.admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;

public class WarningController implements Initializable {

	@FXML 
	private Label warning;
	
	@FXML
    private void handleClose(ActionEvent event) throws IOException{
		 ((Node) event.getSource()).getScene().getWindow().hide();
       
	 }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		warning.setText(WarningComunication.message);
		
	} 
}
