package com.example.androidmannagg;

import com.google.android.gms.maps.model.Marker;

public class MarkerDati {

	Marker _marker;
	String _sito;
	
	public MarkerDati(Marker marker, String sito){
		
		_marker = marker;
		_sito = sito;
		
	}
	
	public String getSito(){
		return _sito;
	}
	
	public Marker getMarker(){
		return _marker;
	}
	
}
