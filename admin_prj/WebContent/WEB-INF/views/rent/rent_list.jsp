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

tr:HOVER {background-color: #EAE9F7}
</style>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
  $( function() {
    $( "#start_date" ).datepicker({
    	dateFormat:"yy-mm-dd"
    });

    $( "#end_date" ).datepicker({
    	dateFormat:"yy-mm-dd"
    });
  } );
</script>
<script type="text/javascript">
	function search(){
		var obj=document.frm;
		var start_date = obj.start_date.value;
		var end_date = obj.end_date.value;
		var id=obj.id.value;
		
		if(start_date!=""&&end_date!=""){
			if(start_date>end_date){ //대여일<=반납일
	        	alert("반납일은 대여일 보다 빠를 수 없습니다. 날짜를 다시 선택해주세요.");
	        	return;
			}
		}
		
		location.href="rent_list.do?start_date="+start_date+"&end_date="+end_date+"&id="+id;
	}
	
	function rentCancel(resev_num){
		if(confirm("정말 예약을 취소하시겠습니까?")){
			location.href="remove_rent.do?resev_num="+resev_num;
		}
	}
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
        <%@ include file="../main/menu.jsp" %>
      </td>
      <td width=800 height=600 align=center valign=top>
      		<h4>예약관리</h4>
	<table class="tab" style="margin:0px auto">
		<thead>
			<tr>
				<th>번호</th>
				<th>차량코드</th>
				<th>예약자</th>
				<th>대여일</th>
				<th>반납일</th>
				<th>면허증번호</th>
				<th>보험여부</th>
				<th>예약취소</th>
			</tr>
		</thead>
		<tbody>
		<c:choose>
			<c:when test="${ empty requestScope.rentList }">
				<tr>
					<td colspan="8">렌트 예약이 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="rent" items="${ requestScope.rentList }">
				<tr>
					<td><c:out value="${ rent.num }"/></td>
					<td><c:out value="${ rent.car_num }"/></td>
					<td><c:out value="${ rent.id }"/></td>
					<td><c:out value="${ rent.start_date }"/></td>
					<td><c:out value="${ rent.end_date }"/></td>
					<td><c:out value="${ rent.licence_num }"/></td>
					<td><c:out value="${ rent.right_flag }"/></td>
					<td><input type="button" name="cancel" value="예약취소" onclick="rentCancel('${rent.resev_num}')"/></td>
				</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		</tbody>
	</table>
	<br/>
	<div align="center">
		<c:if test="${ not empty requestScope.rent_page }">
			<c:if test="${ requestScope.rent_page.currentPage ne 1 }">
				<a href="rent_list.do?currentPage=${rent_page.currentPage-1}">
					<img src="../images/btn_prev.png"/>
				</a>
			</c:if>
			
			<c:forEach var="i" begin="${requestScope.rent_page.firstPage }" end="${ requestScope.rent_page.lastPage }" step="1">
				[ <a href="rent_list.do?currentPage=${ i }">${ i }</a> ]
			</c:forEach> 
			
			<c:if test="${requestScope.rent_page.currentPage  ne requestScope.rent_page.lastPage }">
				<a href="rent_list.do?currentPage=${rent_page.currentPage+1 }" >
					<img src="../images/btn_next.png"/>
				</a>
			</c:if>
		</c:if>
	</div>
	<form name="frm">
	<div style="text-align:center;min-height:100px">
		대여일 : <input type="text" id="start_date" name="start_date"/>
		반납일 : <input type="text" id="end_date" name="end_date"/><br/>
		예약자 아이디 : <input type="text" name="id"/>	
		<input type="button" value="찾기" onclick="search()"/>	
		<a href="rent_able.do"><input type="button" value="예약추가"/></a>	
	</div>
	</form>
      </td>
    </tr>
    
  
  
  
  </table>
  
  </center>


    </body>
</html>