<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: XJHDPL
  Date: 2021/4/7
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理</title>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/static/css/bootstrap.min.css" crossorigin="anonymous">
    <link rel="stylesheet" href="/static/css/font-awesome.min.css">
    <%--    提示确认对话框--%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
</head>
<body>
<nav class="navbar navbar-light">
    <a class="navbar-brand"><span class="text-black">笃行在线视频管理</span></a>
</nav>

<div class="row">
    <ul class="list-group" style="width:15%" >
        <li class="list-group-item ${navFocus==1?"active":""} text-center">
            <a href="/admin/user" class="list-group-item list-group-item-action">用户管理</a>
<%--            <a href="/admin/user" class="nav-link">用户管理</a>--%>
        </li>
        <li class="list-group-item ${navFocus==2?"active":""}  text-center">
            <a href="/admin/courseType" class="list-group-item list-group-item-action">课程主题类别</a>
<%--            <a href="/admin/courseType" class="nav-link">课程主题类别</a>--%>
        </li>
        <li class="list-group-item  ${navFocus==3?"active":""} text-center">
            <span>课程主题</span>
        </li>
        <li class="list-group-item ${navFocus==4?"active":""} text-center">
            <span>视频管理</span>
        </li>
        <li class="list-group-item ${navFocus==5?"active":""} text-center">
            <span>工具类别</span>
        </li>
        <li class="list-group-item ${navFocus==6?"active":""} text-center">
            <span>工具管理</span>
        </li>
        <li class="list-group-item ${navFocus==7?"active":""} text-center">
            <span>banner管理</span>
        </li>
    </ul>
    <div style="width: 85%">
        <div class="card shadow">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">信息列表</h6>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
                        <div class="row">
                            <div class="col-sm-12 col-md-6">
                                <a href="#" data-toggle="modal" data-target="#addModal" data-whatever="@mdo" class="btn btn-primary">添加</a>
                            </div>
                            <div class="col-sm-12 col-md-6">
                                <form class="form-inline">
                                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                                    <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">搜索</button>
                                </form>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <table class="table table-bordered dataTable" id="dataTable" width="100%"
                                       cellspacing="0" role="grid" aria-describedby="dataTable_info"
                                       style="width: 100%;">
                                    <thead>
                                    <tr role="row">
                                        <th class="sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1"
                                            colspan="1" aria-sort="ascending"
                                        >#ID
                                        </th>
                                        <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1"
                                            colspan="1"
                                        >name
                                        </th>
                                        <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1"
                                            colspan="1"
                                        >flag
                                        </th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${courseTypeList.list}" var="courseType">
                                        <tr role="row" class="odd">
                                            <td class="sorting_1">${courseType.id}</td>
                                            <td>${courseType.name}</td>
                                            <td>${courseType.flag}</td>
                                            <td><a href="#" onclick="delUser(this)" myAttr="/admin/user/del/${user.id}?pageNum=${userList.pageNum}">
                                                <i class="fa fa-trash  fa-2x text-danger" aria-hidden="true"></i>
                                            </a>
                                            </td>
                                            <td>
                                                <a href="/admin/user/update/${user.id}?pageNum=${userList.pageNum}">
                                                    <i class="fa fa-pencil-square-o  fa-2x text-warning" aria-hidden="true"></i>
                                                </a>
                                            </td>
                                        </tr>

                                    </c:forEach>
                                    </tbody>
                                </table>
                                <%-- 分页 --%>

                                <nav class="mt-2" aria-label="Page navigation example ">
                                    <ul class="pagination justify-content-center">
                                        <li class="page-item ${courseTypeList.hasPreviousPage?"":"disabled"}">
                                            <a class="page-link" href="/admin/courseType?pageNum=${courseTypeListt.prePage}" tabindex="-1">上一页</a>
                                        </li>
                                        <%--            navigateFirstPage是分页条上第一页
                                                        navigateLastPage是分页条上最后一页
                                        --%>
                                        <c:forEach var="i" begin="${courseTypeList.navigateFirstPage}" end="${courseTypeList.navigateLastPage}">
                                            <li class="page-item ${courseTypeList.pageNum==i?"active":""}">
                                                <a class="page-link" href="/admin/courseType?pageNum=${i}">${i}</a>
                                            </li>
                                        </c:forEach>
                                        <li class="page-item ${courseTypeList.hasNextPage?"":"disabled"}">
                                            <a class="page-link" href="/admin/courseType?pageNum=${courseTypeList.nextPage}">下一页</a>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%--    添加框--%>
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form method="post" action="/admin/courseType/add">
                <div class="modal-header">
                    <h5 class="modal-title" id="addModalLabel">添加</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">

                    <div class="form-row">
                        <div class="col-md-12 mb-3">
                            <label for="validationName">name</label>
                            <input type="text" name="name" class="form-control" placeholder="请填写name"
                                   id="validationName" required>
                            <div class="invalid-feedback">
                                Looks good!
                            </div>
                        </div>

                    </div>

                    <div class="form-row">
                        <div class="col-md-12 mb-3">
                            <label for="validationFlag">flag</label>
                            <!-- is-valid is-invalid-->
                            <input type="text" name="flag" placeholder="请输入flag"
                                   class="form-control " id="validationFlag" required>
                            <!-- valid-feedback invalid-feedback-->
                            <div class="valid-feedback" id="feedbackFlag">
                                Looks good!
                            </div>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-12 mb-3">
                            <label for="validationVcode">验证码</label>
                            <!-- is-valid is-invalid-->
                            <div class="row">
                                <div class="col-md-7"><input type="text" name="vcode" placeholder="请输入验证码"
                                                             class="form-control"
                                                             id="validationVcode"
                                                             maxlength="4"
                                                             required>
                                    <div class="valid-feedback" id="feedbackVcode">
                                        Looks good!
                                    </div>
                                </div>
                                <div class="col-md-5"><img src="/vcode" onclick="changeVcode(this)"></img></div>
                            </div>
                        </div>
                    </div>


                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary">确定</button>
                </div>
            </form>
        </div>
    </div>
</div>


<script src="/static/js/jquery-3.3.1.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="/static/js/bootstrap.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>

<script type="application/javascript">
    function changeVcode(imgNode) {
        imgNode.src = "/vcode?ram=" + new Date().getTime();
    }

    function checkVcode() {
        var vcode = $("#validationVcode").val();
        var flag = false;
        $.ajax({
            url: "/checkVcode?vcode=" + vcode,
            success: function (result) {
                if (result.rcode == 1) {
                    flag = true;
                } else {
                    flag = false;
                }
            },
            // 同步请求
            async: false
        });
        return flag;
    }
</script>
</body>
</html>
