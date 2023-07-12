package com.tj.edu.practice5.jpa.model;


import com.tj.edu.practice5.jpa.model.enums.Nation;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@Table(name="member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //    @NonNull
    @Column(nullable = false)
    private String name;
    private String email;
    //    @NonNull

    @Column(name = "colTest2", insertable = false, updatable = false)
//    @Transient  //테이블에서 컬럼 생성이 않된다
    private Integer test2;
    @Column(updatable = false)
    private LocalDateTime createAt;

//    @Column(columnDefinition="datetime(6) DEFAULT now() comment '수정시간'", insertable = false, nullable = false)
    @Column(columnDefinition="datetime(6) DEFAULT now() comment '수정시간'")
    private LocalDateTime updateAt;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Address> address;


    private Boolean male;

//    @Transient
//    private String testData;


    @Column(columnDefinition = "ENUM")
    @Enumerated(value = EnumType.STRING)
    private Nation nation;

}