<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<script src="http://cdn-hangzhou.goeasy.io/goeasy.js"></script>
<script type="text/javascript">
    var goEasy = new GoEasy({
        appkey:"BC-e7f30516a3d540fbae7de5a03c654ee4"
    });

    goEasy.subscribe({
        channel:"goEasy",
        onMessage:function (message) {
            alert(message.channel+"|||"+message.content);
        }
    });

</script>
<html>
<head>
    <title>Title</title>
</head>
<body>
</body>
</html>
