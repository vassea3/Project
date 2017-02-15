package com.vasea.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class Users {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUser;
	private String name;
	private String username;
	private String password;
	private String securityQuestion;
	private String answer;
	
	public Users() {
		super();
	}
	public Users(int idUser, String name, String username, String password, String securityQuestion,
			String answer) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.username = username;
		this.password = password;
		this.securityQuestion = securityQuestion;
		this.answer = answer;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "Users [idUser=" + idUser + ", name=" + name + ", username=" + username + ", password="
				+ password + ", securityQuestion=" + securityQuestion + ", answer=" + answer + "]";
	}
	
	
}
