package com.valdiviezo.anahi.tangomio;

/**
 * Created by avaldiviezo on 2/3/17.
 */
public class Taller {

    private String index;
    private String urlImage;

    public Taller(String index, String imageUrl) {
        this.index = index;
        this.urlImage = imageUrl;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlimage(String imageUrl) {
        this.urlImage = imageUrl;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }



}
