package com.example.BookShop.repository;

import com.example.BookShop.entity.Author;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorMapper implements RowMapper<Author> {

    @Override
    public Author mapRow(ResultSet rs, int num) throws SQLException {
        return new Author(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"));
    }
}