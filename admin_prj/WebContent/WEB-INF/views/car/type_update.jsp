<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>차종 수정</title>
<style type="text/css">
	th{ background-color:#FFBB05 }
	tr:HOVER { background-color: #EAE9F7 }   
</style>
<script type="text/javascript">
	function cancle(){
		window.close();
	}//cancle
	
	function updateProcess(car_name,type,fuel,rental_fee,car_option,cc){
		location.href="type_update_process.do?car_name="+car_name+"&type="+type+"&fuel="+fuel+"&rental_fee="+rental_fee+"&car_option="+car_option+"&cc="+cc;
	}//click
	
</script>
</head>
<body>
 	<strong>▶차종리스트◀</strong><br/>
 	수정하고 싶은 차량의 정보를 클릭하세요.<br/><br/>
		<table  border="1" style="width:700px; ">
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
	<div align="center">
	<input type="button" value="닫기" class="btn" onclick="cancle()"/>
	</div>
</body>
</html>