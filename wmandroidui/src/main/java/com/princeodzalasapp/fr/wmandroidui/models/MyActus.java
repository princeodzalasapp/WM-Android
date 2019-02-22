package com.princeodzalasapp.fr.wmandroidui.models;

public class MyActus {

    private String code;
    private String nom;
    private String imageUrl;
    private String photoUrl;
    private String club;
    private String desciption;
    private int like;
    private int comment;
    private String date;
    private int moilike;

    public MyActus(String code, String nom, String imageUrl, String photoUrl, String club, String desciption, int like, int comment, String date , int moilike) {
        this.code = code;
        this.nom = nom;
        this.imageUrl = imageUrl;
        this.photoUrl = photoUrl;
        this.club = club;
        this.desciption = desciption;
        this.like = like;
        this.comment = comment;
        this.date = date;
        this.moilike = moilike;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getPhotoUrl() {
        return photoUrl;
    }
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
    public String getClub() {
        return club;
    }
    public void setClub(String club) {
        this.club = club;
    }
    public String getDesciption() {
        return desciption;
    }
    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }
    public int getLike() {
        return like;
    }
    public void setLike(int like) {
        this.like = like;
    }
    public int getComment() {
        return comment;
    }
    public void setComment(int comment) {
        this.comment = comment;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public int getMoilike() {
        return moilike;
    }
    public void setMoilike(int moilike) {
        this.moilike = moilike;
    }

}
