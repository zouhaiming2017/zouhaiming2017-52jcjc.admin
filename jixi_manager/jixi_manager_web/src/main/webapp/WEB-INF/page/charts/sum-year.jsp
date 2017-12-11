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
    <form action="/charts/sum-year" method="get">
         <span class="select-box inline">
         <select name="year" class="select">
            <option value="0" selected="selected">选择年份</option>
            <c:forEach var="year1" items="${years}">
                <option value="${year1}">${year1}</option>
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
            'echarts/chart/bar', // 使用柱状图就加载bar模块，按需加载
            'echarts/chart/line'
        ],
        function (ec) {
            // 基于准备好的dom，初始化echarts图表
            var myChart = ec.init(document.getElementById('main'));

            var option = {
                title : {
                    text: '商城年配货支出和订单收入',
                    subtext: '${year}'
                },
                tooltip : {
                    trigger: 'axis'
                },
                legend: {
                    data:['配货支出','订单收入']
                },
                toolbox: {
                    show : true,
                    feature : {
                        mark : {show: true},
                        dataView : {show: true, readOnly: false},
                        magicType : {show: true, type: ['line', 'bar']},
                        restore : {show: true},
                        saveAsImage : {show: true}
                    }
                },
                calculable : true,
                xAxis : [
                    {
                        type : 'category',
                        data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:'配货支出',
                        type:'bar',
                        data:[${pickOrderSums}],
                        markPoint : {
                            data : [
                                {type : 'max', name: '最大值'},
                                {type : 'min', name: '最小值'}
                            ]
                        },
                        markLine : {
                            data : [
                                {type : 'average', name: '平均值'}
                            ]
                        }
                    },
                    {
                        name:'订单收入',
                        type:'bar',
                        data:[${sellorderSums}],
                        markPoint : {
                            data : [
                                {name : '年最高', value : ${maxSum}, xAxis: ${maxMonth}, yAxis: ${maxSum}, symbolSize:18},
                                {name : '年最低', value : ${minSum}, xAxis: ${minMonth}, yAxis: ${minSum}}
                            ]
                        },
                        markLine : {
                            data : [
                                {type : 'average', name : '平均值'}
                            ]
                        }
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
