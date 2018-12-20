<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/IconExtension.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/icon.css">
<script type="text/javascript">
    $(function () {
        //工具栏按钮
        var toolbar = [{
            iconCls: 'icon-add',
            text: "添加",
            onClick: function () {
                $("#dialog").dialog("open");
            }
        }, '-', {
            text: "修改",
            iconCls: 'icon-edit',
            handler: function () {
                //获取选中行
                var row = $("#dg").edatagrid("getSelected");
                if (row != null) {
                    //编辑指定行
                    var index = $("#dg").edatagrid("getRowIndex", row);
                    $("#dg").edatagrid("editRow", index);
                } else {
                    alert("请先选中行")
                }


            }
        }, '-', {
            text: "删除",
            iconCls: 'icon-reload',
            handler: function () {
                var i = $("#dg").edatagrid("getSelected");
                if (i != null) {
                    $("#dg").edatagrid("destroyRow");
                }
            }
        }, '-', {
            text: "保存",
            iconCls: 'icon-save',
            handler: function () {
                $("#dg").edatagrid("saveRow")
            }
        }, '-', {
            text: "刷新",
            iconCls: 'icon-20130406015709810_easyicon_net_16',
            handler: function () {
                $("#dg").edatagrid("load")
            }
        }];

        //初始化可编辑数据表
        $("#dg").edatagrid({
            fitColumns: true,
            fit: true,
            singleSelect: false,
            pagination: true,
            pageList: [1, 3, 5, 7, 9],
            pageSize: 3,
            url: "${pageContext.request.contextPath}/ban/queryByPage",
            updateUrl: "${pageContext.request.contextPath}/ban/update",
            destroyUrl: "${pageContext.request.contextPath}/ban/delete",
            columns: [[
                {
                    field: "name", title: "名称",
                    width: 200
                }, {
                    field: "status", title: "状态", width: 200, editor: {
                        type: "text",
                        options: {required: true}
                    }
                }, {
                    field: "pub_date", title: "时间", width: 200
                }
            ]],

            toolbar: toolbar,
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/image/' + rowData.img_path + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>描述: ' + rowData.description + '</p>' +
                    '<p>日期: ' + rowData.pub_date + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        });
        //初始化添加对话框
        $("#dialog").dialog({
            title: "添加图片",
            width: 400,
            hetght: 300,
            closed: true,
            href: "${pageContext.request.contextPath}/dialog.jsp",
            modal: true,
            cache: false
        });


    });

</script>


<table id="dg"></table>
<div id="dialog"></div>