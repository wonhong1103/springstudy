<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE HTML>
<html>
<head>
<meta charset=UTF-8>
<title>후기</title>

<!--  -->
<style type="text/css">
.review_wrap {width:100%; height:80%; padding-top:5%;}
.review_wrap table{
	width:800px;
	margin:0 auto;
	border: 1px solid black;
	border-collapse: collapse;
	font-size: 14px;
}

.review_wrap table caption {
	font-size: 20px;
	font-weight: bold;
	margin-bottom: 10px;
}

.review_wrap table th, td {
	text-align: center;
	border: 1px solid black;
	padding: 4px 10px;
}

/* paging */
table tfoot ol.paging {
	list-style: none;
}

table tfoot ol.paging li {
	float: left;
	margin-right: 8px;
}

table tfoot ol.paging li a {
	display: block;
	padding: 3px 7px;
	border: 1px solid black;
	color: #2f313e;
	font-weight: bold;
}

table tfoot ol.paging li a:hover {
	background: #00B3DC;
	color: white;
	font-weight: bold;
}

.disable {
	padding: 3px 7px;
	border: 1px solid silver;
	color: silver;
}

.now {
	padding: 3px 7px;
	border: 1px solid black;
	background: black;
	color: white;
	font-weight: bold;
}
</style>

<script type="text/javascript">
	function reviewWrite_go() {
		location.href ="reviewWrite.do";
	}
</script>
</head>
<body>
<jsp:include page="../frame/header.jsp" />
	<!-- 후기 -->
	<div class="review_wrap" align="center">
		<table class="r_review">
			<caption>후기</caption>
			<thead>
				<tr bgcolor="#dedede">
					<th style="padding: 10px; width: 10%">번호</th>
					<th style="width: 40%">제목</th>
					<th style="width: 20%">글쓴이</th>
					<th style="width: 20%">날짜</th>
					<th style="width: 10%">조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${empty reviewlist}">
						<tr>
							<td colspan="5"><h2> 후기가 존재하지 않습니다. </h2></td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="k" items="${reviewlist}" varStatus="vs">
						<tr>
							<td>${paging.totalRecord-((paging.nowPage-1)*paging.numPerPage+vs.index)}</td>
								<td><a href="reviewOnelist.do?r_idx=${k.r_idx}&rPage=${paging.nowPage}">${k.r_subject}</span> </td>
								<td>${k.r_writer}</td>
								<td>${k.r_write_date.substring(0,10)}</td>
								<td>${k.r_hit}</td>
						</tr>
					</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
			<!-- 페이지기법 -->
			<tfoot>
				<tr>
					<td colspan="4">
						<ol class="paging">
						<!-- 이전  -->
					<c:choose>
						<c:when test="${paging.beginBlock <= paging.pagePerBlock }">
								<li class="disable">이전으로</li>
							</c:when>
							<c:otherwise>
								<li><a href="reviewList.do?rPage=${paging.beginBlock-paging.pagePerBlock }">이전으로</a></li>
							</c:otherwise>
						</c:choose>
						
						<!-- 블록안에 들어간 페이지번호들 -->
						<c:forEach begin="${paging.beginBlock}" end="${paging.endBlock }" step="1" var="k">
							<!-- 현재 페이지이냐 아니야 구분 -->
							<c:choose>
								<c:when test="${k==paging.nowPage}">
								    <li class="now">${k}</li>	
								</c:when>
								<c:otherwise>
									<li><a href="reviewList.do?rPage=${k}">${k}</a></li>
								</c:otherwise>
					</c:choose>
					</c:forEach>
					<!-- 이후 -->
					<c:choose>
						<c:when test="${paging.endBlock >= paging.totalPage }">
								<li class="disable">다음으로</li>
							</c:when>
							<c:otherwise>
								<li><a href="reviewList.do?rPage=${paging.beginBlock+paging.pagePerBlock }">다음으로</a></li>
							</c:otherwise>
					</c:choose>
						</ol>
					</td>
					<td>
						<button onclick="reviewWrite_go()">글쓰기</button>
					</td>
				</tr>
			</tfoot>
		</table>
	</div>
	
	<jsp:include page="../frame/footer.jsp" />	
</body>
</html>