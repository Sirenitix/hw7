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
    private String firstname;
    private String lastname;


//  @JoinColumn(name = "author_id", referencedColumnName = "id")
    @OneToMany(mappedBy = "author")
    private List<Book> bookList = new ArrayList<>();

    public Author(int id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname;
    }
}