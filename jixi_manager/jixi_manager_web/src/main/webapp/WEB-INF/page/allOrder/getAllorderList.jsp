<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <!--[if lt IE 9]>
    <script type="text/javascript" src="../lib/html5shiv.js"></script>
    <script type="text/javascript" src="../lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="../static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="../static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="../lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="../static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="../static/h-ui.admin/css/style.css" />
    <!--[if IE 6]>
    <script type="text/javascript" src="../lib/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>通用订单汇总</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>通用订单汇总管理 <span class="c-gray en">&gt;</span> 通用订单汇总 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
        </span>

        <span class="r">
            <shiro:hasPermission name="allOrder:export"><button onclick="exportExcel()"  class="btn btn-warning-outline radius"><i class="Hui-iconfont">&#xe644;</i>导出</button></shiro:hasPermission>
        </span>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
            <thead>
            <tr class="text-c">
                <th width="25"><input type="checkbox" name="ckAll" value=""></th>
                <th width="100">月度</th>
                <th width="100">交易金额</th>
                <th width="100">交易增长率</th>
                <th width="100">订单数</th>
                <th width="100">订单增长率</th>
                <th width="100">订单平均</th>
                <th width="100">日均交易额</th>
                <th width="100">日均订单</th>
                <th width="100">供应商金额</th>
                <th width="100">实际毛利</th>
                <th width="100">进销项抵扣</th>
                <th width="100">毛利率</th>
                <th width="100">运费比例</th>
                <th width="100">供应商运费</th>
                <th width="100">集兮配送费</th>
                <th width="100">收客户运费</th>
                <%--<th width="100">备注</th>--%>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="allorder" items="${allorders}">
                <tr class="text-c">
                    <td><input type="checkbox" value="" name="ck"></td>
                    <td>${allorder.timeMonth}</td>
                    <td>${allorder.sellSums}</td>
                    <td>${allorder.sellSumsRategrowth}</td>
                    <td>${allorder.sellCounts}</td>
                    <td>${allorder.sellCountsRategrowth}</td>
                    <td>${allorder.sellSumsAvg}</td>
                    <td>${allorder.sellSumsDayavg}</td>
                    <td>${allorder.sellCountsDayavg}</td>
                    <td>${allorder.pickSums}</td>
                    <td>${allorder.realGrossprofit}</td>
                    <td>${allorder.pinOffItemoffset}</td>
                    <td>${allorder.grossmargin}</td>
                    <td>${allorder.freightpro}</td>
                    <td>${allorder.freightSupplier}</td>
                    <td>${allorder.freightJixi}</td>
                    <td>${allorder.freightCustomer}</td>
                    <%--<td>${allorder.remark}</td>--%>
                </tr>
            </c:forEach>
            </tbody>
            <thead>
            <tr class="text-c" style="font-weight:bold;font-size:300px;">
                <th colspan="2" >合计：</th>
                <th>${sellSums}</th>
                <th></th>
                <th>${sellCounts}</th>
                <th></th>
                <th>${sellSumsAvgs}</th>
                <th></th>
                <th></th>
                <th>${pickSums}</th>
                <th>${realGrossprofits}</th>
                <th>${pinOffItemoffsets}</th>
                <th>${grossmargins}</th>
                <th>${freightpros}</th>
                <th>${freightSuppliers}</th>
                <th>${freightJixis}</th>
                <th>${freightCustomers}</th>
            </tr>
            </thead>
        </table>
    </div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="../lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="../static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="../static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="../lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="../lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="../lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">

    /*导出*/
    function exportExcel() {
        // 判断是否至少选择一项
        var checkedNum = $("input[name='ck']:checked").length;
        if (checkedNum == 0) {
            layer.alert("请选择至少一项导出！");
            return;
        }
        // 批量选择
        var checkedList = new Array();
        var $tr;
        $("input[name='ck']:checked").each(function () {
            // 找到选中的复选框所在的行
            $tr = $(this).eq(0).parent().parent();
            // 找到此行中的编号所在td
            var $td = $tr.find("td").eq(1).text();
            checkedList.push($td);
        });
        //设置传到controller层的参数
        document.location.href="/allOrder/exportExcel?timeMonthcodes="+checkedList.toString();
    }

    $('.table-sort').dataTable({
        "aaSorting": [[1, "desc"]],//默认第几个排序
        "bStateSave": true,//状态保存
        "pading": false,
        "aoColumnDefs": [
            //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
            {"orderable": false, "aTargets": [0, 16]}// 不参与排序的列
        ]
    });
</script>
</body>
</html>