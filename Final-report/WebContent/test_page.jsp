<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>토익보카 테스트</title>
	<style>
		body {
			width: 600px;
			margin-top: 50px;
			margin-left: 50px;
		}
		header {
			height: 100px;
		}
		.question {
			padding-top: 25px;
		}
		.buttons {
			padding-top: 50px; 
			text-align: right;
		}
	</style>
</head>
<body>
	<c:set var="qNum" value="${reqpage * 3 - 2}" />
	<header>
		<h1>토익 보카 테스트</h1>
		<div style="text-align: right;">
			<p>반갑습니다, ${id} 님!...</p>
		</div>
		<hr>
	</header>
	<article>
		<form action="${pageContext.request.contextPath}/test.do/${reqpage+1}">
			<c:forEach var="qt" items="${questions}">
			<div class="question">
				<p>${qt.question}</p>
				<div>
					<c:forEach var="item" items="${qt.items}" varStatus="status">
					<input type="radio" name="q${qNum}" value="${qt.scores[status.index]}" ${status.index==0 ? "required" : ""}> ${item} <br>
					</c:forEach>		
				</div>
			</div>
			<c:set var="qNum" value="${qNum+1}" />
			</c:forEach>
					
			<div class="buttons">			
				<c:if test="${reqpage != 1}">
				<input type="button" value=" 이전" onclick="window.history.go(-1);" />
				</c:if>
				<input type="submit" value="다음" />
			</div>
		</form>
	</article>
</body>
</html>
