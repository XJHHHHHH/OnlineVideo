<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>课程列表</title>

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
    <%-- 工具导航--%>
    <ul class="nav nav-pills">
        <li class="nav-item ">
            <a class="nav-link ${typeId==0?"active":""}" href="/courseList">全部</a>
        </li>
        <c:forEach items="${typeList}" var="type">
            <li class="nav-item ">
                <a class="nav-link ${type.id==typeId?"active":""}" href="/courseList/type/${type.id}">${type.name}</a>
            </li>
        </c:forEach>
    </ul>
    <c:forEach items="${topicList.list}" var="topic" varStatus="idx" begin="0">
        <c:if test="${idx.index%4==0}">
            <div class="row row-cols-1 row-cols-md-4 mt-2">
        </c:if>
            <div class="col mb-3">
                <a href="/courseVideo/${topic.id}/${-1}" target="_blank">
                    <div class="card select-shadow">
                        <img src="${topic.iconUrl}" class="card-img-top" alt="...">
                        <div class="card-body">
                            <p class="card-text">${topic.titile}</p>
                            <p class="card-text">${topic.views}</p>
                            <c:choose>
                                <c:when test="${topic.vipFlag==0}">
                                    <span class="badge badge-pill badge-success">免费</span>
                                </c:when>
                                <c:otherwise>
                                    <span class="badge badge-pill badge-danger">VIP</span>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </a>
            </div>
        <c:if test="${idx.index%4==3 || idx.last}">
            </div>
        </c:if>
    </c:forEach>


    <%-- 分页--%>
    <nav class="mt-2" aria-label="Page navigation example ">
        <ul class="pagination justify-content-center">
            <li class="page-item ${topicList.hasPreviousPage?"":"disabled"}">
                <a class="page-link" href="/courseList/type/${typeId}?pageNum=${topicList.prePage}" tabindex="-1">上一页</a>
            </li>
<%--            navigateFirstPage是分页条上第一页
                navigateLastPage是分页条上最后一页
--%>
            <c:forEach var="i" begin="${topicList.navigateFirstPage}" end="${topicList.navigateLastPage}">
                <li class="page-item ${topicList.pageNum==i?"active":""}">
                    <a class="page-link" href="/courseList/type/${typeId}?pageNum=${i}">${i}</a>
                </li>
            </c:forEach>
            <li class="page-item ${topicList.hasNextPage?"":"disabled"}">
                <a class="page-link" href="/courseList/type/${typeId}?pageNum=${topicList.nextPage}">下一页</a>
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