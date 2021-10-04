package com.example.BookShop.service;

import com.example.BookShop.dao.AuthorRepository;
import com.example.BookShop.dao.BookRepository;
import com.example.BookShop.dao.GenreRepository;
import com.example.BookShop.entity.Author;
import com.example.BookShop.entity.Book;
import com.example.BookShop.entity.genre.GenreEntity;
import com.example.BookShop.utils.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.text.ParseException;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;
    private final AuthorRepository authorRepository;
    Logger logger = LoggerFactory.getLogger(BookService.class);


    @Autowired
    public BookService(BookRepository bookRepository, GenreRepository genreRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
        this.authorRepository = authorRepository;
    }

    public List<Book> getBooksData() {
        return bookRepository.customFindAllBooks();
    }

    //New methods

    public List<Book> getBooksByAuthor(String authorName){
        return bookRepository.findBooksByAuthorFirstnameContaining(authorName);
    }

    public Page<Book> getBooksByAuthor(Integer offset, Integer limit,Integer authorId){
        Pageable nextPage = PageRequest.of(offset,limit);
        return bookRepository.findBooksByAuthorId(authorId, nextPage);
    }

    public List<Book> getBooksByTitle(String title){
        return bookRepository.findBooksByTitleContaining(title);
    }

    public List<GenreEntity> getParentGenres(){
        return genreRepository.findAllByOrderByParentIdAsc();
    }

    public List<Book> getBooksWithPriceIsBetween(Integer min, Integer max){
        return bookRepository.findBooksByPriceOldIsBetween(min,max);
    }

    public List<Book> getBooksWithPrice(Integer price){
        return bookRepository.findBooksByPriceOldIs(price);
    }

    public List<Book> getBooksWithMaxPrice(){
        return bookRepository.getBooksWithMaxDiscount();
    }

        public List<Book> getTheMostPopularBook()
        {
            bookRepository.makeBooksListByPopularity();
            return bookRepository.getTheMostPopularBook();
        }

    public List<Book> getPopularBooks()
    {
        bookRepository.makeBooksListByPopularity();
        return bookRepository.getBooksByPopularity();
    }

    public List<Book> getBestseller(){
        return bookRepository.getBestseller();
    }

    public Page<Book> getPageOfRecommendedBooks(Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset,limit);
        return bookRepository.findBooksByOrderByRatingDesc(nextPage);
    }

    public Page<Book> getPageOfNoveltyBooks(Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset,limit);
        return bookRepository.findAll(nextPage);
    }

    public Page<Book> getPageOfPopularBooks(Integer offset, Integer limit){
        bookRepository.makeBooksListByPopularity();
        Pageable nextPage = PageRequest.of(offset,limit);
        return bookRepository.getBooksByPopularity(nextPage);
    }

    public Page<Book> getPageOfSearchResultBooks(String searchWord, Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset,limit);
        return bookRepository.findBookByTitleContaining(searchWord,nextPage);
    }

    public Page<Book> getPageOfNoveltyResultBooks(String from, String to, Integer offset, Integer limit) throws ParseException {
        Converter fromTypeString = new Converter(from);
        Converter toTypeString = new Converter(to);
        Pageable nextPage = PageRequest.of(offset,limit);
        return bookRepository.findBooksByPubDateBetween(fromTypeString.getDateType(), toTypeString.getDateType(), nextPage);
    }

    public Page<Book> getPageOfPopularResultBooks(Integer offset, Integer limit) {
        bookRepository.makeBooksListByPopularity();
        Pageable nextPage = PageRequest.of(offset, limit);
        return bookRepository.getBooksByPopularity(nextPage);
    }

    public Page<Book> getPageOfTagResult(Integer tagId, Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset,limit);
        return bookRepository.findBooksByTagsEquals(tagId,nextPage);
    }

    public Page<Book> getPageOfTag(Integer genreId, Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset,limit);
        if (genreId > 200){
           return bookRepository.getParentGenre(genreId, nextPage);
        }
        return bookRepository.findBooksByGenreEquals(genreId, nextPage);
    }


}
