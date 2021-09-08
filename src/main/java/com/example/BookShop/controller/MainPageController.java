package com.example.BookShop.controller;

import com.example.BookShop.entity.Book;
import com.example.BookShop.service.BookService;
import com.example.BookShop.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainPageController {


    private final BookService bookService;
    private final GeneralService generalService;

    @Autowired
    public MainPageController(GeneralService generalService,BookService bookService) {
        this.generalService = generalService;
        this.bookService = bookService;
    }


    @GetMapping
    public String mainPage(Model model) {
        model.addAttribute("bookData", bookService.getBooksData());
        return "index";
    }

    @GetMapping("/genres")
    public String genresPage(Model model) {
        model.addAttribute("srchPlcholder","something");
        return "genres/genres";
    }


    @GetMapping("/authors")
    public String authorsPage(Model model)
    {
        model.addAttribute("srchPlcholder","something");
        model.addAttribute("authorData", generalService.getAlphabetAndAuthors());
        return "authors/authors";
    }

    @GetMapping("/books/recent")
    public String noveltyPage() {
        return "books/recent";
    }

    @ModelAttribute("booksList")
    public List<Book> bookList(){
        return generalService.getAllBooks();
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

}
