<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디/비밀번호 찾기</title>
<style type="text/css">
.maincontainer {
	padding-top: 20px;
}
</style>
<script type="text/javascript">
	$(function() {
		// 비밀번호 찾기 버튼
		$('.findUserpwBtn').click(function() {
			$('.findUseridDiv').hide();
			$('.findUserpwDiv').show();
		})

		// 아이디 찾기 버튼
		$('.findUseridBtn').click(function() {
			$('.findUserpwDiv').hide();
			$('.findUseridDiv').show();
		})

		// 아이디 찾기
		$('.useridBtn').click(function() {
			$('#foundUserid').text('');
//			alert($('#useridEmail').val());
			var email = $('#useridEmail').val();
			$.ajax({
				url : '/check/findUserid.do?email=' + email,
				success : function(userid) {
					if(userid) {
						$('.findDiv').hide();
						$('.foundDiv').show();
						$('#foundUserid').append("회원님의 아이디는 " + userid + "입니다.");
						$('.goLoginDiv').show();
					}
// 					else {
// 						$('.findDiv').hide();
// 						$('.foundDiv').show();
// 						$('#foundUserid').append("정보를 다시 입력해주세요.");
// 					}
				},
				error : function (XMLHttpRequest, textStatus, errorThrown){
					console.log(textStatus);
					$('.foundDiv').show();
					$('.goLoginDiv').hide();
					$('#foundUserid').append("정보를 다시 입력해주세요.");
		        }
			})
		})

		// 비밀번호 찾기
		$('.userpwBtn').click(function() {
			$('#foundUserpw').text('');
			var email = $('#userpwEmail').val();
			var userid = $('#userid').val();
			$.ajax({
				url:'/check/findUserpw.do?email=' + email + '&userid=' + userid,
				success : function(){
					location = 'change.do?userid=' + userid;
				},
				error:  function (XMLHttpRequest, textStatus, errorThrown){
					console.log(textStatus);
					$('.findDiv').show();
					$('.foundDiv').show();
					$('.foundUseridDiv').hide();
					$('.foundUserpwDiv').show();
					$('#foundUserpw').append("정보를 다시 입력해주세요.");
		        }	
			})
		})

		// 로그인 하기
		$('.loginBtn').click(function(){
			window.close();
			location = '/member/login.do';
		})

		// 아이디 찾은 후 비밀번호 찾기
		$('.goFindUserpwBtn').click(function() {
			$('.foundDiv').hide();
			$('.findDiv').show();
			$("#radioUserpw").prop("checked", true);
			$('.findUseridDiv').hide();
			$('.findUserpwDiv').show();
		})
		
	})
</script>
</head>
<body>
	<div class="container maincontainer">
		<div class="findDiv">
			<div class="container">
				<label class="radio-inline"> <input type="radio" name="find"
					class="findUseridBtn" checked>아이디 찾기
				</label> <label class="radio-inline"> <input type="radio" name="find" id="radioUserpw"
					class="findUserpwBtn">비밀번호 찾기
				</label>
			</div>
			<div class="findUseridDiv">
				가입하신 이메일을 입력해주세요.
				<form>
					<div class="form-group">
						<label for="email">이메일</label> <input name="email"
							class="form-control" id="useridEmail">
						<button class="btn useridBtn" type="button">확인</button>
					</div>
				</form>
			</div>
			<div class="findUserpwDiv" style='display: none'>
				가입하신 아이디와 이메일을 입력해주세요.
				<form>
					<div class="form-group">
						<label for="userid">아이디</label> <input name="userid"
							class="form-control" id="userid">
					</div>
					<div class="form-group">
						<label for="email">이메일</label> <input name="eamil"
							class="form-control" id="userpwEmail">
						<button class="btn userpwBtn" type="button">확인</button>
					</div>
				</form>
			</div>
		</div>
		<div class="foundDiv" style='display: none'>
			<div class="foundUseridDiv">
				 <span id="foundUserid"></span>
				 <div class="form-inline goLoginDiv">
				 <button class="btn btn-sm loginBtn" type="button">로그인 하기</button>
				 <button class="btn btn-sm goFindUserpwBtn" type="button">비밀번호 찾기</button>
				 </div>
			</div>
			<div class="foundUserpwDiv" style='display: none'>
				<span id="foundUserpw"></span>			
			</div>
		</div>
	</div>
</body>
</html>