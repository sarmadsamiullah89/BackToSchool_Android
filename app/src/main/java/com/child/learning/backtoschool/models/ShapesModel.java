package com.child.learning.backtoschool.models;

public class ShapesModel {
    int image;
    String title;

    public ShapesModel() {
    }

    public ShapesModel(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
