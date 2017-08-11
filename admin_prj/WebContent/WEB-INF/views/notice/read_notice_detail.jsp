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
	#agr_wrap{margin:0px auto;width:650px; height:400px}
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

/* tr:HOVER {background-color: #EAE9F7} */
</style>
<script type="text/javascript">
	function chkDelete() {
		var obj = document.searchFrm;
		/*삭제여부 확인 */
		var check = confirm("삭제 하시겠습니까?");
		/* 여부에 따른 삭제처리 */
		if (check) {
			obj.submit();
			alert("삭제되었습니다");
		} else {
			return;
		}
	} //chkDelete
</script>
    </head>
    <body>

         <center>
  
  <table border=1 bordercolor=black cellpadding=0 cellspacing="0" width="1000" min-height="400">

    <tr>
      <td colspan=2 width=100% height=150>
        <img src="http://localhost:8080/admin_prj/template/img/prove-bg.png" width=1000 height=150>
      </td>
      
    </tr>
    
    <tr>
      <td width=200 height=400 align=center valign=top>
       <c:import url="${request.contextPath }/menu.do"/>
      </td>
      <td width=800 height=400 align=center valign=top>
      <!-- =================================================== -->
<!-- <div class="container" style="height: 400px">
	<div class="row"> -->
		<!--        <div class="col-md-12"> -->
		<div class="content first-content">
			<div id="wrap">
				<div id="content">
					<div id="notice"
						style="width: 700px; min-height: 360px; top: 10px; ' margin: 0px auto">
							<table class="tab" style="margin: 10px; min-height: 300px;">
								<colgroup>
									<col width="9%" />
									<col width="*%" />
									<col width="8%" />
									<col width="20%" />
								</colgroup>
								<caption style="background-color: #FFBB05">게시글 상세</caption>
								<tbody>
									<c:set var="noticeDetail"
										value="${requestScope.detail_data }"></c:set>
									<tr>
										<th scope="col">글 번호</th>
										<th scope="col" width="500">제목</th>
										<th scope="col">작성자</th>
										<th scope="col">작성시간</th>
									</tr>
									<tr>
										<td>
											<c:out value="${requestScope.detail_data.num }" />
											<input type="hidden" value="${param.maxNum }" name="maxNum">
											<input type="hidden" value="${requestScope.detail_data.notice_num }" name="notice_num">
										</td>
										<td><c:out value="${requestScope.detail_data.title }" />${ not empty param.title?param.title :''  }</td>
										<td>관리자</td>
										<td><c:out
												value="${requestScope.detail_data.hiredate }" /></td>
									</tr>
									<tr>
										<td colspan="4" align="left"
											style="border: 1px solid #ccc; height: 400px; min-height: 400px; margin: 10px">
											<textarea rows="30" cols="110"><c:out
													value="${requestScope.detail_data.content }" />${ not empty param.content?param.content:''  }</textarea>
										</td>
									</tr>
								</tbody>
							</table>
							<div align="right">
								<a href="notice_modify.do?notice_num=${requestScope.detail_data.notice_num}&num=${ requestScope.detail_data.num }" ><input type="submit" class="btn" value="수정"></a>
								<a href="notice_delete.do?notice_num=${requestScope.detail_data.notice_num}&num=${ requestScope.detail_data.num }" onclick="chkDelete();return false;"><input type="button" class="btn" value="삭제" ></a>
							</div>
					</div>
					<div></div>
					<div align="center">
						<c:if test="${1 < requestScope.detail_data.num }">
							<a
								href="read_notice_detail.do?num=${ requestScope.detail_data.num-1 }&maxNum=${param.maxNum }"><input
								type="button" class="btn" value="이전 글"></a>
						</c:if>
						<c:if test="${ requestScope.detail_data.num < param.maxNum }">
							<a	href="read_notice_detail.do?num=${ requestScope.detail_data.num+1 }&maxNum=${param.maxNum }">
							<input type="button" class="btn" value="다음 글"></a>
						</c:if>
						<!-- <a href="../index.do"><input type="button" class="btn" value="목록으로" ></a> -->
						<a href="../notice_main.do?columnName=${ param.columnName}&keyword=${ param.keyword}" ><input
							type="button" class="btn" value="목록으로"></a>
					</div>
				</div>
			</div>
		</div>
      <!-- =================================================== -->
		<!-- 		</div>
			</div> -->
      <!-- =================================================== -->
      </td>
    </tr>
  </table>
  
  </center>

    </body>
</html>