<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session ="false"%>
   <%@ include file="include/header.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시험 치기</title>
<style>
section a {
	display :block;
	font-size : 50px;
	text-decoration : none;
	
}
section a:hover{
	color : green;
}
</style>
</head>
<body>
	<section>
		<a href="${pageContext.request.contextPath}/test.do/1?numberOfTest=1" >TEST1</a>
		<a href="${pageContext.request.contextPath}/test.do/1?numberOfTest=2" >TEST2</a>
		<a href="${pageContext.request.contextPath}/test.do/1?numberOfTest=3" >TEST3</a>
	</section>
	
</body>
</html>