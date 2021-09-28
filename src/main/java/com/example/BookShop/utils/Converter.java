package com.example.BookShop.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Converter {

    java.sql.Date sqlDateFormat;

    public java.sql.Date getDateType() {
        return sqlDateFormat;
    }

    public Converter(String givenString) throws ParseException {
        DateFormat currentFormat = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat properFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date utilDateFormat = currentFormat.parse(givenString);
        String formattedString = properFormat.format(utilDateFormat);
        sqlDateFormat = java.sql.Date.valueOf(formattedString);
    }
}
