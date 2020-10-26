<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
	function update_ok(f) {
		// 비밀번호검사
		if("${ovo.pwd}" == f.pwd.value){
			f.action="update_ok.do";
			f.submit();
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
	<div align="center">
		<h2>방명록 : 수정화면</h2>
		<hr>
		<p>[<a href="list.do">목록으로 이동</a>]</p>
		<form method="post" enctype="multipart/form-data">
			<table>
				<col  >
				<tr>
					<td style="background:#dd2211 ">작성자</td>
					<td><input type="text" name="name" size ="20" value="${ovo.name }"></td>
				</tr>
				<tr>
					<td style="background:#dd2211 ">제  목</td>
					<td><input type="text" name="subject" size ="20" value="${ovo.subject }"></td>
				</tr>
				<tr>
					<td style="background:#dd2211 ">email</td>
					<td><input type="text" name="email" size ="20" value="${ovo.email}"></td>
				</tr>
				<tr>
					<td style="background:#dd2211 ">비밀번호</td>
					<td><input type="password" name="pwd" size ="20" ></td>
				</tr>
				<tr>
					<td style="background:#dd2211 ">첨부파일</td>
					<c:choose>
						<c:when test="${empty ovo.file_name }">
							<td>
								<input type="file" name="file_name"> <b>첨부파일없음</b>
							</td>
						</c:when>
						<c:otherwise>
							<td>
								<input type="file" name="file_name"> <b>${ovo.file_name}</b>
							</td>
						</c:otherwise>
					</c:choose>
				</tr>
				<tr>
					<td colspan="2">
						<textarea rows="10" cols="60" name="content">${ovo.content }</textarea>
					</td>
				</tr>
				<tfoot>
					<tr>
						<td colspan="2">
							<input type="hidden" name="idx" value="${ovo.idx}">
							<input type="hidden" name="f_name" value="${ovo.file_name}">
							<input type="button" value="수정" onclick="update_ok(this.form)" />
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