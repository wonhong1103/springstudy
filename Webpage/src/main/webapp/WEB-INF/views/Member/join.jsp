<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<!-- 회원가입 css -->
<style type="text/css">
.join_in{width:100%; height:80%; padding-top: 5%; }
table {margin: 0px auto;width: 800px;border-collapse: collapse;font-size: 12pt;}
table, th, td {border: 1px solid black;text-align: center;}
</style>
<!-- 회원가입 스크립트 -->
<script type="text/javascript">
function join_ok(f) {
	// 유효성 검사
	for (var i = 0; i < f.elements.length; i++) {
		if(f.elements[i].value==""){
			if(i==2 || i==3) continue;  // 제외 시킬 때 사용 
			alert(f.elements[i].name+"를 입력하세요");
			f.elements[i].focus();
			return;
		}
	}
	f.action = "join_ok.do";
	f.submit();
	/* if(f.m_pw.value = f.m_pwcheck.value){
	f.action = "join_ok.do";
	f.submit();
	} else{
		alert("비밀번호가 일치하지 않습니다.")
		f.m_pw.value = "";
		f.m_pw.focus();
		return;
	} */
}
function login_go(f) {
	location.href="loing.do";
}
</script>
</head>
<body>
	<jsp:include page="../frame/header.jsp" />	
	
	<!-- 회원가입창 -->
	<div class="join_in">
		<form method="post">
			<table class="join_w">
				<thead>
					<tr>
						<th colspan="2"><h2>회원가입</h2></th>
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
						<th>비밀번호</th>
						<td><input type="password" name="m_pw" placeholder="패스워드를 입력하세요"></td>
					</tr>
					<!-- <tr>
						<th>비밀번호 확인</th>
						<td><input type="password" name="m_pwcheck" placeholder="패스워드를 한번 더 입력하세요"></td>
					</tr> -->
					<tr>
						<th>e-mail</th>
						<td><input type="text" name="m_email" placeholder="email을 입력하세요"></td>
					</tr>
					<tr>
						<th>주소</th>
						<td><input type="text" name="m_reg" placeholder="주소를 입력하세요"></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2"><input type="reset" value="취소"> 
						<input type="submit" value="완료" onclick="join_ok(this.form)"></td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>

	<jsp:include page="../frame/footer.jsp" />
</body>
</html>