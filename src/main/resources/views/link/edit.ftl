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
                        <h1 class="h2">Update Link</h1>
                        <p class="lead">
                            Enter your new link.
                        </p>
                    </div>

                    <div class="card">
                        <div class="card-body">
                            <div class="m-sm-4">
                                <form>
                                    <input type="hidden" name="id" id="link-id" value="${link.id}">
                                    <div class="form-group">
                                        <label>Link Name</label>
                                        <input class="form-control form-control-lg" type="text" name="name" id="link-name"
                                               placeholder="Enter your new link name" value="${link.name}"/>
                                    </div>
                                    <div class="form-group">
                                        <label>Link URL</label>
                                        <input class="form-control form-control-lg" type="url" name="url" id="link-url"
                                               placeholder="Enter your new link url" value="${link.url}"/>
                                    </div>
                                    <div class="form-group">
                                        <label>Link Mark</label>
                                        <div>
                                            <#if user.marks?? && (user.marks?size > 0)>
                                                <#list user.marks as mark>
                                                    <label class="form-check">
                                                        <input class="form-check-input" type="checkbox" name="marks"
                                                               value="${mark.id}"
                                                               ${link_mark_ids?seq_contains(mark.id)?string('checked', '')}>
                                                        <span class="form-check-label">${mark.name}</span>
                                                    </label>
                                                </#list>
                                            <#else>
                                                <label class="form-check">
                                                    <input class="form-check-input" type="checkbox" value="" disabled>
                                                    <span class="form-check-label">Nothing</span>
                                                </label>
                                            </#if>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>Link Comment</label>
                                        <textarea class="form-control form-control-lg" rows="2" id="link-comment"
                                                  placeholder="Enter your new link comment">${link.comment!''}</textarea>
                                    </div>


                                    <div class="text-center mt-3">
                                        <input class="btn btn-lg btn-primary" type="button" onClick="add_link()" value="Update Link"
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
    function add_link() {
        let chk_marks = [];
        $("input[name='marks']:checked").each(function () {
            chk_marks.push($(this).val());
        })

        $.ajax({
            url: "${ctx}/link/update",
            type: "POST",
            data: {
                id: $("#link-id").val(),
                name: $("#link-name").val(),
                url: $("#link-url").val(),
                comment: $("#link-comment").val(),
                "markIds": chk_marks.toString()
            }, success: function (result) {
                if (result.accessCode == 200 && result.processCode == 400) {
                    layer.msg(result.ext.msg, {icon: 1, time: 2000});
                    window.location.href = "${ctx}/user/get/${user.id}?target=link/list";
                } else if (result.accessCode == 200 && result.processCode == 500) {
                    layer.alert(result.ext.reason, {icon: 2, time: 2000});
                }
            }, error: function() {
                layer.alert('?????????????????????????????????', {icon: 2, time: 2000});
            }
        });
    }
</script>
</body>

</html>