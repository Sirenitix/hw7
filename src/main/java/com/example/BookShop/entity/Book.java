package com.example.BookShop.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Book {
    @Id
    private int id;
    private String author;
    private String title;
    private String priceOld;
    private String price;
}
