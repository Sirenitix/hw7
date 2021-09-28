package com.example.BookShop.dao;

public class TagDto {

    private String taggy;

    public TagDto(String taggy) {
        this.taggy = taggy;
    }

    public TagDto(){}

    public int getTaggy() {
        return Integer.parseInt(taggy);
    }

    public void setTaggy(String taggy) {
        this.taggy = taggy;
    }
}
