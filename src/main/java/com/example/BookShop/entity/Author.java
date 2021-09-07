package com.example.BookShop.entity;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String first_name;
    private String last_name;

    @OneToMany
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private List<Book> bookList = new ArrayList<>();

    public Author(int id, String first_name, String last_name) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return first_name + " " + last_name;
    }
}