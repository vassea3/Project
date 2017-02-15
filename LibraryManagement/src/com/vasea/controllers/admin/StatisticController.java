package com.vasea.controllers.admin;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.vasea.daoImpl.StatisticAuthorImpl;
import com.vasea.daoImpl.StatisticBookImpl;
import com.vasea.daoIntf.StatisticAuthorIntf;
import com.vasea.daoIntf.StatisticBookIntf;
import com.vasea.entities.StatisticAuthor;
import com.vasea.entities.StatisticBook;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

public class StatisticController implements Initializable {
	private ObservableList<PieChart.Data> diagramBookO= FXCollections.observableArrayList();
	private ObservableList<PieChart.Data> diagramAuthorO= FXCollections.observableArrayList();
	@FXML
	private PieChart diagramBooks;
	@FXML
	private PieChart diagramAuthors;

	public void setStatisticBook(){
		List<StatisticBook> listBook= new ArrayList<StatisticBook>();
		listBook.addAll(statisticBook());
		int sum=0;
		for(int i=0; i<listBook.size(); i++){
			sum+=listBook.get(i).getBooksStatistic();
		}
		for(int i=0; i<listBook.size(); i++){
			double d=listBook.get(i).getBooksStatistic()*100/sum;
			diagramBookO.add(new PieChart.Data(listBook.get(i).getBook()+" "+d+"%",listBook.get(i).getBooksStatistic()));
			
		}
		
		diagramBooks.setData(diagramBookO);
		diagramBooks.setTitle("Most serched books (in %)");
		
	}
	public void setStatisticAuthor(){
		List<StatisticAuthor> listAuthor= new ArrayList<StatisticAuthor>();
		listAuthor.addAll(statisticAuthor());
		int sum=0;
		for(int i=0; i<listAuthor.size(); i++){
			sum+=listAuthor.get(i).getAuthorStatistic();
		}
		for(int i=0; i<listAuthor.size(); i++){
			double d=listAuthor.get(i).getAuthorStatistic()*100/sum;
			diagramAuthorO.add(new PieChart.Data(listAuthor.get(i).getAuthor()+" "+d+"%",listAuthor.get(i).getAuthorStatistic()));
		}
		diagramAuthors.setData(diagramAuthorO);
		diagramAuthors.setTitle("Most serched authors (in %)");
	}
	public List<StatisticBook> statisticBook(){
		StatisticBookIntf statBookDao= new StatisticBookImpl();
		List<StatisticBook> listBook= new ArrayList<StatisticBook>();
		List<StatisticBook> listBook1= new ArrayList<StatisticBook>();
		List<StatisticBook> listBook2= new ArrayList<StatisticBook>();
		List<StatisticBook> listBook3= new ArrayList<StatisticBook>();
		listBook.addAll(statBookDao.findAll());
		listBook2.addAll(statBookDao.findAll());
		
		for(int i=0; i<listBook2.size(); i++){
			StatisticBook statBook= new StatisticBook();
			for(int j=0; j<listBook.size(); j++){
				StatisticBook statBook1= new StatisticBook();
				statBook1=listBook.get(j);
				if(statBook.getBooksStatistic()<=statBook1.getBooksStatistic()){
					statBook=statBook1;
				}
			}
			listBook1.add(statBook);
			listBook.remove(statBook);
		}
		if(listBook1.size()<10){
			for(int i=0; i<listBook1.size(); i++){
				listBook3.add(listBook1.get(i));
			}
		}else{
			for(int i=0; i<10; i++){
				listBook3.add(listBook1.get(i));
			}
		}

	return listBook3;
	}
	public List<StatisticAuthor> statisticAuthor(){
		StatisticAuthorIntf statAuthorDao= new StatisticAuthorImpl();
		List<StatisticAuthor> listAuthor= new ArrayList<StatisticAuthor>();
		List<StatisticAuthor> listAuthor1= new ArrayList<StatisticAuthor>();
		List<StatisticAuthor> listAuthor2= new ArrayList<StatisticAuthor>();
		List<StatisticAuthor> listAuthor3= new ArrayList<StatisticAuthor>();
		listAuthor.addAll(statAuthorDao.findAll());
		listAuthor2.addAll(statAuthorDao.findAll());
		
		for(int i=0; i<listAuthor2.size(); i++){
			StatisticAuthor statAuthor= new StatisticAuthor();
			for(int j=0; j<listAuthor.size(); j++){
				StatisticAuthor statAuthor1= new StatisticAuthor();
				statAuthor1=listAuthor.get(j);
				if(statAuthor.getAuthorStatistic()<=statAuthor1.getAuthorStatistic()){
					statAuthor=statAuthor1;
				}
			}
			listAuthor1.add(statAuthor);
			listAuthor.remove(statAuthor);
		}
		if(listAuthor1.size()<10){
			for(int i=0; i<listAuthor1.size(); i++){
				listAuthor3.add(listAuthor1.get(i));
			}
		}else{
			for(int i=0; i<10; i++){
				listAuthor3.add(listAuthor1.get(i));
			}
		}

	return listAuthor3;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		 setStatisticBook();
		 setStatisticAuthor();
	}
}
