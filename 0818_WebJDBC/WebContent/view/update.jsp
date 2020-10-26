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
	table, th, td {border: 1px solid blue;}
	h1{text-align: center;}
	a{text-decoration: none;}
</style>
<script type="text/javascript">
	function list_go(f) {
		f.action="index.jsp";
		f.submit();
	}
	function update_go(f) {
		var pw = f.m_pw.value;
		if("${vo.m_pw}" == pw){
			alert("데이터를 수정합니다.")
			f.action="update_ok.jsp";
			f.submit();
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
		<h1> 정보 수정 하기 </h1>
		<form method="post">
		<table>
			<thead>
				<tr>
					<th>IDX</th><th>ID</th><th>PW</th><th>NAME</th><th>AGE</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="text" name="idx" value="${vo.idx }"  disabled></td>
					<td><input type="text" name="m_id" value="${vo.m_id }"  disabled></td>
					<td><input type="password" name="m_pw" ></td>
					<td><input type="text" name="m_name" value="${vo.m_name }"></td>
					<td><input type="number" name="m_age" value="${vo.m_age }"></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="5">
					  <input type="button" value="목록으로" onclick="list_go(this.form)">
					  <input type="button" value="수정하기" onclick="update_go(this.form)"> 
					</td>
				</tr>
			</tfoot>
		</table>
		</form>
	</div>
</body>
</html>