package com.tj.edu.practice5.jpa.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.awt.image.renderable.RenderableImage;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@EqualsAndHashCode(callSuper=true)
//@EntityListeners(value = TimeAudiEntityListener.class)
//@EntityListeners(value = {AuditingEntityListener.class, MemberEntityListener.class})
public class Book extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne(mappedBy = "book")
    @ToString.Exclude
    private BookReviewInfo bookReviewInfo;

    @OneToMany
    @JoinColumn(name = "book_id")
    private List<Review> reviews;

    // ------------- publisher  ------------------
    @ManyToOne
    private Publisher publisher;

// ------------- author  ------------------
//    @ManyToOne
//    private Author author;
//
//    @OneToMany
//    @JoinColumn(name = "book_id")
//    private List<Author> authors;

    @ManyToMany
    private List<Author> authors;

}
