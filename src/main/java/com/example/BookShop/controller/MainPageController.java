package com.example.BookShop.controller;

import com.example.BookShop.entity.Author;
import com.example.BookShop.entity.Book;
import com.example.BookShop.service.AuthorService;
import com.example.BookShop.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(description = "authors data")
@Controller
@RequestMapping("/")
public class MainPageController {


    private final BookService bookService;
    private final AuthorService authorService;
    Logger logger = LoggerFactory.getLogger(MainPageController.class);

    @Autowired
    public MainPageController(AuthorService authorService,BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }


    @GetMapping
    public String mainPage(Model model) {
        logger.info("Db data: " + authorService.getAlphabetAndAuthors());
        model.addAttribute("bookData", bookService.getBooksData());
        return "index";
    }

    @GetMapping("/genres")
    public String genresPage(Model model) {
        return "genres/genres";
    }


    @GetMapping("/authors")
    public String authorsPage(Model model)
    {
        model.addAttribute("authorData", authorService.getAlphabetAndAuthors() );

        return "authors/authors";
    }

    @GetMapping("/books/recent")
    public String noveltyPage() {
        return "books/recent";
    }

    @ModelAttribute("booksList")
    public List<Book> bookList(){
        return bookService.getBooksData();
    }

    @GetMapping("/books/popular")
    public String popularBooksPage() {
        return "books/popular";
    }

    @GetMapping("/signin")
    public String signinPage() {
        return "signin";
    }

    @GetMapping("/documents")
    public String docPage() {
        return "documents/index";
    }

    @GetMapping("/about")
    public String aboutAppPage() {
        return "about";
    }

    @GetMapping("/faq")
    public String faqPage() {
        return "faq";
    }

    @GetMapping("/contacts")
    public String contactsPage() {
        return "contacts";
    }

    @GetMapping("/cart")
    public String cartPage() {
        return "cart";
    }

    @GetMapping("/search")
    public String searchResultsPage(Model model) {return "search/index";}

    @GetMapping("/postponed")
    public String postponedPage(Model model) {
        return "postponed";
    }

    @ApiOperation("method to get map of authors")
    @ResponseBody
    @GetMapping("/api/authors")
    public Map<String, List<Author>> author(){
        return authorService.getAlphabetAndAuthors();
    }

}
