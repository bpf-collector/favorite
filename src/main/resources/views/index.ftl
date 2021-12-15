<!DOCTYPE html>
<html lang="en">

<head>
    <#include "common/head.ftl">
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
        <#include "common/sidebar-nav.ftl">
    </nav>

    <div class="main">
        <#--顶部导航栏-->
        <#include "common/top-nav.ftl">

        <main class="content">
            <div class="container-fluid">

                <div class="header text-center">
                    <h1 class="header-title">
                        Welcome back, ${user.name!''}!
                    </h1>
                    <#--<p class="header-subtitle">You have 24 new messages and 5 new notifications.</p>-->
                </div>

                <div class="row">
                    <div class="col-xxl-3">
                        <div class="card">
                            <div class="card-header">
                                <div class="card-actions float-right">
                                    <a href="javascript:void(0)" class="mr-1">
                                        <i class="align-middle" data-feather="refresh-cw"></i>
                                    </a>
                                    <div class="d-inline-block dropdown show">
                                        <a href="javascript:void(0)" data-toggle="dropdown" data-display="static">
                                            <i class="align-middle" data-feather="more-vertical"></i>
                                        </a>

                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a class="dropdown-item" href="javascript:void(0)">Action</a>
                                        </div>
                                    </div>
                                </div>
                                <h5 class="card-title mb-0">About Me</h5>
                            </div>

                            <div class="card-body">
                                <div class="row no-gutters">
                                    <div class="col-sm-3 col-xl-12 col-xxl-4 text-center">
                                        <img src="${ctx}/images/favicon.ico" width="64" height="64" class="rounded-circle mt-2" alt="Angelica Ramos">
                                    </div>
                                    <div class="col-sm-9 col-xl-12 col-xxl-8">
                                        <strong>Favorite</strong>
                                        <p>这是一个基于标签分类的网站收藏夹，每个网址 <span class="badge badge-success">Link</span>
                                            都可以被标记上标签 <span class="badge badge-success">Mark</span>，并且可以通过标签查找对应的网址。快来试试看吧！</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


            </div>
        </main>
        <#include "common/footer.ftl">
    </div>

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