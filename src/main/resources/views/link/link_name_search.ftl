<div id="datatables-clients_wrapper" class="dataTables_wrapper">
    <div class="row">
        <div class="col-sm-12 col-md-6"></div>
        <div class="col-sm-12 col-md-5">
            <div id="datatables-clients_filter" class="dataTables_filter">
                <input type="search" class="form-control form-control-sm" name="link_name_search"
                       placeholder="Search Link Name" id="link-search">
                <button class="btn btn-sm btn-primary" onclick="search_link()">Search</button>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    function search_link() {
        let search_name = $("#link-search").val();
        if (search_name == null || search_name == '') {
            layer.msg("查询名称不能为空", {icon: 2, time: 2000});
            return false;
        }
        window.location.href = "${ctx}/link/get/name/" + $("#link-search").val();
    }
</script>