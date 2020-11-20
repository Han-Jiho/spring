<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
<script type="text/javascript">
	$(function() {
		$('.stopBtn').click(function() {
			confirm('회원을 정지시키겠습니까?');
		})
		$('.clearBtn').click(function() {
			confirm('회원 정지를 해제하겠습니까?');
		})
	})
</script>
<style type="text/css">
	#id {
		border: 0px;
		padding: 0px;
	}
</style>
</head>
<body>
	<div class="container">
		<h1>회원 정보</h1>
			<table class="table">
				<tr>
					<th>회원 번호</th>
					<td>${vo.no }</td>
				</tr>
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" value="${vo.userid }"
						readonly="readonly" name="id" id="id"> 
					</td>
				</tr>
				<tr>
					<th>별명</th>
					<td>${vo.nickname }</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>${vo.email }</td>
				</tr>
				<tr>
					<th rowspan="3">선호 지역</th>
					<td>${vo.local1 }</td>
				</tr>
				<tr>
					<td>${vo.local2 }</td>
				</tr>
				<tr>
					<td>${vo.local3 }</td>
				</tr>
				<tr>
					<th>회원 상태</th>
					<td>${vo.enabled }</td>
				</tr>
				<tr>
					<th>가입 날짜</th>
					<td>
						<fmt:formatDate value="${vo.join_date }"
						pattern="yyyy/MM/dd"/> 
					</td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<c:if test="${vo.enabled ne 1 }">
							<a href="clear.do?userid=${vo.userid }" 
							class="btn btn-primary clearBtn">정지 해제</a>
						</c:if>
						<c:if test="${vo.enabled eq 1 }">
							<a href="stop.do?userid=${vo.userid }" 
							class="btn btn-danger stopBtn">회원 정지</a>
						</c:if>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><a
						href="list.do?key=${param.key }&word=${param.word}"
						class="btn btn-default delete"> 목록으로 </a></td>
				</tr>
			</table>
	</div>
</body>
</html>