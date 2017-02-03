package com.valdiviezo.anahi.tangomio;

/**
 * Created by avaldiviezo on 2/3/17.
 */
public class Ubicacion {
    private String direccion;
    private String provincia;
    private String departamento;
    private String mapUrl;

    public Ubicacion(String direccion, String provincia, String departamento, String mapUrl) {
        this.direccion = direccion;
        this.provincia = provincia;
        this.departamento = departamento;
        this.mapUrl = mapUrl;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMapUrl() {
        return mapUrl;
    }

    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }
}
