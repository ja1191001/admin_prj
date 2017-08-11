<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
      <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Find Pass Login</title>

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
     <form name="frm" method="post" action="../find_pass.do">
				<table border="0" style="width:300px;margin-left: auto; margin-right: auto;">
					<tr>
						<th colspan="3" align="center"><h3>비밀번호 찾기</h3></th>
					<tr>
					<tr>
						<th style="width:75px; padding-right:10; text-align: right"><label>이름 </label></th>
						<td style="width:140px; text-align:left"><input type="text" name="name" style="width:150px"></td>
						<td rowspan="3" valign="middle" style="text-align: center;"><input type="button" style="height:60px; width: 60px;" value="찾기"  onclick="join()"/></td>
					</tr>
					<tr>
						<th style=" padding-right:10; text-align: right"><label>사원번호 </label></th>
						<td style="text-align:left"><input type="text" name="empno" style="width:150px"></td>
					</tr>
					<tr>
						<th style=" padding-right:10; text-align: right"><label>아이디 </label></th>
						<td style="text-align:left"><input type="text" name="ad_id" style="width:150px"></td>
					</tr>
					<tr style="right: 10px">
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