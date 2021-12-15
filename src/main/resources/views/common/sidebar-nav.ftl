<#--<nav id="sidebar" class="sidebar">-->
    <a class="sidebar-brand" href="${ctx}">
        <svg>
            <use xlink:href="#ion-ios-pulse-strong"></use>
        </svg>
        Favorite
    </a>
    <div class="sidebar-content">
        <div class="sidebar-user">
            <a href="${ctx}/user/profile">
                <img src="${ctx}/images/avatars/avatar.jpg" class="img-fluid rounded-circle mb-2"
                     alt="${user.name!''}"/>
            </a>
            <div class="font-weight-bold" style="font-size: 26px;">${user.name!''}</div>
            <#if user.authority == 1>
                <small>普通用户</small>
            <#elseif user.authority == 2>
                <small>管理员</small>
            </#if>
        </div>

        <ul class="sidebar-nav">
            <li class="sidebar-header">
                Main
            </li>
            <li class="sidebar-item">
                <a class="sidebar-link" href="${ctx}/index" title="首页">
                    <i class="align-middle mr-2 fas fa-fw fa-home"></i> <span class="align-middle">Dashboard</span>
                </a>
            </li>
            <li class="sidebar-item">
                <a href="#auth" data-toggle="collapse" class="sidebar-link collapsed">
                    <i class="align-middle mr-2 fas fa-fw fa-sign-in-alt"></i> <span class="align-middle">Auth</span>
                </a>
                <ul id="auth" class="sidebar-dropdown list-unstyled collapse" data-parent="#sidebar">
                    <li class="sidebar-item"><a class="sidebar-link" href="${ctx}/user/profile" title="查看个人信息">Profile</a></li>
                    <li class="sidebar-item"><a class="sidebar-link" type="button" onclick="logout()" title="退出登录">Logout</a></li>
                </ul>
            </li>
            <li class="sidebar-item">
                <a href="#pages" data-toggle="collapse" class="sidebar-link collapsed">
                    <i class="align-middle mr-2 fas fa-fw fa-file"></i> <span class="align-middle">Pages</span>
                </a>
                <ul id="pages" class="sidebar-dropdown list-unstyled collapse show" data-parent="#sidebar">
                    <li class="sidebar-item">
                        <a class="sidebar-link" href="${ctx}/user/get/${user.id}?target=mark/list" title="查看所有标签">All Mark</a>
                    </li>
                    <li class="sidebar-item">
                        <a class="sidebar-link" href="${ctx}/mark/add" title="添加标签">Add Mark</a>
                    </li>
                    <li class="sidebar-item">
                        <a class="sidebar-link" href="${ctx}/user/get/${user.id}?target=link/list" title="查看所有链接">All Link</a>
                    </li>
                    <li class="sidebar-item">
                        <a class="sidebar-link" href="${ctx}/user/get/${user.id}?target=link/add" title="添加链接">Add Link</a>
                    </li>
                    <li class="sidebar-item">
                        <a class="sidebar-link" href="${ctx}/link/search" title="按照标签查询链接">Search Link</a>
                    </li>
                </ul>
            </li>

            <li class="sidebar-header">
                Extras
            </li>
            <li class="sidebar-item">
                <a href="#layouts" data-toggle="collapse" class="sidebar-link collapsed">
                    <i class="align-middle mr-2 fas fa-fw fa-desktop"></i> <span class="align-middle">Layouts</span>
                </a>
                <ul id="layouts" class="sidebar-dropdown list-unstyled collapse " data-parent="#sidebar">
                    <li class="sidebar-item"><a class="sidebar-link" href="${ctx}/index">Left
                            Sidebar</a></li>
                    <li class="sidebar-item"><a class="sidebar-link" href="${ctx}/lay_right">Right
                            Sidebar</a></li>
                </ul>
            </li>
        </ul>
    </div>
<#--</nav>-->

<script type="text/javascript">
    function logout() {
        $.ajax({
            url: "${ctx}/user/logout",
            type: "GET",
            success: function (result) {
                if (result.accessCode == 200 && result.processCode == 400) {
                    layer.msg(result.ext.msg, {icon: 1, time: 2000});
                    window.location.href = "${ctx}/login";
                } else if (result.accessCode == 200 && result.processCode == 500) {
                    layer.alert(result.ext.reason, {icon: 2, time: 2000});
                }
            },
        });
    }
</script>