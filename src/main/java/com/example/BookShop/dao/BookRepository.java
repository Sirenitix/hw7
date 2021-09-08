package com.example.BookShop.dao;

import com.example.BookShop.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BookRepository extends JpaRepository<Book,Integer> {

    List<Book> findBooksByAuthor_Firstname(String name);

    @Query("from Book")
    List<Book> customFindAllBooks();

}
