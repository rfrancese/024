package com.example.androidmannagg;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;

import android.util.Log;

public class ModificaEvenThread extends Thread {

	String nome,testo;
	ModificaEvento edit;
	String responso;
	int flag=0;
	
	public ModificaEvenThread(String n,String t){
		
		nome = n;
	      testo = t;
		
	}
	
	public void run(){
		try {
			 edit = new ModificaEvento(nome,testo);
			 responso = edit.getResponso();
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