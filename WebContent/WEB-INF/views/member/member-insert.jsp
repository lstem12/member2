<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보입력</title>
</head>
<body>
<form method="post" action="/member/insert">
<table border=1>
	<tr>
		<th>이름</th>
		<td><input type="text" name="m_name"></td>
	</tr>
	<tr>
		<th>아이디</th>
		<td><input type="text" name="m_id"></td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><input type="password" name="m_pwd"></td>
	</tr>
	<tr>
		<th colspan = "2"><button>회원정보입력</button></th>
	</tr>
</table>
</form>
</body>
</html>