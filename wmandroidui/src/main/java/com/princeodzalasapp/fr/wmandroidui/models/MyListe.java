package com.princeodzalasapp.fr.wmandroidui.models;

public class MyListe {

    private String code;
    private String nom;

    public MyListe(String nom, String code) {
        this.code = code;
        this.nom = nom;
    }

    public String getNom() { return nom; }
    public String getCode() { return code; }

}
