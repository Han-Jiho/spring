<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>건의사항 글보기</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#deleteBtn").click(function(){
		var pw = prompt("비밀번호 입력 :"); 
		var pwd = $("#PWD").val()
		if(pw.length >= 4){
			if(pw == pwd){
				$("#deletePW").val(pw);
				$("#deleteForm").submit();
				return;
				}
			else if(pw != pwd){
			alert("잘못된 비밀번호 입니다.")
			return false;
			}
		}
		else{
			alert("비밀번호는 4 - 50 글자 입니다")
			return false;
			}
		// 화면 이동을 막는다.
		return false;
	});
	
});
</script>
</head>
<body>
<div class="container">
	<h1>게시판 글보기</h1>
	<table class="table">
		<tr>
			<th>글번호</th>
			<td>${vo.no }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${vo.title }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${vo.content }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${vo.writer }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><fmt:formatDate value="${vo.writeDate }"
			pattern="yyyy.MM.dd"/></td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${vo.hit }</td>
		</tr>
		<tr>
			<td colspan="2">
				<a href="update.do?no=${vo.no }&inc=0&page=${pageObject.page }&perPageNum=${pageObject.perPageNum }
				&key=${pageObject.key }&word=${pageObject.word}"
				 class="btn btn-default" id="update">글수정</a>
				<a href="#" class="btn btn-default" id="deleteBtn">글삭제</a>
				<a href="list.do?page=${pageObject.page }&perPageNum=${pageObject.perPageNum }
				&key=${pageObject.key }&word=${pageObject.word}" class="btn btn-default">돌아가기</a>
			</td>
		</tr>
	</table>
</div>
<form action="delete.do" method="post" id="deleteForm">
	<input type="hidden" name="no" value="${vo.no }" />
	<input type="hidden" name="pw" id="deletePW" />
	<input type="hidden" id="PWD" value="${vo.pw }" />
</form>
</body>
</html>