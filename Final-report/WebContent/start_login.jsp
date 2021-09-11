<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TVT login</title>
<link rel="stylesheet" type="text/css" href="button.css">
<style>

*{
font-family:sans-serif;
}
body {
	background-color : #0B4C5F;
}

#loginForm { /* formì ë¸ë­ììì´ë¤.*/
	text-align: center;
	position: absolute;
	display: inline-block;
	padding: 2% 6% 2% 6%;
	background-color: white;
	top: 15%;
	left: 37%;
	border-radius: 2em;
}

.inForm {
	margin: 8% 0 8% 0;
	border-bottom : 2px solid gray;
}

.text {
	
	width: 100%;
  	font-size:20px;
  	height:30px;
  	border: none;
  	
}
h2 {
font-size : 40px;

}
</style>
</head>
<body>
	<form action="${pageContext.request.contextPath}/login.do/login" id="loginForm">
		<h2>TVT Center</h2>
		<div class="inForm">
			<input type="text" name="vocaId" class="text" placeholder="아이디"
				required/>
		</div>
		<div class="inForm">
			<input type="password" name="vocaPw" class="text" placeholder="비밀번호"
				required />
		</div>
		<div>
			<input type="submit" class="button" value="login" /> 
			<input
				type="button" class="button" value="sign up"
				onclick="location.href = 'sign_up.html'" />
		</div>
	</form>
</body>
</html>