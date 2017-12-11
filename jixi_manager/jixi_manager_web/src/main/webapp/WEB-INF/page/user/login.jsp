<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/8
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="Bookmark" href="/favicon.ico" >
    <link rel="Shortcut Icon" href="/favicon.ico" />
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
    <title>集兮商城后台管理系统</title>
    <meta name="keywords" content="H-ui.admin v3.1,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
    <meta name="description" content="H-ui.admin v3.1，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<header class="navbar-wrapper">
    <div class="navbar navbar-fixed-top">
        <div class="container-fluid cl"> <a class="logo navbar-logo f-l mr-10 hidden-xs" href="#">后台管理系统</a> <a class="logo navbar-logo-m f-l mr-10 visible-xs" href="/aboutHui.shtml">H-ui</a>
            <span class="logo navbar-slogan f-l mr-10 hidden-xs">集兮商城</span>
            <%--<a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>--%>
            <nav class="nav navbar-nav">
                <ul class="cl">
                    <shiro:hasRole name="超级管理员">
                    <li class="dropDown dropDown_hover"><a href="javascript:;" class="dropDown_A"><i class="Hui-iconfont">&#xe600;</i> 新增 <i class="Hui-iconfont">&#xe6d5;</i></a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <li><a href="javascript:;" onclick="member_add('添加用户','/user/add','','510')"><i class="Hui-iconfont">&#xe60d;</i> 用户</a></li>
                        </ul>
                    </li>
                    </shiro:hasRole>
                </ul>
            </nav>
            <nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
                <ul class="cl">
                    <li>管理员</li>
                    <li class="dropDown dropDown_hover">
                        <a href="#" class="dropDown_A">${user.username} <i class="Hui-iconfont">&#xe6d5;</i></a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <li><a href="javascript:;" onClick="myselfinfo()">个人信息</a></li>
                            <li><a onClick="article_edit('修改密码','/user/updatePassword','${user.id}')" href="javascript:;" title="修改密码">修改密码</a></li>
                            <li><a href="/">切换账户</a></li>
                            <li><a href="/">退出</a></li>
                        </ul>
                    </li>
                    <li id="Hui-msg"> <a href="#" title="消息"><span class="badge badge-danger">1</span><i class="Hui-iconfont" style="font-size:18px">&#xe68a;</i></a> </li>
                    <li id="Hui-skin" class="dropDown right dropDown_hover"> <a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
                            <li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
                            <li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
                            <li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
                            <li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
                            <li><a href="javascript:;" data-val="orange" title="橙色">橙色</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</header>
<aside class="Hui-aside">
    <div class="menu_dropdown bk_2">
        <dl id="menu-article">
            <dt><i class="Hui-iconfont">&#xe616;</i>&nbsp;<strong>价目管理</strong><i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="/pickPriceMaster/list" data-title="供应商报价管理" href="javascript:void(0)">供应商报价管理</a></li>
                    <li><a data-href="/sellPriceMaster/list" data-title="商城上线价管理" href="javascript:void(0)">商城上线价管理</a></li>
                    <%--<li><a data-href="/pickOrderMaster/list" data-title="配货订单管理" href="javascript:void(0)">配货订单管理</a></li>--%>
                    <%--<li><a data-href="/sellOrderMaster/list" data-title="客户订单管理" href="javascript:void(0)">客户订单管理</a></li>--%>
                </ul>
            </dd>
        </dl>
        <dl id="menu-pricecount">
            <dt><i class="Hui-iconfont">&#xe6b6;</i>&nbsp;<strong>汇总管理</strong><i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="/sellorderSum/list" data-title="客户订单汇总管理" href="javascript:void(0)">客户订单汇总管理</a></li>
                    <li><a data-href="/pickOrderSum/list" data-title="配货订单汇总管理" href="javascript:void(0)">配货订单汇总管理</a></li>
                    <%--<li><a data-href="/jixitruckOrder/list" data-title="集兮车队订单管理" href="javascript:void(0)">集兮车队订单管理</a></li>--%>
                </ul>
            </dd>
        </dl>
        <dl id="menu-finance">
            <dt><i class="Hui-iconfont">&#xe63a;</i>&nbsp;<strong>财务管理</strong><i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="/sellorderSumByFinance/listForFinance" data-title="客户订单财务管理" href="javascript:void(0)">客户订单财务管理</a></li>
                    <li><a data-href="/pickorderSumByFinance/listForFinance" data-title="配货订单财务管理" href="javascript:void(0)">配货订单财务管理</a></li>
                    <li><a data-href="/taxService/list" data-title="税务进销项统计" href="javascript:void(0)">税务进销项统计</a></li>
                </ul>
            </dd>
        </dl>
        <dl id="menu-product">
            <dt><i class="Hui-iconfont">&#xe620;</i>&nbsp;<strong>商品管理</strong><i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="/item/list" data-title="商品库存管理" href="javascript:void(0)">商品库存管理</a></li>
                    <li><a data-href="/pickorderItem/list" data-title="商品售出管理" href="javascript:void(0)">商品售出管理</a></li>
                    <li><a data-href="/pickorderItem/ranking" data-title="商品销售排行" href="javascript:void(0)">商品销售排行</a></li>
                </ul>
            </dd>
        </dl>
        <dl id="menu-member">
            <dt><i class="Hui-iconfont">&#xe60d;</i>&nbsp;<strong>客户管理</strong><i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="/customer/list" data-title="客户列表" href="javascript:;">客户列表</a></li>
                </ul>
            </dd>
        </dl>
        <dl id="menu-comments">
            <dt><i class="Hui-iconfont">&#xe62c;</i>&nbsp;<strong>供应商管理</strong><i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="/supplier/list" data-title="供应商管理" href="javascript:void(0)">供应商管理</a></li>
                </ul>
            </dd>
        </dl>
        <dl id="menu-picture">
            <dt><i class="Hui-iconfont">&#xe705;</i>&nbsp;<strong>业务员管理</strong><i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="/sellman/list" data-title="业务员管理" href="javascript:void(0)">业务员管理</a></li>
                </ul>
            </dd>
        </dl>
        <dl id="menu-admin">
            <dt><i class="Hui-iconfont">&#xe60a;</i>&nbsp;<strong>管理员管理</strong> <i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="/role/list" data-title="角色管理" href="javascript:void(0)">角色管理</a></li>
                    <%--<li><a data-href="/permission/list" data-title="权限管理" href="javascript:void(0)">权限管理</a></li>--%>
                    <li><a data-href="/user/list" data-title="管理员列表" href="javascript:void(0)">管理员列表</a></li>
                </ul>
            </dd>
        </dl>
        <dl id="menu-tongji">
            <dt><i class="Hui-iconfont">&#xe61a;</i>&nbsp;<strong>图表统计</strong><i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="/charts/sum-year" data-title="收支年统计图" href="javascript:void(0)">收支年统计图</a></li>
                    <li><a data-href="/charts/sum-month" data-title="收支月统计图" href="javascript:void(0)">收支月统计图</a></li>
                    <li><a data-href="/charts/pie-chart" data-title="饼状图" href="javascript:void(0)">饼状图</a></li>
                    <li><a data-href="/charts/map-chart" data-title="地区分布图" href="javascript:void(0)">地区分布图</a></li>
                    <li><a data-href="/charts/sellman-year" data-title="业务员年销售图" href="javascript:void(0)">业务员年销售图</a></li>
                </ul>
            </dd>
        </dl>
        <dl id="month-detail">
            <dt><i class="Hui-iconfont">&#xe62e;</i>&nbsp;<strong>月度明细</strong><i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="/dataShow/customerTypeDetail" data-title="客户类型月度明细" href="javascript:void(0)">客户类型月度明细</a></li>
                    <li><a data-href="/customerDetail/getCustomerDetail" data-title="客户月度明细表" href="javascript:void(0)">客户月度明细表</a></li>
                    <li><a data-href="/supplierDetail/getSupplierDetail" data-title="供应商月度明细" href="javascript:void(0)">供应商月度明细</a></li>
                    <li><a data-href="/sellmanDetail/getSellmanDetail" data-title="销售月度明细" href="javascript:void(0)">销售月度明细</a></li>

                </ul>
            </dd>
        </dl>
        <dl id="allDate-show">
            <dt><i class="Hui-iconfont">&#xe61e;</i>&nbsp;<strong>通用分析</strong><i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="/allOrder/getAllorderList" data-title="通用订单汇总" href="javascript:void(0)">通用订单汇总</a></li>
                    <li><a data-href="/sellorderAll/getSellorderList" data-title="通用客户分析" href="javascript:void(0)">通用客户分析</a></li>
                </ul>
            </dd>
        </dl>
    </div>
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section class="Hui-article-box">
    <div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
        <div class="Hui-tabNav-wp">
            <ul id="min_title_list" class="acrossTab cl">
                <li class="active">
                    <span title="我的桌面" data-href="">我的桌面</span>
                    <em></em></li>
            </ul>
        </div>
        <div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a></div>
    </div>
    <div id="iframe_box" class="Hui-article">
        <div class="show_iframe">
            <div style="display:none" class="loading"></div>
            <%--<iframe scrolling="yes" frameborder="0" src="../../../../welcome.jsp"></iframe>--%>
            <iframe scrolling="yes" frameborder="0" src="/welcomePage/welcome"></iframe>
        </div>
    </div>
</section>

<div class="contextMenu" id="Huiadminmenu">
    <ul>
        <li id="closethis">关闭当前 </li>
        <li id="closeall">关闭全部 </li>
    </ul>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="../lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="../static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="../static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="../lib/jquery.contextmenu/jquery.contextmenu.r2.js"></script>
<script type="text/javascript">
    $(function(){
        /*$("#min_title_list li").contextMenu('Huiadminmenu', {
         bindings: {
         'closethis': function(t) {
         console.log(t);
         if(t.find("i")){
         t.find("i").trigger("click");
         }
         },
         'closeall': function(t) {
         alert('Trigger was '+t.id+'\nAction was Email');
         },
         }
         });*/
    });
    /*个人信息*/
    function myselfinfo(){
        layer.open({
            type: 1,
            area: ['300px','200px'],
            fix: false, //不固定
            maxmin: true,
            shade:0.4,
            title: '查看信息',
            content: '<div>账号：${user.username}<br/>手机号：${user.phone}</div>'
        });
    }

    /*修改密码*/
    function article_edit(title,url,id){
        var index = layer.open({
            type: 2,
            title: title,
            content: url+"?id="+id
        });
        layer.full(index);
    }

    /*资讯-添加*/
    function article_add(title,url){
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }
    /*图片-添加*/
    function picture_add(title,url){
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }
    /*产品-添加*/
    function product_add(title,url){
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }
    /*用户-添加*/
    function member_add(title,url,w,h){
        layer_show(title,url,w,h);
    }


</script>
<script>
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?080836300300be57b7f34f4b3e97d911";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>
<!--/此乃百度统计代码，请自行删除-->
</body>
</html>
