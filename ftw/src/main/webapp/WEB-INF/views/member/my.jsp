<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보</title>
<c:if test="${not empty param.success }">
	<script type="text/javascript">
		alert('정보 변경 완료');
	</script>
</c:if>
<c:if test="${not empty param.pw_success }">
	<script type="text/javascript">
		alert('비밀번호 변경 완료');
	</script>
</c:if>
<style type="text/css">
#id {
	background: white;
	border: 0px;
}

#email {
	background: white;
	border: 0px;
}

.form-inline {
	margin: 15px;
	align-self: center;
}

.container {
	margin-top: 30px;
}

.btn {
	margin-left: 10px;
}

.title {
	margin-bottom: 20px;
}
</style>
<script type="text/javascript">
	$(function() {
		// 지역 선택
		var area0 = [ "시/도 선택", "서울특별시", "인천광역시", "대전광역시", "광주광역시", "대구광역시",
				"울산광역시", "부산광역시", "경기도", "강원도", "충청북도", "충청남도", "전라북도", "전라남도",
				"경상북도", "경상남도", "제주도" ];
		var area1 = [ "강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구", "금천구",
				"노원구", "도봉구", "동대문구", "동작구", "마포구", "서대문구", "서초구", "성동구",
				"성북구", "송파구", "양천구", "영등포구", "용산구", "은평구", "종로구", "중구", "중랑구" ];
		var area2 = [ "계양구", "남구", "남동구", "동구", "부평구", "서구", "연수구", "중구",
				"강화군", "옹진군" ];
		var area3 = [ "대덕구", "동구", "서구", "유성구", "중구" ];
		var area4 = [ "광산구", "남구", "동구", "북구", "서구" ];
		var area5 = [ "남구", "달서구", "동구", "북구", "서구", "수성구", "중구", "달성군" ];
		var area6 = [ "남구", "동구", "북구", "중구", "울주군" ];
		var area7 = [ "강서구", "금정구", "남구", "동구", "동래구", "부산진구", "북구", "사상구",
				"사하구", "서구", "수영구", "연제구", "영도구", "중구", "해운대구", "기장군" ];
		var area8 = [ "고양시", "과천시", "광명시", "광주시", "구리시", "군포시", "김포시", "남양주시",
				"동두천시", "부천시", "성남시", "수원시", "시흥시", "안산시", "안성시", "안양시", "양주시",
				"오산시", "용인시", "의왕시", "의정부시", "이천시", "파주시", "평택시", "포천시", "하남시",
				"화성시", "가평군", "양평군", "여주군", "연천군" ];
		var area9 = [ "강릉시", "동해시", "삼척시", "속초시", "원주시", "춘천시", "태백시", "고성군",
				"양구군", "양양군", "영월군", "인제군", "정선군", "철원군", "평창군", "홍천군", "화천군",
				"횡성군" ];
		var area10 = [ "제천시", "청주시", "충주시", "괴산군", "단양군", "보은군", "영동군", "옥천군",
				"음성군", "증평군", "진천군", "청원군" ];
		var area11 = [ "계룡시", "공주시", "논산시", "보령시", "서산시", "아산시", "천안시", "금산군",
				"당진군", "부여군", "서천군", "연기군", "예산군", "청양군", "태안군", "홍성군" ];
		var area12 = [ "군산시", "김제시", "남원시", "익산시", "전주시", "정읍시", "고창군", "무주군",
				"부안군", "순창군", "완주군", "임실군", "장수군", "진안군" ];
		var area13 = [ "광양시", "나주시", "목포시", "순천시", "여수시", "강진군", "고흥군", "곡성군",
				"구례군", "담양군", "무안군", "보성군", "신안군", "영광군", "영암군", "완도군", "장성군",
				"장흥군", "진도군", "함평군", "해남군", "화순군" ];
		var area14 = [ "경산시", "경주시", "구미시", "김천시", "문경시", "상주시", "안동시", "영주시",
				"영천시", "포항시", "고령군", "군위군", "봉화군", "성주군", "영덕군", "영양군", "예천군",
				"울릉군", "울진군", "의성군", "청도군", "청송군", "칠곡군" ];
		var area15 = [ "거제시", "김해시", "마산시", "밀양시", "사천시", "양산시", "진주시", "진해시",
				"창원시", "통영시", "거창군", "고성군", "남해군", "산청군", "의령군", "창녕군", "하동군",
				"함안군", "함양군", "합천군" ];
		var area16 = [ "서귀포시", "제주시", "남제주군", "북제주군" ];

		// 처음 시작시 선택
//		$('#sido1').selected($(vo.sido1));

		// 시/도 선택 박스 초기화
		$("select[id^=sido]").each(
				function() {
					$selsido = $(this);
					$.each(eval(area0), function() {
						$selsido.append("<option value='"+this+"'>" + this
								+ "</option>");
					});
					$selsido.next().append("<option value=''>구/군 선택</option>");
				});
		// 시/도 선택시 구/군 설정
		$("select[id^=sido]").change(
				function() {
					var area = "area"
							+ $("option", $(this)).index(
									$("option:selected", $(this))); // 선택지역의 구군 Array
					var $gugun = $(this).next(); // 선택영역 군구 객체
					$("option", $gugun).remove(); // 구군 초기화

					if (area == "area0")
						$gugun.append("<option value=''>구/군 선택</option>");
					else {
						$.each(eval(area), function() {
							$gugun.append("<option value='"+this+"'>" + this
									+ "</option>");
						});
					}
				});
		// 폼 전송
		$('.updateForm').submit(function() {
			// 별명을 입력하지 않았을 때
			if (!$('#nickname').val()) {
				$('#msg_nickname').text('이름을 입력해주세요');
				$('#nickname').focus();
				return false;
			}
		})
		// 회원 탈퇴
		$('.exitBtn').click(function() {
			if(confirm('정말로 탈퇴 하시겠습니까?') == true) {
				location = "pw_check.do?chk=2&userid=${vo.userid}"
			}
		})
	})
</script>
</head>
<body>
	<div class="container">
		<h1>내 정보</h1>
		<form action="update.do" method="post" class="updateForm form-group">
			<div class="form-inline">
				<label for="userid" class="col-sm-2 col-form-label">아이디</label> <input
					readonly="readonly" value="${vo.userid }" name="userid" id="id"
					class="form-control">
			</div>
			<div class="form-inline">
				<label for="nickname" class="col-sm-2 col-form-label">별명</label> <input
					value="${vo.nickname }" class="form-control" name="nickname"
					id="nickname">
			</div>
			<div class="form-inline">
				<label for="email" class="col-sm-2 col-form-label">이메일</label>
				${vo.email }
			</div>
			<div class="form-inline">
				<label for="local1" class="col-sm-2 col-form-label">선호 지역1</label>
				${vo.local1 } 
				<select	id="sido1" class="form-control" name="sido1">
				</select> 
				<select id="gugun1"	class="form-control" name="gugun1">
				</select> 
				<!-- <input name="local1" type="hidden" id="local1"> -->
			</div>
			<div class="form-inline">
				<label for="local2" class="col-sm-2 col-form-label">선호 지역2</label>
				${vo.local2 } 
				<select	id="sido2" class="form-control" name="sido2">
				</select> 
				<select id="gugun2"	class="form-control" name="gugun2">
				</select> 
				<!-- <input name="local2" type="hidden" id="local2"> -->
			</div>
			<div class="form-inline">
				<label for="local3" class="col-sm-2 col-form-label">선호 지역3</label>
				${vo.local3 } 
				<select	id="sido3" class="form-control" name="sido3">
				</select> 
				<select id="gugun3"	class="form-control" name="gugun3">
				</select> 
				<!-- <input name="local3" type="hidden" id="local3"> -->
			</div>
			<div class="form-inline">
				<label for="join_date" class="col-sm-2 col-form-label">가입 날짜</label>
				<fmt:formatDate value="${vo.join_date }" pattern="yyyy/MM/dd" />
			</div>
			<div class="form-inline">
				<button class="btn btn-default">정보 변경</button>
				<a class="btn btn-default" href="pw_check.do?chk=1&userid=${param.userid }"> 비밀번호 수정 </a> 
				<button	class="btn btn-danger exitBtn" type="button"> 회원 탈퇴 </button>
			</div>
		</form>
	</div>
</body>
</html>