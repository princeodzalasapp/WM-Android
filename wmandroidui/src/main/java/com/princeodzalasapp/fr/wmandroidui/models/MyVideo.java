package com.princeodzalasapp.fr.wmandroidui.models;

public class MyVideo {

    private String code;
    private String nom;
    private String imageUrl;
    private String date;

    public MyVideo(String nom, String imageUrl, String code, String date) {
        this.code = code;
        this.nom = nom;
        this.imageUrl = imageUrl;
        this.date = date;
    }

    public String getImageUrl() { return imageUrl; }
    public String getNom() { return nom; }
    public String getCode() { return code; }
    public String getDate() { return date; }

}
