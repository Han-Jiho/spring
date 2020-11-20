-- board 테이블의 데이터 전체를 복사해서 다시 넣기
insert into weekly(no, title, content, writer, pw)
(select weekly_seq.nextval, title, content, writer, pw
 from weekly);
commit;