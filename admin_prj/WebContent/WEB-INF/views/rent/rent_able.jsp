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
	function checkNull(){
		var obj=document.frm;
		var start_date = obj.start_date.value;
		var end_date = obj.end_date.value;
		var type = obj.type.value;
		var fuel = obj.fuel.value;
		
		if(start_date=="" || end_date==""){
			alert("대여일과 반납일은 필수 선택사항입니다.");
			return;
		}else{ //대여일,반납일이 모두 존재하는경우
	        if(start_date>end_date){ //대여일<=반납일
	        	alert("반납일은 대여일 보다 빠를 수 없습니다. 날짜를 다시 선택해주세요.");
	        	return;
	        }
		}//end if
		
		location.href="rent_able.do?start_date="+start_date+"&end_date="+end_date+"&type="+type+"&fuel="+fuel;
	}//checkNull
	
	function detail(car_num, start_date, end_date){
		location.href="rent_detail.do?car_num="+car_num+"&start_date="+start_date+"&end_date="+end_date;
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
       <c:import url="${request.contextPath }/menu.do"/>
      </td>
      <td width=800 height=600 align=center valign=top>
      		<c:if test="${not empty param.start_date and not empty param.end_date}">
	<table>
		<c:if test="${ empty requestScope.rent_able }">
			<tr>
			<td colspan="4" style="text_align:center">렌트 가능한 차량이 없습니다.</td>
			</tr>
		</c:if>
		<tr>
		<c:set var="cnt" value="0"/>
		<c:forEach var="car" items="${ requestScope.rent_able }">
		<c:set var="cnt" value="${ cnt+1 }"/>
			<td onclick="detail('${ car.car_num }','${ car.start_date }','${ car.end_date }')" style="padding:7px">
				<img src="http://localhost:8080/admin_prj/images/${ car.images }" width="270" height="205"/><br/>
				모델명: <c:out value="${ car.car_name }" /><br/>
				년식: <c:out value="${ car.car_year }"/>년<br/>
				차종: <c:out value="${ car.type }"/><br/>
				연료: <c:out value="${ car.fuel }"/><br/>
				렌트비용: <c:out value="${ car.rental_fee }"/>원(1일 기준)<br/>
			</td>
			<c:if test="${ cnt ge 4 }">
				</tr>
				<tr>
				<c:set var="cnt" value="0"/>
			</c:if>
		</c:forEach>
		</tr>
	</table>
	</c:if>
	<form name="frm">
	<div>
	<br/>
	<br/>
		대여일 : <input type="text" id="start_date" name="start_date"/>
		반납일 : <input type="text" id="end_date" name="end_date"/><br/><br/>
		차종 : 
		<select id="type" name="type">
           <option value="">차종</option>
           <option value="소형">소형</option>
           <option value="경차">경차</option>
           <option value="중형">중형</option>
           <option value="SUV">SUV</option>
         </select>
        연료 : 
         <select id="fuel"  name="fuel">
           <option value="">연료</option>
           <option value="LPG">LPG</option>
           <option value="휘발유">휘발유</option>
           <option value="경유">경유</option>
		  </select>
		  <input type="button" class="btn" value="검색" onclick="checkNull()"/>
	</div>
	</form>
      </td>
    </tr>
    
  
  
  
  </table>
  
  </center>


    </body>
</html>