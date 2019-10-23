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
<table class="table table-striped table-bordered table table-hover">

<thead>
    <tr>
      <th style="width:10%">번호</th>
      <th style="width:20%">작성자</th>
      <th style="width:30%">제목</th>
      <th style="width:40%">내용</th>
    </tr>
</thead>

<tbody>
<c:forEach items="${list}" var="dto">
    <tr>
      <td onclick="location.href='/spring_board/ContentView'">${dto.bNum}</td>
      <td onclick='alert("hi")'>${dto.bId}</td>
      <td onclick='alert("hi")'>${dto.bTitle}</td>
      <td onclick='alert("hi")'>${dto.bContent}</td>
    </tr>
</c:forEach>
</tbody>

</table>

<button type="button" class="btn btn-primary" onclick="location.href='/spring_board/BWrite'" >글쓰기</button>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    
</body>
</html>