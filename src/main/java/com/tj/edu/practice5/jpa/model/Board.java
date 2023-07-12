package com.tj.edu.practice5.jpa.model;


import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="boardNo2")
    private Long boardNo;
    @Column(name = "userId2", insertable = false, updatable = false)
    private String userId;
    @Column(name="nickname", columnDefinition="varchar(255) comment '별명'")
    private String nick;
    @Column(columnDefinition="varchar(1) comment '상태값'")
    private String status;
    @Column(columnDefinition="varchar(255) comment '제목'")
    private String title;
    @Column(columnDefinition="varchar(1000) comment '내용'")
    private String content;
    @Column(columnDefinition="int(11) DEFAULT NULL comment '조회수'")
    private Integer hits;
    @Column(columnDefinition="varchar(1) comment '보드 종류'")
    private String boardKind;
    @Column(columnDefinition="varchar(1) comment '종료 여부'")
    private String finishYn;
        private String category;
    private LocalDateTime cdatetime;
    @Column(columnDefinition="datetime(6) DEFAULT now() comment '수정 시간'", insertable = false)
    private LocalDateTime udatetime;
    private String deleteYn;
    private String secretYn;
}
