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
	function write_ok(f) {
		f.action="write_ok.do";
		f.submit();
	}
</script>
</head>
<body>
	<div align="center">
		<h2>방명록 : 작성화면</h2>
		<hr>
		<p>[<a href="list.do">목록으로 이동</a>]</p>
		<form method="post" enctype="multipart/form-data">
			<table>
				<col  >
				<tr>
					<td style="background:#dd2211 ">작성자</td>
					<td><input type="text" name="name" size ="20"/></td>
				</tr>
				<tr>
					<td style="background:#dd2211 ">제  목</td>
					<td><input type="text" name="subject" size ="20"/></td>
				</tr>
				<tr>
					<td style="background:#dd2211 ">email</td>
					<td><input type="text" name="email" size ="20"/></td>
				</tr>
				<tr>
					<td style="background:#dd2211 ">비밀번호</td>
					<td><input type="password" name="pwd" size ="20"/></td>
				</tr>
				<tr>
					<td style="background:#dd2211 ">파일</td>
					<td><input type="file" name="file_name" size ="20"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<textarea rows="10" cols="60" name="content"></textarea>
					</td>
				</tr>
				<tfoot>
					<tr>
						<td colspan="2">
							<input type="button" value="저장" onclick="write_ok(this.form)" />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="reset" value="취소" />
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>