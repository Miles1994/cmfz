<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function () {
        //工具栏按钮
        var toolbar = [{
            iconCls: 'icon-add',
            text: "添加",
            handler: function () {
                alert('编辑按钮')
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
            iconCls: 'icon-remove',
            handler: function () {
                alert('帮助按钮')
            }
        }, '-', {
            text: "保存",
            iconCls: 'icon-save',
            handler: function () {
                $("#dg").edatagrid("saveRow")

            }
        }];


        $("#dg").edatagrid({
            method: "GET",
            fitColumns: true,
            fit: true,
            updateUrl: "${pageContext.request.contextPath}/ban/update",
            url: "${pageContext.request.contextPath}/ban/queryByPage",
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
            pagination: true,
            pageList: [1, 3, 5, 7, 9],
            pageSize: 3,
            toolbar: toolbar,
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/img/' + rowData.img_path + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>描述: ' + rowData.description + '</p>' +
                    '<p>日期: ' + rowData.pub_date + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        });
    });

</script>


<table id="dg"></table>