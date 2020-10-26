<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA 작성</title>
<style type="text/css">
	.qna_wrap {width:100%; height:80%; padding-top:5%;}
	.qna_wrap table {
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
	f.action="qnaList.do"
	f.submit();				
}
	function qnaSend_go(f) {
		// 유효성 검사
		for (var i = 0; i < f.elements.length; i++) {
			if(f.elements[i].value==""){
				if(i==2 || i==3) continue;  // 제외 시킬 때 사용 
				alert(f.elements[i].name+"를 입력하세요");
				f.elements[i].focus();
				return;
			}
		}
		f.action="qnaWrite_ok.do";
		f.submit();
	}
</script>
</head>
<body>
	<jsp:include page="../frame/header.jsp" />	

	<!-- QnA -->
	<div class="qna_wrap">
	<form method="post" encType="multipart/form-data">
		<table class="q_write">
			<caption>QnA 작성하기</caption>
			<tbody>
				<tr>
					<th>제목:</th>
					<td><input type="text" name="subject" size="45"/></td>
				</tr>
				<tr>
					<th>이름:</th>
					<td><input type="text" name="writer" size="12"/></td>
				</tr>
				<tr>
					<th>내용:</th>
					<td>
						 <script src="https://cdn.ckeditor.com/4.14.1/standard/ckeditor.js"></script>
						 <textarea name="content"></textarea>
                		 <script>
                        	CKEDITOR.replace( 'content' );
                		</script>
					</td>
				</tr>
				<tr>
					<th>비밀번호:</th>
					<td><input type="password" name="pwd" size="12"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" value="보내기" onclick="qnaSend_go(this.form)"/>
						<input type="reset" value="다시"/>
						<input type="button" value="목록" onclick="qnsList_go(this.form)"/>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	</div>
	
	<jsp:include page="../frame/footer.jsp" />	
</body>
</html>

