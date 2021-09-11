<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session ="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file = "include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TVT Center</title>
</head>
<body>
	
	<section>
		<div><h1>Online TOEIC VOCA TEST</h1><br>
		시험치러가기<br>
		<input class="button" onclick ="location.href='${pageContext.request.contextPath}/test.jsp'" type ="button" value = "test"/>
		</div>
		<h2>로그인을 하셔야 시험을 칠수 있습니다.</h2>
		
	</section>
</body>
</html>

	