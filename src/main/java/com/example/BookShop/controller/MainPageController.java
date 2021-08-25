package com.example.BookShop.controller;

import com.example.BookShop.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainPageController {

    private final GeneralService generalService;

    @Autowired
    public MainPageController( GeneralService generalService) {
        this.generalService = generalService;
    }

    @GetMapping
    public String mainPage(Model model) {
        model.addAttribute("bookData", generalService.getAllBooks());
        return "index";
    }

    @GetMapping("/genres")
    public String genresPage() {
        return "genres";
    }

    @GetMapping("/authors")
    public String authorsPage(Model model)
    {
        model.addAttribute("authorData", generalService.getAlphabetAndAuthors());
        return "authors";
    }

}
