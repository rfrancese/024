package com.example.androidmannagg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

public class ModificaEvento  extends AsyncTask<String,Void,String>{

   private TextView statusField,roleField;
   private Context context;
   private int byGetOrPost = 0; 
   
   String nome,testo;
   String responso;
   
   //flag 0 means get and 1 means post.(By default it is get.)
   // Costruttore che prendere due parametri, il contesto di utilizzo e la stringa da scrivere nel database
   public ModificaEvento(String n,String t) throws URISyntaxException, ClientProtocolException, IOException {
     // this.context = context;
     
      nome = n;
      testo = t;
      
      responso = doInBackground();
   }

   protected void onPreExecute(){

   }
   /**
    * Metodo che scrive nel database
    * @param username1
    * @return
    * @throws URISyntaxException
    * @throws ClientProtocolException
    * @throws IOException
    */
   protected String doInBackground() throws URISyntaxException, ClientProtocolException, IOException {
      
        	
            String link = "http://swimapp.altervista.org/modificaEvento.php?nome="
            +nome+"&testo="+testo+"_"+MainActivity.user;
            
            Log.v("url",link);
            URL url = new URL(link);
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet();
            request.setURI(new URI(link));
            HttpResponse response = client.execute(request);
            String responseString = new BasicResponseHandler().handleResponse(response);
            
            Log.i("response",""+responseString);
            return responseString;
      
   }
   @Override
   protected void onPostExecute(String result){
     
   }
   
   public String getResponso(){
	   return responso;
   }

@Override
protected String doInBackground(String... params) {
	// TODO Auto-generated method stub
	return null;
}
}