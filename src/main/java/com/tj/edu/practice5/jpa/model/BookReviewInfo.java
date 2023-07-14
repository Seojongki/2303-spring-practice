package com.tj.edu.practice5.jpa.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
@Entity
public class BookReviewInfo extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    private Book book;
//    private Long bookId;

    private float avgReviewScore;
    private Integer reviewCount;

}
