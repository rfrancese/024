package com.example.androidmannagg;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;

import android.os.Looper;
import android.util.Log;

public class AddEventhread extends Thread {

	String nome,data,luogo,citta;
	InserisciEvento ins;
	String responso;
	int flag=0;
	
	public AddEventhread(String n,String d,String l,String c){
		
		nome = n;
	      data = d;
	      luogo = l;
	      citta = c;
		
	}
	
	public void run(){
		 Looper.prepare();
		try {
			 ins = new InserisciEvento(nome,data,luogo,citta);
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
