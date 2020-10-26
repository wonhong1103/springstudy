<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 상세</title>
<style type="text/css">
.notice_wrap {width:100%; height:80%; padding-top:5%;}
.notice_wrap table {
	width:800px;
	margin:0 auto;
	border: 1px solid black;
	border-collapse: collapse;
	font-size: 14px;
}

.notice_wrap table caption {
	font-size: 20px;
	font-weight: bold;
	margin-bottom: 10px;
}

.notice_wrap table th, td {
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
	function noticeList_go(f) {
		f.action = "noticeList.do";
		f.submit();
	}
	/* function noticeUpdate_go(f) {
		f.action = "noticeUpdate.do";
		f.submit();
	}
	function noticeDelete_go(f) {
		f.action = "noticeDelete.do";
		f.submit();
	} */
</script>
</head>
<body>
	<jsp:include page="../frame/header.jsp" />	

	<div class="notice_wrap" align="center">
		<table class="n_onelist">
			<caption>공지 상세</caption>
			<tbody>
				<tr>
					<th bgcolor="#dedede">제목:</th>
					<td> ${nvo.subject}</td>
				</tr>
				<tr>
					<th bgcolor="#dedede">이름:</th>
					<td> ${nvo.writer }</td>
				</tr>
				<tr>
					<th bgcolor="#dedede">내용:</th>
					<c:choose>
						<c:when test="${empty list}">
							<td><h3>공지가 존재하지 않습니다.</h3></td>
						</c:when>
						<c:otherwise>
							<td>
								<textarea name="content" readonly>${nvo.content}</textarea>
							</td>
						</c:otherwise>
					</c:choose>
				</tr>
					
				<tr>
					<th bgcolor="#dedede">첨부파일:</th>
						<c:choose>
							<c:when test="${empty nvo.file_name}">
								<td><b> 첨부파일 없음 </b></td>
							</c:when>
							<c:otherwise>
								<td>
									<img alt="" src="upload/${nvo.file_name}" style="width: 100px"><br>
									<a href="noticeDownload.do?file_name=${nvo.file_name}">${nvo.file_name}</a>
								</td>
							</c:otherwise>
						</c:choose>
				</tr>
				<tr>
					<td colspan="2">
						<!-- <input type="button" value="수정" onclick="noticeUpdate_go(this.form)">
						<input type="button" value="삭제" onclick="noticeDelete_go(this.form)">
						<input type="hidden" value="${nPage}" name="nPage"> -->
						<input type="button" value="목록" onclick="noticeList_go(this.form)">
						 
					</td>
				</tr>
			</tbody>
		</table>
		
	</div>
	<jsp:include page="../frame/footer.jsp" />	

</body>
</html>
					












