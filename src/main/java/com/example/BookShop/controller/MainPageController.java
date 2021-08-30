package com.example.BookShop.controller;

import com.example.BookShop.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainPageController {

    private final GeneralService generalService;


    @Autowired
    public MainPageController(GeneralService generalService) {
        this.generalService = generalService;
    }




    @GetMapping
    public String mainPage(Model model) {
        model.addAttribute("bookData", generalService.getAllBooks());
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
    public String noveltyPage(Model model) {
        return "books/recent";
    }

    @GetMapping("/books/popular")
    public String popularBooksPage(Model model) {
        return "books/popular";
    }

    @GetMapping("/signin")
    public String signinPage(Model model) {
        return "signin";
    }

    @GetMapping("/documents")
    public String docPage(Model model) {
        return "documents/index";
    }

    @GetMapping("/about")
    public String aboutAppPage(Model model) {
        return "about";
    }

    @GetMapping("/faq")
    public String faqPage(Model model) {
        return "faq";
    }

    @GetMapping("/contacts")
    public String contactsPage(Model model) {
        return "contacts";
    }

    @GetMapping("/cart")
    public String cartPage(Model model) {
        return "cart";
    }

    @GetMapping("/search")
    public String searchResultsPage(Model model) {
        return "search/index";
    }


    @GetMapping("/postponed")
    public String postponedPage(Model model) {
        return "postponed";
    }

}
