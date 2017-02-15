package com.vasea.daoImpl;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FormValidator {
	
	public static boolean textFieldNotEmpty(TextField text) {
		
	boolean r=false;
	if(text.getText()!=null && !text.getText().isEmpty()){
		r=true;
	}
	return r;
	}
	
	public static boolean textFieldNotEmpty(TextField text, Label label, String validationText) {
		boolean r=false;
		String c=null;
		if(!textFieldNotEmpty(text)){
			r=false;
			c=validationText;
		}
		label.setText(c);
		
		return r;
	}
}
