<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID/PW찾기</title>
<!-- 로그인 css -->
<style type="text/css">
table {margin: 0px auto;width: 300px;border-collapse: collapse;font-size: 12pt;}
table, th, td {border: 1px solid black;text-align: center;}
</style>
<style type="text/css">
	.find_wrap{width:100%; height:80%; padding-top:5%}
	.find_id{}
	.find_pw{margin-top:100px}
</style>
<script type="text/javascript">
	function findid_ok(f) {
		f.action="findid_ok.do";
		f.submit();
	}
	function findpw_ok(f) {
		f.action="findpw_ok.do";
		f.submit();
	}
</script>
</head>
<body>
	<jsp:include page="../frame/header.jsp" />
	
	<!-- 아이디 찾기 -->
<div class="find_wrap">
	<div>
		<form method="post">
			<table class="find_id">
				<thead>
					<tr>
						<th colspan="2"><h2>아이디 찾기</h2></th>
					</tr>
				</thead>
				<tbody>					
					<tr>
						<th>아이디</th>
						<td><input type="text" name="m_id" placeholder="아이디를 입력하세요"></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" name="m_name" placeholder="이름을 입력하세요"></td>
					</tr>					
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2"><input type="button" value="확인" onclick="findid_ok"></td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>

	<div >
		<form method="post">
			<table class="find_pw">
				<thead>
					<tr>
						<th colspan="2"><h2>비밀번호 찾기</h2></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>아이디</th>
						<td><input type="text" name="m_id" placeholder="아이디를 입력하세요"></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" name="m_name" placeholder="이름을 입력하세요"></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="text" name="m_email" placeholder="email을 입력하세요"></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2"><input type="button" value="확인" onclick="findpw_ok"></td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</div>
	
	<jsp:include page="../frame/footer.jsp" />
</body>
</html>