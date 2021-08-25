package com.example.BookShop.service;

import com.example.BookShop.entity.Author;
import com.example.BookShop.entity.Book;
import com.example.BookShop.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GeneralService {

    private final ProjectRepository<Book> bookRepository;
    private final ProjectRepository<Author> authorRepository;

    @Autowired
    public GeneralService(ProjectRepository<Book> bookRepository,
                          ProjectRepository<Author> authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }



    public List<Book> getAllBooks() {
        return bookRepository.getAll();
    }

    public List<Author> getAllAuthor() {
        return authorRepository.getAll();
    }

    public Map<String, List<Author>> getAlphabetAndAuthors() {
        return authorRepository.getAll()
                .stream()
                //сортировка через компаратор
                .sorted(Comparator.comparing(
                                //по имени автора
                                Author::getFirstName)
                        //по фамилии
                        .thenComparing(Author::getLastName))
                //группируем по первой букве имени автора
                .collect(Collectors.groupingBy((Author author) -> author.getFirstName().substring(0, 1)));
    }
}