<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/8
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
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
    <title>客户订单详情列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>客户订单详情列表管理 <span class="c-gray en">&gt;</span>客户订单详情列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="mt-20">
        <table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
            <tr class="text-c"><td>订单编号</td><td>${sellorderSum.sellordercode}</td></tr>
            <tr class="text-c"><td>订单日期</td><td><fmt:formatDate value="${sellorderSum.selldate}" pattern="yyyy-MM-dd"/></td></tr>
            <tr class="text-c"><td>项目名称</td><td>${sellorderSum.projectname}</td></tr>
            <tr class="text-c"><td>公司名称</td><td>${sellorderSum.company}</td></tr>
            <tr class="text-c"><td>订货人</td><td>${sellorderSum.customername}</td></tr>
            <tr class="text-c"><td>订货人电话</td><td>${sellorderSum.customerphone}</td></tr>
            <tr class="text-c"><td>订货人类型</td><td>${sellorderSum.customertype}</td></tr>
            <tr class="text-c"><td>销售负责人</td><td>${sellorderSum.sellman}</td></tr>
            <tr class="text-c"><td>配送负责人</td><td>${sellorderSum.sendman}</td></tr>
            <tr class="text-c"><td>收货人</td><td>${sellorderSum.pickman}</td></tr>
            <tr class="text-c"><td>收货人电话</td><td>${sellorderSum.pickmanphone}</td></tr>
            <tr class="text-c"><td>收货地址</td><td>${sellorderSum.address}</td></tr>
            <tr class="text-c"><td>配送方式</td><td>${sellorderSum.sendtype}</td></tr>
            <tr class="text-c"><td>线上商品合计</td><td>${sellorderSum.onlinesum}</td></tr>
            <tr class="text-c"><td>线下商品合计</td><td>${sellorderSum.underlinesum}</td></tr>
            <tr class="text-c"><td>运费</td><td>${sellorderSum.freight}</td></tr>
            <tr class="text-c"><td>总计</td><td>${sellorderSum.allsum}</td></tr>
            <tr class="text-c"><td>最终价格</td><td>${sellorderSum.discountprice}</td></tr>
            <tr class="text-c"><td>销售提成</td><td>${sellorderSum.commission}</td></tr>
            <tr class="text-c"><td>已收款</td><td>${sellorderSum.receivedsum}</td></tr>
            <tr class="text-c"><td>未收款</td><td>${sellorderSum.noreceivedsum}</td></tr>
            <tr class="text-c"><td>付款状态</td><td><c:if test="${sellorderSum.allpaystatue==null||sellorderSum.allpaystatue==0}">未结清</c:if><c:if test="${sellorderSum.allpaystatue==1}">已结清</c:if> </td></tr>
            <tr class="text-c"><td>制表人</td><td>${sellorderSum.maketableman}</td></tr>
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
</script>
</body>
</html>
