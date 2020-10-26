<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 공지사항</title>
<script type="text/javascript">
	function noticeWrite_go(f) {
		location.href = "noticeWrite.do"; 
	}
</script>
</head>
<body>
<jsp:include page="../frame/header.jsp" />

	<!-- 공지사항 -->
	<div class="notice_wrap" align="center">
		<table class="n_notice">
			<caption>공지사항</caption>
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
					<c:when test="${empty list}">
						<tr>
							<td colspan="5"><h2> 공지사항이 존재하지 않습니다. </h2></td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="k" items="${list}" varStatus="vs">
							<tr>
								<td>${paging.totalRecord-((paging.nowPage-1)*paging.numPerPage+vs.index)}</td>
								<td><a href="noticeOnelist&n_idx=${k.n_idx}&nPage=${paging.nowPage}">${k.subject}</span> </td>
								<td>${k.writer}</td>
								<td>${k.write_date.substring(0,10)}</td>
								<td>${k.hit}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
			<!-- 페이지기법 -->
			<tfoot>
				<tr>
					<td colspan="5">
						<ol class="paging">
						<!-- 이전 -->
						<c:choose>
							<c:when test="${paging.beginBlock <= paging.pagePerBlock }">
								<li class="disable">이전으로</li>
							</c:when>
							<c:otherwise>
								<li><a href="noticeList.do&nPage=${paging.beginBlock-paging.pagePerBlock }">이전으로</a></li>
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
									<li><a href="noticeList.do&nPage=${k}">${k}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						
						<!-- 다음 -->
						<c:choose>
							<c:when test="${paging.endBlock >= paging.totalPage }">
								<li class="disable">다음으로</li>
							</c:when>
							<c:otherwise>
								<li><a href="noticeList.do&nPage=${paging.beginBlock+paging.pagePerBlock }">다음으로</a></li>
							</c:otherwise>
						</c:choose>
						</ol>
					</td>
					<td>
						<button onclick="noticeWrite_go()">작성</button>
					</td>
				</tr>
			</tfoot>
		</table>
	</div>
	
	<jsp:include page="../frame/footer.jsp" />
</body>
</html>