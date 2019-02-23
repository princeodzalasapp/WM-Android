package com.princeodzalasapp.fr.wmandroidui.models;

public class MyListeUrl {

    private String code;
    private String nom;
    private String imageUrl;
    private String color;

    public MyListeUrl(String nom, String imageUrl, String code) {
        this.code = code;
        this.nom = nom;
        this.imageUrl = imageUrl;
    }
    public MyListeUrl(String nom, String imageUrl, String code, String color) {
        this.code = code;
        this.nom = nom;
        this.imageUrl = imageUrl;
        this.color = color;
    }

    public String getImageUrl() { return imageUrl; }
    public String getNom() { return nom; }
    public String getCode() { return code; }
    public String getColor() { return color; }

}
