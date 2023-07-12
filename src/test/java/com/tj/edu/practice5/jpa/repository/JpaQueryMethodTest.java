package com.tj.edu.practice5.jpa.repository;

import com.tj.edu.practice5.jpa.model.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@SpringBootTest
public class JpaQueryMethodTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void jpaQueryMethodTest1 () {
        // SELECT문: email값으로 특정 row데이터 가져오기
        Set<Member> memberLeesunsins = memberRepository.readByEmail("leesunsin@gmail.com");
        memberLeesunsins.forEach(System.out::println);
//        System.out.println(memberLeesunsins);

        // SELECT문: name값으로 특정 row데이터 가져오기
        List<Member> memberHongildongList = memberRepository.findByName("홍길동");
//        memberHongildongList.forEach(System.out::println);
        System.out.println(memberHongildongList);

        Optional<Member> memberOpt1 = memberRepository.findByCreateAt(LocalDateTime.MAX);
        System.out.println(memberOpt1);

        System.out.println("findByName: " + memberRepository.findByName("이순신"));
        System.out.println("queryByName: " + memberRepository.queryByName("이순신"));
        System.out.println("searchByName: " + memberRepository.searchByName("이순신"));
        System.out.println("streamByName: " + memberRepository.streamByName("이순신"));
        System.out.println("getByName: " + memberRepository.getByName("이순신"));
//        System.out.println("getByByName: " + memberRepository.getByByName("이순신"));  // error
        System.out.println("findMemberByName: " + memberRepository.findMemberByName("이순신"));
        System.out.println("findSomethingByName: " + memberRepository.findSomethingByName("이순신"));

        System.out.println("getByName: " + memberRepository.getByName("이순신"));
//        System.out.println("findByImgNo: " + memberRepository.findByImgNo("1"));  // error(img_no컬럼이 entity구성에 없기 때문

        // exists...by, count...by 쿼리 메소드 만들어보기

        // topNumber, firstNumber, lastNumber, distinct
//        memberRepository.findFirst1ByEmail("namsun@thejoeun.com").forEach(System.out::println);
//        memberRepository.findTop1ByEmail("namsun@thejoeun.com").forEach(System.out::println);
//        memberRepository.findTop2ByEmail("namsun@thejoeun.com").forEach(System.out::println);
//        memberRepository.findLast1ByEmail("namsun@thejoeun.com").forEach(System.out::println);    // last적용안됨
//        memberRepository.findLast2ByEmail("namsun@thejoeun.com").forEach(System.out::println);      // last적용안됨
//        memberRepository.findDistinctByEmail("namsun@thejoeun.com").forEach(System.out::println);
        memberRepository.findDistinctByEmail("namsun@thejoeun.com").forEach(s -> System.out.println(s));
    }

    @Test
    void jpaQueryMethodTest2 () {
//        List<Member> memberList = memberRepository.findByNameAndEmail("홍길동", "test1@naver.com");
//        memberList.forEach(s -> System.out.println(s));
//
//        List<Member> memberList2 = memberRepository.findByNameOrEmail("홍길동", "test4@naver.com");
//        memberList2.forEach(s -> System.out.println(s));

//        List<Member> membersList3 =  memberRepository.findByCreateAtAfter(LocalDateTime.now().minusDays(1L));
//        membersList3.forEach(s -> System.out.println(s));

//        List<Member> membersList4 =  memberRepository.findByCreateAtIsAfter(LocalDateTime.now().minusDays(1L));
//        membersList4.forEach(s -> System.out.println(s);

//        List<Member> membersList5 =  memberRepository.findByIdGreaterThanEqual(3L);
//        System.out.println("---------------------------------------------------------------------------------------------------------------");
//        membersList5.forEach(s -> System.out.println(s));

//        List<Member> membersList6 =  memberRepository.findByCreateAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now());
//        System.out.println("---------------------------------------------------------------------------------------------------------------");
//        membersList6.forEach(s -> System.out.println(s));


//        List<Member> membersList7 =  memberRepository.findByIdGreaterThanEqualAndIdLessThanEqual(1L, 5L);
//        System.out.println("---------------------------------------------------------------------------------------------------------------");
//        membersList7.forEach(s -> System.out.println(s));


//        List<Member> membersList8 =  memberRepository.findByEmailIsNotNull();
//        System.out.println("---------------------------------------------------------------------------------------------------------------");
//        membersList8.forEach(s -> System.out.println(s));


//        List<Member> membersList9 =  memberRepository.findByNameLike("%홍길%");
//        System.out.println("---------------------------------------------------------------------------------------------------------------");
//        membersList9.forEach(s -> System.out.println(s));


//        List<Member> membersList10 =  memberRepository.findByEmailLike("%test%");
//        System.out.println("---------------------------------------------------------------------------------------------------------------");
//        membersList10.forEach(s -> System.out.println(s));


//        List<Member> membersList11 =  memberRepository.findByNameIn(Lists.newArrayList("홍길동","심청이"));
//        System.out.println("---------------------------------------------------------------------------------------------------------------");
//        membersList11.forEach(s -> System.out.println(s));


//        List<Member> membersList12 =  memberRepository.findByNameNotIn(Lists.newArrayList("홍길동","심청이"));
//        System.out.println("---------------------------------------------------------------------------------------------------------------");
//        membersList12.forEach(s -> System.out.println(s));



//        List<Member> membersList13 =  memberRepository.findByNameContains("심청");
//        System.out.println("---------------------------------------------------------------------------------------------------------------");
//        membersList13.forEach(s -> System.out.println(s));



//        List<Member> membersList14 =  memberRepository.findByNameStartingWith("심청");
//        System.out.println("---------------------------------------------------------------------------------------------------------------");
//        membersList14.forEach(s -> System.out.println(s));


//        List<Member> membersList15 =  memberRepository.findByNameEndingWith("이");
//        System.out.println("---------------------------------------------------------------------------------------------------------------");
//        membersList15.forEach(s -> System.out.println(s));



//        List<Member> membersList16 =  memberRepository.findByNameOrderByIdDesc("홍길동");
//        System.out.println("---------------------------------------------------------------------------------------------------------------");
//        membersList16.forEach(s -> System.out.println(s));


//        List<Member> membersList17 =  memberRepository.OrderByIdDesc();
//        System.out.println("---------------------------------------------------------------------------------------------------------------");
//        membersList17.forEach(s -> System.out.println(s));


//        List<Member> membersList18 =  memberRepository.findByAddressIsEmpty();
//        System.out.println("---------------------------------------------------------------------------------------------------------------");
//        membersList18.forEach(s -> System.out.println(s));


//        List<Member> membersList19 =  memberRepository.findByAddressIsNotEmpty();
//        System.out.println("---------------------------------------------------------------------------------------------------------------");
//        membersList19.forEach(s -> System.out.println(s));



//        List<Member> membersList20 =  memberRepository.findByMaleIsFalse();
//        System.out.println("---------------------------------------------------------------------------------------------------------------");
//        membersList20.forEach(s -> System.out.println(s));




        Page<Member> pageMember = memberRepository.findByName("홍길동", PageRequest.of(0, 3, Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))));
        List<Member> memberList13 = pageMember.getContent();
        memberList13.forEach(System.out::println);









    }
}
