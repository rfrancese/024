package com.example.androidmannagg;

public class Utente {

	String _username, _password;
	
	public Utente(String username,String password){
		_username = username;
		_password = password;
	}
	
	public Utente(){
		_username = "";
		_password = "";
	}
	
	public String getUsername(){
		return _username;
	}
	public String getPassword(){
		return _password;
	}
	
	public void setUsername(String username){
		_username = username;
	}
	public void setPassword(String password){
		_password = password;
	}
	
}
