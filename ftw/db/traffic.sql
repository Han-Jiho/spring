-- 사고분석(엄재범)
-- 2020. 10. 08.
-------
-- 테이블이 있으면 제거
DROP TABLE accident;
DROP SEQUENCE accident_seq;

-- 테이블 작성
CREATE TABLE accident(
    no NUMBER PRIMARY KEY, -- 번호
    title VARCHAR2(200) UNIQUE, -- 제목
    content VARCHAR2(2000) NOT NULL, -- 내용
    writer VARCHAR2(30) NOT NULL, -- 작성자
    writeDate date, -- 작성일
    hit NUMBER DEFAULT 1, -- 조회수
    pw VARCHAR2(50) Not Null -- 비밀번호
);

-- 시퀀스 생성
CREATE SEQUENCE accident_seq;

-- 연습값 생성
INSERT INTO accident(no, title, content, writer, pw) 
VALUES(accident_seq.nextval, '연습1입니다', '내용1', '엄재범' ,'1234');

-- 커밋
COMMIT;