package com.example.BookShop.controller;

import com.example.BookShop.entity.Author;
import com.example.BookShop.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
        model.addAttribute("srchPlcholder","something");
        model.addAttribute("bookData", generalService.getAllBooks());
        model.addAttribute("serverTime",new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        return "index";
    }

    @GetMapping("/genres")
    public String genresPage(Model model) {
        model.addAttribute("srchPlcholder","something");
        return "genres";
    }


    @GetMapping("/authors")
    public String authorsPage(Model model)
    {
        model.addAttribute("srchPlcholder","something");
        model.addAttribute("authorData", generalService.getAlphabetAndAuthors());
        return "authors";
    }

}
