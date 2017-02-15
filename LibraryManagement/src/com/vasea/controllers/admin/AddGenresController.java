package com.vasea.controllers.admin;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.vasea.entities.Genres;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;


public class AddGenresController implements Initializable{
	@FXML
    private CheckBox action;
	@FXML
    private CheckBox biography;
	@FXML
    private CheckBox drama‎;
	@FXML
    private CheckBox fantasy‎;
	@FXML
    private CheckBox erotica;
	@FXML
    private CheckBox humour‎;
	@FXML
    private CheckBox romance‎;
	@FXML
    private CheckBox childrenEntertainment‎;
	@FXML
    private CheckBox scienceFiction;
	@FXML
    private CheckBox tragedies;
	@FXML
    private CheckBox comedy‎;
	@FXML
    private CheckBox nonFiction;
	@FXML
	private Button save;
	@FXML
	private Button back;
	
       
	@FXML
	 private void handleSave(ActionEvent event) throws IOException{
		
		
		Stage stage = new Stage();
		 stage.setTitle("Add Genres");
		
       
        System.out.println("a intrat");
		
		
			if(action.isSelected()){
				Genres genre= new Genres();
				genre.setGenre(action.getText());
				GenresComunication.genreList.add(genre);
				}
			 if(biography.isSelected()){
				 Genres genre= new Genres();
				 genre.setGenre(biography.getText());
				 GenresComunication.genreList.add(genre);
				}
			 if(drama‎.isSelected()){
				 Genres genre= new Genres();
				 genre.setGenre(drama‎.getText());
				 GenresComunication.genreList.add(genre);
				}
			 if(fantasy‎.isSelected()){
				 Genres genre= new Genres();
				 genre.setGenre(fantasy‎.getText());
				 GenresComunication.genreList.add(genre);
				}
			 if(erotica.isSelected()){
				 Genres genre= new Genres();
				 genre.setGenre(erotica.getText());
				 GenresComunication.genreList.add(genre);
				}
			 if(humour‎.isSelected()){
				 Genres genre= new Genres();
				 genre.setGenre(humour‎.getText());
				 GenresComunication.genreList.add(genre);
				}
			 if(romance‎.isSelected()){
				 Genres genre= new Genres();
				 genre.setGenre(romance‎.getText());
				 GenresComunication.genreList.add(genre);
				}
			 if(childrenEntertainment‎.isSelected()){
				 Genres genre= new Genres();
				 genre.setGenre(childrenEntertainment‎.getText());
				 GenresComunication.genreList.add(genre);
				}
			 if(scienceFiction.isSelected()){
				 Genres genre= new Genres();
				 genre.setGenre(scienceFiction.getText());
				 GenresComunication.genreList.add(genre);
				}
			 if(tragedies.isSelected()){
				 Genres genre= new Genres();
				 genre.setGenre(tragedies.getText());
				 GenresComunication.genreList.add(genre);
				}
			 if(comedy‎.isSelected()){
				 Genres genre= new Genres();
				 genre.setGenre(comedy‎.getText());
				 
				 GenresComunication.genreList.add(genre);
				}
			 if(nonFiction.isSelected()){
				 Genres genre= new Genres();
				 genre.setGenre(nonFiction.getText());
				
				 GenresComunication.genreList.add(genre);
				}
			 
			System.out.println(GenresComunication.genreList);
			 
			 ((Node) event.getSource()).getScene().getWindow().hide();
			
	}
	 @FXML
     private void handleBack(ActionEvent event) throws IOException{
		 ((Node) event.getSource()).getScene().getWindow().hide();
         
	 }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if(!GenresComunication.genreList.isEmpty()){
			List<String> listGenre = new ArrayList<String>();
			for(int i=0; i<GenresComunication.genreList.size(); i++){
				listGenre.add(GenresComunication.genreList.get(i).getGenre());
			}
			if(listGenre.contains(action.getText())){
				action.setSelected(true);
				}
			if(listGenre.contains(biography.getText())){
				biography.setSelected(true);
				}
			if(listGenre.contains(drama‎.getText())){
				drama‎.setSelected(true);
				}
			if(listGenre.contains(fantasy‎.getText())){
				fantasy‎.setSelected(true);
				}
			if(listGenre.contains(erotica.getText())){
				erotica.setSelected(true);
				}
			if(listGenre.contains(humour‎.getText())){
			humour‎.setSelected(true);
				}
			if(listGenre.contains(romance‎.getText())){
				romance‎.setSelected(true);
				}
			if(listGenre.contains(childrenEntertainment‎.getText())){
				childrenEntertainment‎.setSelected(true);
				}
			if(listGenre.contains(scienceFiction.getText())){
				scienceFiction.setSelected(true);
				}
			if(listGenre.contains(tragedies.getText())){
				tragedies.setSelected(true);
				}
			if(listGenre.contains(comedy‎.getText())){
				comedy‎.setSelected(true);
				}
			if(listGenre.contains(nonFiction.getText())){
				nonFiction.setSelected(true);
				}
			
		}
		GenresComunication.genreList.clear();
	} 
	
	
}
