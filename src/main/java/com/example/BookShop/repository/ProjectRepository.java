package com.example.BookShop.repository;

import java.util.List;

public interface ProjectRepository<T> {
    List<T> getAll();
    T getById(Integer id);
}