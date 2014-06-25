package com.example.androidmannagg;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.*;
import org.apache.http.client.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class JSONERUtenti {

	Utente _utenti;
	String _username, _password;
        
        public JSONERUtenti(String username, String password){
        	_utenti = new Utente();
        	_username = username;
        	_password = password;
        }
 
    
 
    public Utente inviaDati(){
        String result = "";
        String stringaFinale = "";
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("username",_username));
        nameValuePairs.add(new BasicNameValuePair("password",_password));
        InputStream is = null;
        
        //http post
        try{
                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost("http://www.swimapp.altervista.org/cercaUtente.php");
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                HttpResponse response = httpclient.execute(httppost);
                HttpEntity entity = response.getEntity();
                Log.i("OK: ","OK");
                is = entity.getContent();
        }catch(Exception e){
                Log.e("TEST", "Errore nella connessione http "+e.toString());
                return null;
        }
        
        if(is != null){
            //converto la risposta in stringa
            try{
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
                    StringBuilder sb = new StringBuilder();
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                            sb.append(line + "\n");
                    }
                    is.close();
 
                    result=sb.toString();
                    Log.i("result: ",result);
            }catch(Exception e){
                    Log.e("TEST", "Errore nel convertire il risultato "+e.toString());
                    return null;
            }
 
            //parsing dei dati arrivati in formato json
            try{
            		
            		if(result!=null){
                    JSONArray jArray = new JSONArray(result);
                    
                    for(int i=0;i<jArray.length();i++){
                            JSONObject json_data = jArray.getJSONObject(i);
                            //Log.i("TEST","id: "+json_data.getString("paese"));
                            _utenti.setUsername(json_data.getString("username"));
                            _utenti.setPassword(json_data.getString("password"));
                    } return _utenti;
            		}
            		else return null;
            }
            catch(JSONException e){
                    Log.e("log_tag", "Error parsing data "+e.toString());
                    return null;
            }
        }
        else{
        	
        	return null;
 
        }
    }
}