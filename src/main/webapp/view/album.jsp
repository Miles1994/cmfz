<%--suppress ALL --%>
<%@page pageEncoding="UTF-8" %>
<script type="text/javascript">

    var toolbar = [{
        iconCls: 'icon-add',
        text: "专辑详情",
        handler: function () {
            var node = $("#album").treegrid("getSelected");
            if (node != null) {
                //初始化专辑详情对话框
                $("#detail").dialog({
                    title: "专辑详情",
                    href: "${pageContext.request.contextPath}/detail.jsp?id=" + node.id,
                    width: 500,
                    height: 300,
                    cache: true,
                    modal: true
                });
            }
        }
    }, '-', {
        text: "添加专辑",
        iconCls: 'icon-edit',
        handler: function () {
            //打开添加专辑对话框
            $("#add").dialog({
                title: "专辑添加",
                href: "${pageContext.request.contextPath}/add.jsp",
                width: 500,
                height: 300,
                cache: true,
                modal: true
            });

        }
    }, '-', {
        text: "添加音频",
        iconCls: 'icon-remove',
        handler: function () {
            //获取选中行
            var row = $("#album").treegrid("getSelected");
            console.log(row);
            if (row != null) {
                //打开添加音频对话框
                $("#voice").dialog({
                    title: "音频添加",
                    width: 500,
                    height: 300,
                    cache: true,
                    modal: true,
                    href: "${pageContext.request.contextPath}/addvoice.jsp?id=" + row.id
                });
            } else {
                alert("请先选中行")
            }
        }
    }, '-', {
        text: "音频下载",
        iconCls: 'icon-save',
        handler: function () {
            $("#dg").edatagrid("saveRow")

        }
    }];
    $(function () {
        $("#album").treegrid({
            url: '${pageContext.request.contextPath}/alu/queryAlbum',
            idField: "id",
            treeField: "title",
            columns: [[
                {field: 'title', title: '名字', width: 60},
                {field: 'duration', title: '时长', width: 80},
                {field: 'size', title: '大小', width: 80}
            ]],
            fit: true,
            fitColumns: true,
            toolbar: toolbar,
        });


    });

</script>

<table id="album"></table>
<div id="detail"></div>
<div id="add"></div>
<div id="voice"></div>