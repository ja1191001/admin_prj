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
<script type="text/javascript">
	
	function idSearch(){
		window.open("id_search.do", "id", "top="+(window.screenX+100)+", left="+(window.screenY+250)+", width=1175, height=600");
	}//idDup

	function resv(){
		var obj=document.frm;
		var licence_num=obj.licence_num.value;
		var id=obj.id.value;
		
		if(licence_num=="" || licence_num==null){
			alert("면허증번호는 필수 입력사항입니다.");
			return;
		}//end if
		
		if(id=="" || id==null){
			alert("어떤 사용자의 아이디로 등록하는지 결정하세요");
			return;
		}//end if
		
		obj.submit();
	}//resv
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
       <c:import url="${request.contextPath }/menu.jsp" />
      </td>
      <td width=800 height=600 align=center valign=top>
      		<form name="frm" action="rent_add.do">
	<table border="1">
		<c:if test="${ empty requestScope.rend_detail }">
		<tr>
			<td colspan="6">렌트 가능한 차량이 없습니다.</td>
		</tr>
		</c:if>
		
		<tr>
			<td colspan="6">차량정보</td>
		</tr>
		
		<tr>
			<td colspan="4" rowspan="5"><img src="http://localhost:8080/admin_prj/images/${ car_detail.images }" width="510"  height="326"/></td>
			<th>모델명</th>
			<td style="width:100px"><c:out value="${ car_detail.car_name }" /></td>
		</tr>
		
		<tr>
			<th>차량번호판</th>
			<td><c:out value="${ car_detail.assign_num }"/></td>
		</tr>
		
		<tr>
			<th>차종</th>
			<td><c:out value="${ car_detail.type }"/></td>     						
		</tr>
		
		<tr>
			<th>연료</th>
			<td><c:out value="${ car_detail.fuel }"/></td>        						
		</tr>
				
		<tr>
			<th>년식</th>
			<td><c:out value="${ car_detail.car_year }"/>년식</td>        						
		</tr>
		
		<tr>
			<th>옵션</th>
			<td colspan="5"><c:out value="${ car_detail.car_option }"/></td>
		</tr>
		
		<tr>
			<th>예약정보</th>
		</tr>
		
		<tr>
			<th>1일 비용</th>
			<td><c:out value="${ car_detail.rental_fee }"/>원</td>
			<th>대여기간</th>
			<td><c:out value="${ car_detail.duration+1 }"/>일</td>
			<th>대여일</th>
			<td><c:out value="${ car_detail.start_date }"/></td>
		</tr>
		
		<tr>
			<th>총 비용</th>
			<td colspan="3"><c:out value="${ car_detail.rental_fee * (car_detail.duration+1) }"/>원</td>      						
			<th>반납일</th>
			<td><c:out value="${ car_detail.end_date }"/></td>
		</tr>
		
		<tr>
			<th>면허증번호</th>
			<td>
				<input type="text" name="licence_num">
			</td>
			<th>예약자 아이디</th>
			<td>
				<input type="text" name="id" readonly="readonly" onclick="idSearch()">
			</td>
			<th>보험가입</th>
			<td>
				<select id="select_right_flag"  name="right_flag" >
					<option value="y">가입</option>
					<option value="n">미가입</option>
				</select>
			</td>				
		
		</tr>
		<tr>
		<td colspan="6">
		<input type="button" value="예약" onclick="resv()" />
		<input type="button" value="닫기" onclick="cancle()" />
		</td>
		</tr>	
	</table>
		<input type="hidden"  id="car_num" name="car_num" value="${ car_detail.car_num }"/>  	
		<input type="hidden"  id="start_date" name="start_date" value="${ car_detail.start_date }"/>
		<input type="hidden"  id="end_date" name="end_date" value="${ car_detail.end_date }"/>
	</form>
      </td>
    </tr>
    
  
  
  
  </table>
  
  </center>


    </body>
</html>