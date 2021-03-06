package com.example.BookShop.entity.book.review;

import com.example.BookShop.entity.Book;
import com.example.BookShop.entity.user.UserEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "book_review")
public class BookReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT NOT NULL")
//  текст отзыва
    private String text;

    @Column(columnDefinition = "TIMESTAMP NOT NULL")
//  время, когда оставлен отзыв
    private LocalDateTime time;

    @JoinColumn(name = "user_id",
            columnDefinition = "INT NOT NULL")
//  идентификатор пользователя, который написал данный отзыв
    @ManyToOne
    private UserEntity user;

    @JoinColumn(name = "book_id",
            columnDefinition = "INT NOT NULL")
//  идентификатор книги на которую ставится отзыв
    @ManyToOne
    private Book book;

    @OneToMany(mappedBy = "bookReview")
    private List<BookReviewLike> bookReviewLikeList;
}