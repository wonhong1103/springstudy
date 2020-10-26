<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 방 명 록 </title>
<style type="text/css">
	a { text-decoration: none;}
	table {width: 800px; border-collapse: collapse;; text-align: center;}
	table, th, td{border: 3px solid tomato; padding: 3px}
</style>
<script type="text/javascript">
	function delete_ok(f) {
		// 비밀번호 검사
		if("${ovo.pwd}"==f.pwd.value){
			var chk = confirm("정말 삭제 할까요?");
			if(chk){
				f.action="delete_ok.do";
				f.submit();
			}else{
				history.go(-1);
			}
		}else{
			alert("비밀번호가 틀립니다.");
			f.pwd.value = "";
			f.pwd.focus();
			return ;
		}
		
	}
</script>
</head>
<body>
	<div align="center">
		<h2>방명록 :  삭제화면</h2>
		<hr>
		<p>[<a href="list.do">목록으로 이동</a>]</p>
		<form method="post">
			<table>
				<tbody>
				<tr>
					<td style="background:#dd2211 ">비밀번호확인</td>
					<td><input type="password" name="pwd" size ="20"></td>
				</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<input type="button" value="삭제" 
							onclick="delete_ok(this.form)">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="reset" value="취소">
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>