<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<nav class="navbar navbar-expand-lg navbar-light bg-light shadow">

    <div class="container">

        <a class="navbar-brand" href="/">笃行在线视频</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link ${navFocus==1?"active":""}" href="/">首页 <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link ${navFocus==2?"active":""}" href="/courseList">课程</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link ${navFocus==3?"active":""}" href="/vip">会员</a>
                </li>
                </li>
                <li class="nav-item">
                    <a class="nav-link ${navFocus==4?"active":""}" href="/live">直播</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link ${navFocus==5?"active":""}" href="/tools/type/${0}">工具</a>
                </li>
            </ul>
                <%-- 已经登录的用户，显示用户名--%>
                <c:choose>
                <c:when test="${ !empty login_user}">
                    <div class="dropdown mr-1">
                        <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                ${login_user.email}
                        </a>

                        <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                            <a class="dropdown-item" href="/logout">退出</a>

                        </div>
                    </div>
                </c:when>

            <c:otherwise>

                <a href="#" data-toggle="modal" data-target="#loginModal" data-whatever="@fat" class="mr-1">登录</a> /
                <a href="#" data-toggle="modal" data-target="#registModal" data-whatever="@mdo"
                   class="ml-1 mr-3">注册</a>
            </c:otherwise>
            </c:choose>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="搜索视频" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" name="searchName" value="" type="submit">搜索</button>
            </form>
        </div>

    </div>
</nav>

<!-- 登录对话框 -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form method="post" action="/login" onsubmit="return loginSubmit()">
                <div class="modal-header">
                    <h5 class="modal-title" id="loginModalLabel">登录</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-row">
                        <div class="col-md-12 mb-3">
                            <label for="validationLoginEmail">邮箱</label>
                            <!-- is-valid is-invalid-->
                            <input type="text" name="email" class="form-control " id="validationLoginEmail" required>
                            <div class="valid-feedback">
                                Looks good!
                            </div>
                        </div>

                    </div>
                    <div class="form-row">
                        <div class="col-md-12 mb-3">
                            <label for="validationLoginPassword">密码</label>
                            <input type="password" name="password" class="form-control " id="validationLoginPassword"
                                   required>
                            <div class="invalid-feedback" id="loginFeedback">
                                Please provide a valid city.
                            </div>
                        </div>


                    </div>
                    <div class="form-group">
                        <div class="form-check">
                            <input class="form-check-input " name="autoLogin" type="checkbox" value="1"
                                   id="invalidCheck3">
                            <label class="form-check-label">
                                自动登录
                            </label>

                            <a href="#" class="float-right">忘记密码</a>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary">登录</button>
                </div>
                <div class="mb-3 ml-3">
                    <a href="#" data-toggle="modal" data-dismiss="modal" data-target="#registModal">还没有账号？点我注册</a>
                </div>

            </form>
        </div>


    </div>

</div>


<!-- 注册对话框 -->

<div class="modal fade" id="registModal" tabindex="-1" role="dialog" aria-labelledby="registModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form method="post" action="/regist" onsubmit="return registSubmit()">
                <div class="modal-header">
                    <h5 class="modal-title" id="registModalLabel">注册</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">

                    <div class="form-row">
                        <div class="col-md-12 mb-3">
                            <label for="validationUsername">昵称</label>
                            <input type="text" name="username" class="form-control" placeholder="请填写昵称"
                                   id="validationUsername" required>
                            <div class="invalid-feedback">
                                Looks good!
                            </div>
                        </div>

                    </div>

                    <div class="form-row">
                        <div class="col-md-12 mb-3">
                            <label for="validationEmail">邮箱</label>
                            <!-- is-valid is-invalid-->
                            <input type="text" name="email" placeholder="请输入邮箱" onblur="checkEmail(this)"
                                   pattern="[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?"
                                   class="form-control " id="validationEmail" required>
                            <!-- valid-feedback invalid-feedback-->
                            <div class="valid-feedback" id="feedbackEmail">
                                Looks good!
                            </div>
                        </div>

                    </div>

                    <div class="form-row">
                        <div class="col-md-12 mb-3">
                            <label for="validationMobile">手机</label>
                            <!-- is-valid is-invalid-->
                            <input type="text" placeholder="请输入手机号" pattern="1[3456789]\d{9}$" name="mobile"
                                   class="form-control "
                                   id="validationMobile" required>
                            <div class="valid-feedback">
                                Looks good!
                            </div>
                        </div>

                    </div>
                    <div class="form-row">
                        <div class="col-md-12 mb-3">
                            <label for="validationPassword">密码</label>
                            <input type="password" name="password" placeholder="包含数字和字母且在6-20位之间"
                                   pattern="^(?![\d]+$)(?![a-zA-Z]+$)(?![^\da-zA-Z]+$).{6,20}$" class="form-control"
                                   id="validationPassword" required>
                            <div class="invalid-feedback">
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
                    <button type="submit" class="btn btn-primary">注册</button>
                </div>
                <div class="mb-3 ml-3">
                    <a href="#" data-toggle="modal" data-dismiss="modal" data-target="#loginModal">已有账号？点我登录</a>
                </div>

            </form>
        </div>
    </div>
</div>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="/static/js/jquery-3.3.1.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="/static/js/bootstrap.min.js"></script>

<script type="application/javascript">

    function changeVcode(imgNode) {
        imgNode.src = "/vcode?ram=" + new Date().getTime();
    }

    function registSubmit() {
        var vcodeFlag = checkVcode();

        if (!vcodeFlag) {
            // 验证码不正确
            $("#validationVcode").removeClass("is-valid");
            $("#validationVcode").addClass("is-invalid");
            $("#feedbackVcode").text("验证码填写错误");
            $("#feedbackVcode").attr("class", "invalid-feedback");
            return false;
        }
        // 提交注册
        return true;
    }

    function loginSubmit() {

        var flag = false;

        $.ajax({
            url: "/checkLogin",
            type: "POST",
            data: {email: $("#validationLoginEmail").val(), password: $("#validationLoginPassword").val()},
            // 同步请求
            async: false,
            success: function (result) {
                if (result.rcode == 1) {
                    flag = true;
                } else {
                    // 登录失败提示
                    $("#validationLoginEmail").addClass("is-invalid");
                    $("#validationLoginPassword").addClass("is-invalid");
                    $("#loginFeedback").text("账号或密码错误");
                    $("#loginFeedback").attr("class", "invalid-feedback");
                    flag = false;
                }
            }
        });

        return flag;
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

    function checkEmail(emailNode) {
        var email = emailNode.value;
        $.ajax({
            url: "/checkEmail?email=" + email,
            success: function (result) {
                if (result.rcode == 1) {
                    // 可以注册 valid-feedback invalid-feedback
                    $("#validationEmail").addClass("is-valid");
                    $("#validationEmail").removeClass("is-invalid");
                    $("#feedbackEmail").text("Email可以注册");
                    $("#feedbackEmail").attr("class", "valid-feedback");
                } else {
                    // 不可以注册
                    $("#validationEmail").addClass("is-invalid");
                    $("#validationEmail").removeClass("is-valid");
                    $("#feedbackEmail").text("Email已经存在！");
                    $("#feedbackEmail").attr("class", "invalid-feedback");
                }
            }
        });
    }
</script>