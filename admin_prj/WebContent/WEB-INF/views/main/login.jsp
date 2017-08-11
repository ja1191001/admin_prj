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
   function chkLogin(){
      var obj=document.frm;
      var id=obj.id.value;
      var pass=obj.pass.value;
      
      if(id==""){
         alert("아이디를 입력해주세요");
         obj.id.focus();
         return;
      }
      
      if(pass==""){
         alert("비밀번호를 입력해주세요");
         obj.pass.focus();
         return;
      }
      
      obj.submit();
   }
   
   function enterLogin(){
      var obj=document.frm;
      var id=obj.id.value;
      var pass=obj.pass.value;
      
      if(event.keyCode==13){
         
         if(id==""){
            alert("아이디를 입력해주세요");
            obj.id.focus();
            return;
         }
         
         if(pass==""){
            alert("비밀번호를 입력해주세요");
            obj.pass.focus();
            return;
         }
         
         obj.submit();
      }
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
     <form name="frm" action="login.do" method="post">
    <table border="0" width=200>
      <tr>
        <th width=30% align=right>ID</th>
        
        <td width=70% align=left>
          <input type=text name=id size=15>
        </td>
        
        <td align="center" rowspan=2  valign="middle" style="text-align: center;" >
          <input type="button" style="height: 50px; width: 60px" value="로그인"   onclick="chkLogin()"/> 
         </td> 
      </tr>
      
      <tr>
      
        <th width=30% align="right">Password</th>
       
        <td width=70% align="left">
          <input type="password" name="pass" size=15 onkeyup="enterLogin()"/>
        </td>

      </tr>
      
    
    </table>
     </form>
     <a href="main/find_id.jsp" >아이디 찾기</a>/
     <a href="main/find_pass.jsp">비밀번호 찾기</a>
     <br>
     <br>
     <br>
     <br>
     <br>
  </center>
</div>
</body>
</html>