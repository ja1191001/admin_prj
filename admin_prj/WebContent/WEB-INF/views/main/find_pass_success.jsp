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
	function chkPass(){
		var obj=document.frm;
		var pass=obj.pass.value;
		var passChk=obj.passChk.value;
		
		if(passChk!=pass){
			alert("비밀번호를 다시 확인해주세요");
			obj.pass.value="";
			obj.passChk.value="";
			obj.pass.focus();
		}//end if
	
	}//passChk
	
	function change(){
		var obj=document.frm;
		var pass=obj.pass.value;
		var passChk=obj.passChk.value;
		
		if(pass==""){
			alert("비밀번호를 입력해주세요");
			obj.pass.focus();
			return;
		}
		
		if(passChk==""){
			alert("비밀번호를 확인해주세요");
			obj.passChk.focus();
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
  	<form name="frm" action="change_pass.do" method="post">
			<h3>비밀번호를 변경해주세요</h3>
			<table border="0" style="margin-left: auto; margin-right: auto;">
               	<tr>
					<th style="text-align: right; padding-right: 5px"><label>비밀번호 </label></th>
					<td style="text-align:left; "><input type="password" name="pass" style="width:120px"></td>
				</tr>
				<tr>
					<th style="text-align: right; padding-right: 5px"><label>비밀번호 확인 </label></th>
					<td style="text-align:left;"><input type="password" name="passChk" style="width:120px" onchange="chkPass()"></td>
				</tr>
			</table>
			<input type="hidden" name="ad_id" value="${ requestScope.ad_id }"/>
			 <input type="button" style="width: 40px; height: 25px;"  value="변경" onclick="change()"/>
			</form>
<br>
     <br>
     <br>
     <br>
     <br>
  </center>

</body>
</html>