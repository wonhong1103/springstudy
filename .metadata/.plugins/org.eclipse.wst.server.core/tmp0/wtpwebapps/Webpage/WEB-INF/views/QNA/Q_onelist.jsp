<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA 상세</title>
<style type="text/css">
.qna_wrap {width:100%; height:80%; padding-top:5%;}
.qna_wrap table {
	width:800px;
	margin:0 auto;
	border: 1px solid black;
	border-collapse: collapse;
	font-size: 14px;
}

.qna_wrap table caption {
	font-size: 20px;
	font-weight: bold;
	margin-bottom: 10px;
}

.qna_wrap table th, td {
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
	function qnaList_go(f) {
		f.action = "qnaList.do";
		f.submit();
	}
	function qnaUpdate_go(f) {
		f.action = "qnaDpdate.do";
		f.submit();
	}
	function qnaDelete_go(f) {
		f.action = "qnaDelete.do";
		f.submit();
	}
	function q_c_go(f) {
		f.action = "q_c_write.do"
		f.submit();
	}
	function q_c_delete(f) {
		f.action="q_c_delete.do";
		f.submit();
	}
</script>
</head>
<body>
	<jsp:include page="../frame/header.jsp" />	
	
<!-- QnA -->
	<div class="qna_wrap" align="center">
		<table class="q_onelist">
			<caption>QnA 상세</caption>
			<tbody>
				<tr>
					<th bgcolor="#dedede">제목:</th>
					<td> ${qvo.subject}</td>
				</tr>
				<tr>
					<th bgcolor="#dedede">이름:</th>
					<td> ${qvo.writer }</td>
				</tr>
				<tr>
					<th bgcolor="#dedede">내용:</th>
					<td>
						 <script src="https://cdn.ckeditor.com/4.14.1/standard/ckeditor.js"></script>
						 <textarea name="content" readonly><pre>${qvo.content}</pre></textarea>
                		 <script>
                        	CKEDITOR.replace('content');
                		</script>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" value="목록" onclick="qnaList_go(this.form)" >
       					<input type="button" value="수정" onclick="qnaUpdate_go(this.form)" >
       					<input type="button" value="삭제" onclick="qnaDelete_go(this.form)" >
						<input type="hidden" value="${qPage}" name="qPage"> 
					</td>
				</tr>
			</tbody>
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
			<input type="button" value="댓글 저장" onclick="q_c_go(this.form)">
			<%-- 댓글 저장 후 다시 onelistcommend로 가야 하기 때문에  --%>
			<input type="hidden" name= "q_idx" value="${qvo.q_idx}">
			<input type="hidden" value="${qPage}" name="qPage"> 
		</form>
	</div>
	<br>
	<hr>
	<%-- 댓글 출력 --%>
	<div style="display: table; margin-left: 100px; ">
		<c:forEach var="k" items="${q_c_list}">
			<div style="border: 1px solid #cc00cc; width: 400px; margin: 20px; padding: 20px;">
				<form method="post" >
					<p>이름 : ${k.writer} </p>	
					<p>날짜 : ${k.write_date.substring(0,10)} </p>
					<p>내용 : <pre>${k.content}</pre></p>
					<input type="button" value="댓글삭제" onclick="q_c_delete(this.form)">
					<input type="hidden" name="q_c_idx" value="${k.q_c_idx}">
					<input type="hidden" name="q_idx" value="${k.q_idx }">
					<input type="hidden" value="${qPage}" name="qPage">
				</form>
			</div>
			<hr>
		</c:forEach>
	</div>
	<jsp:include page="../frame/footer.jsp" />	
</body>
</html>













