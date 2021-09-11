<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="button.css">
<style>
	body {
	margin : 0;
	background-color : white;
	}
	
	
	header {
	display : flex;
	font-size: 20px;
	font-family : sans-serif;
	background-color : black;
	padding : 10px;
	}
	#logo {
	margin : 0 3% 0 0;
	align-self : center;
	text-decoration : none;
	color : white;
	font-size : 40px;
	font-weight : bold;
	padding : 10px;
	margin-left : 20px;
	}
	
	
	nav {
	flex-grow : 5;
	display : flex;
	justify-content : flex-start;
	align-self: center;
	}
	
	nav a, #user a{
		text-decoration : none;
		color : white;
		padding : 0 30px 0 30px;
		
	}
	nav a:hover, #user a:hover{
	color : gray;
	
	}
	
	#user{
		display : flex;
		align-self : center;
		flex-grow : 0.2;
		
	}
	section{
	text-align: center;
	}

</style>
</head>
<body>
<header>
		<a href = "${pageContext.request.contextPath}/Home.jsp" id="logo">TVT</a>
		<nav>
			<a href="${pageContext.request.contextPath}/test.jsp" >토익</a>
			<a href="${pageContext.request.contextPath}/login.do/mypage" >마이페이지(점수확인)</a>
		</nav>
		<div id = "user">
			<a href = "${pageContext.request.contextPath}/start_login.jsp">login</a>
			<a href ="${pageContext.request.contextPath}/sign_up.html">Sign up</a>
			
		</div>
	</header>
</body>
</html>