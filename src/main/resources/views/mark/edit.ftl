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
<!-- SET YOUR THEME -->

<body class="theme-blue">
<div class="splash active">
    <div class="splash-icon"></div>
</div>

<main class="main h-100 w-100">
    <div class="container h-100">
        <div class="row h-100">
            <div class="col-sm-10 col-md-8 col-lg-6 mx-auto d-table h-100">
                <div class="d-table-cell align-middle">

                    <div class="text-center mt-4">
                        <h1 class="h2">Update Mark</h1>
                        <p class="lead">
                            Enter your new mark name.
                        </p>
                    </div>

                    <div class="card">
                        <div class="card-body">
                            <div class="m-sm-4">
                                <form>
                                    <div class="form-group">
                                        <label>Mark Name</label>
                                        <input class="form-control form-control-lg" type="text" name="name" id="mark-name"
                                               placeholder="Enter your new mark name" value="${mark.name!''}"/>
                                    </div>
                                    <div class="text-center mt-3">
                                        <input class="btn btn-lg btn-primary" type="button" onClick="update_mark('${mark.id}')" value="Update Mark"
                                               style="color:white;"/>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</main>

<script src="${ctx}/js/app.js"></script>
<script type="text/javascript">
    function update_mark(id) {
        let mark_name = $("#mark-name").val();
        if (mark_name == null || mark_name == "") {
            layer.alert("标签名称不能为空", {icon: 2, time: 2000});
            return false;
        }

        $.ajax({
            url: "${ctx}/mark/update/" + id,
            type: "POST",
            data: {
                ame: $("#mark-name").val()
            }, success: function (result) {
                if (result.accessCode == 200 && result.processCode == 400) {
                    layer.msg(result.ext.msg, {icon: 1, time: 2000});
                    window.location.href = "${ctx}/user/get/${user.id}?target=mark/list";
                } else if (result.accessCode == 200 && result.processCode == 500) {
                    layer.alert(result.ext.reason, {icon: 2, time: 2000});
                }
            }, error: function() {
                layer.alert('系统错误，请稍后再试！', {icon: 2, time: 2000});
            }
        });
    }
</script>
</body>

</html>