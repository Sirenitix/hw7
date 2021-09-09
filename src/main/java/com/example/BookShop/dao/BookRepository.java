package com.example.BookShop.dao;

import com.example.BookShop.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    List<Book> findBooksByAuthor_Firstname(String name);

    @Query("from Book")
    List<Book> customFindAllBooks();

}
