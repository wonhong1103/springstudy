<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA 확인시 </title>
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
	function qnaOnelist_ok(f) {
		if("${qvo.pwd}" == f.pwd.value){
			if(chk){
				f.action = "qnaOnelist_ok.do?q_idx";
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

<!-- QnA -->
	<div class="qna_wrap">
	<form method="post">
		<table class="q_check">
			<caption>QnA 비밀글 확인</caption>
			<tbody>
				<tr>
					<th>비밀번호 확인:</th>
					<td><input type="password" name="pwd" size="20"></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<input type="reset" value="취소">
						<input type="button" value="목록" onclick="qnaOnelist_go(this.form)">
						<input type="hidden" name="qPage" value="${qPage}">
						<!-- list에서 ${k.subject} 누르고 여기서 해당 글의 비밀번호 체크하고 맞으면 
						 &b_idx=${k.q_idx}&qPage=${paging.nowPage} 
						 ${k.subject}로 가야함-->
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
	</div>
	<jsp:include page="../frame/footer.jsp" />	
	
</body>
</html>

