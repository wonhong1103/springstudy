<%@page import="com.ict.db.VO"%>
<%@page import="java.util.List"%>
<%@page import="com.ict.db.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  request.setCharacterEncoding("utf-8");
  String idx = request.getParameter("idx");
  
  // DB처리를 하기 위해서 session에 저장된 dao 호출
  DAO dao = (DAO)session.getAttribute("dao");
  
  VO vo = dao.getOneList(idx); 

  session.setAttribute("vo", vo);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 상세보기 </title>
<style type="text/css">
	div{text-align: center; margin: 0px auto;}
	table{width: 600px; margin: 0px auto; 
		border-collapse: collapse; text-align: center;}
	table, th, td {border: 1px solid blue;}
	h1{text-align: center;}
	a{text-decoration: none;}
</style>
<script type="text/javascript">
	function list_go() {
		location.href = "index.jsp";
	}
	function update_go() {
		location.href = "update.jsp";
	}
	function delete_go() {
		location.href = "delete.jsp";
	}
</script>
</head>
<body>
	<div>
		<h1> 상세 정보 보기 </h1>
		<table>
			<thead>
				<tr>
					<th>IDX</th><th>ID</th><th>PW</th><th>NAME</th><th>AGE</th><th>REGDATE</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${vo.idx }</td>
					<td>${vo.m_id }</td>
					<td>${vo.m_pw }</td>
					<td>${vo.m_name }</td>
					<td>${vo.m_age }</td>
					<td>${vo.m_reg.substring(0,10)}</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="6">
					    <button onclick="list_go()"> 목록보기 </button>
					 	<button onclick="update_go()"> 수정하기 </button>
					 	<button onclick="delete_go()"> 삭제하기 </button>
					</td>
				</tr>
			</tfoot>
		</table>
	</div>
</body>
</html>