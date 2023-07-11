package com.tj.edu.practice5.jpa.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

//    @GeneratedValue
    private Long id;
    //    @NonNull
    private String name;
    private String email;
    //    @NonNull
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}


}

