package com.example.BookShop.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
@ApiModel(description = "entity representation of book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("generate id automatically in db")
    private int id;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    @Column(name = "pub_date",columnDefinition = "DATE")
    @ApiModelProperty("publication date of the book")
    private Date pubDate;

    @Column(name="is_bestseller" ,columnDefinition = "INT")
    @ApiModelProperty("if isBestseller = 1 so the book is considered to be bestseller and  if 0 the book is not a " + "bestseller")
    private String isBestseller;

    @Column(columnDefinition = "VARCHAR(255)")
    @ApiModelProperty("mnemonical identity sequence of characters")
    private String slug;

    @Column(columnDefinition = "VARCHAR(255)")
    @ApiModelProperty("image url")
    private String image;

    @Column(columnDefinition = "TEXT")
    @ApiModelProperty("text which contains a description of the book")
    private String description;

    @Column(columnDefinition = "VARCHAR(255)")
    @ApiModelProperty("book title")
    private String title;

    @Column(name = "price", columnDefinition = "INT")
    @JsonProperty("price")
    @ApiModelProperty("book price without discount")
    private int priceOld;

    @Column(name = "discount",columnDefinition = "DOUBLE PRECISION")
    @JsonProperty("discount")
    @ApiModelProperty("discount value for book")
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
