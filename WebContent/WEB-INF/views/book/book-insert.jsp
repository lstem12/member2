<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/book/insert">
책이름: <input type="text" name="b_title"><br>
저   자: <input type="text" name="b_author"><br>
책설명: <input type="text" name="b_desc"><br>
<button>입력</button>
</form>
</body>
</html>