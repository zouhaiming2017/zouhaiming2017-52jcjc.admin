<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/8
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>配货订单详情列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>配货订单详情列表管理 <span class="c-gray en">&gt;</span> 配货订单详情列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="mt-20">
        <table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
            <tr class="text-c"><td>配货单号</td><td>${pickorderSum.pickordercode}</td></tr>
            <tr class="text-c"><td>供应商</td><td>${pickorderSum.supplier}</td></tr>
            <tr class="text-c"><td>收货地址</td><td>${pickorderSum.address}</td></tr>
            <tr class="text-c"><td>收货时间</td><td><fmt:formatDate value="${pickorderSum.pickdata}" pattern="yyyy-MM-dd"/></td></tr>
            <tr class="text-c"><td>联系人</td><td>${pickorderSum.linkman}</td></tr>
            <tr class="text-c"><td>取货人</td><td>${pickorderSum.pickman}</td></tr>
            <tr class="text-c"><td>合计</td><td>${pickorderSum.sum}</td></tr>
            <tr class="text-c"><td>运费</td><td>${pickorderSum.freight}</td></tr>
            <tr class="text-c"><td>总计</td><td>${pickorderSum.allsum}</td></tr>
            <tr class="text-c"><td>已付款</td><td>${pickorderSum.receivedsum}</td></tr>
            <tr class="text-c"><td>未付款</td><td>${pickorderSum.noreceivedsum}</td></tr>
            <tr class="text-c"><td>付款状态</td><td><c:if test="${pickorderSum.allpaystatue==null||pickorderSum.allpaystatue==0}">未结清</c:if><c:if test="${pickorderSum.allpaystatue==1}">已结清</c:if> </td></tr>
            <tr class="text-c"><td>备注</td><td>${pickorderSum.remark}</td></tr>
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
