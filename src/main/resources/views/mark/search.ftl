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
                        <h1 class="h2">Search Link</h1>
                        <p class="lead">
                            Select the marks what you want to search.
                        </p>
                    </div>

                    <div class="card">
                        <div class="card-body">
                            <div class="m-sm-4">
                                <form>
                                    <div class="form-group">
                                        <label>Marks</label>
                                        <div>
                                            <#if user.marks?? && (user.marks?size > 0)>
                                                <#list user.marks as mark>
                                                    <label class="form-check">
                                                        <input class="form-check-input" type="checkbox" name="marks"
                                                               value="${mark.id}">
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

                                    <div class="text-center mt-3">
                                        <input class="btn btn-lg btn-primary" type="button" onClick="search_link_by_marks()" value="Search Link"
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
    function search_link_by_marks() {
        let chk_marks = [];
        $("input[name='marks']:checked").each(function () {
            chk_marks.push($(this).val());
        })

        window.location.href = "${ctx}/link/get/mark?markIds=" + chk_marks.toString();
    }
</script>
</body>

</html>