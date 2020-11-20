<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>건의사항 글 쓰기</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#back").click(function(){
			location = "list.do"
		})
})
</script>
<style type="text/css">
	h6{color: red}
</style>
</head>
<body>
<div class="container">
<h1>게시판 글쓰기</h1>
<h5>※ 이곳에는 건의사항을 올려주세요 ※</h5>
	<h6>※ 희망하는 기능, 기능오류 등등 ※</h6>
	<h6>※ 건의사항과 관계없거나 비속어는 신고할거얌 ※</h6>
<form method="post">
    <div class="form-group">
      <label for="title">제목:</label>
      <input type="text" class="form-control" id="title" 
      name="title" required="required" pattern=".{2,100}"
      maxlength="100">
    </div>
    <div class="form-group">
      <label for="writer">작성자:</label>
      <input type="text" class="form-control" id="writer"
      name="writer" required="required" pattern="[가-힣a-zA-Z]{2,10}"
      maxlength="10">
    </div>
    <div class="form-group">
	  <label for="content">내용:</label>
	  <textarea class="form-control" rows="5" id="content" name="content"></textarea>
	</div>
    <div class="form-group">
      <label for="pw">비밀번호:</label>
      <input type="password" class="form-control" id="pw"
      name="pw" required="required" pattern=".{3,50}"
      maxlength="50">
    </div>
    <button class="btn btn-default">등록</button>
    <button type="button" class="btn btn-default" id="back">돌아가기</button>
  </form>
</div>
</body>
</html>