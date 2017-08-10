
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Newline CSS Template with a video background</title>

        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">

       <link rel="stylesheet" href="http://localhost:8080/admin_prj/template/css/bootstrap.css">
        <link rel="stylesheet" href="http://localhost:8080/admin_prj/template/css/bootstrap.min.css">
        <link rel="stylesheet" href="http://localhost:8080/admin_prj/template/css/bootstrap-theme.css">
        <link rel="stylesheet" href="http://localhost:8080/admin_prj/template/css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="http://localhost:8080/admin_prj/template/css/fontAwesome.css">
        <link rel="stylesheet" href="http://localhost:8080/admin_prj/template/css/templatemo-style.css">
		<link rel="stylesheet" href="http://localhost:8080/admin_prj/common/css/main.css">
        
        <style type="text/css">
	#agr_wrap{margin:0px auto;width:650px; height:600px}
	#agr_header{text-align:center}
	#agr_footer{text-align:center;margin-top:30px}
 	.ag_1{ border:1px solid #333; width:650px; min-height: 250px; overflow: auto;}
   	#wrap{width:700px; min-height:100px; margin:0px auto}
   	#header{wedth:700px; height: 100px; position: relative; 
   	background: #FFBFBF 
   	url(http://localhost:8080/admin_prj/common/images/header_background.png) no-repeat;}
   	#logo{position: absolute; top:20px;left:50px}
   	#content{width: 700px; min-height: 100px; position: relative;}
   	#footer{width:700px; height:100px;}
   	#footer_text{width:500px;height:80px; padding-top:20px;float:right; padding-right: 10px}
   	.btn{
   	height: 25px
   	}
   	.tab {
   border-top: 3px solid #404040;
   border-spacing: 0px
}

th {
	text-align: center;
   font-weight: normal;
   background-color: #FAFAFA;
   border-bottom: 1px solid #E7E7E7;
   height: 37px
}

.numTitle {width: 60px}
.subjectTitle {width: 300px}
.writerTitle {width: 100px}
.evtTitle {width: 120px}
.dateTitle {width: 120px}
.fileTitle {width: 80px}
/* text-align : 글자 정렬  left,center,right  */
td {
   border-bottom: 1px solid #E7E7E7;
   height: 28px;
   text-align: center;
}

</style>
    </head>
    <body>

         <center>
  
  <table border=1 bordercolor=black cellpadding=0 cellspacing="0" width="1000" height="750">

    <tr>
      <td colspan=2 width=100% height=150>
        <img src="http://localhost:8080/admin_prj/template/img/prove-bg.png" width=1000 height=150>
      </td>
      
    </tr>
    
    <tr>
      <td width=200 height=600 align=center valign=top>
        <%@ include file="../main/menu.jsp" %>
      </td>
      <td width=800 height=600 align=center valign=top>
	회원탈퇴가 완료되었습니다!
	<a href="http://localhost:8080/admin_prj/member_main.do"><input type=button value="메인으로가기"></a>
	<br>
	<br>
     
      </td>
    </tr>
    
  
  
  
  </table>
  
  </center>


    </body>
</html>						
						
						