<nav class="navbar navbar-expand navbar-theme">
    <a class="sidebar-toggle d-flex mr-2">
        <i class="hamburger align-self-center"></i>
    </a>

    <div class="navbar-collapse collapse">
        <ul class="navbar-nav ml-auto">
            <#--邮件通知-->
            <li class="nav-item dropdown active">
                <a class="nav-link dropdown-toggle position-relative" href="#" id="messagesDropdown"
                   data-toggle="dropdown">
                    <i class="align-middle fas fa-envelope-open"></i>
                </a>
                <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right py-0"
                     aria-labelledby="messagesDropdown">
                    <div class="dropdown-menu-header">
                        <div class="position-relative">
                            No Messages
                        </div>
                    </div>
                    <div class="list-group">

                    </div>
                    <div class="dropdown-menu-footer">
                        <a href="#" class="text-muted">No messages</a>
                    </div>
                </div>
            </li>

            <#--消息通知-->
            <li class="nav-item dropdown ml-lg-2">
                <a class="nav-link dropdown-toggle position-relative" href="#" id="alertsDropdown"
                   data-toggle="dropdown">
                    <i class="align-middle fas fa-bell"></i>
                    <span class="indicator"></span>
                </a>
                <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right py-0"
                     aria-labelledby="alertsDropdown">
                    <div class="dropdown-menu-header">
                        No Notifications
                    </div>
                    <div class="list-group">

                    </div>
                    <div class="dropdown-menu-footer">
                        <a href="#" class="text-muted">No notifications</a>
                    </div>
                </div>
            </li>

            <#--设置-->
            <li class="nav-item dropdown ml-lg-2">
                <a class="nav-link dropdown-toggle position-relative" href="#" id="userDropdown"
                   data-toggle="dropdown">
                    <i class="align-middle fas fa-cog"></i>
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                    <a class="dropdown-item" href="${ctx}/user/profile"><i class="align-middle mr-1 fas fa-fw fa-user"></i>Profile</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="javascript:void(0)" onclick="logout()"><i
                                class="align-middle mr-1 fas fa-fw fa-arrow-alt-circle-right"></i> Sign out</a>
                </div>
            </li>
        </ul>
    </div>

</nav>

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