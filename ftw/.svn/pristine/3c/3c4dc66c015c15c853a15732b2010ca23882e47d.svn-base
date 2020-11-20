<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주간날씨 수정 글 수정</title>
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
<h1>게시판 글수정</h1>
  <form method="post">
    <div class="form-group">
      <label for="baseDate">baseDate</label>
      <input type="text" class="form-control" id="baseDate"
       name="baseDate" readonly="readonly" value="${vo.baseDate }">
    </div>
    <div class="form-group">
      <label for="monMin">monMin</label>
      <input type="text" class="form-control" id="monMin" name="monMin" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.monMin }">
    </div>
    <div class="form-group">
      <label for="monMax">monMax</label>
      <input type="text" class="form-control" id="monMax" name="monMax" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.monMax }">
    </div>
    <div class="form-group">
      <label for="tueMin">tueMin</label>
      <input type="text" class="form-control" id="tueMin" name="tueMin" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.tueMin }">
    </div>
    <div class="form-group">
      <label for="tueMax">tueMax</label>
      <input type="text" class="form-control" id="tueMax" name="tueMax" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.tueMax }">
    </div>
    <div class="form-group">
      <label for="wedMin">wedMin</label>
      <input type="text" class="form-control" id="wedMin" name="wedMin" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.wedMin }">
    </div>
    <div class="form-group">
      <label for="wedMax">tueMax</label>
      <input type="text" class="form-control" id="wedMax" name="wedMax" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.wedMax}">
    </div>
    <div class="form-group">
      <label for="thuMin">thuMin</label>
      <input type="text" class="form-control" id="thuMin" name="thuMin" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.thuMin }">
    </div>
    <div class="form-group">
      <label for="thuMax">thuMax</label>
      <input type="text" class="form-control" id="thuMax" name="thuMax" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.thuMax }">
    </div>
    <div class="form-group">
      <label for="friMin">friMin</label>
      <input type="text" class="form-control" id="friMin" name="friMin" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.friMin }">
    </div>
    <div class="form-group">
      <label for="friMax">friMax</label>
      <input type="text" class="form-control" id="friMax" name="friMax" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.friMax }">
    </div>
    <div class="form-group">
      <label for="satMin">satMin</label>
      <input type="text" class="form-control" id="satMin" name="satMin" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.satMin }">
    </div>
    <div class="form-group">
      <label for="satMax">satMax</label>
      <input type="text" class="form-control" id="satMax" name="satMax" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.satMax }">
    </div>
    <div class="form-group">
      <label for="sunMin">sunMin</label>
      <input type="text" class="form-control" id="sunMin" name="sunMin" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.sunMin }">
    </div>
    <div class="form-group">
      <label for="sunMax">sunMax</label>
      <input type="text" class="form-control" id="sunMax" name="sunMax" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.sunMax }">
    </div>
    <div class="form-group">
      <label for="monar">monar</label>
      <input type="text" class="form-control" id="monar" name="monar" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.monar }">
    </div>
    <div class="form-group">
      <label for="monpr">monpr</label>
      <input type="text" class="form-control" id="monpr" name="monpr" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.monpr }">
    </div>
    <div class="form-group">
      <label for="tuear">tuear</label>
      <input type="text" class="form-control" id="tuear" name="tuear" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.tuear }">
    </div>
    <div class="form-group">
      <label for="tuepr">tuepr</label>
      <input type="text" class="form-control" id="tuepr" name="tuepr" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.tuepr }">
    </div>
    <div class="form-group">
      <label for="wedar">wedar</label>
      <input type="text" class="form-control" id="wedar" name="wedar" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.wedar }">
    </div>
    <div class="form-group">
      <label for="wedpr">wedpr</label>
      <input type="text" class="form-control" id="wedpr" name="wedpr" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.wedpr }">
    </div>
    <div class="form-group">
      <label for="thuar">thuar</label>
      <input type="text" class="form-control" id="thuar" name="thuar" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.thuar }">
    </div>
    <div class="form-group">
      <label for="thupr">thupr</label>
      <input type="text" class="form-control" id="thupr" name="thupr" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.thupr }">
    </div>
    <div class="form-group">
      <label for="friar">friar</label>
      <input type="text" class="form-control" id="friar" name="friar" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.friar }">
    </div>
    <div class="form-group">
      <label for="fripr">fripr</label>
      <input type="text" class="form-control" id="fripr" name="fripr" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.fripr }">
    </div>
    <div class="form-group">
      <label for="satar">satar</label>
      <input type="text" class="form-control" id="satar" name="satar" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.satar }">
    </div>
    <div class="form-group">
      <label for="satpr">satpr</label>
      <input type="text" class="form-control" id="satpr" name="satpr" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.satpr }">
    </div>
    <div class="form-group">
      <label for="sunar">sunar</label>
      <input type="text" class="form-control" id="sunar" name="sunar" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.sunar }">
    </div>
    <div class="form-group">
      <label for="sunpr">sunpr</label>
      <input type="text" class="form-control" id="sunpr" name="sunpr" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.sunpr }">
    </div>
    <div class="form-group">
      <label for="monaw">monaw</label>
      <input type="text" class="form-control" id="monaw" name="monaw" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.monaw }">
    </div>
    <div class="form-group">
      <label for="monpw">monpw</label>
      <input type="text" class="form-control" id="monpw" name="monpw" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.monpw }">
    </div>
    <div class="form-group">
      <label for="tueaw">tueaw</label>
      <input type="text" class="form-control" id="tueaw" name="tueaw" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.tueaw }">
    </div>
    <div class="form-group">
      <label for="tuepw">tuepw</label>
      <input type="text" class="form-control" id="tuepw" name="tuepw" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.tuepw }">
    </div>
    <div class="form-group">
      <label for="wedaw">wedaw</label>
      <input type="text" class="form-control" id="wedaw" name="wedaw" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.wedaw }">
    </div>
    <div class="form-group">
      <label for="wedpw">wedpw</label>
      <input type="text" class="form-control" id="wedpw" name="wedpw" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.wedpw }">
    </div>
    <div class="form-group">
      <label for="thuaw">thuaw</label>
      <input type="text" class="form-control" id="thuaw" name="thuaw" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.thuaw }">
    </div>
    <div class="form-group">
      <label for="thupw">thupw</label>
      <input type="text" class="form-control" id="thupw" name="thupw" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.thupw }">
    </div>
    <div class="form-group">
      <label for="friaw">friaw</label>
      <input type="text" class="form-control" id="friaw" name="friaw" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.friaw }">
    </div>
    <div class="form-group">
      <label for="fripw">fripw</label>
      <input type="text" class="form-control" id="fripw" name="fripw" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.fripw }">
    </div>
    <div class="form-group">
      <label for="sataw">sataw</label>
      <input type="text" class="form-control" id="sataw" name="sataw" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.sataw }">
    </div>
    <div class="form-group">
      <label for="satpw">satpw</label>
      <input type="text" class="form-control" id="satpw" name="satpw" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.satpw }">
    </div>
    <div class="form-group">
      <label for="sunaw">sunaw</label>
      <input type="text" class="form-control" id="sunaw" name="sunaw" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.sunaw }">
    </div>
    <div class="form-group">
      <label for="sunpw">sunpw</label>
      <input type="text" class="form-control" id="sunpw" name="sunpw" required="required" pattern=".{1,4}" Maxlength="10" value="${vo.sunpw }">
    </div>

    <button>수정</button>
    <button type="button" class="cancelBtn">취소</button>
  </form>
</div>
</body>
</html>