<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-12-21
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function () {
        $("#subVoice").click(function () {
            $("#chapter").form("submit", {
                url: "${pageContext.request.contextPath}/ch/addChapter?aid=" + "${param.id}",
                success: function () {
                    $.messager.show({
                        title: "系统提示",
                        msg: "添加成功"
                    });
                    $("#voice").dialog("close");
                    $("#album").treegrid("load");
                }
            });
        });
    });

</script>
<form id="chapter" enctype="multipart/form-data" method="post">
    <table>
        <tr>
            <td>文件名称：</td>
            <td><input type="text" name="title"/></td>
        </tr>
        <tr>
            <td>文件上传：</td>
            <td><input type="file" name="file"/></td>
        </tr>
        <tr>
            <td><input type="button" value="提交" id="subVoice"/></td>
        </tr>

    </table>
</form>