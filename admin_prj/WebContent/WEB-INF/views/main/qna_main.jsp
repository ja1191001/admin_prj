
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
   background-color: #FFBB05;
   border-bottom: 1px solid #E7E7E7;
   height: 37px
}

 	.numTitle{ width: 60px; text-align: center;  }
 	.subjectTitle{ width: 300px; text-align: center; }
 	.writerTitle{ width: 100px; text-align: center; }
 	.dateTitle{ width: 120px; text-align: center; }
 	.answerTitle{ width: 80px;}
 	
/* text-align : 글자 정렬  left,center,right  */
td {
   border-bottom: 1px solid #E7E7E7;
   height: 28px;
   text-align: center;
}
.mouse:HOVER { background-color: #EAE9F7 }		
</style>
<script type="text/javascript">
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
       <c:import url="${request.contextPath }/menu.do"/>
      </td>
      <td width=800 height=600 align=center valign=top>
		 <c:if test="${empty requestScope.qnaList }">
				<strong>등록된 질문이 없습니다.</strong>
			</c:if>
			<p>
			    <form> 
					<table class="tab" style="margin: auto" >
					<thead>
					<tr >
					
						<th class="numTitle">번호</th>
						<th class="subjectTitle">Q&A</th>
						<th class="writerTitle">작성자</th>
						<th class="dateTitle">등록일</th>
						<th class="answerTitle">답변여부</th>
					</tr>
					</thead>
					<tbody>
					

					<c:forEach var="qna" items="${requestScope.qnaList }">
					<tr class="mouse">
					
						<td><c:out value="${qna.rnum }"/></td> 
							
							
	
							<td><a href="qna/qna_view.do?qnum=${qna.qnum}"><c:out value="${qna.title }"/></a></td>
							<td><c:out value="${qna.id }"/></td>
							<td><c:out value="${qna.hiredate }"/></td>
							<c:set var="flag" value="${qna.answer_flag }"/>
							
<%-- 							<c:if test="${flag eq 'y' }">
							<td><img src="images/answerflag.png"/></td>
							</c:if> --%>
							<c:choose>
								<c:when test="${flag eq 'y' }">
								<td><img src="images/answerflag.png"/></td>
								</c:when>
								<c:otherwise>
								<td></td>
								</c:otherwise>
							</c:choose>
							
							<%-- http://localhost:8080/admin_prj/WEB-INF/views/qna/qna_view.jsp?qnum=${qna.qnum } --%>
					</tr>
					</c:forEach>
					</tbody>
				
					</table>
					<div align="center">
					<c:if test="${ not empty requestScope.qnaPage }">
						<c:if test="${requestScope.qnaPage.currentPage !=1 }">
							<a href="qna_main.do?currentPage=${qnaPage.currentPage-1 }&columnName=${ columnName}&keyword=${ keyword}" ><img alt="이전 페이지" src="http://localhost:8080/admin_prj/images/btn_prev.png" title="이전 페이지"></a>
						</c:if>
						<c:choose>
						<c:when test="${ empty param.columnName }">
						
						<c:forEach var="i" begin="${requestScope.qnaPage.firstPage }" end="${ requestScope.qnaPage.lastPage }" step="1">
						[ <a href="qna_main.do?currentPage=${ i }">${ i }</a> ]
						</c:forEach> 
						
						</c:when>
						<c:otherwise>
						<c:forEach var="i" begin="${requestScope.qnaPage.firstPage }" end="${ requestScope.qnaPage.lastPage }" step="1">
						[ <a href="qna_main.do?currentPage=${ i }&columnName=${ param.columnName}&keyword=${ param.keyword}" >${ i }</a> ]
						</c:forEach>
						
						</c:otherwise>
						</c:choose>
						<c:if test="${requestScope.qnaPage.currentPage  != requestScope.qnaPage.lastPage }">
							<a href="qna_main.do?currentPage=${qnaPage.currentPage+1 }&columnName=${ columnName}&keyword=${ keyword}" onclick="chkValue()" ><img alt="다음 페이지" src="http://localhost:8080/admin_prj/images/btn_next.png" title="다음 페이지"></a>
						</c:if>
					</c:if>
					</div>
	</form>
		<form action="qna_main.do" method="get" name="searchFrm">
			<select name="columnName">
				<option value="title">제목</option>
				<option value="content">내용</option>
				<option value="id">작성자</option>
			</select>
			<input type="text" name="keyword" class="inputBox" value=""/>
			<input type="button" value="검색" class="btn" onclick="chkNull('columnName','keyword')" />
		</form>
     
      </td>
    </tr>
    
  
  
  
  </table>
  
  </center>

    </body>
</html>						
						
						