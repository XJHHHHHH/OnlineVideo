<%--
  Created by IntelliJ IDEA.
  User: XJHDPL
  Date: 2021/4/8
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/static/css/bootstrap.min.css" crossorigin="anonymous">
    <link rel="stylesheet" href="/static/css/font-awesome.min.css">
</head>
<body>
    <div class="container">
        <main role="main" class="col-md-10 ml-sm-auto col-lg-10 px-md-4">

            <h2>Section title</h2>

            <div class="card shadow mb-4">
                <div class="card-header py-3"><h6 class="m-0 font-weight-bold text-primary">修改用户信息</h6>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <form action="/admin/updateUser" method="post">
                            <input type="hidden" name="id" value="${user.id}">
                            <div class="form-group">
                                <label for="exampleInputEmail1">Email</label>
                                <input type="email" class="form-control" id="exampleInputEmail1" value="${user.email}"
                                       aria-describedby="emailHelp" name="email">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">mobile</label>
                                <input type="text" class="form-control" value="${user.mobile}" name="mobile">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Password</label>
                                <input type="password" class="form-control" value="${user.password}" id="exampleInputPassword1" name="password">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">username</label>
                                <input type="text" class="form-control" value="${user.username}" name="username">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">vipFlag</label>
                                <input type="text" class="form-control" value="${user.vipFlag}" name="vipFlag">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">flag</label>
                                <input type="text" class="form-control" value="${user.flag}" name="flag">
                            </div>
                            <div>
                                <input type="hidden" name="pageNum" value="${pageNum}">
                            </div>
                            <button type="submit" class="btn btn-primary">确定</button>
                        </form>
                    </div>
                </div>
            </div>
        </main>
    </div>

    <script src="/static/js/jquery-3.3.1.min.js"></script>

    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="/static/js/bootstrap.min.js"></script>
</body>
</html>
