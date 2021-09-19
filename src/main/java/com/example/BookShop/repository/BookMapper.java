package com.example.BookShop.repository;

import com.example.BookShop.entity.Author;
import com.example.BookShop.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class BookMapper implements RowMapper<Book> {

    //нужен здесь т.к. авторы храняться в отдельной таблице
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookMapper(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Book mapRow(ResultSet rs, int i) throws SQLException {
//         получим автора из таблицы авторов по id указанной в таблице book
        Author author = jdbcTemplate.queryForObject("select * from authors where id = ?",
                new AuthorMapper(),
                rs.getInt("author_id"));
        assert author != null;
        return new Book(
                rs.getInt("id"),
                author,
                rs.getString("pub_date"),
                rs.getString("is_bestseller"),
                rs.getString("slug"),
                rs.getString("image"),
                rs.getString("description"),
                rs.getString("title"),
                rs.getInt("price"),
                rs.getDouble("discount")
                );
    }


}