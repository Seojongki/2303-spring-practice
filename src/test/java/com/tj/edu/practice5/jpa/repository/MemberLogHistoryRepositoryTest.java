package com.tj.edu.practice5.jpa.repository;

import com.tj.edu.practice5.jpa.model.Member;
import com.tj.edu.practice5.jpa.model.MemberLogHistory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MemberLogHistoryRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberLogHistoryRepository memberLogHistoryRepository;


    @BeforeEach
    void setUp() {
    }

    @Test
    void selectRelationTest1(){
        givenMember();
        givenMember2();


        List<MemberLogHistory> memberLogHistoryList = memberLogHistoryRepository.findAll();
//        System.out.println(">>> " + memberLogHistoryList);

        memberLogHistoryList.forEach(System.out::println);
        memberLogHistoryList.get(0).getMember();

    }


    private Member givenMember(){
        Member member = Member.builder()
                .name("안중근")
                .email("anjonggeun@gmail.com")
                .build();

        Member member2 = memberRepository.save(member);
        member2.setName("안중근2");

        return  memberRepository.save(member2);
    }


    private Member givenMember2(){
        Member member = Member.builder()
                .name("박인비")
                .email("inbeepark@gmail.com")
                .build();

        return memberRepository.save(member);
    }



    @AfterEach
    void tearDown() {
    }
}