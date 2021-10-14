package com.example.BookShop.dao;

import javax.validation.constraints.NotEmpty;

public class SearchWordDto {


    private String example;

    public SearchWordDto(String example) {
        this.example = example;
    }

    public SearchWordDto(){}

    public String getExample() {

        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }
}

