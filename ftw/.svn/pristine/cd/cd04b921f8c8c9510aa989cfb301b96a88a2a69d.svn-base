-- 테이블이 있으면 제거
DROP TABLE member;
DROP TABLE member_auth;
DROP SEQUENCE member_seq;

-- 테이블 작성
CREATE TABLE member(
    no NUMBER UNIQUE, -- 회원 번호
    userid VARCHAR2(20) PRIMARY KEY, -- 아이디
    userpw VARCHAR2(2000) NOT NULL, -- 비밀번호
    nickname VARCHAR2(30) NOT NULL, -- 별명
    email VARCHAR2(90) NOT NULL, -- 이메일
    local1 VARCHAR2(100), -- 선호지역1
    local2 VARCHAR2(100), -- 선호지역2
    local3 VARCHAR2(100), -- 선호지역3
    enabled CHAR(1) DEFAULT 1, -- 회원 상태
    join_date DATE DEFAULT sysdate -- 가입 날짜
);

CREATE TABLE member_auth(
    userid VARCHAR2(20) NOT NULL REFERENCES member(userid),
    auth VARCHAR2(50) NOT NULL
);

-- 시퀀스 생성
CREATE SEQUENCE member_seq;

-- 커밋
COMMIT;