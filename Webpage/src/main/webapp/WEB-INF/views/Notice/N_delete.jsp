<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 삭제</title>
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
		f.action = "noticeList.do";
		f.submit();
	}
	function noticeDelete_ok(f) {
		if("${nvo.pwd}" == f.pwd.value){
			var chk = confirm("정말삭제할까요?");
			if(chk){
				f.action = "noticeDelete_ok.do";
				f.submit();
			}else{
				history.go(-1);
			}
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

	<div class="notice_wrap">
	<form method="post">
		<table class="n_delete">
			<caption>공지 삭제하기</caption>
			<tbody>
				<tr>
					<th>비밀번호 확인:</th>
					<td><input type="password" name="pwd" size="20"></td>
				</tr>
			</tbody>
			<tfoot>
				<tr> 
					<td colspan="2">
						<input type="button" value="삭제" onclick="noticeDelete_ok(this.form)">
						<input type="reset" value="취소">
						<input type="button" value="목록" onclick="noticeList_go(this.form)">
						<input type="hidden" name="nPage" value="${nPage}">
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
	</div>
	
	<jsp:include page="../frame/footer.jsp" />		
</body>
</html>

