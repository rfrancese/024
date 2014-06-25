package com.example.androidmannagg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MappaPiscine extends FragmentActivity implements OnMarkerClickListener {
	 
    // Google Map
    private GoogleMap googleMap;
    
    private LocationManager locationManager;
    double lat=0, lng=0;
    ArrayList<Piscina> piscine = new ArrayList<Piscina>();
    ArrayList<MarkerDati> markers = new ArrayList<MarkerDati>();
	JSONERPiscine hello;
	String link="";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        
        Criteria criteria = new Criteria();
        String provider = locationManager.getBestProvider(criteria, false);
        Location location = locationManager.getLastKnownLocation(provider);
       try{
        lng = (double) (location.getLongitude());
       lat = (double) (location.getLatitude());
       }
       catch(Exception e){
    	   
    	   lat = 40.8400969;
    	   lng = 14.2516357;
    	   
       }
       //lng = 14.269948;
       //lat = 40.875874;
         
         
         setContentView (R.layout.mappa_piscine);
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
            
           googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                    new LatLng(lat, lng), 10));
           
           addPuntatori();

           
           googleMap.setMyLocationEnabled(true);
            // You can customize the marker image using images bundled with
            // your app, or dynamically generated bitmaps. 
           
            
        }
    }
 
    @Override
    protected void onResume() {
        super.onResume();
        initilizeMap();
    }
    
   Thread t = new Thread(new Runnable(){

		@Override
		public void run() {
			hello = new JSONERPiscine();
			piscine = hello.inviaDati();
			}
      });
    
    public void addPuntatori(){
    	t.start();
           while(piscine.size()==0){
           //Log.i("size()",""+piscine.size());
        	   }
           Log.i("size()",""+piscine.size());
           addMarkers();
    }
    
    public void addMarkers(){
    	
    	for(int i=0;i<piscine.size();i++){
    	//Log.i("size()",""+piscine.size());
    		MarkerOptions m = new MarkerOptions()
            .title(piscine.get(i).getNome()).snippet("Città: "+piscine.get(i).getCity()+"\n\n "+piscine.get(i).getIndirizzo()+
            		"\n\nTelefono: "+piscine.get(i).getTelefono()) // Anchors the marker on the bottom left
            .position(new LatLng(piscine.get(i).getLat(),piscine.get(i).getLng()));
    		Marker marker = googleMap.addMarker(m);
    		String sito = piscine.get(i).getSito();
    		//String number = piscine.get(i).getTelefono();
    		markers.add(new MarkerDati(marker,sito));
    		googleMap.addMarker(m);
        	googleMap.setOnMarkerClickListener(this);
    		
    	}
    }

	@Override
	public boolean onMarkerClick(Marker m) {
		 Intent nextScreen = new Intent(getApplicationContext(), InformazioniPiscina.class);
	        //TO DO chiamata telefono
		 	String sitoToPass="";
		 	for(int i=0;i<markers.size();i++) if(markers.get(i).getMarker().equals(m)) sitoToPass = markers.get(i).getSito();

			nextScreen.putExtra("Titolo", m.getTitle());
			nextScreen.putExtra("Info", m.getSnippet());
			nextScreen.putExtra("Sito", sitoToPass);
	        startActivity(nextScreen);
	        return false;
	}
 
}