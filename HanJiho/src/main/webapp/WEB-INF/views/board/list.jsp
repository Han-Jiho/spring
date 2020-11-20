<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="pageObject" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<!-- Bootstrap 라이브러리 등록 CDN방식 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>게시판 리스트</title>
<style type="text/css">
	.dataRow:hover {
		background: #ddd;
		cursor: pointer;
	}
</style>
<script type="text/javascript">
	$(function() {
		$(".dataRow").click(function() {
			var no = $(this).find(".no").text();
			location = "view.do?no=" + no + "&inc=1";
		});
	});
</script>

</head>
<body>
	<div class="container">
		<h2>게시판 리스트</h2>
		<table class="table">
			<tr>
				<th>글 번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<c:forEach items="${list }" var="vo">
				<tr class="dataRow">
					<td class="no">${vo.no }</td>
					<td>${vo.title }</td>
					<td>${vo.writer }</td>
					<td><fmt:formatDate value="${vo.writeDate }"
							pattern="yyyy.MM.dd" /></td>
					<td>${vo.hit }</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5"><a href="write.do" class="btn btn-default">글쓰기</a>
				</td>
			</tr>
			<tr>
				<td colspan="5"><pageObject:pageNav pageObject="${pageObject }" listURI="list.do" />
				</td>
			</tr>
		</table>
	</div>
</body>
</html>