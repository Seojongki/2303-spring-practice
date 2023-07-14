package com.tj.edu.practice5.jpa.repository;

import com.tj.edu.practice5.jpa.model.Member;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class EntityManagerTest {
    @Autowired
    private EntityManager em;
    @Autowired
    private MemberRepository memberRepository;
    @Test
    void entityManagerTest() {
        em.createQuery("select u from Member u").getResultList().forEach(s -> System.out.println(s));
    }

    @Test
//    @Transactional
    void cacheEntityFindTest() {
//        System.out.println(memberRepository.findByEmail("namsun@thejoeun.com"));
//        System.out.println(memberRepository.findByEmail("namsun@thejoeun.com"));
//        System.out.println(memberRepository.findByEmail("namsun@thejoeun.com"));
//        System.out.println(memberRepository.findById(1L));
//        System.out.println(memberRepository.findById(1L));
//        System.out.println(memberRepository.findById(1L));

        memberRepository.deleteById(1L);
    }

    @Test
    @Transactional
    void cacheEntityFindTest2() {
        Member member = memberRepository.findById(1L).get();
        member.setName("아무개");

//        memberRepository.save(member);
//        memberRepository.flush();
        memberRepository.saveAndFlush(member);
        System.out.println("------------------------------------1");

        member.setEmail("231ssa@sadf.com");
//        memberRepository.save(member);
//        memberRepository.flush();
        memberRepository.saveAndFlush(member);
        System.out.println("------------------------------------2");
    }

    @Test
    @Transactional
    void entityManagerTest2() {
        Member member = Member.builder()
                .name("aaaa")
                .email("xzcvz@fdasf.com")
                .build();
        em.persist(member); // jpa 영속성 관리에 저장

        memberRepository.findAll().forEach(System.out::println);
    }
}
