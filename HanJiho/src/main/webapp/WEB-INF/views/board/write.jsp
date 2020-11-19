<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>

  <!-- Bootstrap 라이브러리 등록 CDN방식 -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(function(){
	$(".cancelBtn").click(function(){
		history.back();
	});
});
</script>

</head>
<body>
<div class="container">
<h2>게시판 글쓰기</h2>
<form method="post" class="form-group">
	<table class="table">
	<tr>
		<th>작성자</th>
		<td><input name="writer" class="form-control"></td>
	</tr>
	<tr>
		<th>제목</th>
		<td><input name="title" class="form-control"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea name="content" rows="5"
		 class="form-control"></textarea></td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><input type="password" name="password" class="form-control"></td>
	</tr>
	<tr>
		<td>
			<button>등록</button>
			<button type="reset">새로입력</button>
			<button type="button" class="cancelBtn">취소</button>
		</td>
	</tr>
	
	</table>
</form>
</div>
</body>
</html>