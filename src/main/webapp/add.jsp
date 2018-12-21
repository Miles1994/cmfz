<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-12-21
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function () {

        $("#sub1").click(function () {
            $("#a_form").form("submit", {
                url: "${pageContext.request.contextPath}/alu/add",
                success: function () {
                    $.messager.show({
                        title: "系统提示",
                        msg: "添加成功"
                    });
                    $("#add").dialog("close");
                    $("#album").treegrid("load");
                }
            });
        });
    });


</script>


<form id="a_form" enctype="multipart/form-data" method="post">
    <table>
        <tr>
            <td>专辑标题：</td>
            <td><input type="text" name="title"/></td>
        </tr>
        <tr>
            <td>图片：</td>
            <td><input type="file" name="file"/></td>
        </tr>
        <tr>
            <td>评分：</td>
            <td><input type="text" name="score"/></td>
        </tr>
        <tr>
            <td>作者：</td>
            <td><input type="text" name="author"/></td>
        </tr>
        <tr>
            <td>播音：</td>
            <td><input type="text" name="voicer"/></td>
        </tr>
        <tr>
            <td>简介：</td>
            <td><input type="text" name="introduction"/></td>
        </tr>
        <tr>
            <td><input type="button" value="提交" id="sub1"/></td>
        </tr>
    </table>

</form>
