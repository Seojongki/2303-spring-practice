package com.tj.edu.practice5.jpa.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper=true)
@EntityListeners(value = {MemberEntityListener.class})
@Entity
@Table(name = "author")
public class Author extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="book_id", insertable=false, updatable=false)
    private Long bookId;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String name;


//    ---------- book -------------


//    @ManyToMany
//    private List<Book> books;


}
