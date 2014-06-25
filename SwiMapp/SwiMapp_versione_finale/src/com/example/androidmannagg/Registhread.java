package com.example.androidmannagg;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;

import android.os.Looper;
import android.util.Log;

public class Registhread extends Thread {

	String _username,_password,_nome,_cognome;
	InserisciUtente ins;
	String responso;
	int flag=0;
	
	public Registhread(String username,String password,String nome,String cognome){
		
		_username = username;
	      _password = password;
	      _nome = nome;
	      _cognome = cognome;
		
	}
	
	public void run(){
		 Looper.prepare();
		try {
			 ins = new InserisciUtente(_username,_password,_nome,_cognome);
			 responso = ins.getResponso();
			 flag=1;
			 Log.i("FLAG",""+flag);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getFlag(){
		return flag;
	}
	
	public String getResponso(){
		return responso;
	}
	
}
