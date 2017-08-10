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
 	.numTitle{ width: 50px; text-align: center;  }
 	.idTitle{ width: 100px; text-align: center; }
 	.nameTitle{ width: 80px; text-align: center; }
 	.genderTitle{ width: 30px; text-align: center; }
 	.emailTitle{ width: 150px;text-align: center;}
 	.phoneTitle{ width: 100px;text-align: center;}
 	.hiredateTitle{ width: 120px;text-align: center;}
 	.flagTitle{ width: 80px;text-align: center;}
 	.flagTitle{ width: 80px;text-align: center;}
/* text-align : 글자 정렬  left,center,right  */
td {
   border-bottom: 1px solid #E7E7E7;
   height: 28px;
   text-align: center;
}
.mouse:HOVER { background-color: #EAE9F7 }		

</style>
<script type="text/javascript">
function del(id){
	var obj = document.frm;
	  if (confirm("정말로 탈퇴시키시겠습니까?")){ 
		  location.href="member_update.do?id="+id;
	  }
}
function chkValue(){
	var obj=document.movePage;
	
	obj.submit();
}//chkValue

function chkNull(){
	var obj=document.searchFrm;

	obj.submit();
}//chkNull
	
</script>
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
        <%@ include file="menu.jsp" %>
      </td>
      <td width=800 height=600 align=center valign=top>
               <c:if test="${empty requestScope.memberList }">
				<strong>등록된 회원이 없습니다.</strong>
			</c:if> 
			<p>
				<form >
					<table class="tab" style="margin: auto" >
					<thead>
					<tr>
					
						<th class="numTitle">번호</th>
						<th class="idTitle">아이디</th>
						<th class="nameTitle">이름</th>
						<th class="genderTitle">성별</th>
						<th class="emailTitle">이메일</th>
						<th class="phoneTitle">핸드폰번호</th>
						<th class="hiredateTitle">가입일</th>
						<th class="flagTitle">탈퇴여부</th>
						<th class="buttonTitle">강제탈퇴</th>
					</tr>
					</thead>
					<tbody>
					

				<c:forEach var="member" items="${requestScope.memberList }"> 
					<tr class="mouse">
						
						<td><c:out value="${member.rnum }"/></td> 
						<td><c:out value="${member.id }"/></td>
						<td><c:out value="${member.name }"/></td>
						<td><c:out value="${member.gender }"/></td>
						<td><c:out value="${member.email }"/></td>
						<td><c:out value="${member.phone }"/></td>
						<td><c:out value="${member.hiredate }"/></td>
						<td><c:out value="${member.drop_flag }"/></td>
						<td><input type=button value="탈퇴" onclick="del('${member.id}')"></td>

					</tr>
		</c:forEach> 
					</tbody>
				
					</table>
					
				<div align="center">
					<c:if test="${ not empty requestScope.memberPage }">
						<c:if test="${requestScope.memberPage.currentPage !=1 }">
							<a href="member_main.do?currentPage=${memberPage.currentPage-1 }&columnName=${ columnName}&keyword=${ keyword}" ><img alt="이전 페이지" src="http://localhost:8080/admin_prj/images/btn_prev.png" title="이전 페이지"></a>
						</c:if>
						<c:choose>
						<c:when test="${ empty param.columnName }">
						
						<c:forEach var="i" begin="${requestScope.memberPage.firstPage }" end="${ requestScope.memberPage.lastPage }" step="1">
						[ <a href="member_main.do?currentPage=${ i }">${ i }</a> ]
						</c:forEach> 
						
						</c:when>
						<c:otherwise>
						<c:forEach var="i" begin="${requestScope.memberPage.firstPage }" end="${ requestScope.memberPage.lastPage }" step="1">
						[ <a href="member_main.do?currentPage=${ i }&columnName=${ param.columnName}&keyword=${ param.keyword}" >${ i }</a> ]
						</c:forEach>
						
						</c:otherwise>
						</c:choose>
						<c:if test="${requestScope.memberPage.currentPage  != requestScope.memberPage.lastPage }">
							<a href="member_main.do?currentPage=${memberPage.currentPage+1 }&columnName=${ columnName}&keyword=${ keyword}" onclick="chkValue()" ><img alt="다음 페이지" src="http://localhost:8080/admin_prj/images/btn_next.png" title="다음 페이지"></a>
						</c:if>
					</c:if>
					</div>
	</form>
			<form action="member_main.do" method="get" name="searchFrm">
			<select name="columnName">
				<option value="id">아이디</option>
				<option value="drop_flag">탈퇴여부</option>
			</select>
			<input type="text" name="keyword" class="inputBox" value=""/>
			<input type="button" value="검색" class="btn" onclick="chkNull('columnName','keyword')" />
		</form>
	<br>
	<br>
     
      </td>
    </tr>
    
  
  
  
  </table>
  
  </center>


        <footer>
          <p>Copyright &copy; 2017 Your Company 
                                
           | Designed by <a href="http://www.templatemo.com" target="_parent"><em>templatemo</em></a></p>
        </footer>
    
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.2.min.js"><\/script>')</script>

        <script src="js/vendor/bootstrap.min.js"></script>
        <script src="js/plugins.js"></script>
        <script src="js/main.js"></script>

    </body>
</html>