<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
      <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Login</title>

        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">

        <link rel="stylesheet" href="http://localhost:8080/admin_prj/template/css/fontAwesome.css">
        <link rel="stylesheet" href="http://localhost:8080/admin_prj/template/css/templatemo-style.css">
		<link rel="stylesheet" href="http://localhost:8080/admin_prj/common/css/main.css">
 
 <style type="text/css">
  style="font-family: 바탕;"
 </style>       
<script type="text/javascript">

	function join(){
		var obj=document.frm;
		var name=obj.name.value;
		var empno=obj.empno.value;
		var ad_id=obj.ad_id.value;
		
		if(name==""){
			alert("이름을 입력해주세요");
			obj.name.focus();
			return;
		}
		
		if(empno==""){
			alert("사원번호를 입력해주세요");
			obj.empno.focus();
			return;
		}
		
		if(ad_id==""){
			alert("아이디를 입력해주세요");
			obj.ad_id.focus();
			return;
		}
		
		obj.submit();
	}
</script>
</head>
<body>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<div style="background-image:url('http://localhost:8080/admin_prj/images/login_images2.jpg');background-size: cover;  padding-top: 100px;">
  <center >
     	<h3>사원의 관리자 아이디는 ' <strong><c:out value="${ requestScope.ad_id }"/></strong> '</h3><br/>
			<a href="start.do"><input type="button" style="height:25px; width: 60px;" value="Login"/></a>
			<a href="main/find_pass.jsp"><input type="button" style="height:25px; width: 90px;" value="비밀번호 찾기"/></a>
     <br>
     <br>
     <br>
     <br>
     <br>
  </center>

</body>
</html>