<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//////////차량 수정/////////
	function checkNull(){
		var obj=document.frm;
		var assign_num=obj.assign_num.value;
		var car_year=obj.car_year.value;
		var images=obj.images.value;
		var able_flag=obj.able_flag.value;
		
		if(assign_num="" || car_year=="" || images=="" || able_flag==""){
			alert("모든 정보는 필수입력사항입니다.");
			return;
		}//end if
		obj.submit();
	}//checkNull
	
	function cancle(){
		window.close();
	}//cancle
</script>

</head>
<body>
car_update.jsp입니다.
	<form action="car_update_success.do" name="frm" enctype="multipart/form-data">
     		<table border="1" style="width:500px; height:150px;" >
                        		<tr>
                       				<td style="background-color:#FFBB05">차량번호</td>
									<td><c:out value="${ cud.car_num }"/></td>
								</tr>
								<tr>
                       				<td style="background-color:#FFBB05">차량명</td>
									<td><c:out value="${ cud.car_name }"/></td>
								</tr>
								<tr>
									<td style="background-color:#FFBB05">차량번호판</td>
									<td><input type="text" name="assign_num" value="${ cud.assign_num }"></td>
								</tr>
								<tr>
									<td style="background-color:#FFBB05">년식</td>
									<td><input type="text" name="car_year" value="${ cud.car_year }"></td>
								</tr>
								<tr>
									<td style="background-color:#FFBB05">이미지</td>
									<td>
										<input type="file" name="images" class="inputbox" value="${ cud.images }"/>
									</td>
								</tr>
								<tr>
									<td style="background-color:#FFBB05">사용여부</td>
									<td>
										<select id="able_flag"  name="able_flag">
											<c:if test="${ cud.able_flag =='n' }">
						                         <option value="n">사용불가능</option>
						                         <option value="y">사용가능</option>
					                         </c:if>
					                         <option value="y">사용가능</option>
				                         	 <option value="n">사용불가능</option>
										</select>
									</td>
								</tr>
				</table>
					<input type="hidden"  id="car_num" name="car_num" value="${ cud.car_num }">  	
		</form>
		<br/>
		<input type="button" value="수정완료" class="btn" onclick="checkNull()" />
		<input type="button" value="취소" class="btn" onclick="cancle()" />

</body>
</html>