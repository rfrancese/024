package com.example.androidmannagg;

import java.util.ArrayList;

public class ThreadLogin extends Thread {

	String user, pass;
	JSONERUtenti json;
	Utente arlu;
	int flag=0;
	
	public ThreadLogin(String u, String p){
		user = u;
		pass = p;
	}
	
	@Override
	public void run() {
		
		json = new JSONERUtenti(user,pass);
		arlu = json.inviaDati();
		flag=1;
		
	}
	
	public Utente inviaDati(){
		return arlu;
	}
	public int getFlag(){
		return flag;
	}

}
