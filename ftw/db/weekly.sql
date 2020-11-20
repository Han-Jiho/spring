drop table weekly;
drop sequence weekly_seq

create table weekly(
 no number primary key,    --번호
 title varchar2(300) not null,    --제목
 content varchar2(2000) not null,   --내용
 writer varchar2(30) not null,   --작성자
 writeDate date default sysdate,   --작성일
 hit number default 0,   --조회수
 pw varchar2(50) not null   --비밀번호
);

create sequence weekly_seq;