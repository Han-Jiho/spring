<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Flow Traffic Weather::<decorator:title /></title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
header, footer {
	background: AntiqueWhite;
}

pre {
	background: white;
	border: 0px;
}

/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Add a gray background color and some padding to the footer */
footer {
	background-color: #f2f2f2;
	padding: 25px;
}

.carousel-inner img {
	width: 100%; /* Set width to 100% */
	margin: auto;
	min-height: 200px;
}

/* Hide the carousel text when the screen is less than 600 pixels wide */
@media ( max-width : 600px) {
	.carousel-caption {
		display: none;
	}
}

article {
	min-height: 795px;
}

#welcome {
	color: grey;
	margin: 0 auto;
}

.nickname {
	color: white;
}
.userid {
	visibility: none;
	display: none;
}
.logoutDiv {
	visibility: none;
	display: none;
}
#logoImg {
	max-height: 200%;
	max-width: 200%;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$('.logoutBtn').click(function() {
			$('.logoutForm').submit();
		})
		$('.my').click(function() {
			var userid = $('.userid').text();
			//alert(userid);
			location = "/member/my.do?userid=" + userid;
		})
	});
</script>
</head>
<decorator:head />
<body>
	<header>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#myNavbar">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="/main/index.do">
						<img alt="Logo" src="/resources/img/dd.png"
						id="logoImg"> 
					</a>
				</div>
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav">
						<!-- <li><a href="/traffic/traffic.do">traffic</a></li> -->
						<li><a href="/traffic/list.do">교통 정보</a></li>
						<li><a href="/today/list.do">오늘의 날씨</a></li>
						<li><a href="/ptp/list.do">버스 도착 정보</a></li>
						<li><a href="/weekly/list.do">주간 날씨</a></li>
						<li><a href="/accident/list.do">교통 사고</a></li>
						<li><a href="/weather/list.do">자유게시판</a></li>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
						<li><a href="/member/cnt.do">회원통계</a></li>
						</sec:authorize>
					</ul>
				</div>
				<div class="memberDiv" align="right">
					<sec:authorize access="isAnonymous()">
						<a href="/member/join.do">회원 가입</a>
						<a href="/member/login.do">로그인</a>
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">
						<span class="nickname"> <sec:authentication
								property="principal.member.nickname" />님
						</span>
						<span class="userid"><sec:authentication property="principal.member.userid"/></span>
						<%-- <sec:authentication property="principal.member.authList" /> --%>
						<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_MEMBER')">
							<a class="my">내정보</a>
						</sec:authorize>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<a href="/member/list.do">회원목록</a>
						</sec:authorize>
						<a class="logoutBtn">로그아웃</a>
						<div class="logoutDiv">
							<form method="post" class="logoutForm form-inline"
								action="/member/logout.do">
									<input type="hidden" name="${_csrf.parameterName }"
										value="${_csrf.token }">
							</form>
						</div>
					</sec:authorize>
				</div>
			</div>
		</nav>
	</header>
	<article>
		<decorator:body />
	</article>
	<footer class="container-fluid text-center">
		<p>이 홈페이지의 저작권은 6P에게 있습니다.</p>
	</footer>
</body>
</html>