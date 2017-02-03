package com.valdiviezo.anahi.tangomio;

/**
 * Created by avaldiviezo on 1/30/17.
 */
public class Clase {
    private String horario;
    private String ubicacion;
    private String mapa;
    private String duracion;
    private String imageUrl;

    public Clase(String horario, String ubicacion, String mapa, String duracion, String imageUrl, String profesor) {
        this.horario = horario;
        this.ubicacion = ubicacion;
        this.mapa = mapa;
        this.duracion = duracion;
        this.imageUrl = imageUrl;
        this.profesor = profesor;
    }

    private String profesor;

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getMapa() {
        return mapa;
    }

    public void setMapa(String mapa) {
        this.mapa = mapa;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


}
