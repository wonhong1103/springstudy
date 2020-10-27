<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#bbs table {
	    width:800px;
	    margin:0 auto;
	    margin-top:20px;
	    border:1px solid black;
	    border-collapse:collapse;
	    font-size:14px;
	    
	}
	
	#bbs table caption {
	    font-size:20px;
	    font-weight:bold;
	    margin-bottom:10px;
	}
	
	#bbs table th {
	    text-align:center;
	    border:1px solid black;
	    padding:4px 10px;
	}
	
	#bbs table td {
	    text-align:left;
	    border:1px solid black;
	    padding:4px 10px;
	}
	
	.no {width:15%}
	.subject {width:30%}
	.writer {width:20%}
	.reg {width:20%}
	.hit {width:15%}
	.title{background:lightsteelblue}
	.odd {background:silver}
	
	.div1{
		border: 1px solid blue;
		width: 60%;
		margin: 0px auto;
		padding: 5px 20px;
	}
</style>
<script type="text/javascript">
	function list_go(f) {
		f.action = "list.do";
		f.submit();
	}
	function update_go(f) {
		f.action = "update.do";
		f.submit();
	}
	function delete_go(f) {
		f.action = "delete.do";
		f.submit();
	}
	function comment_go(f) {
		f.action = "c_write.do"
		f.submit();
	}
	function c_delete(f) {
		f.action="c_delete.do";
		f.submit();
	}
</script>
</head>
<body>
	<div id="bbs">
	<form method="post">
		<table summary="게시판 글쓰기">
			<caption>게시판 글쓰기</caption>
			<tbody>
				<tr>
					<th>제목:</th>
					<td> ${bvo.subject}</td>
				</tr>
				<tr>
					<th>이름:</th>
					<td> ${bvo.writer }</td>
				</tr>
				<tr>
					<th>내용:</th>
					<td>
						 <script src="https://cdn.ckeditor.com/4.14.1/standard/ckeditor.js"></script>
						 <textarea name="content" readonly><pre>${bvo.content}</pre></textarea>
                		 <script>
                        	CKEDITOR.replace('content');
                		</script>
					</td>
				</tr>
				<tr>
					<th>첨부파일:</th>
						<c:choose>
							<c:when test="${empty bvo.file_name}">
								<td><b> 첨부파일 없음 </b></td>
							</c:when>
							<c:otherwise>
								<td>
									<img alt="" src="/resources/upload/${bvo.file_name}" style="width: 100px"><br>
									<a href="down.do?file_name=${bvo.file_name}">${bvo.file_name}</a>
								</td>
							</c:otherwise>
						</c:choose>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" value="수정" onclick="update_go(this.form)">
						<input type="button" value="삭제" onclick="delete_go(this.form)">
						<input type="button" value="목록" onclick="list_go(this.form)">
						<input type="hidden" value="${cPage}" name="cPage"> 
					</td>
				</tr>
			</tbody>
		</table>
		</form>
	</div>
	<%-- 댓글 처리 --%>
	<br>
	<hr>
	<br>
	<%-- 댓글 출력 --%>
	<div style="display: table; margin-left: 100px; ">
		<c:forEach var="k" items="${c_list}">
			<div style="border: 1px solid #cc00cc; width: 400px; margin: 20px; padding: 20px;">
				<form method="post" >
					<p>이름 : ${k.writer}<br>
					날짜 : ${k.write_date.substring(0,10)}<br>
					내용 : <pre>${k.content}</pre>
					</p>
					<c:if test="${log_id==k.writer}">
						<input type="button" value="댓글삭제" onclick="c_delete(this.form)">
						<input type="hidden" name="c_idx" value="${k.c_idx}">
						<input type="hidden" name="b_idx" value="${k.b_idx }">
						<input type="hidden" value="${cPage}" name="cPage">
					</c:if>
				</form>
			</div>
			<hr>
		</c:forEach>
	</div>
	<div class="div1">
		<form method="post">
			<p style="font-size: 20px"><b>이름 : ${log_id}</b><br>
				<b>내용</b><br>
			    <textarea rows="4" cols="80" name="content" 
			    placeholder="댓글을 남겨 보세요"></textarea>
			    <input style="margin-left: 40px"  
			     type="button" value="댓글 저장" 
			    onclick="comment_go(this.form)">
				<%-- 댓글 저장 후 다시 onelist.do로 가야 하기 때문에  --%>
				<input type="hidden" name= "b_idx" value="${bvo.b_idx}">
				<input type="hidden" value="${cPage}" name="cPage"> 
				<input type="hidden" value="${log_id}" name="m_id">
				<input type="hidden" value="${log_id}" name="writer">
				<input type="hidden" value="1111" name="pwd">
			</p>
		</form>
	</div>
	<br>
	<hr>
	
</body>
</html>













