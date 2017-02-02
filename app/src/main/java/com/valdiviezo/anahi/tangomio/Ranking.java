package com.valdiviezo.anahi.tangomio;

/**
 * Created by avaldiviezo on 2/1/17.
 */
public class Ranking {

    private String nombre;
    private String autor;
    private String posicion;
    private String linkVideo;

    public Ranking(String nombre, String autor, String posicion, String linkVideo) {
        this.nombre = nombre;
        this.autor = autor;
        this.posicion = posicion;
        this.linkVideo = linkVideo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }


    public String getLinkVideo() {
        return linkVideo;
    }

    public void setLinkVideo(String linkVideo) {
        this.linkVideo = linkVideo;
    }

}
