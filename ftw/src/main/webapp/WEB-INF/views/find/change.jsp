<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
</head>
<body>
	<div class="container">
		<form method="post" class="changeForm form-group">
			<div class="form-inline">변경할 비밀번호를 입력해주세요.</div>
			<div class="form-inline">
				<input type="hidden" id="userid" value="${param.userid }"> <input
					type="password" name="userpw" id="userpw" class="form-control">
				<button class="btn btn-default">변경 완료</button>
				<button class="cancelBtn btn btn-default" type="button">변경
					취소</button>
			</div>
		</form>
	</div>
</body>
</html>