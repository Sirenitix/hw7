package com.example.BookShop.entity;

import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//  @Transient
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author=" + author +
                ", title='" + title + '\'' +
                ", price_old='" + price_old + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    private String title;
    private String price_old;
    private String price;


}
