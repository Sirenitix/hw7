package com.example.BookShop.repository;

import com.example.BookShop.entity.Author;
import com.example.BookShop.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {

    //нужен здесь т.к. авторы храняться в отдельной таблице
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookMapper(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Book mapRow(ResultSet rs, int i) throws SQLException {
        return new Book(
                rs.getInt("id"),
                rs.getString("author"),
                rs.getString("title"),
                rs.getString("priceOld"),
                rs.getString("price")
        );
    }
}