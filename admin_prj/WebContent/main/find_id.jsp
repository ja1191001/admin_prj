<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
      <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Find Login</title>

        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">

        <link rel="stylesheet" href="http://localhost:8080/admin_prj/template/css/fontAwesome.css">
        <link rel="stylesheet" href="http://localhost:8080/admin_prj/template/css/templatemo-style.css">
		<link rel="stylesheet" href="http://localhost:8080/admin_prj/common/css/main.css">
 
 <style type="text/css">
  style="font-family: 바탕;"
  
  .btn{
  color: #F0F0F0;
  }
 </style>       
<script type="text/javascript">

	function join(){
		var obj=document.frm;
		var name=obj.name.value;
		var empno=obj.empno.value;
		
		if(name==""){
			alert("이름을 입력해주세요");
			obj.name.focus();
			return;
		}
		
		if(empno==""){
			alert("이메일을 입력해주세요");
			obj.empno.focus();
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
     <form name="frm" method="post" action="../find_id.do">
		<table style="width:300px;margin-left: auto; margin-right: auto;">
			<tr>
				<th colspan="3" align="center"><h3>아이디 찾기</h3></th>
			<tr>
			<tr>
				<th style="width:150px;text-align: right"><label>이름 </label></th>
				<td style="width:150px;text-align:left"><input type="text" name="name" style="width:120px" onchange="chkPass()"></td>
				<td rowspan="2" valign="middle" ><input type="button" style="height: 50px; width:60px;" value="찾기"onclick="join()"/></td>
			</tr>
			<tr>
				<th style="text-align: right"><label>사원번호 </label></th>
				<td style="text-align:left"><input type="text" name="empno" style="width:120px" onchange="chkPass()"></td>
			</tr>
			<tr style="padding:10px">
			</tr>
		</table>
		<a href="../start.do" >로그인 화면으로 돌아가기</a>
	</form>
     <br>
     <br>
     <br>
     <br>
     <br>
  </center>

</body>
</html>