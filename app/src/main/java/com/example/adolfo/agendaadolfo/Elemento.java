package com.example.adolfo.agendaadolfo;

import java.io.Serializable;

/**
 * Created by adolf on 02/12/2016.
 */

public class Elemento implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    String telefono,rFoto, email, direcicon,web;
    private String nombre;

    public Elemento(String nombre,long id,String telefono,String rFoto){
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
        this.rFoto = rFoto;
    }
    public Elemento(String nombre,long id,String telefono,String rFoto,String email,String direccion,String web){
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
        this.rFoto = rFoto;
        this.email = email;
        this.direcicon = direccion;
        this.web = web;
    }

    public String getNombre(){return nombre;}

    public long getId(){return id;}

    public String getTelefono(){return telefono; }

    public String getEmail(){return email;}

    public String getDirecicon(){return direcicon;}

    public String getWeb(){return web;}

    public String getFoto(){return rFoto;}


    public void setId(long id){this.id = id;}

    public void setNombre(){this.nombre = nombre;}

    public void setTelefono(){this.telefono = telefono;}

    public void setImagen(String url){this.rFoto = url; }

    public void setEmail(){this.email = email;}

    public void setDirecicon(){this.direcicon = direcicon;}

    public void setWeb(){this.web = web;}
}

