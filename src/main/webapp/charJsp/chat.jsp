<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="http://cdn-hangzhou.goeasy.io/goeasy.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript">
    var goEasy = new GoEasy({
        appkey: "BC-e7f30516a3d540fbae7de5a03c654ee4"
    });
    goEasy.subscribe({
        channel: "myChannel",
        onMessage: function (data) {
            $("#span").append(data.content+"</br>");
        }
    });
    $(function () {
        $("#send").click(function () {
            var chat = $("#text").val();
            $.post("${pageContext.request.contextPath}/chat/we", "chat=" + chat);
            $("#text").val("");
        })
    });
</script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="chat" style=" margin: 30px auto; height: 500px;width: 500px; background-color: #00bbee">
    <input type="text" align="center" id="text">
    <input type="button" value="发送" id="send">
    <span id="span"></span>
</div>

</body>
</html>
