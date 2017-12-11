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
    <title>通用客户分析</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>通用客户分析管理 <span class="c-gray en">&gt;</span> 通用客户分析 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
        </span>

        <span class="r">
            <shiro:hasPermission name="sellorderAll:export"><button onclick="exportExcel()"  class="btn btn-warning-outline radius"><i class="Hui-iconfont">&#xe644;</i>导出</button></shiro:hasPermission>
        </span>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
            <thead>
            <tr class="text-c">
                <th width="25"><input type="checkbox" name="ckAll" value=""></th>
                <th width="100">月度</th>
                <th width="100">交易客户数</th>
                <th width="100">总交易金额</th>
                <th width="100">总订单数</th>


                <th width="100">T4订单数</th>
                <th width="100">T3订单数</th>
                <th width="100">T2订单数</th>
                <th width="100">T1订单数</th>

                <th width="100">T4交易金额</th>
                <th width="100">T3交易金额</th>
                <th width="100">T2交易金额</th>
                <th width="100">T1交易金额</th>

                <th width="100">T4订单增长率</th>
                <th width="100">T3订单增长率</th>
                <th width="100">T4交易增长率</th>
                <th width="100">T3交易增长率</th>

                <th width="100">T4订单平均</th>
                <th width="100">T3订单平均</th>
                <th width="100">T4交易占比</th>
                <th width="100">T3交易占比</th>
                <th width="100">T4客户数</th>
                <th width="100">T3客户数</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="sellorderAll" items="${sellorderAlls}">
                <tr class="text-c">
                    <td><input type="checkbox" value="" name="ck"></td>
                    <td>${sellorderAll.timeMonth}</td>
                    <td>${sellorderAll.allCustomerCount}</td>
                    <td>${sellorderAll.allsums}</td>
                    <td>${sellorderAll.allcounts}</td>

                    <td>${sellorderAll.dCount}</td>
                    <td>${sellorderAll.cCount}</td>
                    <td>${sellorderAll.bCount}</td>
                    <td>${sellorderAll.aCount}</td>

                    <td>${sellorderAll.dSum}</td>
                    <td>${sellorderAll.cSum}</td>
                    <td>${sellorderAll.bSum}</td>
                    <td>${sellorderAll.aSum}</td>

                    <td>${sellorderAll.dCountRategrowth}</td>
                    <td>${sellorderAll.cCountRategrowth}</td>
                    <td>${sellorderAll.dSumRategrowth}</td>
                    <td>${sellorderAll.cSumRategrowth}</td>

                    <td>${sellorderAll.dSumAvg}</td>
                    <td>${sellorderAll.cSumAvg}</td>
                    <td>${sellorderAll.dSumPro}</td>
                    <td>${sellorderAll.cSumPro}</td>
                    <td>${sellorderAll.dCustomerCount}</td>
                    <td>${sellorderAll.cCustomerCount}</td>
                </tr>
            </c:forEach>
            </tbody>
            <thead>
            <tr class="text-c" style="font-weight:bold;font-size:300px;">
                <th colspan="3" >合计：</th>
                <th>${allsums}</th>
                <th>${allcounts}</th>

                <th>${dCounts}</th>
                <th>${cCounts}</th>
                <th>${bCounts}</th>
                <th>${aCounts}</th>

                <th>${dSums}</th>
                <th>${cSums}</th>
                <th>${bSums}</th>
                <th>${aSums}</th>

                <th></th>
                <th></th>
                <th></th>
                <th></th>

                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
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
        document.location.href="/sellorderAll/exportExcel?timeMonthcodes="+checkedList.toString();
    }

    $('.table-sort').dataTable({
        "aaSorting": [[1, "desc"]],//默认第几个排序
        "bStateSave": true,//状态保存
        "pading": false,
        "aoColumnDefs": [
            //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
            {"orderable": false, "aTargets": [0, 22]}// 不参与排序的列
        ]
    });
</script>
</body>
</html>