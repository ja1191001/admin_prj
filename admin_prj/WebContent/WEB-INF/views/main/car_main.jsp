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
	th{ background-color:#FFBB05 }
/* 	tr:HOVER { background-color: #EAE9F7 }    */
</style>
</style>

<script type="text/javascript">
	//////////차종 추가/////////
	function type_insert(){
		/* location.href="car/type_insert.jsp"; */
		window.open("car/type_insert.jsp","차종추가","width=600 height=500");
	}
	//////////차종 수정/////////
	function updateProcess(car_name,type,fuel,rental_fee,car_option,cc){
		window.open("type_update_process.do?car_name="+car_name+"&type="+type+"&fuel="+fuel+"&rental_fee="+rental_fee+"&car_option="+car_option+"&cc="+cc,"차종정보 수정","width=600 height=350");
	}//click
	
	//////////차량 추가/////////
	function car_insert(){
		/* location.href="car_insert.do"; */
		window.open("car_insert.do","차량추가","width=600 height=350");
	}
	
	///////////////차량 수정/////////////////
	function openPopCar(car_num){
   		//alert("openPopUp()함수 탔습니다. 이제 reserv_detail.do를 호출합니다 ");
		window.open("car/updateOrDelete.jsp?car_num="+car_num,"차량정보 수정 또는 삭제","width=600 height=350");
   	}//detailRsvInfo
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
		     <strong>▶차종 목록◀</strong><br/>
 	수정하고 싶은 차종의 정보를 클릭하세요.
		<table  border="1" style="width:700px;  margin: 0px auto;">
		<c:if test="${ empty requestScope.listType }">
			<td colspan="4">등록된 차량이 없습니다.</td>
		</c:if>
			<tr>
				<th>번호</th>
				<th>차량명</th>
				<th>차종</th>
				<th>연료</th>
				<th>1일 렌트비용</th>
				<th>옵션</th>
				<th>배기량</th>
			</tr>
		<c:set var="i" value="1"/>
		<c:forEach var="carType" items="${ requestScope.listType }">
			<tr onclick="updateProcess('${ carType.car_name }','${ carType.type }','${ carType.fuel }','${ carType.rental_fee }','${ carType.car_option }','${ carType.cc }')" style="padding:7px">
						<td><c:out value="${ i }"/></td>
						<td><c:out value="${ carType.car_name }"/></td>
						<td><c:out value="${ carType.type }" /></td>
						<td><c:out value="${ carType.fuel }"/></td>
						<td><c:out value="${ carType.rental_fee }"/>원</td>
						<td><c:out value="${ carType.car_option }"/></td>
						<td><c:out value="${ carType.cc }"/>cc</td>
			</tr>
			<c:set var="i" value="${ i+1 }"/>
		</c:forEach>
	</table>
	<br/>
<br/><br/>

	<strong>▶차량 목록◀</strong><br/>
	수정하고 싶은 차량의 정보를 클릭하세요.
	<table  border="1" style="width:500px; margin: 0px auto; ">
		<c:if test="${ empty requestScope.list }">
			<td colspan="4">등록된 차량이 없습니다.</td>
		</c:if>
			<tr>
				<th>번호</th>
				<th>차량번호</th>
				<th>모델명</th>
				<th>차량번호판</th>
				<th>년식</th>
				<th>사용여부</th>
			</tr>
		<c:set var="i" value="1"/>
		<c:forEach var="car" items="${ requestScope.list }">
			<tr onclick="openPopCar('${ car.car_num }')" style="padding:7px">
						<td><c:out value="${ i }"/></td>
						<td><c:out value="${ car.car_num }"/></td>
						<td><c:out value="${ car.car_name }" /></td>
						<td><c:out value="${ car.assign_num }"/></td>
						<td><c:out value="${ car.car_year }"/>년</td>
						<td><c:out value="${ car.able_flag }"/></td>
			</tr>
			<c:set var="i" value="${ i+1 }"/>
		</c:forEach>
	</table>
	
	<br/><br/>
	
	<strong>▶차종/차량 추가◀</strong><br/>
	<table border="1" style="text-align: center; width: 300px; margin: 0px auto;" >
		<tr>
			<th>차종</th>
			<th>차량</th>
		</tr>
		<tr>
			<td>
				<input type="button" value="추가"  style="width: 100px" class="btn" onclick="type_insert()"/>
			</td>
			<td>
				<input type="button" value="추가" style="width: 100px" class="btn" onclick="car_insert()"/>
			</td>
		</tr>	
	</table>
		      </td>
		    </tr>
		    
		  
		  
		  
		  </table>
		  
  </center>

    </body>
</html>