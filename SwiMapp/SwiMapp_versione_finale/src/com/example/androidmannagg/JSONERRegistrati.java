package com.example.androidmannagg;

import java.net.URL;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class JSONERRegistrati {

	String _nome, _cognome, _username, _password;
	
	public JSONERRegistrati(String nome, String cognome, String username, String password){
		
		_nome = nome;
		_cognome = cognome;
		_username = username;
		_password = password;
		
	}
	
}
