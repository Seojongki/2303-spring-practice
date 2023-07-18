package com.tj.edu.practice5.jpa.repository;

import com.tj.edu.practice5.jpa.model.Member;
import com.tj.edu.practice5.jpa.model.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class EntityManagerTest {
    @Autowired
    private EntityManagerFactory emf;
    //    @Autowired
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private UsersRepository usersRepository;
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

        em.flush();
    }

    @Test
//    @Transactional // OSIV (Open Session In View) -> transaction
    void entityManagerTest2() {
        Member member = Member.builder()
                .name("aaaa")
                .email("xzcvz@fdasf.com")
                .build();
        em.persist(member); // jpa 영속성 관리에 저장

        memberRepository.findAll().forEach(System.out::println);
    }

    @Test
    @Transactional
    @Commit
//    @Rollback(false)
    void entityManagerTest3() {
        Users users = Users.builder()
                .name("홍길동10")
                .build();
        usersRepository.save(users);

        em.persist(users); // 영속성 상태 --> 변경감지가 이루어짐
        users.setEmail("hong10@naver.com");
        em.flush();  //sql 실행

//        em.detach(users);  // 준영속성 상태  --> 변경감지가 되지 않음 (데이터베이스에 반영않됨)
//        em.clear();
        em.merge(users); // 준영속성 상태에서 영속성 상태로 변경
        em.remove(users);    // 비영속성으로 삭제 상태

//        usersRepository.findAll().forEach(System.out::println);
//        System.out.println(usersRepository.findByName("홍길동10").get(0));
    }


    @Test
    @Transactional
    void persistCacheDelayInsertUpdate(){
        Users user = usersRepository.findById(1L).get(); //select, dirty check(변경감지)
        user.setName("심청이");
        usersRepository.save(user);  //update

        user.setEmail("sim@test.com"); //select, update
        usersRepository.save(user);  //select, update
    }

}
