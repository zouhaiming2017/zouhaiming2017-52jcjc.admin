<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="Bookmark" href="../favicon.ico" >
    <link rel="Shortcut Icon" href="../favicon.ico" />
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
    <!--/meta 作为公共模版分离出去-->

    <title>新建网站角色 - 管理员管理</title>
    <meta name="keywords" content="H-ui.admin v3.1,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
    <meta name="description" content="H-ui.admin v3.1，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container">
    <form action="" method="post" class="form form-horizontal" id="form-admin-role-add">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>角色名称：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" placeholder="" id="rolename" name="rolename">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>角色描述：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" placeholder="" id="describes" name="describes">
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">网站角色：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <dl class="permission-list">
                    <dt>
                        <label>
                            <input type="checkbox" value="" name="user-Character-0" id="user-Character-0">
                            价目管理
                        </label>
                    </dt>
                    <dd>
                        <dl class="cl permission-list2">
                            <dt>
                                <label class="">
                                    <input type="checkbox" value="pickPriceMaster:*" name="user-Character-0-0" id="user-Character-0-0">
                                    供应商报价管理
                                </label>
                            </dt>
                            <dd>
                                <label class=""><br/>
                                    <input type="checkbox" value="pickPriceMaster:add" name="ck" id="user-Character-0-0-0">
                                    添加</label>
                                <label class="">
                                    <input type="checkbox" value="pickPriceMaster:update" name="ck" id="user-Character-0-0-1">
                                    修改</label>
                                <label class="">
                                    <input type="checkbox" value="pickPriceMaster:delete" name="ck" id="user-Character-0-0-2">
                                    删除</label>
                                <label class="">
                                    <input type="checkbox" value="pickPriceMaster:select" name="ck" id="user-Character-0-0-3">
                                    查看</label>
                                <label class="">
                                    <input type="checkbox" value="pickPriceMaster:import" name="ck" id="user-Character-0-0-4">
                                    导入</label>
                                <label class="">
                                    <input type="checkbox" value="pickPriceMaster:export" name="ck" id="user-Character-0-0-5">
                                    导出</label>
                            </dd>
                        </dl>
                        <dl class="cl permission-list2">
                            <dt>
                                <label class="">
                                    <input type="checkbox" value="sellPriceMaster:*" name="user-Character-0-1" id="user-Character-0-1">
                                    商城上线价管理
                                </label>
                            </dt>
                            <dd>
                                <label class=""><br/>
                                    <input type="checkbox" value="sellPriceMaster:add" name="ck" id="user-Character-0-1-0">
                                    添加</label>
                                <label class="">
                                    <input type="checkbox" value="sellPriceMaster:update" name="ck" id="user-Character-0-1-1">
                                    修改</label>
                                <label class="">
                                    <input type="checkbox" value="sellPriceMaster:delete" name="ck" id="user-Character-0-1-2">
                                    删除</label>
                                <label class="">
                                    <input type="checkbox" value="sellPriceMaster:select" name="ck" id="user-Character-0-1-3">
                                    查看</label>
                                <label class="">
                                    <input type="checkbox" value="sellPriceMaster:import" name="ck" id="user-Character-0-1-4">
                                    导入</label>
                                <label class="">
                                    <input type="checkbox" value="sellPriceMaster:export" name="ck" id="user-Character-0-1-5">
                                    导出</label>
                            </dd>
                        </dl>
                    </dd>
                </dl>
                <dl class="permission-list">
                    <dt>
                        <label>
                            <input type="checkbox" value="" name="user-Character-0" id="user-Character-1">
                            汇总管理
                        </label>
                    </dt>
                    <dd>
                        <dl class="cl permission-list2">
                            <dt>
                                <label class="">
                                    <input type="checkbox" value="sellOrderSum:*" name="user-Character-1-0" id="user-Character-1-0">
                                    客户订单汇总管理</label>
                            </dt>
                            <dd>
                                <label class=""><br/>
                                    <input type="checkbox" value="sellOrderSum:add" name="ck" id="user-Character-1-0-0">
                                    添加</label>
                                <label class="">
                                    <input type="checkbox" value="sellOrderSum:update" name="ck" id="user-Character-1-0-1">
                                    修改</label>
                                <label class="">
                                    <input type="checkbox" value="sellOrderSum:delete" name="ck" id="user-Character-1-0-2">
                                    删除</label>
                                <label class="">
                                    <input type="checkbox" value="sellOrderSum:select" name="ck" id="user-Character-1-0-3">
                                    查看</label>
                                <label class="">
                                    <input type="checkbox" value="sellOrderSum:import" name="ck" id="user-Character-1-0-4">
                                    导入</label>
                                <label class="">
                                    <input type="checkbox" value="sellOrderSum:export" name="ck" id="user-Character-1-0-5">
                                    导出</label>
                                <label class="">
                                    <input type="checkbox" value="sellOrderSum:setCommission" name="ck" id="user-Character-1-0-6">
                                    设置提成</label>
                            </dd>
                        </dl>
                        <dl class="cl permission-list2">
                            <dt>
                                <label class="">
                                    <input type="checkbox" value="pickOrderSum:*" name="user-Character-1-0" id="user-Character-1-1">
                                    配货订单汇总管理</label>
                            </dt>
                            <dd>
                                <label class=""><br/>
                                    <input type="checkbox" value="pickOrderSum:add" name="ck" id="user-Character-1-1-0">
                                    添加</label>
                                <label class="">
                                    <input type="checkbox" value="pickOrderSum:update" name="ck" id="user-Character-1-1-1">
                                    修改</label>
                                <label class="">
                                    <input type="checkbox" value="pickOrderSum:delete" name="ck" id="user-Character-1-1-2">
                                    删除</label>
                                <label class="">
                                    <input type="checkbox" value="pickOrderSum:select" name="ck" id="user-Character-1-1-3">
                                    查看</label>
                                <label class="">
                                    <input type="checkbox" value="pickOrderSum:import" name="ck" id="user-Character-1-1-4">
                                    导入</label>
                                <label class="">
                                    <input type="checkbox" value="pickOrderSum:export" name="ck" id="user-Character-1-1-5">
                                    导出</label>
                            </dd>
                        </dl>
                        <%--<dl class="cl permission-list2">--%>
                            <%--<dt>--%>
                                <%--<label class="">--%>
                                    <%--<input type="checkbox" value="jixitruckOrder:*" name="user-Character-1-0" id="user-Character-1-2">--%>
                                    <%--集兮车队订单管理</label>--%>
                            <%--</dt>--%>
                            <%--<dd>--%>
                                <%--<label class=""><br/>--%>
                                    <%--<input type="checkbox" value="jixitruckOrder:add" name="ck" id="user-Character-1-2-0">--%>
                                    <%--添加</label>--%>
                                <%--<label class="">--%>
                                    <%--<input type="checkbox" value="jixitruckOrder:update" name="ck" id="user-Character-1-2-1">--%>
                                    <%--修改</label>--%>
                                <%--<label class="">--%>
                                    <%--<input type="checkbox" value="jixitruckOrder:delete" name="ck" id="user-Character-1-2-2">--%>
                                    <%--删除</label>--%>
                                <%--<label class="">--%>
                                    <%--<input type="checkbox" value="jixitruckOrder:select" name="ck" id="user-Character-1-2-3">--%>
                                    <%--查看</label>--%>
                                <%--<label class="">--%>
                                    <%--<input type="checkbox" value="jixitruckOrder:exportExcel" name="ck" id="user-Character-1-2-5">--%>
                                    <%--导出</label>--%>
                            <%--</dd>--%>
                        <%--</dl>--%>
                        <%--<dl class="cl permission-list2">--%>
                            <%--<dt>--%>
                                <%--<label class="">--%>
                                    <%--<input type="checkbox" value="sellorderJc:*" name="user-Character-1-0" id="user-Character-1-2">--%>
                                    <%--集兮仓库订单管理</label>--%>
                            <%--</dt>--%>
                            <%--<dd>--%>
                                <%--<label class=""><br/>--%>
                                    <%--<input type="checkbox" value="sellorderJc:add" name="ck" id="user-Character-1-2-0">--%>
                                    <%--添加</label>--%>
                                <%--<label class="">--%>
                                    <%--<input type="checkbox" value="sellorderJc:update" name="ck" id="user-Character-1-2-1">--%>
                                    <%--修改</label>--%>
                                <%--<label class="">--%>
                                    <%--<input type="checkbox" value="sellorderJc:delete" name="ck" id="user-Character-1-2-2">--%>
                                    <%--删除</label>--%>
                                <%--<label class="">--%>
                                    <%--<input type="checkbox" value="sellorderJc:select" name="ck" id="user-Character-1-2-3">--%>
                                    <%--查看</label>--%>
                                <%--<label class="">--%>
                                    <%--<input type="checkbox" value="sellorderJc:import" name="ck" id="user-Character-1-2-4">--%>
                                    <%--导入</label>--%>
                                <%--<label class="">--%>
                                    <%--<input type="checkbox" value="sellorderJc:export" name="ck" id="user-Character-1-2-5">--%>
                                    <%--导出</label>--%>
                            <%--</dd>--%>
                        <%--</dl>--%>
                    </dd>
                </dl>

                <dl class="permission-list">
                    <dt>
                        <label>
                            <input type="checkbox" value="" name="user-Character-0" id="user-Character-8">
                            财务管理
                        </label>
                    </dt>
                    <dd>
                        <dl class="cl permission-list2">
                            <dt>
                                <label class="">
                                    <input type="checkbox" value="sellorderSumByFinance:*" name="user-Character-1-0" id="user-Character-8-0">
                                    客户订单财务管理</label>
                            </dt>
                            <dd>
                                <label class=""><br/>
                                    <input type="checkbox" value="sellorderSumByFinance:update" name="ck" id="user-Character-8-0-0">
                                    修改</label>
                                <label class="">
                                    <input type="checkbox" value="sellorderSumByFinance:select" name="ck" id="user-Character-8-0-1">
                                    查看</label>
                                <label class="">
                                    <input type="checkbox" value="sellorderSumByFinance:exportExcelAsFinance" name="ck" id="user-Character-8-0-2">
                                    导出</label>
                            </dd>
                        </dl>
                        <dl class="cl permission-list2">
                            <dt>
                                <label class="">
                                    <input type="checkbox" value="pickorderSumByFinance:*" name="user-Character-1-0" id="user-Character-8-1">
                                    配货订单财务管理</label>
                            </dt>
                            <dd>
                                <label class=""><br/>
                                    <input type="checkbox" value="pickorderSumByFinance:update" name="ck" id="user-Character-8-1-0">
                                    修改</label>
                                <label class="">
                                    <input type="checkbox" value="pickorderSumByFinance:select" name="ck" id="user-Character-8-1-1">
                                    查看</label>
                                <label class="">
                                    <input type="checkbox" value="pickorderSumByFinance:exportExcelAsFinance" name="ck" id="user-Character-8-1-2">
                                    导出</label>
                            </dd>
                        </dl>
                        <dl class="cl permission-list2">
                            <dt>
                                <label class="">
                                    <input type="checkbox" value="taxService:*" name="user-Character-1-0" id="user-Character-8-2">
                                    税务进销项统计管理</label>
                            </dt>
                            <dd>
                                <label class=""><br/>
                                    <input type="checkbox" value="taxService:update" name="ck" id="user-Character-8-2-0">
                                    修改</label>
                                <label class="">
                                    <input type="checkbox" value="taxService:select" name="ck" id="user-Character-8-2-1">
                                    查看</label>
                                <label class="">
                                    <input type="checkbox" value="taxService:add" name="ck" id="user-Character-8-2-2">
                                    添加</label>
                            </dd>
                        </dl>
                    </dd>
                </dl>

                <dl class="permission-list">
                    <dt>
                        <label>
                            <input type="checkbox" value="" name="user-Character-0" id="user-Character-2">
                            商品管理
                        </label>
                    </dt>
                    <dd>
                        <dl class="cl permission-list2">
                            <dt>
                                <label class="">
                                    <input type="checkbox" value="item:*" name="user-Character-1-0" id="user-Character-2-0">
                                    商品库存管理</label>
                            </dt>
                            <dd>
                                <label class=""><br/>
                                    <input type="checkbox" value="item:add" name="ck" id="user-Character-2-0-0">
                                    添加</label>
                                <label class="">
                                    <input type="checkbox" value="item:update" name="ck" id="user-Character-2-0-1">
                                    修改</label>
                                <label class="">
                                    <input type="checkbox" value="item:delete" name="ck" id="user-Character-2-0-2">
                                    删除</label>
                                <label class="">
                                    <input type="checkbox" value="item:select" name="ck" id="user-Character-2-0-3">
                                    查看</label>
                                <label class="">
                                    <input type="checkbox" value="item:import" name="ck" id="user-Character-2-0-4">
                                    商品库存数据导入</label>
                                <label class="">
                                    <input type="checkbox" value="item:exportExcel" name="ck" id="user-Character-2-0-5">
                                    导出</label>
                            </dd>
                        </dl>
                        <dl class="cl permission-list2">
                            <dt>
                                <label class="">
                                    <input type="checkbox" value="pickorderItem:*" name="user-Character-1-0" id="user-Character-11-0">
                                    商品售出管理</label>
                            </dt>
                            <dd>
                                <label class=""><br/>
                                    <input type="checkbox" value="pickorderItem:update" name="ck" id="user-Character-11-0-1">
                                    修改</label>
                                <label class="">
                                    <input type="checkbox" value="pickorderItem:delete" name="ck" id="user-Character-11-0-2">
                                    删除</label>
                                <label class="">
                                    <input type="checkbox" value="pickorderItem:select" name="ck" id="user-Character-11-0-3">
                                    查看</label>
                                <label class="">
                                    <input type="checkbox" value="pickorderItem:import" name="ck" id="user-Character-11-0-4">
                                    导入</label>
                                <label class="">
                                    <input type="checkbox" value="pickorderItem:exportExcel" name="ck" id="user-Character-11-0-5">
                                    导出</label>
                            </dd>
                        </dl>
                        <dl class="cl permission-list2">
                            <dt>
                                <label class="">
                                    <input type="checkbox" value="pickorderItem:*" name="user-Character-1-0" id="user-Character-11-1">
                                    商品售出排行</label>
                            </dt>
                            <dd>
                                <label class=""><br/>
                                    <input type="checkbox" value="pickorderItem:ranking" name="ck" id="user-Character-11-1-0">
                                    查看</label>
                                <label class="">
                                    <input type="checkbox" value="pickorderItem:exportRankExcel" name="ck" id="user-Character-11-1-1">
                                    导出</label>
                            </dd>
                        </dl>
                    </dd>
                </dl>
                <dl class="permission-list">
                    <dt>
                        <label>
                            <input type="checkbox" value="" name="user-Character-0" id="user-Character-3">
                            客户管理
                        </label>
                    </dt>
                    <dd>
                        <dl class="cl permission-list2">
                            <dt>
                                <label class="">
                                    <input type="checkbox" value="customer:*" name="user-Character-1-0" id="user-Character-3-0">
                                    客户管理</label>
                            </dt>
                            <dd>
                                <label class=""><br/>
                                    <input type="checkbox" value="customer:add" name="ck" id="user-Character-3-0-0">
                                    添加</label>
                                <label class="">
                                    <input type="checkbox" value="customer:update" name="ck" id="user-Character-3-0-1">
                                    修改</label>
                                <label class="">
                                    <input type="checkbox" value="customer:delete" name="ck" id="user-Character-3-0-2">
                                    删除</label>
                                <label class="">
                                    <input type="checkbox" value="customer:select" name="ck" id="user-Character-3-0-3">
                                    查看</label>
                                <label class="">
                                    <input type="checkbox" value="customer:addFormSellOrderSum" name="ck" id="user-Character-3-0-4">
                                    从订单表更新客户</label>
                            </dd>
                        </dl>
                    </dd>
                </dl>
                <dl class="permission-list">
                    <dt>
                        <label>
                            <input type="checkbox" value="" name="user-Character-0" id="user-Character-4">
                            供应商管理
                        </label>
                    </dt>
                    <dd>
                        <dl class="cl permission-list2">
                            <dt>
                                <label class="">
                                    <input type="checkbox" value="supplier:*" name="user-Character-1-0" id="user-Character-4-0">
                                    供应商管理</label>
                            </dt>
                            <dd>
                                <label class=""><br/>
                                    <input type="checkbox" value="supplier:add" name="ck" id="user-Character-4-0-0">
                                    添加</label>
                                <label class="">
                                    <input type="checkbox" value="supplier:update" name="ck" id="user-Character-4-0-1">
                                    修改</label>
                                <label class="">
                                    <input type="checkbox" value="supplier:delete" name="ck" id="user-Character-4-0-2">
                                    删除</label>
                                <label class="">
                                    <input type="checkbox" value="supplier:select" name="ck" id="user-Character-4-0-3">
                                    查看</label>
                                <label class="">
                                    <input type="checkbox" value="supplier:addFormPickPrice" name="ck" id="user-Character-4-0-4">
                                    从报价表更新供应商</label>
                            </dd>
                        </dl>
                    </dd>
                </dl>
                <dl class="permission-list">
                    <dt>
                        <label>
                            <input type="checkbox" value="" name="user-Character-0" id="user-Character-5">
                            业务员管理
                        </label>
                    </dt>
                    <dd>
                        <dl class="cl permission-list2">
                            <dt>
                                <label class="">
                                    <input type="checkbox" value="sellman:*" name="user-Character-1-0" id="user-Character-5-0">
                                    业务员管理</label>
                            </dt>
                            <dd>
                                <label class=""><br/>
                                    <input type="checkbox" value="sellman:add" name="ck" id="user-Character-5-0-0">
                                    添加</label>
                                <label class="">
                                    <input type="checkbox" value="sellman:update" name="ck" id="user-Character-5-0-1">
                                    修改</label>
                                <label class="">
                                    <input type="checkbox" value="sellman:delete" name="ck" id="user-Character-5-0-2">
                                    删除</label>
                                <label class="">
                                    <input type="checkbox" value="sellman:select" name="ck" id="user-Character-5-0-3">
                                    查看</label>
                                <label class="">
                                    <input type="checkbox" value="sellman:selectOrder" name="ck" id="user-Character-5-0-4">
                                    查询业务员订单</label>
                            </dd>
                        </dl>
                    </dd>
                </dl>
                <dl class="permission-list">
                    <dt>
                        <label>
                            <input type="checkbox" value="" name="user-Character-0" id="user-Character-7">
                            图表统计
                        </label>
                    </dt>
                    <dd>
                        <dl class="cl permission-list2">
                            <dt>
                                <label class="">
                                    <input type="checkbox" value="yearSumCharts:*" name="user-Character-1-0" id="user-Character-7-0">
                                    收支年统计图</label>
                            </dt>
                            <dd>
                                <label class=""><br/>
                                    <input type="checkbox" value="yearSumCharts:select" name="ck" id="user-Character-7-0-0">
                                    查看</label>
                            </dd>
                        </dl>
                        <dl class="cl permission-list2">
                            <dt>
                                <label class="">
                                    <input type="checkbox" value="monthSumCharts:*" name="user-Character-1-0" id="user-Character-7-1">
                                    收支月统计图</label>
                            </dt>
                            <dd>
                                <label class=""><br/>
                                    <input type="checkbox" value="monthSumCharts:select" name="ck" id="user-Character-7-1-0">
                                    查看</label>
                            </dd>
                        </dl>
                        <dl class="cl permission-list2">
                            <dt>
                                <label class="">
                                    <input type="checkbox" value="pieChart:*" name="user-Character-1-0" id="user-Character-7-2">
                                    饼状图</label>
                            </dt>
                            <dd>
                                <label class=""><br/>
                                    <input type="checkbox" value="pieChart:select" name="ck" id="user-Character-7-2-0">
                                    查看</label>
                            </dd>
                        </dl>
                        <dl class="cl permission-list2">
                            <dt>
                                <label class="">
                                    <input type="checkbox" value="mapChart:*" name="user-Character-1-0" id="user-Character-7-3">
                                    地区分布图</label>
                            </dt>
                            <dd>
                                <label class=""><br/>
                                    <input type="checkbox" value="mapChart:select" name="ck" id="user-Character-7-3-0">
                                    查看</label>
                            </dd>
                        </dl>
                        <dl class="cl permission-list2">
                            <dt>
                                <label class="">
                                    <input type="checkbox" value="sellmanYearOrderChart:*" name="user-Character-7-4" id="user-Character-7-4">
                                    业务员年销售图</label>
                            </dt>
                            <dd>
                                <label class=""><br/>
                                    <input type="checkbox" value="sellmanYearOrderChart:select" name="ck" id="user-Character-7-4-0">
                                    查看</label>
                            </dd>
                        </dl>
                    </dd>
                </dl>
                <dl class="permission-list">
                    <dt>
                        <label>
                            <input type="checkbox" value="" name="user-Character-0" id="user-Character-6">
                            管理员管理
                        </label>
                    </dt>
                    <dd>
                        <dl class="cl permission-list2">
                            <dt>
                                <label class="">
                                    <input type="checkbox" value="role:*" name="user-Character-1-0" id="user-Character-6-0">
                                    角色管理</label>
                            </dt>
                            <dd>
                                <label class=""><br/>
                                    <input type="checkbox" value="role:add" name="ck" id="user-Character-6-0-0">
                                    添加</label>
                                <label class="">
                                    <input type="checkbox" value="role:update" name="ck" id="user-Character-6-0-1">
                                    修改</label>
                                <label class="">
                                    <input type="checkbox" value="role:delete" name="ck" id="user-Character-6-0-2">
                                    删除</label>
                                <label class="">
                                    <input type="checkbox" value="role:select" name="ck" id="user-Character-6-0-3">
                                    查看</label>
                            </dd>
                        </dl>
                        <dl class="cl permission-list2">
                            <dt>
                                <label class="">
                                    <input type="checkbox" value="permission:*" name="user-Character-1-0" id="user-Character-6-1">
                                    权限管理</label>
                            </dt>
                            <dd>
                                <label class=""><br/>
                                    <input type="checkbox" value="permission:add" name="ck" id="user-Character-6-1-0">
                                    添加</label>
                                <label class="">
                                    <input type="checkbox" value="permission:update" name="ck" id="user-Character-6-1-1">
                                    修改</label>
                                <label class="">
                                    <input type="checkbox" value="permission:delete" name="ck" id="user-Character-6-1-2">
                                    删除</label>
                                <label class="">
                                    <input type="checkbox" value="permission:select" name="ck" id="user-Character-6-1-3">
                                    查看</label>
                            </dd>
                        </dl>
                        <dl class="cl permission-list2">
                            <dt>
                                <label class="">
                                    <input type="checkbox" value="user:*" name="user-Character-6-2" id="user-Character-6-2">
                                    用户管理</label>
                            </dt>
                            <dd>
                                <label class=""><br/>
                                    <input type="checkbox" value="user:add" name="ck" id="user-Character-6-2-0">
                                    添加</label>
                                <label class="">
                                    <input type="checkbox" value="user:update" name="ck" id="user-Character-6-2-1">
                                    修改</label>
                                <label class="">
                                    <input type="checkbox" value="user:delete" name="ck" id="user-Character-6-2-2">
                                    删除</label>
                                <label class="">
                                    <input type="checkbox" value="user:select" name="ck" id="user-Character-6-2-3">
                                    查看</label>
                            </dd>
                        </dl>
                    </dd>
                </dl>

                <dl class="permission-list">
                    <dt>
                        <label>
                            <input type="checkbox" value="" name="user-Character-0" id="user-Character-9">
                            月度明细
                        </label>
                    </dt>
                    <dd>
                        <dl class="cl permission-list2">
                            <dt>
                                <label class="">
                                    <input type="checkbox" value="dataShow:*" name="user-Character-9-0" id="user-Character-9-0">
                                    客户类型月度明细</label>
                            </dt>
                            <dd>
                                <label class=""><br/>
                                    <input type="checkbox" value="dataShow:customerTypeDetail" name="ck" id="user-Character-9-0-0">
                                    查看</label>
                                <label class="">
                                    <input type="checkbox" value="dataShow:export" name="ck" id="user-Character-9-0-1">
                                    导出</label>
                            </dd>
                        </dl>
                        <dl class="cl permission-list2">
                            <dt>
                                <label class="">
                                    <input type="checkbox" value="customerDetail:*" name="user-Character-1-0" id="user-Character-9-1">
                                    客户月度明细</label>
                            </dt>
                            <dd>
                                <label class=""><br/>
                                    <input type="checkbox" value="customerDetail:getCustomerDetail" name="ck" id="user-Character-9-1-0">
                                    查看</label>
                                <label class="">
                                    <input type="checkbox" value="customerDetail:export" name="ck" id="user-Character-9-1-1">
                                    导出</label>
                            </dd>
                        </dl>
                        <dl class="cl permission-list2">
                            <dt>
                                <label class="">
                                    <input type="checkbox" value="supplierDetail:*" name="user-Character-6-2" id="user-Character-9-2">
                                    供应商月度明细</label>
                            </dt>
                            <dd>
                                <label class=""><br/>
                                    <input type="checkbox" value="supplierDetail:getSupplierDetail" name="ck" id="user-Character-9-2-0">
                                    查看</label>
                                <label class="">
                                    <input type="checkbox" value="supplierDetail:export" name="ck" id="user-Character-9-2-1">
                                    导出</label>
                            </dd>
                        </dl>
                        <dl class="cl permission-list2">
                            <dt>
                                <label class="">
                                    <input type="checkbox" value="sellmanDetail:*" name="user-Character-6-2" id="user-Character-9-3">
                                    销售月度明细</label>
                            </dt>
                            <dd>
                                <label class=""><br/>
                                    <input type="checkbox" value="sellmanDetail:getSellmanDetail" name="ck" id="user-Character-9-3-0">
                                    查看</label>
                                <label class="">
                                    <input type="checkbox" value="sellmanDetail:export" name="ck" id="user-Character-9-3-1">
                                    导出</label>
                            </dd>
                        </dl>
                    </dd>
                </dl>
                <dl class="permission-list">
                    <dt>
                        <label>
                            <input type="checkbox" value="" name="user-Character-0" id="user-Character-10">
                            通用分析
                        </label>
                    </dt>
                    <dd>
                        <dl class="cl permission-list2">
                            <dt>
                                <label class="">
                                    <input type="checkbox" value="allOrder:*" name="user-Character-9-0" id="user-Character-10-0">
                                    通用订单汇总</label>
                            </dt>
                            <dd>
                                <label class=""><br/>
                                    <input type="checkbox" value="allOrder:getAllorderList" name="ck" id="user-Character-10-0-0">
                                    查看</label>
                                <label class="">
                                    <input type="checkbox" value="allOrder:export" name="ck" id="user-Character-10-0-1">
                                    导出</label>
                            </dd>
                        </dl>
                        <dl class="cl permission-list2">
                            <dt>
                                <label class="">
                                    <input type="checkbox" value="sellorderAll:*" name="user-Character-1-0" id="user-Character-10-1">
                                    通用客户分析</label>
                            </dt>
                            <dd>
                                <label class=""><br/>
                                    <input type="checkbox" value="sellorderAll:getSellorderList" name="ck" id="user-Character-10-1-0">
                                    查看</label>
                                <label class="">
                                    <input type="checkbox" value="sellorderAll:export" name="ck" id="user-Character-10-1-1">
                                    导出</label>
                            </dd>
                        </dl>

                    </dd>
                </dl>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <button type="submit" onclick="addRole()"  class="btn btn-success radius" id="admin-role-save" name="admin-role-save"><i class="icon-ok"></i> 确定</button>
            </div>
        </div>
    </form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="../lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="../static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="../static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="../lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="../lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="../lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">

    $(function(){
        $(".permission-list dt input:checkbox").click(function(){
            $(this).closest("dl").find("dd input:checkbox").prop("checked",$(this).prop("checked"));
        });
        $(".permission-list2 dd input:checkbox").click(function(){
            var l =$(this).parent().parent().find("input:checked").length;
            var l2=$(this).parents(".permission-list").find(".permission-list2 dd").find("input:checked").length;
            if($(this).prop("checked")){
                $(this).closest("dl").find("dt input:checkbox").prop("checked",true);
                $(this).parents(".permission-list").find("dt").first().find("input:checkbox").prop("checked",true);
            }
            else{
                if(l==0){
                    $(this).closest("dl").find("dt input:checkbox").prop("checked",false);
                }
                if(l2==0){
                    $(this).parents(".permission-list").find("dt").first().find("input:checkbox").prop("checked",false);
                }
            }
        });



        $("#form-admin-role-add").validate({
            rules:{
                rolename:{
                    required:true,
                },
                describes:{
                    required:true,
                },
            },
            onkeyup:false,
            focusCleanup:true,
            success:"valid",
            submitHandler:function(form){
                // 批量选择
                var checkedList = new Array();
                var $chk;
                $("input[name='ck']:checked").each(function () {
                    // 得到到选中的复选框的值
                    $chk = $(this).val();
                    checkedList.push($chk);
                });
//                var params = {"permissions": checkedList.toString()};
                $.post("/role/add?permissions="+checkedList.toString(), $("#form-admin-role-add").serialize(), function (data) {
                    console.info(data);
                });
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
            }
        });
    });
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>