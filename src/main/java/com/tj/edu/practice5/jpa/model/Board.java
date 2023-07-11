package com.tj.edu.practice5.jpa.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Board {
    @Id
    private Long boardNo;
    private String userId;
    private String nick;
    private String status;
    private String title;
    private String content;
    private Integer hits;
    private String boardKind;
    private String finishYn;
    private String category;
    private LocalDateTime cdatetime;
    private LocalDateTime udatetime;
    private String deleteYn;
    private String secretYn;
}
