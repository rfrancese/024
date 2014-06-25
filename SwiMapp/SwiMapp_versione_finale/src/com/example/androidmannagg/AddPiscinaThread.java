package com.example.androidmannagg;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;

import android.os.Looper;
import android.util.Log;

public class AddPiscinaThread extends Thread {

	String nome,indirizzo,citta;
	InserisciPiscina ins;
	String responso;
	int flag=0;
	
	public AddPiscinaThread(String n,String i,String c){
		
		nome = n;
	      indirizzo = i;
	      citta = c;
		
	}
	
	public void run(){
		 Looper.prepare();
		try {
			 ins = new InserisciPiscina(nome,indirizzo,citta);
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
