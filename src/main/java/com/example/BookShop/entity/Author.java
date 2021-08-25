package com.example.BookShop.entity;

import lombok.*;
import javax.persistence.Id;

@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @Id
    private int id;
    private String firstName;
    private String lastName;
}