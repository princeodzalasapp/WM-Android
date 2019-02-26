package com.princeodzalasapp.fr.wmandroidui.Models;

public class MyListe {

    private String code;
    private String nom;
    private String color;

    public MyListe(String nom, String code) {
        this.code = code;
        this.nom = nom;
    }

    public MyListe(String nom, String code, String color) {
        this.code = code;
        this.nom = nom;
        this.color = color;
    }

    public String getNom() { return nom; }
    public String getCode() { return code; }
    public String getColor() { return color; }

}
