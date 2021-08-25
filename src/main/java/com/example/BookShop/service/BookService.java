package com.example.BookShop.service;

import com.example.BookShop.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class BookService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getBookData() {
        List<Book> books = jdbcTemplate.query("SELECT * FROM books", (ResultSet rs, int rowNum)->{
           Book book = new Book();
           book.setId(rs.getInt("id"));
           book.setAuthor(rs.getString("author"));
           book.setTitle(rs.getString("title"));
           book.setPriceOld(rs.getString("priceOld"));
           book.setPrice(rs.getString("price"));
            Logger.getLogger("The entitiy book contain: " + book);
           return book;
        });
        return new ArrayList<>(books);
    }

    public List<Book> getAuthorData() {
        List<Book> books = jdbcTemplate.query("SELECT * FROM authors", (ResultSet rs, int rowNum)->{
            Book book = new Book();
            book.setAuthor(rs.getString("author"));
            Logger.getLogger("The entitiy book contain: " + book);
            return book;
        });
        return new ArrayList<>(books);
    }


}
