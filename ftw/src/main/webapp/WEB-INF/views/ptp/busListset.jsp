<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>순식간에 지나가서 아무도 못볼것이다.</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function(){
		var nosun_id = $("#nosun_id").val()
		var bus_id = $("#bus_id").val()
		var col = $("#col").val()
		
		if(1==1){
			location = "busList.do?nosun_id="+nosun_id+"&bus_id="+bus_id+"&col="+col;
			}
	
		})
	
</script>
</head>
<body>
<input type="hidden" id="nosun_id" value="${bus.nosun_id }">
<input type="hidden" id="bus_id" value="${bus.bus_id }">
<input type="hidden" id="col" value="${bus.col }">
<marquee scrollamount="100">
<img src="https://data.ac-illust.com/data/thumbnails/bf/bf99c282ac5c542c3de5dd510d6ed2df_t.jpeg" width="150px" height="150px">
</marquee>
<marquee scrollamount="50" direction="right">
<img src="https://cdn.crowdpic.net/list-thumb/thumb_l_88E38F18040B6E5B49B3C4252AE6667D.png" width="150px" height="150px">
</marquee>
<marquee scrollamount="200" direction="right">
<img src="https://previews.123rf.com/images/viktorijareut/viktorijareut1508/viktorijareut150800292/44024379-%EB%9F%B0%EB%8D%98-%EB%B9%A8%EA%B0%84-%EB%B2%84%EC%8A%A4-%EB%B2%A1%ED%84%B0-%EC%9D%BC%EB%9F%AC%EC%8A%A4%ED%8A%B8-%EB%A0%88%EC%9D%B4-%EC%85%98-%EB%9F%B0%EB%8D%98-%EA%B8%B0%ED%98%B8%EC%9E%85%EB%8B%88%EB%8B%A4-%EC%9D%B4%EC%B8%B5.jpg" width="150px" height="150px"></marquee>
</body>
</html>