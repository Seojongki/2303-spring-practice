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
@EqualsAndHashCode(callSuper=true)
//@EntityListeners(value = {AuditingEntityListener.class})
public class MemberLogHistory extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name="member_id", updatable = false, insertable = false)
//    private Long memberId;

    private String name;
    private String email;

    @ManyToOne
    private Member member;


}
