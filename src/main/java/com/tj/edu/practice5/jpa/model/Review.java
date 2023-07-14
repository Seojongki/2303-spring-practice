package com.tj.edu.practice5.jpa.model;


import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper=true)
@EntityListeners(value = {MemberEntityListener.class})
@Entity
@Table(name = "review")
public class Review extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(500)", nullable = false)
    private String title;
    @Column(columnDefinition = "text")
    private String content;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Book book;

}
