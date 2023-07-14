package com.tj.edu.practice5.jpa.repository;

import com.tj.edu.practice5.jpa.model.Book;
import com.tj.edu.practice5.jpa.model.BookReviewInfo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookReviewInfoRepositoryTest {

    @Autowired
    private BookReviewInfoRepository bookReviewInfoRepository;

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
    }


//    @Test
//    void crudTest1(){
//        BookReviewInfo bookReviewInfo = BookReviewInfo.builder()
//                .bookId(1L)
//                .avgReviewScore(2.3f)
//                .reviewCount(8)
//                .build();
//
//        bookReviewInfoRepository.save(bookReviewInfo);
//        System.out.println(">>>>>  " + bookReviewInfo);
//    }
//
//    @Test
//    void crudTest2(){
//        Book book = Book.builder()
//                .name("아주 쉬운 스프링 부트 3.1")
//                .author("저자1")
//                .build();
//
//        bookRepository.save(book);
//
//        BookReviewInfo bookReviewInfo = BookReviewInfo.builder()
//                .bookId(1L)
//                .avgReviewScore(2.3f)
//                .reviewCount(8)
//                .build();
//
//        bookReviewInfoRepository.save(bookReviewInfo);
//
//        List<BookReviewInfo> bookReviewInfoList = bookReviewInfoRepository.findAll();
//        bookReviewInfoList.forEach(System.out::println);
//    }

    @Test
    void crudTest3(){
        Book book = getGivenBook();
        BookReviewInfo bookReviewInfo = getGivenBookReviewInfo(book);

        List<BookReviewInfo> bookReviewInfoList = bookReviewInfoRepository.findAll();
        bookReviewInfoList.forEach(System.out::println);
    }


    @Test
    void oneToOneTest3(){
        Book book = getGivenBook();
        BookReviewInfo bookReviewInfo = getGivenBookReviewInfo(book);

        bookReviewInfoRepository.findById(1L); //@OneToOne join을 위해 findById를 사용
    }

    private Book getGivenBook(){
        Book book = Book.builder()
                .name("스프링부트 3.1")
//                .author("저자3")
                .build();
        return bookRepository.save(book);
    }

    private BookReviewInfo getGivenBookReviewInfo(Book book){
        BookReviewInfo bookReviewInfo = BookReviewInfo.builder()
                .book(book)
                .avgReviewScore(2.3f)
                .reviewCount(8)
                .build();

        return bookReviewInfoRepository.save(bookReviewInfo);
    }



    @AfterEach
    void tearDown() {
    }
}