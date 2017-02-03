package com.valdiviezo.anahi.tangomio;

/**
 * Created by avaldiviezo on 1/31/17.
 */
public class Tienda {

    private String nombreTienda;
    private String ubicacionTienda;
    private String telefonoTienda;

    private String imageUrl;
    private String mapTienda;

    public Tienda(String nombreTienda, String ubicacionTienda, String telefonoTienda,String imageUrl, String mapTienda) {
        this.nombreTienda = nombreTienda;
        this.ubicacionTienda = ubicacionTienda;
        this.telefonoTienda = telefonoTienda;
        this.imageUrl = imageUrl;
        this.mapTienda = mapTienda;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public String getUbicacionTienda() {
        return ubicacionTienda;
    }

    public void setUbicacionTienda(String direccion) {
        this.ubicacionTienda = direccion;
    }

    public String getTelefonoTienda() {
        return telefonoTienda;
    }

    public void setTelefonoTienda(String telefonoTienda) {
        this.telefonoTienda = telefonoTienda;
    }

    public String getMapTienda() {
        return mapTienda;
    }

    public void setMapTienda(String mapTienda) {
        this.mapTienda = mapTienda;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
