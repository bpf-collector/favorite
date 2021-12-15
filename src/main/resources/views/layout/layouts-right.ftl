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

    <div class="main">
        <nav class="navbar navbar-expand navbar-theme">

            <div class="navbar-collapse collapse">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item dropdown active">
                        <a class="nav-link dropdown-toggle position-relative" href="#" id="messagesDropdown"
                           data-toggle="dropdown">
                            <i class="align-middle fas fa-envelope-open"></i>
                        </a>
                        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right py-0"
                             aria-labelledby="messagesDropdown">
                            <div class="dropdown-menu-header">
                                <div class="position-relative">
                                    4 New Messages
                                </div>
                            </div>
                            <div class="list-group">
                                <a href="#" class="list-group-item">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col-2">
                                            <img src="${ctx}/images/avatars/avatar-5.jpg" class="avatar img-fluid rounded-circle"
                                                 alt="Michelle Bilodeau">
                                        </div>
                                        <div class="col-10 pl-2">
                                            <div class="text-dark">Michelle Bilodeau</div>
                                            <div class="text-muted small mt-1">Nam pretium turpis et arcu. Duis arcu
                                                tortor.
                                            </div>
                                            <div class="text-muted small mt-1">5m ago</div>
                                        </div>
                                    </div>
                                </a>
                                <a href="#" class="list-group-item">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col-2">
                                            <img src="${ctx}/images/avatars/avatar-3.jpg" class="avatar img-fluid rounded-circle"
                                                 alt="Kathie Burton">
                                        </div>
                                        <div class="col-10 pl-2">
                                            <div class="text-dark">Kathie Burton</div>
                                            <div class="text-muted small mt-1">Pellentesque auctor neque nec urna.</div>
                                            <div class="text-muted small mt-1">30m ago</div>
                                        </div>
                                    </div>
                                </a>
                                <a href="#" class="list-group-item">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col-2">
                                            <img src="${ctx}/images/avatars/avatar-2.jpg" class="avatar img-fluid rounded-circle"
                                                 alt="Alexander Groves">
                                        </div>
                                        <div class="col-10 pl-2">
                                            <div class="text-dark">Alexander Groves</div>
                                            <div class="text-muted small mt-1">Curabitur ligula sapien euismod vitae.
                                            </div>
                                            <div class="text-muted small mt-1">2h ago</div>
                                        </div>
                                    </div>
                                </a>
                                <a href="#" class="list-group-item">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col-2">
                                            <img src="${ctx}/images/avatars/avatar-4.jpg" class="avatar img-fluid rounded-circle"
                                                 alt="Daisy Seger">
                                        </div>
                                        <div class="col-10 pl-2">
                                            <div class="text-dark">Daisy Seger</div>
                                            <div class="text-muted small mt-1">Aenean tellus metus, bibendum sed,
                                                posuere ac, mattis non.
                                            </div>
                                            <div class="text-muted small mt-1">5h ago</div>
                                        </div>
                                    </div>
                                </a>
                            </div>
                            <div class="dropdown-menu-footer">
                                <a href="#" class="text-muted">Show all messages</a>
                            </div>
                        </div>
                    </li>
                    <li class="nav-item dropdown ml-lg-2">
                        <a class="nav-link dropdown-toggle position-relative" href="#" id="alertsDropdown"
                           data-toggle="dropdown">
                            <i class="align-middle fas fa-bell"></i>
                            <span class="indicator"></span>
                        </a>
                        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right py-0"
                             aria-labelledby="alertsDropdown">
                            <div class="dropdown-menu-header">
                                4 New Notifications
                            </div>
                            <div class="list-group">
                                <a href="#" class="list-group-item">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col-2">
                                            <i class="ml-1 text-danger fas fa-fw fa-bell"></i>
                                        </div>
                                        <div class="col-10">
                                            <div class="text-dark">Update completed</div>
                                            <div class="text-muted small mt-1">Restart server 12 to complete the
                                                update.
                                            </div>
                                            <div class="text-muted small mt-1">2h ago</div>
                                        </div>
                                    </div>
                                </a>
                                <a href="#" class="list-group-item">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col-2">
                                            <i class="ml-1 text-warning fas fa-fw fa-envelope-open"></i>
                                        </div>
                                        <div class="col-10">
                                            <div class="text-dark">Lorem ipsum</div>
                                            <div class="text-muted small mt-1">Aliquam ex eros, imperdiet vulputate
                                                hendrerit et.
                                            </div>
                                            <div class="text-muted small mt-1">6h ago</div>
                                        </div>
                                    </div>
                                </a>
                                <a href="#" class="list-group-item">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col-2">
                                            <i class="ml-1 text-primary fas fa-fw fa-building"></i>
                                        </div>
                                        <div class="col-10">
                                            <div class="text-dark">Login from 192.186.1.1</div>
                                            <div class="text-muted small mt-1">8h ago</div>
                                        </div>
                                    </div>
                                </a>
                                <a href="#" class="list-group-item">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col-2">
                                            <i class="ml-1 text-success fas fa-fw fa-bell-slash"></i>
                                        </div>
                                        <div class="col-10">
                                            <div class="text-dark">New connection</div>
                                            <div class="text-muted small mt-1">Anna accepted your request.</div>
                                            <div class="text-muted small mt-1">12h ago</div>
                                        </div>
                                    </div>
                                </a>
                            </div>
                            <div class="dropdown-menu-footer">
                                <a href="#" class="text-muted">Show all notifications</a>
                            </div>
                        </div>
                    </li>
                    <li class="nav-item dropdown ml-lg-2">
                        <a class="nav-link dropdown-toggle position-relative" href="#" id="userDropdown"
                           data-toggle="dropdown">
                            <i class="align-middle fas fa-cog"></i>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                            <a class="dropdown-item" href="#"><i class="align-middle mr-1 fas fa-fw fa-user"></i> View
                                Profile</a>
                            <a class="dropdown-item" href="#"><i class="align-middle mr-1 fas fa-fw fa-comments"></i>
                                Contacts</a>
                            <a class="dropdown-item" href="#"><i class="align-middle mr-1 fas fa-fw fa-chart-pie"></i>
                                Analytics</a>
                            <a class="dropdown-item" href="#"><i class="align-middle mr-1 fas fa-fw fa-cogs"></i>
                                Settings</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#"><i
                                        class="align-middle mr-1 fas fa-fw fa-arrow-alt-circle-right"></i> Sign out</a>
                        </div>
                    </li>
                </ul>
            </div>

            <a class="sidebar-toggle d-flex ml-2">
                <i class="hamburger align-self-center"></i>
            </a>
        </nav>
        <main class="content">
            <div class="container-fluid">

                <div class="header text-center">
                    <h1 class="header-title">
                        Welcome back, Linda!
                    </h1>
                    <p class="header-subtitle">You have 24 new messages and 5 new notifications.</p>
                </div>

                <div class="row">
                    <div class="col-xl-7">
                        <div class="card flex-fill w-100">
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
                                <h5 class="card-title mb-0">Recent Movement</h5>
                            </div>
                            <div class="card-body py-3">
                                <div class="chart chart-sm">
                                    <canvas id="chartjs-dashboard-line"></canvas>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-xl-5 d-flex">
                        <div class="w-100">
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="card flex-fill bg-primary text-white">
                                        <div class="card-header">
                                            <h5 class="card-title text-white mb-0">Sales Today</h5>
                                        </div>
                                        <div class="card-body py-3">
                                            <div class="row no-gutters">
                                                <div class="col-4 align-self-center text-left">
                                                    <div class="icon icon-primary">
                                                        <i class="align-middle" data-feather="truck"></i>
                                                    </div>
                                                </div>
                                                <div class="col-8 align-self-center text-right">
                                                    <p class="text-white mb-1">Sales Today</p>
                                                    <h2 class="text-white">2562</h2>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card flex-fill bg-danger text-white">
                                        <div class="card-header">
                                            <h5 class="card-title text-white mb-0">Visitors Today</h5>
                                        </div>
                                        <div class="card-body py-3">
                                            <div class="row no-gutters">
                                                <div class="col-4 align-self-center text-left">
                                                    <div class="icon icon-danger">
                                                        <i class="align-middle" data-feather="users"></i>
                                                    </div>
                                                </div>
                                                <div class="col-8 align-self-center text-right">
                                                    <p class="text-white mb-1">Visitors Today</p>
                                                    <h2 class="text-white">17212</h2>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="card flex-fill bg-success text-white">
                                        <div class="card-header">
                                            <h5 class="card-title text-white mb-0">Total Earnings</h5>
                                        </div>
                                        <div class="card-body py-3">
                                            <div class="row no-gutters">
                                                <div class="col-4 align-self-center text-left">
                                                    <div class="icon icon-success">
                                                        <i class="align-middle" data-feather="dollar-sign"></i>
                                                    </div>
                                                </div>
                                                <div class="col-8 align-self-center text-right">
                                                    <p class="text-white mb-1">Total Earnings</p>
                                                    <h2 class="text-white">$24300</h2>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card flex-fill bg-warning text-white">
                                        <div class="card-header">
                                            <h5 class="card-title text-white mb-0">Pending Orders</h5>
                                        </div>
                                        <div class="card-body py-3">
                                            <div class="row no-gutters">
                                                <div class="col-4 align-self-center text-left">
                                                    <div class="icon icon-warning">
                                                        <i class="align-middle" data-feather="shopping-cart"></i>
                                                    </div>
                                                </div>
                                                <div class="col-8 align-self-center text-right">
                                                    <p class="text-white mb-1">Pending Orders</p>
                                                    <h2 class="text-white">43</h2>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-12 col-md-6 col-xxl-3 d-flex order-1 order-xxl-1">
                        <div class="card flex-fill">
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
                                <h5 class="card-title mb-0">Calendar</h5>
                            </div>
                            <div class="card-body d-flex">
                                <div class="align-self-center w-100">
                                    <div class="chart">
                                        <div id="datetimepicker-dashboard"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-12 col-md-12 col-xxl-6 d-flex order-3 order-xxl-2">
                        <div class="card flex-fill w-100">
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
                                <h5 class="card-title mb-0">Current Visitors</h5>
                            </div>
                            <div class="card-body px-4">
                                <div id="world_map" style="height:350px;"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-12 col-md-6 col-xxl-3 d-flex order-2 order-xxl-3">
                        <div class="card flex-fill w-100">
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
                                <h5 class="card-title mb-0">Browser Usage</h5>
                            </div>
                            <div class="card-body d-flex">
                                <div class="align-self-center w-100">
                                    <div class="py-3">
                                        <div class="chart chart-xs">
                                            <canvas id="chartjs-dashboard-pie"></canvas>
                                        </div>
                                    </div>

                                    <table class="table mb-0">
                                        <tbody>
                                        <tr>
                                            <td><i class="fas fa-square-full text-primary"></i> Chrome</td>
                                            <td class="text-right">4401</td>
                                        </tr>
                                        <tr>
                                            <td><i class="fas fa-square-full text-warning"></i> Firefox</td>
                                            <td class="text-right">4003</td>
                                        </tr>
                                        <tr>
                                            <td><i class="fas fa-square-full text-danger"></i> IE</td>
                                            <td class="text-right">1589</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-12 col-lg-8 col-xxl-9 d-flex">
                        <div class="card flex-fill">
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
                                <h5 class="card-title mb-0">Top Selling Products</h5>
                            </div>
                            <table id="datatables-dashboard" class="table table-striped my-0">
                                <thead>
                                <tr>
                                    <th>Name</th>
                                    <th class="d-none d-xl-table-cell">License</th>
                                    <th class="d-none d-xl-table-cell">Technology</th>
                                    <th class="d-none d-xl-table-cell">Tickets</th>
                                    <th>Sales</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>AppStack</td>
                                    <td class="d-none d-xl-table-cell">Single license</td>
                                    <td><span class="badge badge-success">HTML</span></td>
                                    <td class="d-none d-xl-table-cell">50</td>
                                    <td class="d-none d-xl-table-cell">720</td>
                                </tr>
                                <tr>
                                    <td>Spark</td>
                                    <td class="d-none d-xl-table-cell">Single license</td>
                                    <td><span class="badge badge-danger">Angular</span></td>
                                    <td class="d-none d-xl-table-cell">20</td>
                                    <td class="d-none d-xl-table-cell">540</td>
                                </tr>
                                <tr>
                                    <td>Milo</td>
                                    <td class="d-none d-xl-table-cell">Single license</td>
                                    <td><span class="badge badge-warning">React</span></td>
                                    <td class="d-none d-xl-table-cell">40</td>
                                    <td class="d-none d-xl-table-cell">280</td>
                                </tr>
                                <tr>
                                    <td>Ada</td>
                                    <td class="d-none d-xl-table-cell">Single license</td>
                                    <td><span class="badge badge-info">Vue</span></td>
                                    <td class="d-none d-xl-table-cell">60</td>
                                    <td class="d-none d-xl-table-cell">610</td>
                                </tr>
                                <tr>
                                    <td>Abel</td>
                                    <td class="d-none d-xl-table-cell">Single license</td>
                                    <td><span class="badge badge-danger">Angular</span></td>
                                    <td class="d-none d-xl-table-cell">80</td>
                                    <td class="d-none d-xl-table-cell">150</td>
                                </tr>
                                <tr>
                                    <td>Spark</td>
                                    <td class="d-none d-xl-table-cell">Single license</td>
                                    <td><span class="badge badge-success">HTML</span></td>
                                    <td class="d-none d-xl-table-cell">20</td>
                                    <td class="d-none d-xl-table-cell">480</td>
                                </tr>
                                <tr>
                                    <td>Libre</td>
                                    <td class="d-none d-xl-table-cell">Single license</td>
                                    <td><span class="badge badge-warning">React</span></td>
                                    <td class="d-none d-xl-table-cell">30</td>
                                    <td class="d-none d-xl-table-cell">280</td>
                                </tr>
                                <tr>
                                    <td>Von</td>
                                    <td class="d-none d-xl-table-cell">Single license</td>
                                    <td><span class="badge badge-danger">Angular</span></td>
                                    <td class="d-none d-xl-table-cell">50</td>
                                    <td class="d-none d-xl-table-cell">350</td>
                                </tr>
                                <tr>
                                    <td>Material Blog</td>
                                    <td class="d-none d-xl-table-cell">Single license</td>
                                    <td><span class="badge badge-info">Vue</span></td>
                                    <td class="d-none d-xl-table-cell">10</td>
                                    <td class="d-none d-xl-table-cell">480</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="col-12 col-lg-4 col-xxl-3 d-flex">
                        <div class="card flex-fill w-100">
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
                                <h5 class="card-title mb-0">Monthly Sales</h5>
                            </div>
                            <div class="card-body d-flex w-100">
                                <div class="align-self-center chart chart-lg">
                                    <canvas id="chartjs-dashboard-bar"></canvas>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </main>
        <#include "../common/footer.ftl">
    </div>

    <nav id="sidebar" class="sidebar sidebar-right">
        <#include "../common/sidebar-nav.ftl">
    </nav>
</div>

<script src="${ctx}/js/app.js"></script>

<script>
    $(function () {
        // Line chart
        new Chart(document.getElementById("chartjs-dashboard-line"), {
            type: 'line',
            data: {
                labels: ["Jan", "", "Feb", "", "Mar", "", "Apr", "", "May", "", "Jun", "", "Jul", "", "Aug", "", "Sep", "", "Oct", "", "Nov", "", "Dec", ""],
                datasets: [{
                    label: "Sales ($)",
                    fill: true,
                    backgroundColor: "transparent",
                    borderColor: window.theme.primary,
                    data: [6, 7, 8, 11, 9, 11, 8, 14, 12, 16, 9, 10, 14, 15, 9, 12, 16, 17, 22, 18, 24, 32, 31, 36]
                }, {
                    label: "Orders",
                    fill: true,
                    backgroundColor: "transparent",
                    borderColor: window.theme.tertiary,
                    borderDash: [4, 4],
                    data: [3, 5, 4, 9, 5, 8, 5, 6, 4, 7, 4, 3, 4, 6, 4, 7, 12, 12, 18, 15, 20, 25, 22, 25]
                }]
            },
            options: {
                maintainAspectRatio: false,
                legend: {
                    display: false
                },
                tooltips: {
                    intersect: false
                },
                hover: {
                    intersect: true
                },
                plugins: {
                    filler: {
                        propagate: false
                    }
                },
                scales: {
                    xAxes: [{
                        reverse: true,
                        gridLines: {
                            color: "rgba(0,0,0,0.0)"
                        }
                    }],
                    yAxes: [{
                        ticks: {
                            stepSize: 5
                        },
                        display: true,
                        borderDash: [5, 5],
                        gridLines: {
                            color: "rgba(0,0,0,0)",
                            fontColor: "#fff"
                        }
                    }]
                }
            }
        });
    });
</script>
<script>
    $(function () {
        // Pie chart
        new Chart(document.getElementById("chartjs-dashboard-pie"), {
            type: 'pie',
            data: {
                labels: ["Chrome", "Firefox", "IE", "Other"],
                datasets: [{
                    data: [4401, 4003, 1589],
                    backgroundColor: [
                        window.theme.primary,
                        window.theme.warning,
                        window.theme.danger,
                        "#E8EAED"
                    ],
                    borderColor: "transparent"
                }]
            },
            options: {
                responsive: !window.MSInputMethodContext,
                maintainAspectRatio: false,
                legend: {
                    display: false
                },
                cutoutPercentage: 60
            }
        });
    });
</script>
<script>
    $(function () {
        // Bar chart
        new Chart(document.getElementById("chartjs-dashboard-bar"), {
            type: 'bar',
            data: {
                labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
                datasets: [{
                    label: "Last year",
                    backgroundColor: window.theme.primary,
                    borderColor: window.theme.primary,
                    hoverBackgroundColor: window.theme.primary,
                    hoverBorderColor: window.theme.primary,
                    data: [54, 67, 41, 55, 62, 45, 55, 73, 60, 76, 48, 79]
                }, {
                    label: "This year",
                    backgroundColor: "#E8EAED",
                    borderColor: "#E8EAED",
                    hoverBackgroundColor: "#E8EAED",
                    hoverBorderColor: "#E8EAED",
                    data: [69, 66, 24, 48, 52, 51, 44, 53, 62, 79, 51, 68]
                }]
            },
            options: {
                maintainAspectRatio: false,
                legend: {
                    display: false
                },
                scales: {
                    yAxes: [{
                        gridLines: {
                            display: false
                        },
                        stacked: false,
                        ticks: {
                            stepSize: 20
                        }
                    }],
                    xAxes: [{
                        barPercentage: .75,
                        categoryPercentage: .5,
                        stacked: false,
                        gridLines: {
                            color: "transparent"
                        }
                    }]
                }
            }
        });
    });
</script>
<script>
    $(function () {
        var mapData = {
            "US": 298,
            "SA": 200,
            "DE": 220,
            "FR": 540,
            "CN": 120,
            "AU": 760,
            "BR": 550,
            "IN": 200,
            "GB": 120,
        };
        $('#world_map').vectorMap({
            map: 'world_mill',
            backgroundColor: "transparent",
            zoomOnScroll: false,
            regionStyle: {
                initial: {
                    fill: '#e4e4e4',
                    "fill-opacity": 0.9,
                    stroke: 'none',
                    "stroke-width": 0,
                    "stroke-opacity": 0
                }
            },
            series: {
                regions: [{
                    values: mapData,
                    scale: [window.theme.primary],
                    normalizeFunction: 'polynomial'
                }]
            },
        });
        setTimeout(function () {
            $(window).trigger('resize');
        }, 250)
    })
</script>
<script>
    $(function () {
        $('#datatables-dashboard').DataTable({
            pageLength: 6,
            lengthChange: false,
            bFilter: false,
            autoWidth: false
        });
    });
</script>
<script>
    $(function () {
        $('#datetimepicker-dashboard').datetimepicker({
            inline: true,
            sideBySide: false,
            format: 'L'
        });
    });
</script>
</body>

</html>