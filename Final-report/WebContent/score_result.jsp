<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>토익 보카 테스트</title>
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
	</style>
</head>
<body>
	<header>
		<h1>테스트 결과</h1>
		<div style="text-align: right;">
			<p>반갑습니다, ${result.id} !...</p>
		</div>
		<hr>
	</header>
	<article>
		<form action="${pageContext.request.contextPath}/Home.jsp" >
			<div>
				<h3>성격 테스트 분석 결과</h3>
			</div>
			<div>
				<p><b>1. 평가 점수 :</b>${result.score} 정도 예상합니다.</p>
				<p><b>2. 맞은 문항 :</b>
					<c:forEach var="i" begin="0" end="14">
					${result.correct[i]}&nbsp
					</c:forEach>
				</p> 
				<p>
				<b>3. 틀린 문항 :</b>
					<c:forEach var="i" begin="0" end="14">
					${result.incorrect[i]}&nbsp
					</c:forEach>
				</p>
			</div>
			<div style="padding-top: 50px; text-align: right;">
				<input type="submit" value="첫 화면으로 가기" />
			</div>
		</form>
	</article>
</body>
</html>
