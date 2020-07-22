<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/lent/update" id="frm">
<input type="hidden" name="l_num" value="${lent.l_num}">
<table border="1">
	<tr>
		<th>대여번호</th>
		<td>${lent.l_num}</td>
	</tr>
	<tr>
		<th>대여일자</th>
		<td>${lent.l_lentdate}</td>
	</tr>
	<tr>
		<th>반납일자</th>
		<td><input type="text" name="l_recdate" value="${lent.l_recdate}"></td>
	</tr>
	<tr>
		<th>대여자</th>
		<td>${lent.m_name}</td>
	</tr>
	<tr>
		<th>대여도서</th>
		<td>${lent.b_title}</td>
	</tr>
	<tr>
	<th colspan="2"><button>수정</button><button type="button" onclick="doDelete()">삭제</button></th>
	</tr>	
</table>
</form>
<script>
	function doDelete(){
		var formObj = document.querySelector("#frm");
		formObj.action = '/lent/delete';
		formObj.submit();
	}
</script>
</body>
</html>