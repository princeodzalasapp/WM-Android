package com.princeodzalasapp.fr.wmandroidui.models;

public class MyListeIcon {

    private String code;
    private String nom;
    private String imageUrl;
    private String color;
    private String colorIcon;

    public MyListeIcon(String nom, String imageUrl, String code) {
        this.code = code;
        this.nom = nom;
        this.imageUrl = imageUrl;
    }

    public MyListeIcon(String nom, String imageUrl, String code, String color) {
        this.code = code;
        this.nom = nom;
        this.imageUrl = imageUrl;
        this.color = color;
    }

    public MyListeIcon(String nom, String imageUrl, String code, String color, String colorIcon) {
        this.code = code;
        this.nom = nom;
        this.imageUrl = imageUrl;
        this.color = color;
        this.colorIcon = colorIcon;
    }

    public String getImageUrl() { return imageUrl; }
    public String getNom() { return nom; }
    public String getCode() { return code; }
    public String getColor() { return color; }
    public String getColorIcon() { return colorIcon; }

}
