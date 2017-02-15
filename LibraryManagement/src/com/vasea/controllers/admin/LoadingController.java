package com.vasea.controllers.admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;


public class LoadingController implements Initializable  {
	Task<?> copyWorker;
	@FXML
	private ProgressBar progresBar;
	@FXML
	private Button porneste;

	@FXML
	 private void handleStart(ActionEvent event) throws IOException {
		 if(UserComunication.user.getIdUser()==1){
			 ((Node) event.getSource()).getScene().getWindow().hide();
	         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Home.fxml"));
	         Parent root1 = (Parent) fxmlLoader.load();
	         Stage stage = new Stage();
	         stage.setTitle("Lybrary management");
	         stage.setScene(new Scene(root1));
	         stage.show();
		 }
		 else{
			 ((Node) event.getSource()).getScene().getWindow().hide();
	         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/client/ClientHome.fxml"));
	         Parent root1 = (Parent) fxmlLoader.load();
	         Stage stage = new Stage();
	         stage.setTitle("Lybrary management");
	         stage.setScene(new Scene(root1));
	         stage.show();
		 }
		 
	 }
	    public Task<?> createWorker(){
	    	Task<?> task= new Task<Object>() {
	        	
	            @Override
	            protected Object call() throws Exception {
	                for (int i = 0; i < 101; i++) {
	                    Thread.sleep(30);
	                    updateMessage(i+"%");
	                    updateProgress(i+1, 100);
	                  
	                } 
	                if (progresBar.getProgress()==1) {
	               porneste.setVisible(true);
	                }
	                return true;
	            }
	        }; 
	        return task;
	    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		porneste.setVisible(false);
		  progresBar.setProgress(0);
	        copyWorker=createWorker();
	        progresBar.progressProperty().bind(copyWorker.progressProperty());
	        copyWorker.messageProperty().addListener(new ChangeListener<String>() {
	            @Override
	            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
	               
	            }
	        });
	        	new Thread (copyWorker).start();  
	}
}
