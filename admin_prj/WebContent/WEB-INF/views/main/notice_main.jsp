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

        <link rel="stylesheet" href="template/css/bootstrap.min.css">
        <link rel="stylesheet" href="template/css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="template/css/fontAwesome.css">
        <link rel="stylesheet" href="template/css/templatemo-style.css">

        <!-- <link href="https://fonts.googleapis.com/css?family=Montserrat:100,200,300,400,500,600,700,800,900" rel="stylesheet">

        <script src="js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script> -->
        
        <style type="text/css">
	#agr_wrap{margin:0px auto;width:650px; height:600px}
	#agr_header{text-align:center}
	#agr_footer{text-align:center;margin-top:30px}
 	.ag_1{ border:1px solid #333; width:650px; height: 250px; overflow: auto;}
</style>
    </head>
    <body>

        <div class="overlay"></div>
        <section class="top-part">
        </section>
        
        <section class="cd-hero">
		<div class="cd-slider-nav">
		
		<c:import url="${ request.contextPath }/menu.do"/>
		</div>

          <ul>

            <li>
              <div class="heading">
                <h1>메인타이틀</h1>
                <span>서브타이틀</span>
              </div>
              <div class="cd-full-width first-slide">
                <div class="container">
                  <div class="row">
                    <div class="col-md-12">
                      <div class="content first-content">
                        <h4>소제목</h4>
                        <div id="content">
	<div id="notice" style="width:750px; min-height:700px;top:100px;'margin:0px auto">
	<table class="tab" style="margin: 10px">
		<colgroup>
			<col width="10%"/>
			<col width="*"/>
			<col width="15%"/>
			<col width="20%"/>
		</colgroup>
	<thead>
	<tr>
		<th class="numTitle" scope="col">번호</th>
		<th class="subjectTitle" scope="col"	>제목</th>
		<th class="writerTitle" scope="col">작성자</th>
		<th class="dateTitle" scope="col">작성일</th>
	</tr>
	</thead>
	<tbody>
	<c:choose>
		<c:when test="${empty requestScope.noticeList }">
			<tr><td colspan="4" align="center">작성된 글이 없습니다.</td></tr>
		</c:when>
		<c:otherwise>
			<c:forEach var="notice" items="${requestScope.noticeList }">
			<tr>
				<td><c:out value="${notice.num }"/></td>
				<td align="left"> <a href="notice/read_notice_detail.do?num=${ notice.num }"><c:out value="${notice.title }"/></a></td>
				<td>관리자</td>
				<td><c:out value="${notice.hiredate }"/></td>
			</tr>	
			</c:forEach>
		</c:otherwise>
	</c:choose>
	</tbody>
	</table>
	<br/>
	<form action="notice_main.do" method="get" name="movePage">	
<div align="center">
<c:if test="${ not empty requestScope.noticePage }">
	<c:if test="${requestScope.noticePage.currentPage !=1 }">
		<a href="notice_main.do?currentPage=${noticePage.currentPage-1 }&columnName=${ columnName}&keyword=${ keyword}" ><img alt="이전 페이지" src="http://localhost:8080/car_prj/images/btn_prev.png" title="이전 페이지"></a>
	</c:if>
	<c:choose>
	<c:when test="${ empty param.columnName }">
	
	<c:forEach var="i" begin="${requestScope.noticePage.firstPage }" end="${ requestScope.noticePage.lastPage }" step="1">
	[ <a href="notice_main.do?currentPage=${ i }">${ i }</a> ]
	</c:forEach> 
	
	</c:when>
	<c:otherwise>
	<c:forEach var="i" begin="${requestScope.noticePage.firstPage }" end="${ requestScope.noticePage.lastPage }" step="1">
	[ <a href="notice_main.do?currentPage=${ i }&columnName=${ param.columnName}&keyword=${ param.keyword}" >${ i }</a> ]
	</c:forEach>
	
	</c:otherwise>
	</c:choose>
	<c:if test="${requestScope.noticePage.currentPage  != requestScope.noticePage.lastPage }">
		<a href="notice_main.do?currentPage=${noticePage.currentPage+1 }&columnName=${ columnName}&keyword=${ keyword}" onclick="chkValue()" ><img alt="다음 페이지" src="http://localhost:8080/car_prj/images/btn_next.png" title="다음 페이지"></a>
	</c:if>
</c:if>
</div>	
</form>
	<div style="text-align: center; min-height: 100px;" >
	<form action="notice_main.do" method="get" name="searchFrm">
		<select name="columnName">
			<option value="title">제목</option>
			<option value="content">내용</option>
		</select>
		<input type="text" name="keyword" class="inputBox" value=""/>
		<input type="button" value="검색" class="btn" onclick="chkNull('columnName','keyword')" />
		
	</form>

	</div>
	</div>
	</div>
                        <div class="primary-button">
                          <a href="">링크</a>
                        </div>
                      </div>
                    </div>
                  </div>                  
                </div>
              </div>
            </li>
          </ul> <!-- .cd-hero-slider -->
        </section> <!-- .cd-hero -->


        <footer>
          <p>Copyright &copy; 2017 Your Company 
                                
           | Designed by <a href="http://www.templatemo.com" target="_parent"><em>templatemo</em></a></p>
        </footer>
    
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.2.min.js"><\/script>')</script>

        <script src="js/vendor/bootstrap.min.js"></script>
        <script src="js/plugins.js"></script>
        <script src="js/main.js"></script>

    </body>
</html>