<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
tr {
	    text-align:center;
	    padding:4px 10px;
	    background-color: #F6F6F6;
	}
	
th {
		width:120px;
	    text-align:center;
	    padding:4px 10px;
	    background-color: #B2CCFF;
	}
	
	/* 가운데 정렬 */
	h2{text-align: center;}
	table { margin: 0px auto;}
</style>
<script type="text/javascript">
	function delete_ok(f) {
		if("${vo.pwd}"== f.pwd.value){
			var chk = confirm("정말 삭제할까요?");
			if(chk){
				f.action="/MyController?cmd=delete_ok";
				f.submit();
			}else{
				history.go(-1);
			}
		}else{
			alert("비밀번호틀림\n다시입력하세요");
			f.pwd.value="";
			f.pwd.focus();
			return ;
		}
	}
</script>
</head>
<body>
	<h2>BOARD 글 삭제</h2>
	<form method="post">
		<table width="800">
			<tbody>
				<tr>
					<th>비빌번호확인</th>
					<td align="left"><input type="password" name="pwd"></td>
				</tr>
            </tbody>
            <tfoot>
            	<tr>
            		<td colspan="2">
            			<input type="button" value="삭제" onclick="delete_ok(this.form)">
            			<input type="hidden" value="${cPage}" name="cPage">
            			<input type="hidden" value="${vo.idx}" name="idx">
            		</td>
            	</tr>
            </tfoot>
		</table>
	</form>
</body>
</html>