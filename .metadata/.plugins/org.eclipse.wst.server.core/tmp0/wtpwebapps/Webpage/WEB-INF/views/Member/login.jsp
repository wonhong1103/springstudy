<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<!-- 로그인 css -->
<style>
table {
    border-collapse: collapse;
    border-spacing: 0;
}
    .wrapper { width:100%; height:80%; padding-top:5%; font-family: '돋움';}
    .main { }
    
    .login_box { width:300px; height:350px; padding: 40px; margin: 0 auto;   
                  border: 1px solid black;}
    .login_box .input_login { border-bottom: 2px solid gray; padding: 20px 0 9px 0;}
    .login_box .input_login input { width: 100%; color: gray; font-size: 15px; border:none; font-family:inherit;}
    .login_box .check { color: black; font-size: 14px; padding: 10px 0px 15px 0px; font-family: '돋움';}
    
    .login_box  .login input { width:100%; height:55px;  font-size:16px; 
                               padding:17px 0 16px; border:0; cursor:pointer; font-family:'돋움';}
    
    .login_box .last { width:100%; margin-top:10px; border-top:1px solid gray; padding-top:20px;}
    .login_box .last .join { float:left;}
    .login_box .last .search { float:right;}
    .login_box .last .join a { color: gray;}
    .login_box .last .search a { color:gray;} 
</style>
<!-- 로그인 스크립트 -->
<script type="text/javascript">
	function login_ok(f) {
		f.action = "login_ok.do";
		f.submit();
		if (document.getElementById("log_id").value != document
				.getElementById("hidden1").value) {
			alert("아이디가 틀렸습니다.");
		}
		if (document.getElementById("login_pw").value != document
				.getElementById("hidden2").value) {
			alert("비밀번호가 틀렸습니다.");
		}
	}
	function join_go() {
		location.href = "join.do";
	}
	function findidpw_go() {
		location.href = "findidpw.do";
	}
</script>
</head>
<body>
	<jsp:include page="../frame/header.jsp" />	
	
	<!-- 로그인창 -->
 <div class="wrapper">
        <div class="main">
            <div class="login_box">
                <div class="input_login">
                    <input type="text" name="m_id" placeholder="아이디을 입력하세요">
                </div>
                <div class="input_login">
                    <input type="password" name="m_pw" placeholder="비밀번호를 입력하세요">
                </div>
                <div class="check">
                    <label><input type="checkbox">로그인 유지</label>
                    <input type="hidden" >
                </div>
                <div class="login">
                    <input type="button" value="로그인" onclick="login_ok(this.form)">
                </div>
                <div class="last">
               	 	<input class="join" type="button" value="회원가입" onclick="join_go(this.form)">
                	<input class="search" type="button" value="ID/PW 찾기" onclick="findidpw_go(this.form)">
                    <!-- <div class="join"><a href="join_go(this.form)">회원가입</a></div>
                    	 <div class="search"><a href="findidpw_go(this.form)">ID/PW 찾기</a></div> 
                    -->
                </div>
            </div>
        </div>
    </div>

	<jsp:include page="../frame/footer.jsp" />
</body>
</html>