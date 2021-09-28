package com.example.BookShop.controller;

import com.example.BookShop.entity.Book;
import com.example.BookShop.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RestController
@Api(description = "book data api")
public class BooksRestApiController {

    private final BookService bookService;

    @Autowired
    public BooksRestApiController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books/by-author")
    @ApiOperation("operation to get list of books by passed author first name")
    public ResponseEntity<List<Book>> booksByAuthor(@RequestParam("author") String authorName){
        return ResponseEntity.ok(bookService.getBooksByAuthor(authorName));
    }

    @GetMapping("/books/by-title")
    @ApiOperation("get books by book title")
    public ResponseEntity<List<Book>> booksByTitle(@RequestParam("title") String title){
        return ResponseEntity.ok(bookService.getBooksByTitle(title));
    }

    @GetMapping("/books/by-price-range")
    @ApiOperation("get books by price range from min price to max price")
    public ResponseEntity<List<Book>> priceRangeBooks(@RequestParam("min") Integer min,@RequestParam("max") Integer max){
        return ResponseEntity.ok(bookService.getBooksWithPriceIsBetween(min,max));
    }

    @GetMapping("/books/with-max-price")
    @ApiOperation("get list of books with max price")
    public ResponseEntity<List<Book>> maxPriceBooks(){
        return ResponseEntity.ok(bookService.getBooksWithMaxPrice());
    }

    @GetMapping("/books/the-most-popular")
    @ApiOperation("get list of books by their popularity")
    public ResponseEntity<List<Book>> theMostPopularBook(){

        return ResponseEntity.ok(bookService.getTheMostPopularBook());
    }

    @GetMapping("/books/allbooks")
    @ApiOperation("get all books")
    public ResponseEntity<List<Book>> allBooks(){

        return ResponseEntity.ok(bookService.getBooksData());
    }

    @GetMapping("/books/by-popularity")
    @ApiOperation("get list of books by their popularity")
    public ResponseEntity<List<Book>> popularBooks(){

        return ResponseEntity.ok(bookService.getPopularBooks());
    }

    @GetMapping("/books/bestsellsers")
    @ApiOperation("get bestseller books (which is_bestseller = 1)")
    public ResponseEntity<List<Book>> bestSellerBooks(){
        return ResponseEntity.ok(bookService.getBestseller());
    }

}
