<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		function checkNull(){
			var obj=document.frm;
	 	 	var car_name=obj.car_name.value;
			var rental_fee=obj.rental_fee.value;
			var car_option=obj.car_option.value; 
			
 	 	 	if(car_name=="" || rental_fee=="" || car_option==""){
				alert("모든 정보를 입력해주세요.");
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
     <strong>▶차종 추가◀</strong><br/>
 	아래에 정보를 입력하여 새로운 차종을 추가하세요.
	<form action="../type_insert_success.do" name="frm">
		<table border="1" style="width: 500px; text-align: center;">
			<tr>
				<td colspan="2" style="background-color:#FFBB05">차종추가</td>
			</tr>
			<tr>
				<td style="background-color:#FFBB05">차량명(car_name)</td>
				<td><input type="text" id="car_name" name="car_name"></td>
			</tr>
			<tr>
				<td style="background-color:#FFBB05">종류(type)</td>
				<td>
					<select id="type" name="type">
	                    <option value="소형">소형</option>
	                    <option value="경차">경차</option>
	                    <option value="중형">중형</option>
	                    <option value="SUV">SUV</option>
					</select>
				</td>
			</tr>
			<tr>
				<td style="background-color:#FFBB05">1일 렌트비용(rental_fee)</td>
				<td><input type="text" id="rental_fee" name="rental_fee">원</td>
			</tr>
			<tr>
				<td style="background-color:#FFBB05">연료(fuel)</td>
				<td>
					<select id="fuel" name="fuel">
	                       <option value="LPG">LPG</option>
	                       <option value="휘발유">휘발유</option>
	                       <option value="경유">경유</option>
					</select>
				</td>
			</tr>
			<tr>
				<td style="background-color:#FFBB05">배기량(cc)</td>
				<td><input type="text" id="cc" name="cc">cc</td>
			</tr>
			<tr>
				<td style="background-color:#FFBB05">옵션(option)</td>
				<td>
					<textarea id="car_option" name="car_option" rows="10" style="width:100%;"></textarea>
				</td>
			</tr>
		</table>
	</form>
	<br/>
	<input type="button" value="등록" class="btn" onclick="checkNull()"/>
	<input type="button" value="닫기" class="btn" onclick="cancle()"/>
</body>
</html>