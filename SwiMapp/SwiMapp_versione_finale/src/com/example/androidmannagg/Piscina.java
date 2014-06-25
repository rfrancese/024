package com.example.androidmannagg;

public class Piscina {
	private  String _city = "";
    private  double _lng;
    private  double _lat;
    private String _nome = "";
    private String _telefono = "";
    private String _sito = "";
    private String _indirizzo = "";
    
    public Piscina(String city,double lng,double lat,String nome,String telefono, String sito, String indirizzo){
    	_city = city;
    	_lng = lng;
    	_lat = lat;
    	_nome = nome;
    	_telefono = telefono;
    	_sito = sito;
    	_indirizzo = indirizzo;
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
    public void settelefono(String telefono)
    {
        _telefono = telefono;
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
    public String getTelefono()
    {
        return _telefono;
    }
    public String getSito()
    {
        return _sito;
    }
    public String getIndirizzo()
    {
        return _indirizzo;
    }
}
