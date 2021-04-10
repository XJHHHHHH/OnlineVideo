<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>工具</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="/static/css/duxing-video.css" crossorigin="anonymous">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/static/css/bootstrap.min.css" crossorigin="anonymous">
</head>
<body>

<%--头部--%>
<jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>
<br><br>
<%--首页内容区域--%>
<div class="container">

    <%--    工具导航--%>
    <ul class="nav nav-pills">
        <li class="nav-item">
            <a class="nav-link ${toolTypeId==0?"active":""}" href="/tools/type/${0}">全部</a>
        </li>
        <c:forEach items="${toolTypeList}" var="toolType">
            <li class="nav-item">
                <a class="nav-link ${toolTypeId==toolType.id?"active":""}" href="/tools/type/${toolType.id}">${toolType.name}</a>
            </li>
        </c:forEach>
    </ul>
<%--  如果返回的是pageInfo    则要.list--%>
   <c:forEach items="${toolList.list}" var="tool" varStatus="idx" begin="0">
       <c:if test="${idx.index % 4 == 0}">
           <div class="row row-cols-1 row-cols-md-4 mt-2">
       </c:if>
           <div class="col mb-3">
               <a href="${tool.toolsUrl}" target="_blank">
                   <div class="card select-shadow">
                       <img src="${tool.iconUrl}" class="card-img-top" alt="...">
                       <div class="card-body">
                           <p class="card-text text-center">${tool.name}</p>
                       </div>
                   </div>
               </a>
           </div>
       <c:if test="${idx.index%4==3 || idx.last}">
           </div>
       </c:if>
   </c:forEach>

    <%--        分页--%>
    <nav class="mt-2" aria-label="Page navigation example">
        <ul class="pagination justify-content-center">
            <li class="page-item ${toolList.hasPreviousPage?"":"disabled"}">
                <a class="page-link" href="/tools/type/${toolTypeId}?pageNum=${toolList.prePage}" tabindex="-1">上一页</a>
            </li>
            <c:forEach var="i" begin="${toolList.navigateFirstPage}" end="${toolList.navigateLastPage}">
                <li class="page-item ${toolList.pageNum==i?"active":""}">
                    <a class="page-link" href="/tools/type/${toolTypeId}?pageNum=${i}">${i}</a>
                </li>
            </c:forEach>
            <li class="page-item ${toolList.hasNextPage?"":"disabled"}">
                <a class="page-link" href="/tools/type/${toolTypeId}?pageNum=${toolList.prePage}">下一页</a>
            </li>
        </ul>
    </nav>
</div>
<br>
<br>
<%--网站的尾部--%>
<jsp:include page="/WEB-INF/jsp/common/footer.jsp"></jsp:include>
</body>
</html>