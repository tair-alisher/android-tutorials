package com.example.booklist.model;

import java.io.Serializable;

public class Book implements Serializable {

    private String title;
    private String description;
    private String imgUrl;
    private int pages;
    private int reviews;
    private float rating;
    private int drawableResource;

    public Book() { }

    public Book(int drawableResource) {
        this.drawableResource = drawableResource;
    }

    public Book(String title, String description, String imgUrl, int pages, int reviews, float rating, int drawableResource) {
        this.title = title;
        this.description = description;
        this.imgUrl = imgUrl;
        this.pages = pages;
        this.reviews = reviews;
        this.rating = rating;
        this.drawableResource = drawableResource;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getReviews() {
        return reviews;
    }

    public void setReviews(int reviews) {
        this.reviews = reviews;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getDrawableResource() {
        return drawableResource;
    }

    public void setDrawableResource(int drawableResource) {
        this.drawableResource = drawableResource;
    }
}
