<!DOCTYPE html>
<html lang="en">

<head>
    <#include "../common/head.ftl">
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
                        Tables
                    </h1>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="dashboard.html">Pages</a></li>
                            <li class="breadcrumb-item"><a href="#">All Mark</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Mark Table</li>
                        </ol>
                    </nav>
                </div>
                <div class="row">
                    <div class="col-12 col-xl-6">
                        <div class="card">
                            <div class="card-header">
                                <h5 class="card-title">Mark Table</h5>
                            </div>
                            <#if user.marks?? && (user.marks?size > 0)>
                                <table class="table">
                                <thead>
                                <tr>
                                    <th style="width:40%;">Name</th>
                                    <th style="width:30%">Link Count</th>
                                    <th>Actions</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <#list user.marks as mark>
                                        <tr>
                                            <td>
                                                <a href="${ctx}/link/get/mark?markIds=${mark.id}">${mark.name}</a>
                                            </td>
                                            <#if mark.linkList?? && (mark.linkList?size>0) >
                                                <td>${mark.linkList?size}</td>
                                            <#else>
                                                <td>0</td>
                                            </#if>

                                            <td class="table-action">
                                                <a href="${ctx}/mark/update/${mark.id}" title="编辑"
                                                   class="btn btn-sm btn-primary">
                                                    <i class="align-middle fas fa-fw fa-pen"></i>
                                                </a>
                                                <a href="javascript:void(0)" onclick="del_mark('${mark.name}')"
                                                   class="btn btn-sm btn-danger" title="删除">
                                                    <i class="align-middle fas fa-fw fa-trash"></i>
                                                </a>
                                            </td>
                                        </tr>
                                    </#list>
                                </tbody>
                            </table>
                            <#else>
                                <div class="alert alert-primary alert-dismissible" role="alert" style="width: 80%; margin-left: 10%;">
                                    <div class="alert-icon">
                                        <i class="far fa-fw fa-bell"></i>
                                    </div>
                                    <div class="alert-message">
                                        <strong>您还没添加标签哦！</strong>
                                    </div>
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                            </#if>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <#include "../common/footer.ftl">
    </div>

</div>

<script src="${ctx}/js/app.js"></script>
<script>
    function del_mark(name) {
        layer.confirm('确认删除 【' + name + '】吗？', {btn: ['确定', '取消']}, function () {
                $.ajax({
                    type: 'POST',
                    url: "${ctx}/mark/delete/" + name,
                    dataType: 'json',
                    success: function (result) {
                        if (result.accessCode == 200 && result.processCode == 400) {
                            layer.msg(result.ext.msg, {icon: 1, time: 2000});
                            window.location.href = "${ctx}/user/get/${user.id}?target=mark/list";
                        } else if (result.accessCode == 200 && result.processCode == 500) {
                            layer.alert(result.ext.reason, {icon: 2, time: 2000});
                        }
                        layer.closeAll();
                    }, error: function() {
                        layer.alert('系统错误，请稍后再试！', {icon: 2, time: 2000});
                    }
                })
            }, function (index) {
                layer.close(index);
                return false;// 取消
            }
        );
    }
</script>
</body>
</html>