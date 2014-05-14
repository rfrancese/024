package com.example.swimapp;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;
import android.app.Activity;
import android.os.Bundle;

public class MappaEventi extends Activity {
	  static final LatLng HAMBURG = new LatLng(53.558, 9.927);
	  static final LatLng KIEL = new LatLng(53.551, 9.993);
	  private GoogleMap map;

	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.mappaeventi);
	    map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
	        .getMap();
	    
	    if (map!=null){
	      Marker hamburg = map.addMarker(new MarkerOptions().position(HAMBURG)
	          .title("Hamburg"));
	      Marker kiel = map.addMarker(new MarkerOptions()
	          .position(KIEL)
	          .title("Kiel")
	          .snippet("Kiel is cool")
	          .icon(BitmapDescriptorFactory
	              .fromResource(R.drawable.ic_launcher)));
	    }
	    
	  }
}
	
  /* @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mappaeventi);
 
        TextView provincia = (TextView) findViewById(R.id.provincia);
        
        Bundle datipassati = getIntent().getExtras();  
        String value = "Eventi in provincia di "+datipassati.getString("Provincia"); 
    	
    	provincia.setText(value);
    	 
    }
    
 // get the selected dropdown list value
    
   
  	
  	
  		  

  		  
  	 
  	
    }*/

	
