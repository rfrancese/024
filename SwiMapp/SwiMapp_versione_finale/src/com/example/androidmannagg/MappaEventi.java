package com.example.androidmannagg;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MappaEventi extends FragmentActivity implements OnMarkerClickListener {
	 
    // Google Map
    private GoogleMap googleMap;

    Bundle extras;
    double lat=0, lng=0;
    ArrayList<Evento> eventi = new ArrayList<Evento>();
	JSONEREventi hello;
	String value;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.mappa);
        
        /**-------------------**/
      
      /**---------**/
      
        try {
            // Loading map
            initilizeMap();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
 
    /**
     * function to load map. If map is not created it will create it for you
     * */
    private void initilizeMap() {
        if (googleMap == null) {
            googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(
                    R.id.map)).getMap();
 
            // check if map is created successfully or not
            if (googleMap == null) {
                Toast.makeText(getApplicationContext(),
                        "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                        .show();
            }
            
            extras  = getIntent().getExtras();
           
            value = extras.getString("Provincia");
            	
            switch(value){
            case "Salerno":{ lat=40.6779567; lng = 14.7659122; break;}
            case "Napoli":{lat=40.8400969; lng = 14.2516357; break;}
            case "Caserta":{lat=41.0754153; lng = 14.3321946; break;}
            case "Benevento":{lat=41.1304480; lng = 14.7811740; break;}
            case "Avellino":{lat=40.9147487; lng = 14.7927229; break;}
            }
            
           googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                    new LatLng(lat, lng), 10));
           
           addPuntatori();
           
            
        }
    }
 
    @Override
    protected void onResume() {
        super.onResume();
        initilizeMap();
    }
    
    public void showMarkers(){
    	try {
    		
			File stocks = new File("Eventi.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(stocks);
			doc.getDocumentElement().normalize();
			
			System.out.println("root of xml file" + doc.getDocumentElement().getNodeName());
			NodeList nodes = doc.getElementsByTagName("evento");
			System.out.println("==========================");
			
			for (int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);
			
				if (node.getNodeType() == Node.ELEMENT_NODE) 
				{
					Element element = (Element) node;
					//-----------
					googleMap.addMarker(new MarkerOptions()
                    .title(getValue("paese", element)).snippet("Informazioni") // Anchors the marker on the bottom left
                    .position(new LatLng(Double.parseDouble(getValue("lat", element)),Double.parseDouble(getValue("long", element)))));
					//-----------
					/*System.out.println("Città: " + getValue("paese", element));
					System.out.println("Latitudine: " + getValue("lat", element));
					System.out.println("Longitudine: " + getValue("long", element));
					System.out.println("-----------------------------------------");*/
				}
			}
		} 
		catch (Exception ex) {
			ex.printStackTrace();
			}
    	/*googleMap.addMarker(new MarkerOptions()
        .title("citymycity").snippet("infoplace") // Anchors the marker on the bottom left
        .position(new LatLng(lat,lng)));*/
    }
    private static String getValue(String tag, Element element) {
		NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = (Node) nodes.item(0);
		return node.getNodeValue();
	}
    
   
    
    Thread t = new Thread(new Runnable(){

		@Override
		public void run() {
			hello = new JSONEREventi(value);
			eventi = hello.inviaDati();
			}
      });
    
    public void addPuntatori(){
    	t.start();
           while(eventi.size()==0){
           //Log.i("size()",""+piscine. size());
        	   }
           //Log.i("size()",""+eventi.size());
           
           addMarkers();
    }
    
    public void addMarkers(){
    	if(eventi!=null){
    	for(int i=0;i<eventi.size();i++){
    	//Log.i("size()",""+eventi.size());
    	MarkerOptions m = new MarkerOptions()
        .title(eventi.get(i).getNome()).snippet("Città: "+eventi.get(i).getCity()+"\n\n Luogo: "+eventi.get(i).getPiscina()+
        			" \n\n Data: "+eventi.get(i).getData()+"\n\n Categorie: "+eventi.get(i).getCategoria()+
        			"\n\n"+eventi.get(i).getSito()) // Anchors the marker on the bottom left
        .position(new LatLng(eventi.get(i).getLat(),eventi.get(i).getLng()));
    	Marker marker = googleMap.addMarker(m);
    	googleMap.setOnMarkerClickListener(this);
    	//marker.onClickMarker(new Map.onClickMarker(){startActivity(MyClass.this,MyNewClass.class);});
    	//if(onMarkerClick(marker)) onMarkerClick(marker);
    	}
    	}
    	}
    
    public void onMarkerClicked(Marker m){
    	/*Intent nextScreen = new Intent(getApplicationContext(), MainActivity.class);

        //Sending data to another Activity
        

        startActivity(nextScreen);*/
    }

	@Override
	public boolean onMarkerClick(Marker m) {
		
        Intent nextScreen = new Intent(getApplicationContext(), InformazioneEvento.class);
        
		nextScreen.putExtra("Titolo", m.getTitle());
		nextScreen.putExtra("Info", m.getSnippet());
        startActivity(nextScreen);
        return false;
	}
   
 
}