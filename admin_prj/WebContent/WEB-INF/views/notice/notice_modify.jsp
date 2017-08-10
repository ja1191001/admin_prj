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

      <!--  <link rel="stylesheet" href="http://localhost:8080/admin_prj/template/css/bootstrap.css">
        <link rel="stylesheet" href="http://localhost:8080/admin_prj/template/css/bootstrap.min.css">
        <link rel="stylesheet" href="http://localhost:8080/admin_prj/template/css/bootstrap-theme.css">
        <link rel="stylesheet" href="http://localhost:8080/admin_prj/template/css/bootstrap-theme.min.css"> -->
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

/* tr:HOVER {background-color: #EAE9F7} */
</style>
<script type="text/javascript">
	function chkDelete() {
		var obj = document.searchFrm;
		/*삭제여부 확인 */
		var check = confirm("삭제 하시겠습니까?");
		/* 여부에 따른 삭제처리 */
		if (check) {
			
			alert("삭제되었습니다");
			obj.submit();
		} else {
			return;
		}
	} //chkDelete
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
        <%@ include file="../main/menu.jsp" %>
      </td>
      <td width=800 height=600 align=center valign=top>
	<div id="content">
			<div id="notice"
				style="width: 700px; min-height: 360px; top: 100px; ' margin: 0px auto">
				<form action="modify_detail.do" method="post">
					<table class="tab" style="margin: 10px; min-height: 300px;">
						<colgroup>
							<col width="9%" />
							<col width="*%" />
							<col width="8%" />
							<col width="20%" />
						</colgroup>
						<caption style="background-color: #ccc">게시글 상세</caption>
						<tbody>
							<c:set var="noticeDetail"
								value="${requestScope.detail_data }">
							</c:set>
							<tr>
								<td scope="col">글 번호</th>
								<td scope="col" width="460">제목</th>
								<td scope="col">작성자</th>
								<td scope="col">작성시간</th>
							</tr>
							<tr>
								<td>
									<c:out value="${requestScope.detail_data.num }" />
									<%-- <input type="hidden" value="${reqeustScope.detail_data.notice_num }" name="notice_num"> --%>
									<input type="hidden" value="${ param.notice_num }" name="notice_num">
								</td>
								 <td>
									<input type="text" name="title" class="inputBox" value="${requestScope.detail_data.title } " style="width: 400px;">
								 </td>
								<td><input type="hidden" value="${reqeustScope.detail_data.id }" name="id">관리자</td>
								<td><c:out	value="${requestScope.detail_data.hiredate }" /></td>
							</tr>
							<tr>
								<td colspan="4" align="left"
									style="border: 1px solid #ccc; height: 300px; min-height: 300px; margin: 10px">
									<textarea name="content" rows="22" cols="121"><c:out value="${requestScope.detail_data.content }" /></textarea>
								</td>
							</tr>
						</tbody>
					</table>
					<div align="center">
						<a href="modify_detail.do?notice_num=${requestScope.detail_data.notice_num }&num=${param.num}&hiredate=${requestScope.detail_data.hiredate }"><input type="submit" class="btn" value="수정">
						<a href="#"  onclick="history.go(-1);return false;"><input type="button" class="btn" value="취소" ></a>
					</div>
					</form>
				
			</div>
		</div>
      </td>
    </tr>
  </table>
  
  </center>

    </body>
</html>