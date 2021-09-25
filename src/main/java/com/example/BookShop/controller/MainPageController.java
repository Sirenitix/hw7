package com.example.BookShop.controller;

import com.example.BookShop.dao.BooksPageDto;
import com.example.BookShop.dao.SearchWordDto;
import com.example.BookShop.entity.Author;
import com.example.BookShop.entity.Book;
import com.example.BookShop.service.AuthorService;
import com.example.BookShop.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import liquibase.pro.packaged.S;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
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

    @ModelAttribute("booksList")
    public List<Book> bookList(){
        return bookService.getPageOfNoveltyBooks(0, 20).getContent();
    }

    @ModelAttribute("popularBooks")
    public List<Book> popularBooks(){
        return bookService.getPageOfPopularBooks(0, 20).getContent();
    }

    @ModelAttribute("recommendedBooks")
    public List<Book> recommendedBooks() {
        return bookService.getPageOfRecommendedBooks(0, 6).getContent();
    }

    @ModelAttribute("searchWordDto")
    public SearchWordDto searchWordDto() {
        return new SearchWordDto();
    }


    @ModelAttribute("searchResults")
    public List<Book> searchResults() {
        return new ArrayList<>();
    }

    @ModelAttribute("sizeOfSearchResults")
    public List<Book> sizeOfSearchResults() {
        return new ArrayList<>();
    }

    @GetMapping
    public String mainPage(Model model) {
        logger.info("Db data: " + authorService.getAlphabetAndAuthors());
        model.addAttribute("recommendedBooks");
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

    @GetMapping("/books/recommended")
    @ResponseBody
    public BooksPageDto getBooksPage(@RequestParam("offset") Integer offset,
                                     @RequestParam("limit") Integer limit) {
        return new BooksPageDto(bookService.getPageOfRecommendedBooks(offset, limit).getContent());
    }

    @GetMapping( "/search/{searchWord}")
    public String getSearchResults(@PathVariable(value = "searchWord", required = false) SearchWordDto searchWordDto,
                                   Model model) {
        model.addAttribute("searchWordDto", searchWordDto);
        model.addAttribute("sizeOfSearchResults", bookService.getBooksByTitle(searchWordDto.getExample()));
        model.addAttribute("searchResults",
                bookService.getPageOfSearchResultBooks(searchWordDto.getExample(), 0, 5).getContent());

        return "/search/index";
    }

    @GetMapping("/search/page/{searchWord}")
    @ResponseBody
    public BooksPageDto getNextSearchPage(@RequestParam("offset") Integer offset,
                                          @RequestParam("limit") Integer limit,
                                          @PathVariable(value = "searchWord", required = false) SearchWordDto searchWordDto) {
        return new BooksPageDto(bookService.getPageOfSearchResultBooks(searchWordDto.getExample(), offset, limit).getContent());
    }

    @GetMapping("/books/page/recent")
    @ResponseBody
    public BooksPageDto getNextNoveltyPage(@RequestParam("offset") Integer offset,
                                          @RequestParam("limit") Integer limit) {
        return new BooksPageDto(bookService.getPageOfNoveltyResultBooks( offset, limit).getContent());
    }

    @GetMapping("/books/page/popular")
    @ResponseBody
    public BooksPageDto getNextPopularPage(@RequestParam("offset") Integer offset,
                                           @RequestParam("limit") Integer limit) {
        return new BooksPageDto(bookService.getPageOfPopularResultBooks( offset, limit).getContent());
    }

}
