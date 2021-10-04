package com.example.BookShop.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vladmihalcea.hibernate.type.array.ListArrayType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "books")
@ApiModel(description = "entity representation of book")
@TypeDef(
        name = "list-array",
        typeClass = ListArrayType.class
)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("generate id automatically in db")
    private int id;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    @Column(name = "pubdate",columnDefinition = "DATE")
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

    @Column(name = "soldbooks", columnDefinition = "INT")
    @JsonProperty("soldbooks")
    @ApiModelProperty("number of users who bought the book.")
    private int soldBooks;

    @Column(name = "booksincart", columnDefinition = "INT")
    @JsonProperty("booksincart")
    @ApiModelProperty("Number of users with the book in the shopping cart")
    private int booksInCart;

    @Column(name = "deferredbooks", columnDefinition = "INT")
    @JsonProperty("deferredbooks")
    @ApiModelProperty("Number of users whose book is deferred")
    private int deferredbooks;

    @Column(name = "popularity", columnDefinition = "BIGINT DEFAULT 0")
    @JsonProperty("popularity")
    @ApiModelProperty("Popularity level")
    private int popularity;

    @Column(name = "rating", columnDefinition = "BIGINT")
    @JsonProperty("rating")
    @ApiModelProperty("Books rating")
    private int rating;

    @JsonProperty("tags")
    @ApiModelProperty("Books tags")
    @Type(type = "list-array")
    @Column(
            name = "tags",
            columnDefinition = "integer[]"
    )
    private List<Integer> tags;

    @Column(name = "genre", columnDefinition = "INT")
    @JsonProperty("genre")
    @ApiModelProperty("Books genre")
    private int genre;

    public Book(int id, Author author, Date pubDate, String isBestseller, String slug, String image, String description, String title, int priceOld, double price) {
        this.id = id;
        this.author = author;
        this.pubDate = pubDate;
        this.isBestseller = isBestseller;
        this.slug = slug;
        this.image = image;
        this.description = description;
        this.title = title;
        this.priceOld = priceOld;
        this.price = price;
    }
}
