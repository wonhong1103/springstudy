<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
<!-- 전체 css -->
<style type="text/css">
	li{list-style: none;}
	body, html {
	height:100%; margin:0px; padding:0px;
	font-family: 'Times New Roman', serif;
}
	a { text-decoration: none ; color: black;}
</style>
<!-- 왼 사이드바 -->
<style type="text/css">
	#s_sidebar {float:left; background-color: gray; position: fixed; width: 250px; height:100%;}
	#s_sidebar ul ul {margin:2px; padding:2px; position:relative; text-align:center;}
	#s_sidebar ul li li {width:200px; height: 30px; line-height: 30px;}
	#s_sidebar ul ul li:hover {background: darkgray;}
	#s_sidebar ul ul li:hover ul{display:block;}
	#s_sidebar ul ul li a {width:200px; height: 30px; line-height: 30px}
	#s_sidebar ul ul ul {display: none; position:absolute; left:205px; top:0px; background-color: gray}
</style>
<script type="text/javascript">
	function reviewList_go(f){
		f.action="reviewList.do";
		f.submit();
	}
	function qnaList_go(f){
		f.action="qnaList.do";
		f.submit();
	}
	function noticeList_go(f){
		f.action="noticeList.do";
		f.submit();
	}
	function cart_go(f){
		f.action="cartList.do";
		f.submit();
	}
	function login_go(f){
		f.action="login.do";
		f.submit();
	}
</script>
</head>
<body>
<!-- 왼쪽메뉴바 -->	
	<nav id ="sidebar">
		
		<div id = "s_sidebar" >	
		<ul>
		<div id="title" >
		<h1 style="Font-size:40px; text-align: center; "><a href="home.do">가나다라</a></h1>
		<br><br>
			<div id="main_gnb">
				<li class="m_bar"><a href="cart.do">장바구니</a></li>
				<li class="m_bar"><a href="#">마이페이지</a></li>
				<li class="m_bar"><a href="login.do">로그인</a></li>	
			</div>
			<br><br><br><br><br>
		</div>
			<li>TOP
				<ul>
					<li>OUTER
						<ul>
							<li><a href="productList.do">s menu1</a></li>
							<li><a href="productList.do">s menu2</a></li>
							<li><a href="productList.do">s menu3</a></li>
						</ul>
					</li>
				</ul>
				<ul>
					<li>JACKET
						<ul>
							<li><a href="#">s menu1</a></li>
							<li><a href="#">s menu2</a></li>
							<li><a href="#">s menu3</a></li>
						</ul>
					</li>
				</ul>
				<ul>
					<li>SHIRTS
						<ul>
							<li><a href="">s menu1</a></li>
							<li><a href="">s menu2</a></li>
							<li><a href="">s menu3</a></li>
						</ul>
					</li>
				</ul>
			</li>
			
			<li>BOTTOM
				<ul>
					<li>JEANS
						<ul>
							<li><a href="">s menu1</a></li>
							<li><a href="">s menu2</a></li>
							<li><a href="">s menu3</a></li>
						</ul>
					</li>
				</ul>
				<ul>
					<li>SLACKS
						<ul>
							<li><a href="">s menu1</a></li>
							<li><a href="">s menu2</a></li>
							<li><a href="">s menu3</a></li>
						</ul>
					</li>
				</ul>
				<ul>
					<li>SHORTS
						<ul>
							<li><a href="">s menu1</a></li>
							<li><a href="">s menu2</a></li>
							<li><a href="">s menu3</a></li>
						</ul>
					</li>
				</ul>
			</li>
			
			<li>ACCESSORY
				<ul>
					<li>SHOES
						<ul>
							<li><a href="">s menu1</a></li>
							<li><a href="">s menu2</a></li>
							<li><a href="">s menu3</a></li>
						</ul>
					</li>
				</ul>
				<ul>
					<li>BAGS
						<ul>
							<li><a href="">s menu1</a></li>
							<li><a href="">s menu2</a></li>
							<li><a href="">s menu3</a></li>
						</ul>
					</li>
				</ul>
				<ul>
					<li>ACCESSORY
						<ul>
							<li><a href="">ring</a></li>
							<li><a href="">necklace</a></li>
							<li><a href="">watch</a></li>
						</ul>
					</li>
				</ul>
			</li>
			<br><br><br><br><br>	
			<div class= "other">
				<li><a href="qnaList.do">QnA</a></li>
				<li><a href="noticeList.do">공지사항</a></li>
				<li><a href="reviewList.do">후기</a></li>
			</div>
			
			<form>
			<fieldset style="width:150px;">
			<legend>검색</legend>
			<input id="keyword" name="keyword" fw-filter="" fw-label="검색어" fw-msg="" class="inputTypeText" placeholder="" onmousedown="SEARCH_BANNER.clickSearchForm(this)" value="" type="text">
			
			<div class="searchbtn" onclick="SEARCH_BANNER.submitSearchBanner(this); return false;"><i class="xi-search" aria-hidden="true"></i></div>
			
			</fieldset>
			</form>
		</ul>
		</div>
	</nav>
</body>
</html>