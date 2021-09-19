package com.example.BookShop.entity;

import lombok.*;
import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    @Column(name = "pub_date",columnDefinition = "DATE")
    private Date pubDate;

    @Column(name="is_bestseller" ,columnDefinition = "INT")
    private String isBestseller;

    @Column(columnDefinition = "VARCHAR(255)")
    private String slug;

    @Column(columnDefinition = "VARCHAR(255)")
    private String image;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "VARCHAR(255)")
    private String title;

    @Column(name = "price", columnDefinition = "INT")
    private int priceOld;

    @Column(name = "discount",columnDefinition = "DOUBLE PRECISION")
    private double price;


    public Book(int id, Author author, String pubDate, String isBestseller, String slug, String image, String description, String title, int priceOld, double price) {
        this.id = id;
        this.author = author;
        this.pubDate = Date.valueOf(pubDate);
        this.isBestseller = isBestseller;
        this.slug = slug;
        this.image = image;
        this.description = description;
        this.title = title;
        this.priceOld = priceOld;
        this.price = price;
    }
}
