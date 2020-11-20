<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글보기</title>
<!-- Bootstrap 라이브러리 등록 CDN방식 -->
<!--  <meta name="viewport" content="width=device-width, initial-scale=1">  -->
<!--  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">  -->
<!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>  -->
<!--  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>  -->

<!-- 댓글 js모듈 등록 -->

  
</head>
<body>
<div class="container">
	<h1>게시판 글보기</h1>
	<table class="table">
		<tr>
			<th>번호</th>
			<td id="no">${vo.no }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${vo.title }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><pre style="border: none;">${vo.content }</pre></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${vo.writer }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><fmt:formatDate value="${vo.writeDate }" pattern="yyyy.MM.dd"/></td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${vo.hit }</td>
		</tr>
		<tr>
			<td colspan="2">
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<a href="update.do?no=${vo.no }" class="btn btn-default">수정</a>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<a href="delete.do?no=${vo.no}" class="btn btn-default" id="deleteBtn">삭제</a>
			</sec:authorize>	
				<a href="list.do" class="btn btn-default">리스트</a>
			</td>
		</tr>
	</table>
	
		<!-- 댓글처리를 위한 div -->	
<!--  		
		<div>
			<button type="button" class="btn btn-default" 
			data-toggle="modal" data-target="#myModal" id="replyWriteBtn">
			댓글달기</button>
			<span id="replyPage">1</span>
		</div>
-->
    		
		<!-- 댓글 리스트 -->
<!--  		
		<div id="replyListDiv">
  			<ul class="list-group">
			  <li class="list-group-item rowData">
			  	<span class="rno">번호</span>. 내용 입력
			  	<span class="badge" style="background : none;">
			  		<button class="replyUpdateBtn btn btn-default">수정</button>
			  		<button class="replyDeleteBtn btn btn-default">삭제</button>
			  	</span>
			  	<hr/>
			  	이름(작성일)
			  </li>
			</ul>
		</div>
-->
		
	</div>
	<!-- 삭제를 위한 form tag : 보이지 않는다. -->
	<form action="delete.do" method="post" id="deleteForm">
		<input type="hidden" name="no" value="${vo.no }"/>
		<input type="hidden" name="pw" id="deletePW"/>
	</form>
	
<!-- Modal : 처음에는 안보이다가 이벤트가 발생되면 나타나는 창-->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
 		<!-- 댓글달기를 클릭하면 "댓글 쓰기"로 댓글수정을 클릭하면 "댓글 수정"으로 제목 변경 -->
        <h4 class="modal-title">댓글쓰기</h4>
      </div>
      <div class="modal-body">
        <p>
        	<form id="replyWriteForm">
        		<!-- 댓글 수정할 때는 댓글번호가 필요하다. -->
        		<input type="text" id="rno" />
				<div class="form-group">
					<label for="content">내용</label> 
					<textarea class="form-control" rows="5" id="content"></textarea>
				</div>
				<div class="form-group">
  					<label for="writer">작성자</label>
  					<input type="text" class="form-control" id="writer">
				</div>
			</form>
        </p>
      </div>
      <div class="modal-footer">
      	<button id="replyWriteProcessBtn" class="btn btn-default">등록</button>
      	<button id="replyUpdateProcessBtn" class="btn btn-default">수정</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
      </div>
    </div>

  </div>
</div>	
</body>
</html>