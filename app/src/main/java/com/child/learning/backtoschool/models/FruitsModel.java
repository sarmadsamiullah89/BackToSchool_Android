package com.child.learning.backtoschool.models;

public class FruitsModel {
    int image;
    String title;

    public FruitsModel() {
    }

    public FruitsModel(int image, String title) {
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
