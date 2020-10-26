<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품등록</title>
<style type="text/css">
.admin_wrap{width:100%; height:80%; padding-top: 5%; }
.admin{
	margin-left: 600px;
	width: 800px;
	border-collapse: collapse;
	border-color: black;
	text-align: center;
	}
.admin table, th, td{border: 1px solid black;}
.admin table{width: 500px;}
h2{margin-left:600px;}
	
</style>
<script type="text/javascript">
	function product_add(f) {
		f.action="/MyController?cmd=productadd";
		f.submit()
	}
</script>
</head>
<body>
	<jsp:include page="../frame/header.jsp" />

	<div class="admin_wrap">
	<h2> 상품 등록 </h2>
	<form method="post" enctype="multipart/form-data">
		<table class="admin">
			<tbody>
				<tr>
					<th bgcolor="#dedede"> 분류 </th>
					<td>
						<input type="radio" name="category" value="com001">TOP
						<input type="radio" name="category" value="ele002">BOTTOM
						<input type="radio" name="category" value="sp003">ACCESSORY
					</td>
				</tr>
				<tr>
					<th bgcolor="#dedede"> 제품번호 </th>
					<td><input type="text" name="p_num"   size="20"></td>
				</tr>
				<tr>
					<th bgcolor="#dedede"> 제품명 </th>
					<td><input type="text" name="p_name"   size="20"></td>
				</tr>
				<tr>
					<th bgcolor="#dedede"> 사이즈 </th>
					<td><input type="text" name="p_company"  size="20"></td>
				</tr>
				<tr>
					<th bgcolor="#dedede"> 컬러 </th>
					<td><input type="text" name="p_company"  size="20"></td>
				</tr>
				<tr>
					<th bgcolor="#dedede"> 상품가격 </th>
					<td><input type="text" name="p_price"   size="20"></td>
				</tr>
				<tr>
					<th bgcolor="#dedede"> 할인가 </th>
					<td><input type="text" name="p_saleprice"   size="20"></td>
				</tr>
				<tr>
					<th bgcolor="#dedede"> 상품이미지S </th>
					<td><input type="file" name="p_image_s" size="20"></td>
				</tr>
				<tr>
					<th bgcolor="#dedede"> 상품이미지L </th>
					<td><input type="file" name="p_image_l" size="20"></td>
				</tr>
				<tr>
					<td colspan="2" bgcolor="#dedede"><b>상품내용</b></td>
				</tr>
				<tr>
					<td colspan="2">
						<textarea rows="10" cols="50" name="p_content"></textarea>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<input type="button" value="상품등록" onclick="product_add(this.form)">
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
	</div>
	
	<jsp:include page="../frame/footer.jsp" />
</body>
</html>