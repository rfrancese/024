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

public class JSONERPiscine {

	ArrayList<Piscina> _piscine;

        public JSONERPiscine(ArrayList<Piscina> piscine){
        	_piscine = piscine;
    }
        public JSONERPiscine(){
        	_piscine = new ArrayList<Piscina>();
        }
 
        
 
    public ArrayList<Piscina> inviaDati(){
        String result = "";
        String stringaFinale = "";
        InputStream is = null;
 
        //http post
        try{
                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost("http://www.swimapp.altervista.org/leggiPiscine_new.php");
                //httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                HttpResponse response = httpclient.execute(httppost);
                HttpEntity entity = response.getEntity();
                Log.i("OK: ","OK");
                is = entity.getContent();
        }catch(Exception e){
                Log.e("TEST", "Errore nella connessione http "+e.toString());
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
            }catch(Exception e){
                    Log.e("TEST", "Errore nel convertire il risultato "+e.toString());
            }
 
            //parsing dei dati arrivati in formato json
            try{
                    JSONArray jArray = new JSONArray(result);
                    for(int i=0;i<jArray.length();i++){
                            JSONObject json_data = jArray.getJSONObject(i);
                            //Log.i("TEST","id: "+json_data.getString("paese"));
                            stringaFinale = json_data.getString("paese");
                            _piscine.add(new Piscina(json_data.getString("paese"),json_data.getDouble("lng"),
                            		json_data.getDouble("lat"),json_data.getString("nome"),
                            		json_data.getString("telefono"), json_data.getString("sito"), json_data.getString("indirizzo")));
                    }
            }
            catch(JSONException e){
                    Log.e("log_tag", "Error parsing data "+e.toString());
            }
        }
        else{//is è null e non ho avuto risposta
 
        }
 
        return _piscine;
    }
}