package com.example.BookShop.dao;

import com.example.BookShop.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Transactional
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


    @Query("from Book where is_bestseller = 1")
    List<Book> getBestseller();

    @Query(value="SELECT * FROM books WHERE discount = (SELECT MAX(discount) FROM books)", nativeQuery=true)
    List<Book> getBooksWithMaxDiscount();

    @Modifying
    @Query(value="UPDATE books SET popularity=soldbooks+((7*booksincart)/10)+((4*deferredbooks)/10)", nativeQuery=true)
    void makeBooksListByPopularity();

    @Query(value="SELECT * FROM books WHERE popularity = (SELECT MAX(popularity) FROM books)", nativeQuery=true)
    List<Book> getTheMostPopularBook();

    @Query(value="SELECT * FROM books ORDER BY popularity DESC", nativeQuery=true)
    List<Book> getBooksByPopularity();

    @Query(value="SELECT * FROM books ORDER BY popularity DESC", nativeQuery=true)
    Page<Book> getBooksByPopularity(Pageable nextPage);

    Page<Book> findBookByTitleContaining(String bookTitle, Pageable nextPage);

    @Query(value="SELECT * FROM books where ?1 = any(tags) ", nativeQuery=true)
    Page<Book> findBooksByTagsEquals(Integer tag, Pageable nextPage);

    Page<Book> findBooksByPubDateBetween(Date from, Date to, Pageable nextPage);

    Page<Book> findBooksByOrderByRatingDesc(Pageable nextPage);

    Page<Book> findBooksByGenreEquals(Integer genreId, Pageable nextPage);

    @Query(value="SELECT * FROM books where genre in (SELECT id FROM genre where parent_id = ?1)", nativeQuery=true)
    Page<Book> getParentGenre(Integer genreId, Pageable nextPage);

    Page<Book> findBooksByAuthorId(Integer authorId, Pageable nextPage);
}
