<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>

<script>
	function info_chk(frm) { 
		frm.action='BDeleteGo'; 
		frm.submit(); 
	 	return true; 
	} 
</script>

<form action="BUpdateGo" method="POST" onsubmit="return info_chk()">

<div class="form-group">
	<label for="Id">글번호</label>
	<input type="text" class="form-control" id="bNum" name="bNum" value="${ContentView.bNum}" readonly>
</div>

<div class="form-group">
	<label for="Id">작성자</label>
	<input type="text" class="form-control" id="bId" name="bId" value="${ContentView.bId}" readonly>
</div>

<div class="form-group">
	<label for="Id">제목</label>
	<input type="text" class="form-control" id="BTitle" name="BTitle" value="${ContentView.bTitle}">
</div>
  
<div class="form-group"> 
	<label for="content">Comment:</label> 
	<textarea class="form-control" rows="10" id="BContent" name="BContent">${ContentView.bContent}</textarea> 
</div>

 <button type="submit" class="btn btn-primary">수정하기</button>
 <button type="button" class="btn btn-primary" onclick="return info_chk(this.form)">삭제하기</button>
 
</form>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    
</body>
</html>