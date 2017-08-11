<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Hyerim 11RentCar</title>

        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">

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

tr:HOVER {background-color: #EAE9F7}
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
        <c:import url="${request.contextPath }/menu.do"/>
      </td>
      <td width=800 height=600 align=center valign=top>
	여기에 메뉴를 뿌린다
	<div id="notice" style="width:750px; min-height:700px;top:100px;'margin:0px auto">
	<table class="tab" style="margin: 0px auto;" >
		<colgroup>
			<col width="10%"/>
			<col width="*"/>
			<col width="15%"/>
			<col width="20%"/>
		</colgroup>
	<thead>
	<tr>
		<th class="numTitle" scope="col">번호</th>
		<th class="subjectTitle" scope="col"	>제목</th>
		<th class="writerTitle" scope="col">작성자</th>
		<th class="dateTitle" scope="col">작성일</th>
	</tr>
	</thead>
	<tbody>
	<c:choose>
		<c:when test="${empty requestScope.noticeList }">
			<tr><td colspan="4" align="center">작성된 글이 없습니다.</td></tr>
		</c:when>
		<c:otherwise>
			<c:forEach var="notice" items="${requestScope.noticeList }">
			<tr>
				<td>
					<c:out value="${notice.num }"/>
					<input type="hidden" value="${requestScope.notice.notice_num }" name="noticeNum"> 
					<input type="hidden" value="${requestScope.notice_cnt.num }" name="maxNum"> 
				</td>
				<td align="left"> <a href="notice/read_notice_detail.do?currentPage=${noticePage.currentPage }&num=${ notice.num }&maxNum=${requestScope.notice_cnt.num }&columnName=${ param.columnName}&keyword=${ param.keyword}" ><c:out value="${notice.title }"/></a></td>
				<td>관리자</td>
				<td><c:out value="${notice.hiredate }"/></td>
			</tr>	
			</c:forEach>
		</c:otherwise>
	</c:choose>
	</tbody>
	</table>
	<div align="right">
	<a href="notice/notice_write.do" ><input type="button" value="글쓰기" class="btn" /></a>
	</div>
	<br/>
	<form action="notice_main.do" method="get" name="movePage">	
<div align="center">
<c:if test="${ not empty requestScope.noticePage }">
	<c:if test="${requestScope.noticePage.currentPage !=1 }">
		<a href="notice_main.do?currentPage=${noticePage.currentPage-1 }&columnName=${ param.columnName}&keyword=${ param.keyword}" ><img alt="이전 페이지" src="http://localhost:8080/car_prj/images/btn_prev.png" title="이전 페이지"></a>
	</c:if>
	<c:choose>
	<c:when test="${ empty param.columnName }">
	
	<c:forEach var="i" begin="${requestScope.noticePage.firstPage }" end="${ requestScope.noticePage.lastPage }" step="1">
	[ <a href="notice_main.do?currentPage=${ i }">${ i }</a> ]
	</c:forEach> 
	
	</c:when>
	<c:otherwise>
	<c:forEach var="i" begin="${requestScope.noticePage.firstPage }" end="${ requestScope.noticePage.lastPage }" step="1">
	[ <a href="notice_main.do?currentPage=${ i }&columnName=${ param.columnName}&keyword=${ param.keyword}" >${ i }</a> ]
	</c:forEach>
	
	</c:otherwise>
	</c:choose>
	<c:if test="${requestScope.noticePage.currentPage  != requestScope.noticePage.totalPage }">
		<a href="notice_main.do?currentPage=${noticePage.currentPage+1 }&columnName=${ columnName}&keyword=${ keyword}" onclick="chkValue()" ><img alt="다음 페이지" src="http://localhost:8080/car_prj/images/btn_next.png" title="다음 페이지"></a>
	</c:if>
</c:if>
</div>	
</form>
	<div style="text-align: center; min-height: 100px;" >
	<form action="notice_main.do" method="get" name="searchFrm">
		<select name="columnName">
			<option value="title">제목</option>
			<option value="content">내용</option>
		</select>
		<input type="text" name="keyword" class="inputBox" value=""/>
		<input type="button" value="검색" class="btn" onclick="chkNull('columnName','keyword')" />
		
	</form>

	</div>
	</div>
        

      </td>
    </tr>
    
  
  
  
  </table>
  
  </center>
</body>
</html>