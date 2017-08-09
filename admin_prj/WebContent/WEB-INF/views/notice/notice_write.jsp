<%@page import="kr.co.sist.notice.dao.MainDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info="상세 글 보기" errorPage="cal_err.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Hyerim RentCar</title>

<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="apple-touch-icon.png">

<link rel="stylesheet"
	href="http://localhost:8080/car_prj/template/css/bootstrap.css">
<link rel="stylesheet"
	href="http://localhost:8080/car_prj/template/css/bootstrap.min.css">
<link rel="stylesheet"
	href="http://localhost:8080/car_prj/template/css/bootstrap-theme.css">
<link rel="stylesheet"
	href="http://localhost:8080/car_prj/template/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="http://localhost:8080/car_prj/template/css/fontAwesome.css">
<link rel="stylesheet"
	href="http://localhost:8080/car_prj/template/css/templatemo-style.css">
<link rel="stylesheet"
	href="http://localhost:8080/car_prj/common/css/main.css">
<style type="text/css">
#agr_wrap {
	margin: 0px auto;
	width: 650px;
	height: 600px
}

#agr_header {
	text-align: center
}

#agr_footer {
	text-align: center;
	margin-top: 30px
}

.ag_1 {
	border: 1px solid #333;
	width: 650px;
	min-height: 250px;
	overflow: auto;
}

#wrap {
	width: 700px;
	min-height: 100px;
	margin: 0px auto
}

#header {
	wedth: 700px;
	height: 100px;
	position: relative;
	background: #FFBFBF
		url(http://localhost:8080/car_prj/common/images/header_background.png)
		no-repeat;
}

#logo {
	position: absolute;
	top: 20px;
	left: 50px
}

#content {
	width: 700px;
	min-height: 100px;
	position: relative;
}

#footer {
	width: 700px;
	height: 100px;
}

#footer_text {
	width: 500px;
	height: 80px;
	padding-top: 20px;
	float: right;
	padding-right: 10px
}

.btn {
	height: 25px;
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

.numTitle {
	width: 60px
}

.subjectTitle {
	width: 300px
}

.writerTitle {
	width: 100px
}

.evtTitle {
	width: 120px
}

.dateTitle {
	width: 120px
}

.fileTitle {
	width: 80px
}
/* text-align : 글자 정렬  left,center,right  */
td {
	border-bottom: 1px solid #E7E7E7;
	height: 28px;
	text-align: center;
}

tr:HOVER {
	background-color: #EAE9F7
}
</style>

<script type="text/javascript">
	function chkNull() {
		var obj = document.frm;
		var title=obj.title.value;
		var content=obj.content.value;
		
		/*등록여부 확인 */
		var check = confirm("등록하시겠습니까?");
		/* 여부에 따른 삭제처리 */
		if (check) {
			if(title=""){ //제목이 없다면
				alert("제목을 작성해 주세요");
				return;
			}//end if	
			if(content=""){ //내용이 없다면
				alert("내용을 작성해 주세요");
				return;
			}//end if
			obj.submit();
		} else {
			return;
		}//end else
	} //chkDelete
</script>
</head>
<body>
	<!-- 작성일 : 2017. 7. 26.
		  작성자 : user
		  내용 : 			
	-->
	<div class="overlay"></div>
	<section class="top-part"></section>

	<section class="cd-hero">
		<div class="cd-slider-nav">

			<c:import url="${ request.contextPath }/menu.do" />
		</div>

		<!--      <ul>

            <li> -->
		<div class="heading">
			<h1>공지사항</h1>
			<span>공지사항</span>
		</div>
		<div class="cd-full-width first-slide" style="min-height: 750px">
			<div class="container" style="height: 400px">
				<div class="row">
					<!--        <div class="col-md-12"> -->
					<div class="content first-content">
						<div id="wrap">
							<div id="content">
								<div id="notice"
									style="width: 700px; min-height: 360px; top: 100px; ' margin: 0px auto">
									<form action="notice_write_action.do" method="post" name="frm">
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
													<td scope="col" width="500">제목</th>
													<td scope="col">작성자</th>
													<td scope="col">작성시간</th>
												</tr>
												<tr>
													<td>
														<input type="hidden" value="NOTICE_NUM" name="notice_num"> 
														<%-- <input type="hidden" value="${ param.notice_num }" name="notice_num"> --%>
													</td>
													 <td>
														<input type="text" name="title" class="inputBox" value="" style="width: 400px;">
													 </td>
													<td><input type="hidden" value="${reqeustScope.detail_data.id }" name="id">관리자</td>
												</tr>
												<tr>
													<td colspan="4" align="left"
														style="border: 1px solid #ccc; height: 400px; min-height: 400px; margin: 10px">
														<textarea name="content" rows="30" cols="110">
														</textarea>
													</td>
												</tr>
											</tbody>
										</table>
									
										<div align="center">
											<a href="notice_write_action.do?"><input type="submit" class="btn" value="작성" onclick="chkNull()">
											<a href="#"  onclick="history.go(-1);return false;"><input type="button" class="btn" value="취소" ></a>
										</div>
										</form>
									
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>
	</section>
	<footer>
		<!-- <div id="footer_text"> -->
		Copyright &copy; 2017 class4 dongha, All Right Reserved
		<!-- </div> -->
	</footer>
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.2.min.js"><\/script>')</script>

	<script src="js/vendor/bootstrap.min.js"></script>
	<script src="js/plugins.js"></script>
	<script src="js/main.js"></script>
</body>
</html>