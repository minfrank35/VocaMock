<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
  <%@ include file="include/header.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>점수확인</title>
<style>
section {
	display: flex;
	justify-content: center;
}
table {
	margin-top : 10px;
	border-collapse : collapse;
	margin-bottom : 10px;
	
	}
	td {
	padding : 10px;
	border : 1px solid black;
	}
	
	
</style>
</head>
<body>
	<section>
		<table >
			<thead>
				<tr><td>score</td><td>회차</td></tr>
			</thead>
			<tbody>
			<c:forEach var ="rdo" items = "${scorelist}">
				<tr>
				<td>${rdo.score}</td>
				<td>${rdo.number}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</section>
</body>
</html>