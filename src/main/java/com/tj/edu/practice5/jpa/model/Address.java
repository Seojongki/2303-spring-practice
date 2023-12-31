package com.tj.edu.practice5.jpa.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@EqualsAndHashCode(callSuper=true)
//@EntityListeners(value = TimeAudiEntityListener.class)
//@EntityListeners(value = {AuditingEntityListener.class, MemberEntityListener.class})
public class Address extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String zipcode;
//    private LocalDateTime createAt;
//    private LocalDateTime updateAt;

}
