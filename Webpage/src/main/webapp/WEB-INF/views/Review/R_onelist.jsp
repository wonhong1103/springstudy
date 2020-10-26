<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기 상세</title>
<style type="text/css">
.review_wrap {width:100%; height:80%; padding-top:5%;}
.review_wrap table {
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

	.div1{
		border: 1px solid black;
		width: 60%;
		margin: 0px auto;
		padding: 5px 20px;
	}
</style>
<script type="text/javascript">
function reviewList_go(f) {
	f.action="reviewList.do";
	f.submit();
}
function reviewUpdate_go(f) {
	f.action="reviewUpdate.do";
	f.submit();
}
function reviewDelete_go(f) {
	f.action="reviewDelete.do";
	f.submit();
}
function r_c_go(f) {
	f.action = "r_c_write.do"
	f.submit();
}
function r_c_delete(f) {
	f.action="r_c_delete.do";
	f.submit();
}
</script>
</head>
<body>
	<jsp:include page="../frame/header.jsp" />	
	<div class="review_wrap" align="center">
		<table class="r_onelist">
			<caption>후기 상세</caption>
			<tbody>
				<tr>
					<th>제목:</th>
					<td> ${rvo.subject}</td>
				</tr>
				<tr>
					<th>이름:</th>
					<td> ${rvo.writer }</td>
				</tr>
				<tr>
					<th>내용:</th>
					<td>
						 <script src="https://cdn.ckeditor.com/4.14.1/standard/ckeditor.js"></script>
						 <textarea name="content" readonly><pre>${rvo.content}</pre></textarea>
                		 <script>
                        	CKEDITOR.replace('content');
                		</script>
					</td>
				</tr>
				<tr>
					<th>첨부파일:</th>
						<c:choose>
							<c:when test="${empty rvo.file_name}">
								<td><b> 첨부파일 없음 </b></td>
							</c:when>
							<c:otherwise>
								<td>
									<img alt="" src="/resources/upload/${rvo.file_name}" style="width: 100px"><br>
									<a href="reviewDown.do?file_name=${rvo.file_name}">${rvo.file_name}</a>
								</td>
							</c:otherwise>
						</c:choose>
				</tr>
	</tbody>
	<tfoot>
	<tr>
     <td colspan="2">
        <input type="button" value="목록" onclick="reviewList_go(this.form)" >
        <input type="button" value="수정" onclick="reviewUpdate_go(this.form)" >
        <input type="button" value="삭제" onclick="reviewDelete_go(this.form)" >
        <input type="hidden" value="${rPage}" name="rPage">
     </td>
	</tr>
	</tfoot>
		</table>
		
	</div>
	<%-- 댓글 처리 --%>
	<br>
	<hr>
	<br>
	<div class="div1">
		<form method="post">
			<p> 이름 : <input type="text" name="writer" size="15"> </p>
			<p> 내용 : <br>
			   <textarea rows="4" cols="40" name="content"></textarea>
			</p>
			<p> 비밀번호 : <input type="password" name="pwd" size="15"> </p>
			<input type="button" value="댓글 저장" onclick="r_c_go(this.form)">
			<%-- 댓글 저장 후 다시 onelistcommend로 가야 하기 때문에  --%>
			<input type="hidden" name= "r_idx" value="${rvo.r_idx}">
			<input type="hidden" value="${rPage}" name="rPage"> 
		</form>
	</div>
	<br>
	<hr>
	<%-- 댓글 출력 --%>
	<div style="display: table; margin-left: 100px; ">
		<c:forEach var="k" items="${r_c_list}">
			<div style="border: 1px solid #cc00cc; width: 400px; margin: 20px; padding: 20px;">
				<form method="post" >
					<p>이름 : ${k.writer} </p>	
					<p>날짜 : ${k.write_date.substring(0,10)} </p>
					<p>내용 : <pre>${k.content}</pre></p>
					<input type="button" value="댓글삭제" onclick="r_c_delete(this.form)">
					<input type="hidden" name="r_c_idx" value="${k.r_c_idx}">
					<input type="hidden" name="r_idx" value="${k.r_idx }">
					<input type="hidden" value="${rPage}" name="rPage">
				</form>
			</div>
			<hr>
		</c:forEach>
	</div>
	<jsp:include page="../frame/footer.jsp" />	
</body>
</html>













