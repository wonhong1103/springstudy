<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home 화면</title>
<!-- 광고,제품 -->
<!-- 콘텐츠 스타일 -->
<style type="text/css">
	.main_wrapper{
		text-align: center;
		padding: 10px 100px 100px 100px;
	}
	
	.mp{
		text-align: center;
		display:inline-block;
		floast: left;
		margin: 20px;
	}	
	.pics{
		width:300px; 
		height:450px;
	}
</style>

<!-- 로그인 스크립트 -->
<script type="text/javascript">
	
</script>
</head>
<body>

	<jsp:include page="frame/header.jsp" />
	<!-- 메인광고,제품 -->	
	<!-- 제품들 -->
	<section>
		<article style="margin-left: 300px; margin-right: auto;">	
<div class="main_wrapper" >
	<ul>
	<hr>
	<p><a href="">[BEST 20]</a></p>
	<li class=mp><div class=main_p><a href=""><img class= pics src="../resources/images/맨투맨.jpeg" alt="My Image" ></a></div></li>
	<li class=mp><div class=main_p><a href="#"><img class= pics src="../resources/images/반팔티.jpeg" alt="My Image" ></a></div></li>
	<li class=mp><div class=main_p><a href="#"><img class= pics src="../resources/images/반팔티1.jpeg" alt="My Image" ></a></div></li>
	<li class=mp><div class=main_p><a href="#"><img class= pics src="../resources/images/박스티.jpeg" alt="My Image" ></a></div></li>
	<hr>
	<p><a href="productList.do">[NEW]</a></p>
	<li class=mp><div class=main_p><a href="#"><img class= pics src="../resources/images/맨투맨.jpeg" alt="My Image" ></a></div></li>
	<li class=mp><div class=main_p><a href="#"><img class= pics src="../resources/images/반팔티.jpeg" alt="My Image" ></a></div></li>
	<li class=mp><div class=main_p><a href="#"><img class= pics src="../resources/images/반팔티1.jpeg" alt="My Image" ></a></div></li>
	<li class=mp><div class=main_p><a href="#"><img class= pics src="../resources/images/박스티.jpeg" alt="My Image" ></a></div></li>
	<hr>
	<li class=mp><div class=main_p><a href="#"><img class= pics src="../resources/images/맨투맨.jpeg" alt="My Image" ></a></div></li>
	<li class=mp><div class=main_p><a href="#"><img class= pics src="../resources/images/반팔티.jpeg" alt="My Image" ></a></div></li>
	<li class=mp><div class=main_p><a href="#"><img class= pics src="../resources/images/반팔티1.jpeg" alt="My Image" ></a></div></li>
	<li class=mp><div class=main_p><a href="#"><img class= pics src="../resources/images/박스티.jpeg" alt="My Image" ></a></div></li>
	
	<li class=mp><div class=main_p><a href="#"><img class= pics src="../resources/images/맨투맨.jpeg" alt="My Image" ></a></div></li>
	<li class=mp><div class=main_p><a href="#"><img class= pics src="../resources/images/반팔티.jpeg" alt="My Image" ></a></div></li>
	<li class=mp><div class=main_p><a href="#"><img class= pics src="../resources/images/반팔티1.jpeg" alt="My Image" ></a></div></li>
	<li class=mp><div class=main_p><a href="#"><img class= pics src="../resources/images/박스티.jpeg" alt="My Image" ></a></div></li>
	
	<li class=mp><div class=main_p><a href="#"><img class= pics src="../resources/images/박스티.jpeg" alt="My Image" ></a></div></li>
	<li class=mp><div class=main_p><a href="#"><img class= pics src="../resources/images/박스티.jpeg" alt="My Image" ></a></div></li>
	</ul>
</div>
	</article>
	</section>
<jsp:include page="frame/footer.jsp" />	
</body>
</html>