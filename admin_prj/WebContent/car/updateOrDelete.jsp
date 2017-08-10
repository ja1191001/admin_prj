<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main.css"/>

<script type="text/javascript">
	//////////차량 수정/////////
	function car_update(car_num){
		location.href="../car_update.do?car_num="+car_num;
	}
	
	//////////차량 삭제/////////
	function car_delete(car_num){
		location.href="../car_delete.do?car_num="+car_num;
	}
	
	function cancle(){
		window.close();
	}
	
</script>

</head>
<body>
	<c:set var="car_num" value="${ param.car_num }"/>
		<table border="1" style="text-align: center; width: 400px" >
			<tr>
				<td colspan="2" style="background-color: #FFBB05"><c:out value="${ param.car_num }"/>의 차량</td>
			</tr>
			<tr>
				<th>정보 수정</th>
				<th>정보 삭제</th>
			</tr>
			<tr>
				<td>
					<input type="button" value="수정" class="btn" onclick="car_update('${ param.car_num }')"/>
				</td>
				<td>
					<input type="button" value="삭제" class="btn" onclick="car_delete('${ param.car_num }')"/>
				</td>
			</tr>	
		</table>
		<input type="button" value="닫기" class="btn" onclick="cancle()"/>
</body>
</html>