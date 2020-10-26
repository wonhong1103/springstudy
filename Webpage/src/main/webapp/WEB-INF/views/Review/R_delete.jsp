<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기 삭제</title>

<style type="text/css">
	.review_wrap {width:100%; height:80%; padding-top:5%;}
	.review_wrap table {
	    width:800px;
	    margin:0 auto;
	    border:1px solid black;
	    border-collapse:collapse;
	    font-size:14px;
	    
	}
	
	.review_wrap table caption {
	    font-size:20px;
	    font-weight:bold;
	    margin-bottom:10px;
	}
	
	.review_wrap table th, tbody {
	    text-align:left;
	    border:1px solid black;
	    padding:4px 10px;
	}
	.review_wrap table td, tbody {
	    text-align:left;
	    border:1px solid black;
	    padding:4px 10px;
	}
	.review_wrap th{
		background-color:#dedede
	}
	

</style>
<script type="text/javascript">
	function reviewlist_go(f) {
		f.action = "reviewList.do";
		f.submit();
	}
	function reviewDelete_ok(f) {
		if("${rvo.pwd}" == f.pwd.value){
			var chk = confirm("정말삭제할까요?");
			if(chk){
				f.action = "reviewDelete_ok.do";
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

	<div class="review_wrap">
	<form method="post">
		<table class="r_delete">
			<caption>후기 삭제하기</caption>
			<tbody>
				<tr>
					<th>비밀번호 확인:</th>
					<td><input type="password" name="pwd" size="20"></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<input type="button" value="삭제" onclick="reviewDelete_ok(this.form)">
						<input type="reset" value="취소">
						<input type="button" value="목록" onclick="reviewList_go(this.form)">
						<input type="hidden" name="rPage" value="${rPage}">
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
	</div>
	
	<jsp:include page="../frame/footer.jsp" />	
</body>
</html>

