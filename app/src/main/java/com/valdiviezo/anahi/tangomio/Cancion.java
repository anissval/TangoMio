package com.valdiviezo.anahi.tangomio;

/**
 * Created by Aniss on 01/02/2017.
 */
public class Cancion {

    private String nombreCancion;
    private String nombreAutor;
    private String linkVideo;

    public Cancion(String nombreCancion, String nombreAutor) {
        this.nombreCancion = nombreCancion;
        this.nombreAutor = nombreAutor;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getCancionAutor(){
        return getNombreCancion()+""+getNombreAutor();
    }

    public String getLinkVideo() {
        return linkVideo;
    }

    public void setLinkVideo(String linkVideo) {
        this.linkVideo = linkVideo;
    }




}
