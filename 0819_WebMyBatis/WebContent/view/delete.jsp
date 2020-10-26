<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div{text-align: center; margin: 0px auto;}
	table{width: 600px; margin: 0px auto; 
		border-collapse: collapse; text-align: center;}
	table, th, td {border: 1px solid tomato;}
	h1{text-align: center;}
	a{text-decoration: none;}
</style>
<script type="text/javascript">
	function delete_go(f) {
		var pw = f.m_pw.value;
		if("${vo.m_pw}" == pw){
			var chk = confirm("정말삭제할까요?")
			if(chk){
				f.action="delete_ok.jsp";
				f.submit();
			}else{
				f.m_pw.value="";
				f.m_pw.focus();
				return;
			}
			
		}else{
			alert("비밀번호틀립니다.\n다시입력해주세요")
			f.m_pw.value="";
			f.m_pw.focus();
			return ;
		}
	}
</script>
</head>
<body>
	<div>
		<form method="post">
			<table>	
				<tbody>
						<tr><th>패스워드</th> 
							<td><input type="password"  name="m_pw"></td></tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<input type="button" value="삭제" onclick="delete_go(this.form)">
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>