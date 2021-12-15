<!DOCTYPE html>
<html lang="en">

<head>
    <#include "../common/head.ftl">
    <link rel="stylesheet" href="${ctx}/css/tooltips.css"/>

    <#--<script src="${ctx}/js/jquery.min.js"></script>-->
    <script>
        window.dataLayer = window.dataLayer || [];

        function gtag() {
            dataLayer.push(arguments);
        }

        gtag('js', new Date());

        gtag('config', 'UA-120946860-7');
    </script>

</head>

<body>
<div class="splash active">
    <div class="splash-icon"></div>
</div>

<div class="wrapper">
    <#-- 侧边栏模块 -->
    <nav id="sidebar" class="sidebar">
        <#include "../common/sidebar-nav.ftl">
    </nav>

    <div class="main">
        <#--顶部导航栏-->
        <#include "../common/top-nav.ftl">

        <main class="content">
            <div class="container-fluid">

                <div class="header">
                    <h1 class="header-title">
                        Profile
                    </h1>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="dashboard.html">Auth</a></li>
                            <#--<li class="breadcrumb-item"><a href="#">Pages</a></li>-->
                            <li class="breadcrumb-item active" aria-current="page">Settings</li>
                        </ol>
                    </nav>
                </div>
                <div class="row">
                    <div class="col-md-3 col-xl-2">

                        <div class="card">
                            <div class="card-header">
                                <h5 class="card-title mb-0">Profile Settings</h5>
                            </div>

                            <div class="list-group list-group-flush" role="tablist">
                                <a class="list-group-item list-group-item-action active" data-toggle="list"
                                   href="#account" role="tab">
                                    Account
                                </a>
                                <a class="list-group-item list-group-item-action" data-toggle="list" href="#password"
                                   role="tab">
                                    Password
                                </a>
                                <a class="list-group-item list-group-item-action" data-toggle="list" href="#"
                                   role="tab">
                                    Your data
                                </a>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-9 col-xl-10">
                        <div class="tab-content">
                            <div class="tab-pane fade show active" id="account" role="tabpanel">
                                <div class="card">
                                    <div class="card-header">
                                        <div class="card-actions float-right">
                                            <a href="#" class="mr-1">
                                                <i class="align-middle" data-feather="refresh-cw"></i>
                                            </a>
                                            <div class="d-inline-block dropdown show">
                                                <a href="#" data-toggle="dropdown" data-display="static">
                                                    <i class="align-middle" data-feather="more-vertical"></i>
                                                </a>

                                                <div class="dropdown-menu dropdown-menu-right">
                                                    <a class="dropdown-item" href="#">Action</a>
                                                    <a class="dropdown-item" href="#">Another action</a>
                                                    <a class="dropdown-item" href="#">Something else here</a>
                                                </div>
                                            </div>
                                        </div>
                                        <h5 class="card-title mb-0">Public info</h5>
                                        ${user}
                                    </div>
                                    <div class="card-body">
                                        <form>
                                            <div class="row">
                                                <div class="col-md-8">
                                                    <div class="form-group">
                                                        <label for="inputUsername">Username</label>
                                                        <input type="text" disabled class="form-control"
                                                               value="${user.name!''}">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="inputUsername">Create Time</label>
                                                        <input type="text" disabled class="form-control"
                                                               value="${user.createTime!''}">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="inputUsername">Mark Count</label>
                                                        <input type="text" disabled class="form-control"
                                                               value="${user.markCount!0}">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="inputUsername">Link Count</label>
                                                        <input type="text" disabled class="form-control"
                                                               value="${user.linkCount!0}">
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="text-center">
                                                        <img alt="Chris Wood" src="${ctx}/images/avatars/avatar.jpg"
                                                             class="rounded-circle img-responsive mt-2" width="128"
                                                             height="128"/>
                                                        <#--<div class="mt-2">-->
                                                        <#--    <span class="btn btn-primary"><i class="fas fa-upload"></i> Upload</span>-->
                                                        <#--</div>-->
                                                        <p><small>Your Photo</small></p>
                                                    </div>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>

                            <div class="tab-pane fade" id="password" role="tabpanel">
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="card-title">Password</h5>

                                        <div>
                                            <div class="form-group">
                                                <label for="inputPasswordCurrent">Active Code</label>
                                                <input type="text" class="form-control" id="reset-code">
                                                <#--<small><a href="#">Forgot your password?</a></small>-->
                                            </div>
                                            <div class="form-group">
                                                <label for="inputPasswordNew">New password</label>
                                                <input type="password" class="form-control" id="inputPasswordNew">
                                            </div>
                                            <div class="form-group">
                                                <label for="inputPasswordNew2">Verify password</label>
                                                <input type="password" class="form-control" id="inputPasswordNew2">
                                            </div>
                                            <input class="btn btn-primary" type="button" onClick="forget()" value="Save changes"
                                                   style="color:white;"/>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <#include "../common/footer.ftl">
    </div>

</div>

<script src="${ctx}/js/app.js"></script>

<script src="${ctx}/js/jquery.pure.tooltips.js"></script>
<script type="text/javascript">
    //重置密码
    function forget() {
        var username = '${user.name}',
            password = $("#inputPasswordNew").val(),
            repassword = $("#inputPasswordNew2").val(),
            code = $("#reset-code").val(),
            flag = false;
        //判断密码是否为空
        if (password == "") {
            $.pt({
                target: $("#inputPasswordNew"),
                position: 'r',
                align: 't',
                width: 'auto',
                height: 'auto',
                content: "密码不能为空"
            });
            flag = true;
        } else {
            if (password != repassword) {
                $.pt({
                    target: $("#inputPasswordNew2"),
                    position: 'r',
                    align: 't',
                    width: 'auto',
                    height: 'auto',
                    content: "两次输入的密码不一致"
                });
                flag = true;
            }
        }

        //检查用户名是否已经存在
        //调后台代码检查用户名是否已经被注册

        //检查注册码是否正确
        //调后台方法检查注册码，这里写死为11111111
        if (code != '888') {
            $.pt({
                target: $("#reset-code"),
                position: 'r',
                align: 't',
                width: 'auto',
                height: 'auto',
                content: "注册码不正确"
            });
            flag = true;
        }

        if (flag) {
            return false;
        } else {//重置密码
            $.ajax({
                type: "POST",
                url: "${ctx}/user/update",
                data: {
                    name: username,
                    password: password
                },
                success: function (result) {
                    if (result.accessCode == 200 && result.processCode == 400) {
                        layer.msg(result.ext.msg, {icon: 1, time: 2000});
                        window.location.href = "${ctx}/index";
                    } else if (result.accessCode == 200 && result.processCode == 500) {
                        layer.alert(result.ext.reason, {icon: 2, time: 2000});
                    }
                },
                error: function() {
                    layer.alert('系统错误，请重新登录！', {icon: 2, time: 2000});
                }
            });

            return false;
        }
    }
</script>
</body>

</html>