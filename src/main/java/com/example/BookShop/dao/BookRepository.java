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

    //New Rest Repository
    List<Book> findBooksByAuthorFirstnameContaining(String authorFirstName);

    List<Book> findBooksByTitleContaining(String bookTitle);

    List<Book> findBooksByPriceOldIsBetween(Integer min, Integer max);

    List<Book> findBooksByPriceOldIs(Integer price);

    @Query("from Book where is_bestseller=1")
    List<Book> getBestseller();

    @Query(value="SELECT * FROM books WHERE discount = (SELECT MAX(discount) FROM books)", nativeQuery=true)
    List<Book> getBooksWithMaxDiscount();

}
