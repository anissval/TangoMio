package com.valdiviezo.anahi.tangomio;

/**
 * Created by Aniss on 03/02/2017.
 */
public class Evento {

    private String index;
    private String urlImage;

    public Evento(String index, String urlImage) {
        this.index = index;
        this.urlImage = urlImage;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

}
