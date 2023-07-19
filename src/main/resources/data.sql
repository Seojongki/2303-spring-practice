--insert into member(`id`,`name`,`email`,`create_at`,`update_at`) values (1, '홍길동', 'test1@naver.com', now(), now());
--insert into member(`id`,`name`,`email`,`create_at`,`update_at`) values (2, '이순신', 'test2@naver.com', now(), now());
--insert into member(`id`,`name`,`email`,`create_at`,`update_at`) values (3, '홍길동', 'test3@naver.com', now(), now());
--insert into member(`id`,`name`,`email`,`create_at`,`update_at`) values (4, '심청이', 'test41@naver.com', now(), now());
--insert into member(`id`,`name`,`email`,`create_at`,`update_at`) values (5, '홍길동', 'test51@naver.com', now(), now());
--
--insert into users(`id`, `name`, `email`) values (1,'홍길동', 'honggildong@gmail.com');
--insert into users(`id`, `name`, `email`) values (2, '홍길동2', 'hong2@gmail.com');
--insert into users(`id`, `name`, `email`) values (3, '홍길동3', 'hong3@gmail.com');
--
--insert into publisher(`id`,`name`, `create_at`, `update_at`) values (1, '더조은아카데미', now(), now());
--insert into publisher(`id`,`name`, `create_at`, `update_at`) values (2, '한빛출판사', now(), now());
--
--insert into book(`id`, `name`, `publisher_id`, `create_at`, `update_at`) values (1, '재미있는 자바', 1, now(), now());
--insert into book(`id`, `name`, `publisher_id`, `create_at`, `update_at`) values (2, '어려운 데이터베이스', 1, now(), now());
--insert into book(`id`, `name`, `publisher_id`, `create_at`, `update_at`) values (3, '텍스트로 디자인하는 css', 1, now(), now());
--insert into book(`id`, `name`, `publisher_id`, `create_at`, `update_at`) values (4, '재미있는 자바책', 2, now(), now());


INSERT INTO article (title, content) VALUES ('제목1', '내용1');
INSERT INTO article (title, content) VALUES ('제목2', '내용2');
INSERT INTO article (title, content) VALUES ('제목3', '내용3');