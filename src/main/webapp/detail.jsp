<%--suppress ALL --%>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-12-21
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $.get("${pageContext.request.contextPath}/alu/queryOne", "id=${param.id}", function (data) {
        $("#d_form").form("load", data);
        $("#coverImg").prop("src", "${pageContext.request.contextPath}/image/album/" + data.cover_img)
    });
</script>
<form id="d_form">
    <table>
        <tr>
            <td>封面：</td>
            <td>
                <img id="coverImg" style="height: 50px"/>
            </td>
        </tr>
        <tr>
            <td>名称：</td>
            <td><input type="text" name="title" disabled="disabled"/></td>
        </tr>
        <tr>
            <td>集数：</td>
            <td><input type="text" name="count" disabled="disabled"/></td>
        </tr>
        <tr>
            <td>评分：</td>
            <td><input type="text" name="score" disabled="disabled"/></td>
        </tr>

        <tr>
            <td>作者：</td>
            <td><input type="text" name="author" disabled="disabled"/></td>
        </tr>

        <tr>
            <td>播音：</td>
            <td><input type="text" name="voicer" disabled="disabled"/></td>
        </tr>

        <tr>
            <td>简介：</td>
            <td><input type="text" name="introduction" disabled="disabled"/></td>
        </tr>

        <tr>
            <td>上传时间：</td>
            <td><input type="date" name="pub_date" disabled="disabled"/></td>
        </tr>

    </table>
</form>
