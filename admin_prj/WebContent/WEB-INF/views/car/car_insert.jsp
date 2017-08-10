<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script src="http://code.jquery.com/jquery.min.js"></script>
	
	<script type="text/javascript">
		function checkNull(){
			var obj=document.frm;
		 	var assign_num=obj.assign_num.value;
		 	var car_name=obj.car_name.value;
		 	var able_flag=obj.able_flag.value;
			var car_year=obj.car_year.value;
			var images=obj.images.value; 
			 var tempArr=obj.images.value.split("."); // .으로 잘라서 파일확장자를 얻는과정
			 
			 var fileExt=tempArr[tempArr.length-1].toLowerCase(); //파일확장자를 얻어냄
			 var blockExt=["jpg","png"];
			 var blockFlag=false;
			 
			 for(var i=0; i<blockExt.length; i++){
			 	if(blockExt[i]==fileExt){
			 		blockFlag=true;
			 		break;
			 	}//end if
			 }//end for
			 
		 	  if(!(blockFlag)){
				 alert("이미지가 없거나 업로드 가능한 이미지 형식이 아닙니다.");
				 return;
			 }//end if
			 
			 var maxSize=1024*1024*5;
			 if(obj.images.files[0].size > maxSize ){
				 alert("업로드 가능한 파일크기는 최대5Mbyte까지 입니다.");
				 return;
			 }//end if   
			 
			 if(car_name=="" || assign_num=="" || car_year=="" || images=="" || able_flag==""){
				 alert("모든 정보는 필수입력 사항입니다.");
				 return;
			 }
			 
 			obj.submit(); 
 			alert("submit되었습니다.");
		}//checkNull
		
		function cancle(){
			window.close();
		}//cancle
		
		</script>
</head>
<body>
	
	
     <strong>▶차량 추가◀</strong><br/>
 	아래에 정보를 입력하여 새로운 차량을 추가하세요.
	<form action="car_insert_success.do" name="frm" enctype="multipart/form-data">
		<table border="1" style="width: 500px; text-align: center;">
			<tr>
				<td colspan="2" style="background-color:#FFBB05">차량추가</td>
			</tr>
			<tr>
				<td style="background-color:#FFBB05">차량명(car_name)</td>
				<td><select id="car_name" name="car_name" >
						<c:forEach var="car" items="${ requestScope.list }">
		                    <option value="${ car.car_name }"><c:out value="${ car.car_name }" /></option>
	                    </c:forEach>
					</select></td>
			</tr>
			<tr>
				<td style="background-color:#FFBB05">차량번호판(assign_num)</td>
				<td><input type="text" id="assign_num" name="assign_num"></td>
			</tr>
			<tr>
				<td style="background-color:#FFBB05">년식(car_year)</td>
				<td><input type="text" id="car_year" name="car_year">년</td>
			</tr>
			<tr>
				<td style="background-color:#FFBB05">이미지(images)</td>
				<td>
					<input type="file" name="images" class="inputbox"/>
				</td>
			</tr>
			<tr>
				<td style="background-color:#FFBB05">차량사용여부(able_flag)</td>
				<td>
					<select id="able_flag"  name="able_flag">
	                       <option value="y">사용가능</option>
	                       <option value="n">사용불가능</option>
					</select>
				</td>
			</tr>
		</table>
	</form>
	<br/>
	<input type="button" value="등록" class="btn" onclick="checkNull()"/>
	<input type="button" value="닫기" class="btn" onclick="cancle()"/>
	<br/><br/>
	 

</body>
</html>