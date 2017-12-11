<%--
  Created by IntelliJ IDEA.
  User: zhm
  Date: 2017/9/26
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="../lib/Hui-iconfont/1.0.8/iconfont.css" />
    <title>ECharts</title>
</head>
<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="height:400px"></div>
<!-- ECharts单文件引入 -->
<script src="http://echarts.baidu.com/build/dist/echarts.js"></script>

<div class="text-c">
    <form action="/charts/pie-chart" method="get">
         <span class="select-box inline">
         <select name="year" class="select">
            <option value="0" selected="selected">选择年份</option>
            <c:forEach var="year1" items="${years}">
                <option value="${year1}">${year1}</option>
            </c:forEach>
		 </select>
         </span>
        <span class="select-box inline">
         <select name="month" class="select">
            <option value="0" selected="selected">选择月份</option>
            <c:forEach var="month1" items="${months}">
                <option value="${month1}">${month1}</option>
            </c:forEach>
		 </select>
         </span>
        <button name=""  class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i>查  看</button>
    </form>
</div>
<script type="text/javascript">

    // 路径配置
    require.config({
        paths: {
            echarts: 'http://echarts.baidu.com/build/dist'
        }
    });

    // 使用
    require(
        [
            'echarts',
            'echarts/chart/pie',
            'echarts/chart/funnel'
        ],
        function (ec) {
            // 基于准备好的dom，初始化echarts图表
            var myChart = ec.init(document.getElementById('main'));

            var option = {
                title : {
                    text: '按客户类型查看收益',
                    subtext: '${month}',
                    x:'center'
                },
                tooltip : {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                legend: {
                    orient : 'vertical',
                    x : 'left',
                    data:['T1类客户','T2类客户','T3类客户','T4类客户','T5类客户']
                },
                toolbox: {
                    show : true,
                    feature : {
                        mark : {show: true},
                        dataView : {show: true, readOnly: false},
                        magicType : {
                            show: true,
                            type: ['pie', 'funnel'],
                            option: {
                                funnel: {
                                    x: '25%',
                                    width: '50%',
                                    funnelAlign: 'left',
                                    max: 1548
                                }
                            }
                        },
                        restore : {show: true},
                        saveAsImage : {show: true}
                    }
                },
                calculable : true,
                series : [
                    {
                        name:'客户类型',
                        type:'pie',
                        radius : '55%',
                        center: ['50%', '60%'],
                        data:[
                            {value:${T1}, name:'T1类客户'},
                            {value:${T2}, name:'T2类客户'},
                            {value:${T3}, name:'T3类客户'},
                            {value:${T4}, name:'T4类客户'},
                            {value:${T5}, name:'T5类客户'}
                        ]
                    }
                ]
            };

            // 为echarts对象加载数据
            myChart.setOption(option);
        }
    );
</script>
</body>
</html>
