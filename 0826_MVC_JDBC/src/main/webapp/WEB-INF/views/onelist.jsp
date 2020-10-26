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
	function update_go(f) {
		f.action="update.do";
		f.submit();
	}
	function delete_go(f) {
		f.action="delete.do";
		f.submit();
	}
</script>
</head>
<body>
	<div align="center">
		<h2>방명록 : 상세화면</h2>
		<hr>
		<p>[<a href="list.do">목록으로 이동</a>]</p>
		<form method="post">
			<table>
				<tr>
					<td style="background:#dd2211 ">작성자</td>
					<td>${vo.name }</td>
				</tr>
				<tr>
					<td style="background:#dd2211 ">제  목</td>
					<td>${vo.subject }</td>
				</tr>
				<tr>
					<td style="background:#dd2211 ">email</td>
					<td>${vo.email }</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: left; padding-left: 50px"><pre>${vo.content}</pre></td>
				</tr>
				<tfoot>
					<tr>
						<td colspan="2">
							<input type="button" value="수정화면" onclick="update_go(this.form)" />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="reset" value="삭제화면" onclick="delete_go(this.form)" />
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>