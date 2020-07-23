<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:if test="${rMap.msg eq '대여정보 수정완료'}">
<script>
		alert("${rMap.msg}");
		location.href="/lent/list";
</script>
</c:if>

<c:if test="${rMap.msg eq '대여정보 수정실패'}">
<script>
		alert("${rMap.msg}");
		location.href="/lent/list";
</script>
</c:if>
</body>
</html>