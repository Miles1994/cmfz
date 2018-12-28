<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<script type="text/javascript" src="${pageContext.request.contextPath }/js/echarts.min.js"></script>

<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="statistics_main" style="width: 600px;height: 400px;;margin-top: 30px;margin-left: 30px"></div>

<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('statistics_main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '持名法州App活跃用户'
        },
        tooltip: {},
        legend: {
            data: ["男","女"]
        },
        xAxis: {
            data: [],
            width:20
        },
        yAxis: {},
        series: [{
            name: '数量',
            type: 'bar',
            data: [],
            barWidth: 40
        }]
    };

    myChart.setOption(option);

    $.post("${pageContext.request.contextPath }/us/date","sex=男", function (data) {
        console.log(data);
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption({
            xAxis: {
                data: ["7天","15天","30天","60天"]
            },
            series: [{
                // 根据名字对应到相应的系列
                name: '活跃用户',
                data: data
            }]
        });
    }, "json");


</script>

