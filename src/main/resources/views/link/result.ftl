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
                            <li class="breadcrumb-item"><a href="#">Link List</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Link Tables</li>
                        </ol>
                    </nav>
                </div>
                <div class="row">
                    <div class="col-12 col-xl-6">
                        <div class="card">
                            <div class="card-header">
                                <h5 class="card-title">Result Table</h5>
                            </div>

                            <#-- 搜索框 -->
                            <#include "link_name_search.ftl">
                            <#if linkList?? && (linkList?size > 0)>
                                <table class="table">
                                <thead>
                                <tr>
                                    <th style="width:20%;">Name</th>
                                    <th style="width:15%">Mark Count</th>
                                    <th style="width:40%">Mark</th>
                                    <th>Actions</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <#list linkList as link>
                                        <tr>
                                            <td>${link.name}</td>
                                            <input type="hidden" value="${link.url}" id="link-${link.id}">
                                            <#if link.marks?? && (link.marks?size>0) >
                                                <td>${link.marks?size}</td>
                                            <#else>
                                                <td>0</td>
                                            </#if>

                                            <td>
                                                <#if link.marks?? && (link.marks?size>0)>
                                                    <#list link.marks as mark>
                                                        <#if search_mark_ids?? && search_mark_ids?seq_contains(mark.id)>
                                                            <button class="btn btn-sm btn-pill btn-primary"
                                                                    onclick="search_link_by_mark('${mark.id}')">${mark.name}
                                                            </button>
                                                        <#else>
                                                            <button class="btn btn-sm btn-pill btn-outline-primary"
                                                                    onclick="search_link_by_mark('${mark.id}')">${mark.name}
                                                            </button>
                                                        </#if>
                                                    </#list>
                                                <#else>
                                                    -
                                                </#if>
                                            </td>

                                            <td class="table-action">
                                                <a href="javascript:void(0)" type="button" onclick="copyUrl('${link.id}')"
                                                   class="btn btn-sm btn-success" title="复制链接">
                                                    <i class="align-middle fas fa-fw fa-copy"></i>
                                                </a>
                                                <a href="${ctx}/link/update/${link.id}" title="编辑"
                                                   class="btn btn-sm btn-primary">
                                                    <i class="align-middle fas fa-fw fa-pen"></i>
                                                </a>
                                                <a href="javascript:void(0)" onclick="del_link('${link.id}', '${link.name}')"
                                                   class="btn btn-sm btn-danger" title="删除">
                                                    <i class="align-middle fas fa-fw fa-trash"></i>
                                                </a>
                                                <a href="${link.url}" target="_blank" class="btn btn-sm btn-bitbucket"
                                                   title="打开链接">
                                                    <i class="align-middle fas fa-fw fa-paper-plane"></i>
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
                                        <strong>暂未查询到链接！</strong>
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
<script src="${ctx}/js/jQuery-2.1.4.min.js"></script>
<script>
    function del_link(id, name) {
        layer.confirm('确认删除 【' + name + '】吗？', {btn: ['确定', '取消']}, function () {
                $.ajax({
                    type: 'POST',
                    url: "${ctx}/link/delete/" + id,
                    dataType: 'json',
                    success: function (result) {
                        if (result.accessCode == 200 && result.processCode == 400) {
                            layer.msg(result.ext.msg, {icon: 1, time: 2000});
                            window.location.href = "${ctx}/user/get/${user.id}?target=link/list";
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

    function copyUrl(id) {
        let id_name = "#link-" + id;
        let obj = $(id_name);

        let element = document.createElement("span");
        element.textContent = obj.val();
        document.body.appendChild(element);

        if (window.getSelection()) {
            let range = document.createRange();
            range.selectNode(element);
            window.getSelection().removeAllRanges();
            window.getSelection().addRange(range);
            document.execCommand("copy");
            element.remove();
            layer.msg("复制成功", {icon: 1, time: 2000});
        } else {
            layer.msg("浏览器不支持，无法复制！", {icon: 2, time: 2000});
        }
    }

    // 通过标签ID查询链接
    function search_link_by_mark(id) {
        window.location.href = "${ctx}/link/get/mark?markIds=" + id;
    }
</script>
</body>
</html>