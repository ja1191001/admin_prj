<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

  <center>
     <form name="frm" action="login.do" method="post">
    <table border="0" width=200>
      <tr>
        <td width=30% align=right>ID</td>
        <td width=70% align=left>
          <input type=text name=id size=15>
        </td>
      </tr>
      
      <tr>
        <td width=30% align="right">Password</td>
        <td width=70% align="left">
          <input type="password" name="pass" size=15 onkeyup="enterLogin()"/>
        </td>
      </tr>
      
      <tr>
        <td align=right colspan=2>
          <input type="button" value="로그인" onclick="chkLogin()"/> 
         </td> 
      </tr>
    
    </table>
     </form>
     <a href="main/find_id.jsp">아이디 찾기</a>/
     <a href="main/find_pass.jsp">비밀번호 찾기</a>
  </center>

</body>
</html>