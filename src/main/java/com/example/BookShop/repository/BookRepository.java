package com.example.BookShop.repository;

import com.example.BookShop.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository implements ProjectRepository<Book> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Book> getAll() {
        return new ArrayList<>(jdbcTemplate.query("select * from books", new BookMapper(jdbcTemplate)));
    }

    @Override
    public Book getById(Integer id) {
        return jdbcTemplate.queryForObject("select * from books where id = ?", new BookMapper(jdbcTemplate), id);
    }
}