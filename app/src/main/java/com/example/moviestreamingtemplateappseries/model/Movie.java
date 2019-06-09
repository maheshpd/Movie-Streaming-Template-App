package com.example.moviestreamingtemplateappseries.model;

public class Movie {
    private String title;
    private String description;
    private String studio;
    private int thumbnail;
    private String rating;
    private String straminglink;
    private int coverPhoto;

    public Movie(String title, int thumbnail) {
        this.title = title;
        this.thumbnail = thumbnail;
    }

    public Movie(String title, int thumbnail, int coverPhoto) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.coverPhoto = coverPhoto;
    }

    public Movie(String title, String description, String studio, int thumbnail, String rating, String straminglink) {
        this.title = title;
        this.description = description;
        this.studio = studio;
        this.thumbnail = thumbnail;
        this.rating = rating;
        this.straminglink = straminglink;
    }

    public int getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(int coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getStraminglink() {
        return straminglink;
    }

    public void setStraminglink(String straminglink) {
        this.straminglink = straminglink;
    }
}
