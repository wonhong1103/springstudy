<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 작성</title>
<style type="text/css">
	.notice_wrap {width:100%; height:80%; padding-top:5%;}
	.notice_wrap table {
	    width:800px;
	    margin:0 auto;
	    border:1px solid black;
	    border-collapse:collapse;
	    font-size:14px;
	    
	}
	
	.notice_wrap table caption {
	    font-size:20px;
	    font-weight:bold;
	    margin-bottom:10px;
	}
	
	.notice_wrap table th, tbody {
	    text-align:left;
	    border:1px solid black;
	    padding:4px 10px;
	}
	.notice_wrap table td, tbody {
	    text-align:left;
	    border:1px solid black;
	    padding:4px 10px;
	}
	.notice_wrap th{
		background-color:#dedede
	}
	
</style>
<script type="text/javascript">
	function noticeList_go(f) {
		f.action="noticeList.do"
		f.submit();				
	}
	function noticeSend_go(f) {
		// 유효성 검사
		for (var i = 0; i < f.elements.length; i++) {
			if(f.elements[i].value==""){
				if(i==2 || i==3) continue;  // 제외 시킬 때 사용 
				alert(f.elements[i].name+"를 입력하세요");
				f.elements[i].focus();
				return;
			}
		}
		f.action="noticeWrite_ok.do";
		f.submit();
	}
</script>
</head>
<body>
	<jsp:include page="../frame/header.jsp" />	

	<div class="notice_wrap">
	<form method="post" encType="multipart/form-data">
		<table class="n_write">
			<caption>공지 작성하기</caption>
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
					<th>첨부파일:</th>
					<td><input type="file" name="file"/></td>
				</tr>
				<tr>
					<th>비밀번호:</th>
					<td><input type="password" name="pwd" size="12"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" value="보내기" onclick="noticeSend_go(this.form)"/>
						<input type="reset" value="다시"/>
						<input type="button" value="목록" onclick="noticeList_go(this.form)"/>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	</div>
	
	<jsp:include page="../frame/footer.jsp" />	
</body>
</html>

