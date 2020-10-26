<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품품목별 화면</title>

<!-- 콘텐츠 스타일 -->
<style type="text/css">
	.main_wrapper{
		text-align: center;
		padding: 100px 100px 100px 400px;
	}
	
	.mp{
		text-align: center;
		display:inline-block;
		floast: left;
		margin: 10px;
	}	
	.pics{
		width:300px; 
		height:450px;
	}
</style>

</head>
<body>
	<jsp:include page="../frame/header.jsp" />	
	
	<!-- 제품들 -->
<div class="main_wrapper" >
	<h2>OUTER</h2>
	<p><h3>padded</h3><h3>coat</h3><h3>suit</h3></p>
	<ul>
	<li class=mp><div class=main_p><a href="#"><img class= pics src="../resources/images/맨투맨.jpeg" alt="My Image" ></a></div></li>
	<li class=mp><div class=main_p><a href="#"><img class= pics src="../resources/images/반팔티.jpeg" alt="My Image" ></a></div></li>
	<li class=mp><div class=main_p><a href="#"><img class= pics src="../resources/images/반팔티1.jpeg" alt="My Image" ></a></div></li>
	<li class=mp><div class=main_p><a href="#"><img class= pics src="../resources/images/박스티.jpeg" alt="My Image" ></a></div></li>
	
	<li class=mp><div class=main_p><a href="#"><img class= pics src="../resources/images/맨투맨.jpeg" alt="My Image" ></a></div></li>
	<li class=mp><div class=main_p><a href="#"><img class= pics src="../resources/images/반팔티.jpeg" alt="My Image" ></a></div></li>
	<li class=mp><div class=main_p><a href="#"><img class= pics src="../resources/images/반팔티1.jpeg" alt="My Image" ></a></div></li>
	<li class=mp><div class=main_p><a href="#"><img class= pics src="../resources/images/박스티.jpeg" alt="My Image" ></a></div></li>
	
	<li class=mp><div class=main_p><a href="#"><img class= pics src="../resources/images/맨투맨.jpeg" alt="My Image" ></a></div></li>
	<li class=mp><div class=main_p><a href="#"><img class= pics src="../resources/images/반팔티.jpeg" alt="My Image" ></a></div></li>
	<li class=mp><div class=main_p><a href="#"><img class= pics src="../resources/images/반팔티1.jpeg" alt="My Image" ></a></div></li>
	<li class=mp><div class=main_p><a href="#"><img class= pics src="../resources/images/박스티.jpeg" alt="My Image" ></a></div></li>
	
	<li class=mp><div class=main_p><a href="#"><img class= pics src="../resources/images/맨투맨.jpeg" alt="My Image" ></a></div></li>
	<li class=mp><div class=main_p><a href="#"><img class= pics src="../resources/images/반팔티.jpeg" alt="My Image" ></a></div></li>
	<li class=mp><div class=main_p><a href="#"><img class= pics src="../resources/images/반팔티1.jpeg" alt="My Image" ></a></div></li>
	<li class=mp><div class=main_p><a href="#"><img class= pics src="../resources/images/박스티.jpeg" alt="My Image" ></a></div></li>

	</ul>
</div>
	<!-- produts_list.jsp 확인해보기 -->
	
	<jsp:include page="../frame/footer.jsp" />
</body>
</html>