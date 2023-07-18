package com.tj.edu.practice5.jpa.repository;

import com.tj.edu.practice5.jpa.model.Book;
import com.tj.edu.practice5.jpa.model.BookAndId;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByName(String name);

    // JPQL
    @Query(value = "select b from Book b where name = ?1")
    List<Book> findByMyBooks(String name);

    @Query(value = "select b from Book b where name = ?2 and id = ?1")
    List<Book> findByMyBooksAndMyId(Long id, String name);

    @Query(value = "select b from Book b where name like %:name% and id = :id")
    List<Book> findByNamedByMyBooksAndMyId(@Param("id") Long id, @Param("name") String name);

    @Query(value = "select b.name from Book b where name = ?1")
    List<String> findNameByMyBooks(String name);

    // return 해주는 book객체를 convert가 안되서 안되는 메소드
    @Query(value = "select b.id id, b.name name from Book b where name = ?1")
//    List<Book> findNameIdByMyBooks(String name);
    List<Map<String, Object>> findNameIdByMyBooks(String name);

    @Query(value = "select b.id id, b.name name from Book b where name = :name")
    List<Map<String, Object>> findByNamedNameIdByMyBooks(@Param("name") String name);

    @Query(value = "select * from book where name=?1",  nativeQuery = true)
    List<Book> findByNativeByMyBooks(String name);

    @Query(value = """
                SELECT
            				A.PRODUCT_NO
            				, A.PRODUCT_NAME
            				, A.PRODUCT_KIND
            				, A.PRODUCT_WEIGHT
            				, A.PRODUCT_EA
            				, A.PRODUCT_VOLUME
            				, A.TITLE
            				, A.CONTENT
            				, A.PRODUCT_PRICE
            				, A.PRODUCT_STOCK
            				, A.PRODUCT_CNT
            				, A.DISCOUNT_YN
            				, A.DELETE_YN
            				, B.IMG_PATH
                            , C.SATISFACTION_GRADE
            				, C.REPURCHASE_GRADE
            				, C.DELIVERY_GRADE
            			FROM T4_PRODUCT A
            			INNER JOIN  T4_P_IMAGE B
            			ON A.PRODUCT_NO=B.PRODUCT_NO
                        LEFT JOIN (
            					SELECT
            						AVG(SATISFACTION_GRADE) AS SATISFACTION_GRADE
            						, AVG(REPURCHASE_GRADE) AS REPURCHASE_GRADE
            						, AVG(DELIVERY_GRADE) AS DELIVERY_GRADE
            						, PRODUCT_NO
            					FROM T4_REVIEW GROUP BY PRODUCT_NO
                                ) C
            			ON A.PRODUCT_NO = C.PRODUCT_NO
            			WHERE B.THUMBNAIL_YN='Y'
            			AND A.PRODUCT_STOCK > 0
            			ORDER BY RAND()
            			LIMIT 5
            """,  nativeQuery = true)
//    List<Book> findByNativeByMyProducts();
    List<Map<String, Object>> findByNativeByMyProducts();


    @Query(value = "select b.id abc, b.name name2 from Book b where name = :name")
    List<BookAndId> findByCustomNamedNameIdByMyBooks(@Param("name") String name);

//    @Query(value = "select b.id abc, b.name name2 from Book b where name = :name")
//    List<Tuple> findByCustomNamedNameIdByMyBooks(@Param("name") String name);


    @Query(value = "select * from book where name = #{#book.name}", nativeQuery = true)
    List<Book> findByNativeNameByMyBooks2(@Param("book") Book book);


    @Transactional
    @Modifying
    @Query(value = """
                    update
                        book b
                    set
                        b.name = '이상한 자바책'
                    where b.id = :id
                    """, nativeQuery = true)
    int updateSpecificName(@Param("id") Long id);


    @Transactional
    @Modifying
    @Query(value = """
                    delete
                    from
                        book
                    where id = :id
                    """, nativeQuery = true)
    int deleteSpecificName(@Param("id") Long id);


    @Transactional
    @Modifying // insert, update, delete 문에는 필수적으로 들어가야함
    @Query(value = """
                    insert into book (`id`,`name`,`create_at`,`update_at`)
                    values (5, '정말 쉬운 자바책', now(), now())
                    """, nativeQuery = true)
    int insertSpecificName(@Param("id") Long id);



    List<Book> findByNameIsNullAndNameEqualsAndCreateAtGreaterThanEqualAndUpdateAtLessThan(String name, LocalDateTime createAt, LocalDateTime updateAt);
}
