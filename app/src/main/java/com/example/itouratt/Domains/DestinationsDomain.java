package com.example.itouratt.Domains;

import java.io.Serializable;

public class DestinationsDomain implements Serializable {

    private String title;
    private String location;
    private String country;
    private String description;
    private int score;
    private double price;
    private String locImage;

    public DestinationsDomain(String title, String location, String country, String description, int score, double price, String locImage) {
        this.title = title;
        this.location = location;
        this.country = country;
        this.description = description;
        this.score = score;
        this.price = price;
        this.locImage = locImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLocImage() {
        return locImage;
    }

    public void setLocImage(String locImage) {
        this.locImage = locImage;
    }
}
