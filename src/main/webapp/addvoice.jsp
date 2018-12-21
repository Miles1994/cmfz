<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-12-21
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">


</script>
<form id="chapter" enctype="multipart/form-data" method="post">
    <table>
        <tr>
            <td>章节名称：</td>
            <td><input type="text" name="title"/></td>
        </tr>
        <tr>
            <td>文件大小</td>
            <td><input type="text" name="size"/></td>
        </tr>
        <tr>
            <td>时长：</td>
            <td><input type="text" name="duration"/></td>
        </tr>
        <tr>
            <td>文件上传：</td>
            <td><input type="file" name="file"/></td>
        </tr>

    </table>
</form>