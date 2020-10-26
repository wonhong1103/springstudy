<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA 수정</title>
<style type="text/css">
	.qna_wrap {width:100%; height:80%; padding-top:5%;}
	.qna_wrap table{
	    width:800px;
	    margin:0 auto;
	    border:1px solid black;
	    border-collapse:collapse;
	    font-size:14px;
	    
	}
	
	.qna_wrap table caption {
	    font-size:20px;
	    font-weight:bold;
	    margin-bottom:10px;
	}
	
	.qna_wrap table th, tbody {
	    text-align:left;
	    border:1px solid black;
	    padding:4px 10px;
	}
	.qna_wrap table td, tbody {
	    text-align:left;
	    border:1px solid black;
	    padding:4px 10px;
	}
	.qna_wrap th{
		background-color:#dedede
	}
	

</style>
<script type="text/javascript">
	function qnaList_go(f) {
		f.action="qnaList"
		f.submit();				
	}
	function qnaUpdate_ok(f) {
		if("${qvo.pwd}" == f.pwd.value){
			f.action = "qnaUpdate_ok";
			f.submit();
		}else{
			alert("비밀번호가 틀립니다.\n다시입력해주세요");
			f.pwd.value="";
			f.pwd.focus();
			return;
		}
		
	}
</script>
</head>
<body>
	<jsp:include page="../frame/header.jsp" />	
<!-- QnA -->
	<div class="qna_wrap">
	<form method="post" encType="multipart/form-data">
		<table class="q_update">
			<caption>QnA 수정하기</caption>
			<tbody>
				<tr>
					<th>제목:</th>
					<td><input type="text" name="subject" size="45" value="${bvo.subject}"></td>
				</tr>
				<tr>
					<th>이름:</th>
					<td><input type="text" name="writer" size="12" value="${bvo.writer}"></td>
				</tr>
				<tr>
					<th>내용:</th>
					<td>
						 <script src="https://cdn.ckeditor.com/4.14.1/standard/ckeditor.js"></script>
						 <textarea name="content">${qvo.content}</textarea>
                		 <script>
                        	CKEDITOR.replace( 'content' );
                		</script>
					</td>
				</tr>
				<tr>
					<th>비밀번호:</th>
					<td><input type="password" name="pwd" size="12"></td>
				</tr>
				</tbody>
				<tfoot align="center">
				<tr>
					<td colspan="2">
						<input type="button" value="수정하기" onclick="update_ok(this.form)"/>
						<input type="reset" value="다시"/>
						<input type="button" value="목록" onclick="list_go(this.form)"/>
						<%-- 수정시 파일을 업로드 하지 않을 것을 대비 이전 파일이름을 넘긴다.--%>
						<input type="hidden" name="qPage" value="${qPage }">
					</td>
				</tr>
				</tfoot>
		</table>
	</form>
	</div>	
	<jsp:include page="../frame/footer.jsp" />	
</body>
</html>

