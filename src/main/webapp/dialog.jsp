<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-12-20
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>

<script type="text/javascript">
    $(function () {
        $("#sub").click(function () {
            $("#form").form("submit", {
                url: "${pageContext.request.contextPath}/ban/add",
                onSubmit: function () {
                    return true;
                },
                success: function () {
                    $("#dialog").dialog("close");
                    $.messager.show({
                        title: "系统提示",
                        msg: "添加成功"
                    });
                    $("#dg").edatagrid("load");
                }
            });
        });
    });
</script>


<form action="#" method="post" enctype="multipart/form-data" id="form">
    <table>
        <tr>
            <td>图片标题</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>描述</td>
            <td><input type="text" name="description"></td>
        </tr>
        <tr>
        <tr>
            <td>文件</td>
            <td><input type="file" name="file"></td>
        </tr>
        <tr>
            <td><input type="button" value="submit" id="sub"></td>
        </tr>
    </table>
</form>
