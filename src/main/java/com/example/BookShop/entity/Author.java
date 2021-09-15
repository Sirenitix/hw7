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

    @Column(columnDefinition = "VARCHAR(255)")
    private String photo;

    @Column(columnDefinition = "VARCHAR(255)")
    private String slug;

    @Column(columnDefinition = "TEXT")
    private String description;

//  @JoinColumn(name = "author_id", referencedColumnName = "id")
    @OneToMany(mappedBy = "author")
    private List<Book> bookList = new ArrayList<>();

    public Author(int id, String firstname, String lastname, String photo, String slug, String description) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.photo = photo;
        this.slug = slug;
        this.description = description;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname;
    }
}