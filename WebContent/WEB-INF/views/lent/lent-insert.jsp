


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>




<%@ include file="/WEB-INF/views/common/common.jsp"%>





<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/lent/insert">
	<table border="1">
		<tr>
			<th>대여자</th>
			<td><input type="number" name="m_num"></td>
		</tr>
		<tr>
			<th>대여할책</th>
			<td>
				<select name="b_num">
					<c:forEach items="${bookList}" var="book">
						<option value="${book.b_num}">${book.b_title}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<th colspan="2"><button>대여</button></th>
		</tr>
	</table>
</form>
</body>
</html>