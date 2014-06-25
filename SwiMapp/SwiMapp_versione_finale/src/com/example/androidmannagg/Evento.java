package com.example.androidmannagg;

public class Evento {
	 
    private  String _city = "";
    private  double _lng;
    private  double _lat;
    private String _nome = "";
    private String _data = "";
    private String _piscina = "";
    private String _sito ="";
    private String _categoria = "";
    
    public Evento(String city,double lng,double lat,String nome,String piscina,String data, String sito, String categoria){
    	_city = city;
    	_lng = lng;
    	_lat = lat;
    	_nome = nome;
    	_data = data;
    	_piscina = piscina;
    	_sito = sito;
    	_categoria = categoria;
    }
     
    /************* Define Setter Methods *********/
     
    public void setcity(String city)
    {
        _city = city;
    }
    public void setlng(double lng)
    {
        _lng = lng;
    }
    public void setlat(double lat)
    {
        _lat = lat;
    }
    public void setnome(String nome)
    {
        _nome = nome;
    }
    public void setdata(String data)
    {
        _data = data;
    }
    
    public void setpiscina(String piscina){
    	_piscina = piscina;
    }
    
     
     
    /************* Define Getter Methods *********/
     
    public String getCity()
    {
        return _city;
    }
     
    public double getLng()
    {
        return _lng;
    }
    public double getLat()
    {
        return _lat;
    }
   
    public String getNome()
    {
        return _nome;
    }
    public String getPiscina()
    {
        return _piscina;
    }
    public String getData(){
    	return _data;
    }
    public String getCategoria(){
    	return _categoria;
    }
    public String getSito(){
    	return _sito;
    }
    
} 