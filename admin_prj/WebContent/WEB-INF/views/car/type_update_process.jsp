<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
 	//////////차종 수정/////////
	function checkNull(){
		var obj=document.frm;
		var type=obj.type.value;
		var fuel=obj.fuel.value;
		var car_option=obj.car_option.value;
		var rental_fee=obj.rental_fee.value;
		var cc=obj.cc.value;
		if(type="" || fuel=="" || car_option=="" || rental_fee=="" || cc==""){
			alert("모든 정보는 필수입력사항입니다.");
			return;
		}//end if
		obj.submit();
	}//checkNull
	
	function back(){
		location.href=history.back();
	}//cancle 
</script>

</head>
<body>
     <strong>▶차종 수정◀</strong><br/>
 	아래에 정보를 수정하여 차종의 정보를 변경하세요.
<form action="type_update_success.do" name="frm" >
     		<table border="1" style="width:500px; height:150px;" >
                        		<tr>
                       				<td style="background-color:#FFBB05">차량명</td>
									<td><c:out value="${ ctd.car_name }"/></td>
								</tr>
								<tr>
                       				<td style="background-color:#FFBB05">차종</td>
									<td>
									<select id="type"  name="type" >
											<c:if test="${ ctd.type =='소형' }">
						                         <option value="소형">소형</option>
						                         <option value="경차">경차</option>
						                         <option value="중형">중형</option>
						                         <option value="SUV">SUV</option>
					                         </c:if>
					                       	<c:if test="${ ctd.type =='경차' }">
						                         <option value="경차">경차</option>
						                         <option value="소형">소형</option>
						                         <option value="중형">중형</option>
						                         <option value="SUV">SUV</option>
					                         </c:if>
			                         		<c:if test="${ ctd.type =='중형' }">
						                         <option value="중형">중형</option>
						                         <option value="소형">소형</option>
						                         <option value="경차">경차</option>
						                         <option value="SUV">SUV</option>
					                         </c:if>
					                         <c:if test="${ ctd.type =='SUV' }">
						                         <option value="SUV">SUV</option>
						                         <option value="소형">소형</option>
						                         <option value="경차">경차</option>
						                         <option value="중형">중형</option>
					                         </c:if> 
										</select>
									</td>
								</tr>
								<tr>
									<td style="background-color:#FFBB05">연료</td>
									<td>
										<select id="fuel"  name="fuel" >
											<c:if test="${ ctd.fuel =='LPG' }">
						                         <option value="LPG">LPG</option>
						                         <option value="휘발유">휘발유</option>
						                         <option value="경유">경유</option>
					                         </c:if>
					                       	<c:if test="${ ctd.fuel =='휘발유' }">
						                         <option value="휘발유">휘발유</option>
						                         <option value="LPG">LPG</option>
						                         <option value="경유">경유</option>
					                         </c:if>
					                         <c:if test="${ ctd.fuel =='경유' }">
						                         <option value="경유">경유</option>
						                          <option value="LPG">LPG</option>
						                         <option value="휘발유">휘발유</option>
						                     </c:if>    
										</select>
									</td>
								</tr>
								<tr>
									<td style="background-color:#FFBB05">1일 렌트비용</td>
									<td><input type="text" name="rental_fee" value="${ ctd.rental_fee }"></td>
								</tr>
								<tr>
									<td style="background-color:#FFBB05">배기량</td>
									<td><input type="text" name="cc" value="${ ctd.cc }"></td>
								</tr>
								<tr>
									<td style="background-color:#FFBB05">옵션</td>
									<td>
										<textarea id="car_option" name="car_option" rows="5" style="width:100%;" ><c:out value="${ ctd.car_option}"/></textarea>
									</td>
								</tr>
				</table>
					<input type="hidden"  name="car_name1" value="${ param.car_name }">  	
					<input type="hidden"  name="type1" value="${ param.type }">  	
					<input type="hidden"  name="fuel1" value="${ param.fuel }">  	
					<input type="hidden"  name="rental_fee1" value="${ param.rental_fee }">  	
					<input type="hidden"  name="cc1" value="${ param.cc }">
		</form>
		<br/>
		<input type="button" value="수정완료" class="btn" onclick="checkNull()"/>
		<input type="button" value="뒤로" class="btn" onclick="back()"/> 

</body>
</html>