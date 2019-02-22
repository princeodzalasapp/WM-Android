package com.princeodzalasapp.fr.wmandroidui.models;

public class MyListe {

    private String code;
    private String nom;
    private String imageUrl;

    public MyListe(String nom, String imageUrl, String code) {
        this.code = code;
        this.nom = nom;
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() { return imageUrl; }
    public String getNom() { return nom; }
    public String getCode() { return code; }

}
