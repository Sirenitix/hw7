package com.example.BookShop.repository;

import com.example.BookShop.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorRepository implements ProjectRepository<Author>{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Author> getAll() {
        return new ArrayList<>(jdbcTemplate.query("select * from authors", new AuthorMapper()));
    }

    @Override
    public Author getById(Integer id) {
        return jdbcTemplate.queryForObject("select * from authors where id = ?", new AuthorMapper(), id);
    }
}

