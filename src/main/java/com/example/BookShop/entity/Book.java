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

    @Column(columnDefinition = "DATE")
    private String pub_date;

    @Column(columnDefinition = "INT")
    private String is_bestseller;

    @Column(columnDefinition = "VARCHAR(255)")
    private String slug;

    @Column(columnDefinition = "VARCHAR(255)")
    private String image;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int discount;

    @Column(columnDefinition = "VARCHAR(255)")
    private String title;

    @Column(columnDefinition = "VARCHAR(255)")
    private String price_old;

    @Column(columnDefinition = "VARCHAR(255)")
    private String price;


}
