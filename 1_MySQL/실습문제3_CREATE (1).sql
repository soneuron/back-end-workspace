DROP TABLE rent;
DROP TABLE member;
DROP TABLE book;
DROP TABLE publisher;

-- 실습 문제
-- 도서관리 프로그램을 만들기 위한 테이블 만들기

-- 1. 출판사들에 대한 데이터를 담기 위한 출판사 테이블(publisher) 
--    컬럼 : pub_no(출판사번호) -- 기본 키
--           pub_name(출판사명) -- NOT NULL
--           phone(전화번호)
CREATE TABLE publisher(
	pub_no INT PRIMARY KEY AUTO_INCREMENT,
    pub_name VARCHAR(20) NOT NULL,
    phone VARCHAR(13)
);
INSERT INTO publisher(pub_name, phone) VALUES('프리렉', '032-326-7282');
INSERT INTO publisher(pub_name, phone) VALUES('인사이트', '02-322-5143');
INSERT INTO publisher(pub_name, phone) VALUES('길벗', '02-332-0931');

select * from publisher;

-- 2. 도서들에 대한 데이터를 담기 위한 도서 테이블 (book)
--    컬럼 : bk_no (도서번호) -- 기본 키
--           bk_title (도서명) -- NOT NULL
--           bk_author(저자명) -- NOT NULL
--           bk_price(가격)
--           bk_pub_no(출판사 번호) -- 외래 키(publisher 테이블을 참조하도록)
--    조건 : 이때 참조하고 있는 부모 데이터 삭제 시 자식 데이터도 삭제 되도록 옵션 지정
CREATE TABLE book(
	bk_no INT PRIMARY KEY AUTO_INCREMENT,
    bk_title VARCHAR(40) NOT NULL,
    bk_author VARCHAR(30) NOT NULL,
    bk_price INT,
    bk_pub_no INT,
    FOREIGN KEY (bk_pub_no) REFERENCES publisher(pub_no)  
);
INSERT INTO book(bk_title, bk_author, bk_price, bk_pub_no) VALUES('개발자를 위한 생각의 정리, 문서 작성법', '카이마이 미즈히로', '20000', 1);
INSERT INTO book(bk_title, bk_author, bk_price, bk_pub_no) VALUES('1일 1로그 100일 완성 IT지식', '브라이언w. 커니핸', '200000', 2);
INSERT INTO book(bk_title, bk_author, bk_price, bk_pub_no) VALUES('개발자가 영어도 잘해야 하나요?', '최희철', '27000', 3);
INSERT INTO book(bk_title, bk_author, bk_price, bk_pub_no) VALUES('피플웨어', '톰 드마르코', '16800', 2);
INSERT INTO book(bk_title, bk_author, bk_price, bk_pub_no) VALUES('그로스 해킹', '라이언 홀리데이', '13800', 3);

select * from book;

-- 3. 회원에 대한 데이터를 담기 위한 회원 테이블 (member)
--    컬럼 : member_no(회원번호) -- 기본 키
--           member_id(아이디)   -- 중복 금지
--           member_pwd(비밀번호) -- NOT NULL
--           member_name(회원명) -- NOT NULL
--           gender(성별)        -- 'M' 또는 'F'로 입력되도록 제한
--           address(주소)       
--           phone(연락처)       
--           status(탈퇴여부)     -- 기본값 'N' / 'Y' 혹은 'N'만 입력되도록 제약조건
--           enroll_date(가입일)  -- 기본값 현재날짜
CREATE TABLE member(
	member_no INT PRIMARY KEY AUTO_INCREMENT,
    member_id VARCHAR(10) UNIQUE,
    member_pwd VARCHAR(20) NOT NULL,
    member_name VARCHAR(10) NOT NULL,
    gender VARCHAR(3) CHECK(gender IN ('M', 'F')) NOT NULL,
    address VARCHAR(20),
    phone VARCHAR(13),
    status VARCHAR(2) CHECK(status IN ('N', 'Y')) DEFAULT 'N',
    enroll_date DATE
);
INSERT INTO member(member_id, member_pwd, member_name, gender, address, phone, status, enroll_date)
VALUES('user01', 'pass01', '가나다', 'M', '서울시 강남구', '010-1111-2222', 'N', current_date());
INSERT INTO member(member_id, member_pwd, member_name, gender, address, phone, status, enroll_date)
VALUES('user02', 'pass02', '라마바', 'M', '서울시 서초구', '010-3333-4444', 'N', current_date());
INSERT INTO member(member_id, member_pwd, member_name, gender, address, phone, status, enroll_date)
VALUES('user03', 'pass03', '사아자', 'F', '경기도 광주시', '010-4444-5555', 'N', current_date());


-- 4. 도서를 대여한 회원에 대한 데이터를 담기 위한 대여 목록 테이블(rent)
--    컬럼 : rent_no(대여번호) -- 기본 키
--           rent_mem_no(대여 회원번호) -- 외래 키(member와 참조)
--           rent_book_no(대여 도서번호) -- 외래 키(book와 참조)
--           rent_date(대여일) -- 기본값 현재날짜
--    조건 : 이때 부모 데이터 삭제 시 NULL 값이 되도록 옵션 설정

-- ALTER로 FOREIGN KEY만 관리
CREATE TABLE rent(
	rent_no INT PRIMARY KEY AUTO_INCREMENT,
    rent_mem_no INT,
    FOREIGN KEY (rent_mem_no) REFERENCES member(member_no),
    rent_book_no INT,
    FOREIGN KEY (rent_book_no) REFERENCES book(bk_no) ON DELETE SET NULL,
    rent_date DATE
);
INSERT INTO rent(member_no, bk_no, rent_date) VALUES(

-- 5. 2번 도서를 대여한 회원의 이름, 아이디, 대여일, 반납 예정일(대여일 + 7일)을 조회하시오.




-- 6. 회원번호가 1번인 회원이 대여한 도서들의 도서명, 출판사명, 대여일, 반납예정일을 조회하시오.
