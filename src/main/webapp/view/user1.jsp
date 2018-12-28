<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<script src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
<script src="${pageContext.request.contextPath}/js/china.js"></script>
<script type="text/javascript">
    var chart = echarts.init(document.getElementById("map"));

    option = {
        title : {
            text: '持明法洲用户分布图',
            subtext: '2017-2018',
            left: 'center'
        },
        tooltip : {
            trigger: 'item'
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data:["男","女"]
        },
        visualMap: {
            min: 0,
            max: 2500,
            left: 'left',
            top: 'bottom',
            text:['高','低'],           // 文本，默认为数值文本
            calculable : true
        },
        toolbox: {
            show: true,
            orient : 'vertical',
            left: 'right',
            top: 'center',
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        series : [
            {
                name: '男',
                type: 'map',
                mapType: 'china',
                roam: false,
                label: {
                    normal: {
                        show: false
                    },
                    emphasis: {
                        show: true
                    }
                },
                data:[]
            },{
                name: '女',
                type: 'map',
                mapType: 'china',
                roam: false,
                label: {
                    normal: {
                        show: false
                    },
                    emphasis: {
                        show: true
                    }
                },
                data:[]
            }
        ]
    };
    chart.setOption(option);
    $(function () {
        $.post("${pageContext.request.contextPath}/us/province","sex=男", function (data) {
            chart.setOption({
                series: [{
                    // 根据名字对应到相应的系列
                    name: '男',
                    data: data
                }]
            });
        }, "json");

        $.post("${pageContext.request.contextPath}/us/province","sex=女", function (data) {
            chart.setOption({
                series: [{
                    // 根据名字对应到相应的系列
                    name: '女',
                    data: data
                }]
            });
        }, "json");
    });
</script>
<div id="map" style="width: 100%;height: 100%;margin-top: 30px;margin-left: 30px"></div>