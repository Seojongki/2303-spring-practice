package com.tj.edu.practice5.jpa.repository;

import com.tj.edu.practice5.jpa.model.Member;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;


@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void crud() {
//        Member member1 = new Member(1L, "홍길동", null, LocalDateTime.now(), LocalDateTime.now());
        // create문
//        Member copyMember = memberRepository.save(member1); // insert into Member values (~~~
//        System.out.println("copyMember -> " + copyMember);

//        Member member =
        // select문
        System.out.println("select *문 ------------------------------------------------------------------------------------------------------------------------");
        List<Member> memberList = memberRepository.findAll(Sort.by(Sort.Direction.DESC, "name")); //findAll은  == select * from member을 나타냄
        //jdk 1.8에서 사용된 stream기술을 이용한 print찍는 방법
        memberList.forEach(System.out::println);  //아래의 for문을 1줄로 출력함

//        for(Member member : memberList) {
//            System.out.println(member.toString());
//        }

        // select where 문
        System.out.println("select where문 ------------------------------------------------------------------------------------------------------------------------");
        List<Member> memberList2 = memberRepository.findAllById(Lists.newArrayList(1L,3L)); // == select * from member where id in (1,3)
        memberList2.forEach(System.out::println);  //아래의 for문을 1줄로 출력함


        // update 문
        System.out.println("update문 ------------------------------------------------------------------------------------------------------------------------");
        Member member1 = new Member(1L, "홍길동", "이메일 주소", LocalDateTime.now(), LocalDateTime.now());
        memberRepository.save(member1); //1번을 가진 id가 있다면 update, 없으면 create문 발생
        List<Member> memberList3 = memberRepository.findAll();
        memberList3.forEach(System.out::println);


        // delete 문
        System.out.println("delete문 ------------------------------------------------------------------------------------------------------------------------");
//        memberRepository.deleteAll();

        memberRepository.deleteAllInBatch();
        List<Member> memberList4 = memberRepository.findAll();
        memberList4.forEach(System.out::println);




    }
}