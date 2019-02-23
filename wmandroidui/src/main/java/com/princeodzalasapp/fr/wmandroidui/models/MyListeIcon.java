package com.princeodzalasapp.fr.wmandroidui.models;

public class MyListeIcon {

    private String code;
    private String nom;
    private String imageUrl;

    public MyListeIcon(String nom, String imageUrl, String code) {
        this.code = code;
        this.nom = nom;
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() { return imageUrl; }
    public String getNom() { return nom; }
    public String getCode() { return code; }

}
