<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>차량수정</title>

        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">

        <link rel="stylesheet" href="http://localhost:8080/admin_prj/template/css/fontAwesome.css">
        <link rel="stylesheet" href="http://localhost:8080/admin_prj/template/css/templatemo-style.css">
		<link rel="stylesheet" href="http://localhost:8080/admin_prj/common/css/main.css">
<script type="text/javascript">
   //////////차량 수정/////////
   function checkNull(){
      var obj=document.frm;
      var assign_num=obj.assign_num.value;
      var car_year=obj.car_year.value;
      var able_flag=obj.able_flag.value;
      var images=obj.images.value; 
       var tempArr=obj.images.value.split("."); // .으로 잘라서 파일확장자를 얻는과정
       var fileExt=tempArr[tempArr.length-1].toLowerCase(); //파일확장자를 얻어냄
       var blockExt=["jpg","png","gif"];
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
<strong>▶차량 수정◀</strong>
   <form action="car_update_success.do" name="frm" enctype="multipart/form-data" method="post">
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
                                    <input type="file" name="images" class="inputbox"/>
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
      <div align="center">
      <input type="button" value="수정완료" class="btn" onclick="checkNull()" />
      <input type="button" value="취소" class="btn" onclick="cancle()" />
      </div>

</body>
</html>