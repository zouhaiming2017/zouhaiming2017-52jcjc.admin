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
    <title>客户订单列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>客户订单列表管理 <span class="c-gray en">&gt;</span> 客户订单列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="text-c">
        <form action="/sellorderSum/like" method="post">
            <button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button>
        <span class="select-box inline">
        <select name="company" class="select">
            <option value="0" selected="selected">公司分类</option>
            <c:forEach var="company" items="${companys}">
                <option value="${company.company}">${company.company}</option>
            </c:forEach>
		</select>
        </span>
        <span class="select-box inline">
		<select name="address" class="select">
            <option value="0" selected="selected" style="align-content: center">工地分类</option>
            <c:forEach var="address" items="${addresses}">
                <option value="${address.address}">${address.address}</option>
            </c:forEach>
		</select>
        </span>
            日期范围：
            <input type="text" value="<fmt:formatDate value="${selldateMin}" pattern="yyyy-MM-dd"/>" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'logmax\')||\'%y-%M-%d\'}' })" id="logmin" name="selldateMin" class="input-text Wdate" style="width:120px;">
            -
            <input type="text" value="<fmt:formatDate value="${selldateMax}" pattern="yyyy-MM-dd"/>" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'logmin\')}',maxDate:'%y-%M-%d' })" id="logmax" name="selldateMax" class="input-text Wdate" style="width:120px;">
            <%--<input type="text" name="sellordercode" id="sellordercode" value="${sellordercode}" placeholder="订单编号" style="width:250px" class="input-text">--%>
            <button name=""  class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜客户订单</button>
        </form>
    </div>
    <br/>
    <div class="text-c">
        <form method="post" enctype="multipart/form-data" id="importExcel">
            <!--上传按钮-->
            <span class="btn-upload">
            <a href="javascript:void();" class="btn btn-default radius"><i class="Hui-iconfont">&#xe642;</i> 浏览文件</a>
            <input type="file" multiple name="myFile" class="input-file" id="myFile">
        </span>
            <button name=""  class="btn btn-secondary-outline  size-M radius" onclick="upload()"><i class="Hui-iconfont">&#xe645;</i>导入Excel-（客户订单表）</button>
        </form>
    </div>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
            <a onclick="article_add('添加订单汇总','/sellorderSum/add')" href="javascript:;" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加客户订单</a>
        </span>

        <span class="r">
            <%--<button onclick="countSum()"  class="btn btn-success-outline radius"><i class="Hui-iconfont">&#xe61e;</i>统计价格</button>--%>
            <button onclick="exportExcel()"  class="btn btn-warning-outline radius"><i class="Hui-iconfont">&#xe644;</i>导出</button>
        </span>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
            <thead>
            <tr class="text-c">
                <th width="25"><input type="checkbox" name="ckAll" value=""></th>
                <th width="30">序号</th>
                <th width="160">客户订单编号</th>
                <th width="120">订货单位</th>
                <th width="100">商品编码</th>
                <th width="100">商品名称</th>
                <th width="80">售价</th>
                <th width="80">数量</th>
                <th width="80">合计</th>
                <th width="120">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="sellorderMaster" items="${sellorderMasters}">
                <tr class="text-c">
                    <td><input type="checkbox" value="" name="ck"></td>
                    <td>${sellorderMaster.id}</td>
                    <td>${sellorderMaster.sellordercode}</td>
                    <td>${sellorderMaster.company}</td>
                    <td>${sellorderMaster.itemcode}</td>
                    <td>${sellorderMaster.itemname}</td>
                    <td>${sellorderMaster.outprice}</td>
                    <td>${sellorderMaster.count}</td>
                    <td>${sellorderMaster.sum}</td>
                    <td class="f-14 td-manage"><a style="text-decoration:none" class="ml-5" onClick="article_detail('详情','/sellorderSum/detail','${sellorderSum.sellordercode}')" href="javascript:;" title="详情"><i class="Hui-iconfont">&#xe715;</i></a> <a style="text-decoration:none" class="ml-5" onClick="article_edit('编辑','/sellorderSum/update','${sellorderSum.sellordercode}')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" class="ml-5" onClick="article_del(this,'${sellorderSum.sellordercode}')"  href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
                </tr>
            </c:forEach>
            </tbody>
            <%--<thead>--%>
            <%--<tr class="text-c" style="font-weight:bold;font-size:300px;">--%>
                <%--<th colspan="4" >价格统计：</th>--%>
                <%--<th>${onlineSums}</th>--%>
                <%--<th>${underlineSums}</th>--%>
                <%--<th>${freights}</th>--%>
                <%--<th>${allSums}</th>--%>
                <%--<th>总额：${allSums}</th>--%>
            <%--</tr>--%>
            <%--</thead>--%>
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

    /*导入*/
    function upload() {
        var file = document.getElementById('myFile');
        var form1 = document.getElementById('importExcel');
        if (file.value == null || file.value == "") {
            alert("请选则文件！");
        } else {
            form1.action = "/sellorderSum/importExcel";
            form1.submit();
            layer.msg('上传成功!', {icon: 1, time: 900});
        }
    }
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
            // 找到此行中的sellordercode所在td
            var $td = $tr.find("td").eq(1).text();
            checkedList.push($td);
        });

        //设置传到controller层的参数
//        var params = {"sellordercodes": checkedList.toString()};
        document.location.href="/sellorderSum/exportExcel?sellordercodes="+checkedList.toString();

    }

    /*批量删除*/
    function datadel() {
        // 判断是否至少选择一项
        var checkedNum = $("input[name='ck']:checked").length;
        if (checkedNum == 0) {
            alert("请选择至少一项！");
            return;
        }

        // 批量选择
        var checkedList = new Array();
        var $tr;
        $("input[name='ck']:checked").each(function () {
            // 找到选中的复选框所在的行
            $tr = $(this).eq(0).parent().parent();
            // 找到此行中的sellordercode所在td
            var $td = $tr.find("td").eq(1).text();
            checkedList.push($td);
        });


        //设置传到controller层的参数
        var params = {"sellordercodes": checkedList.toString()};
        layer.confirm('确认要删除订单编号为'+checkedList.toString()+'的数据吗？',function(index){
            if(index) {
                $.post("/sellorderSum/delete", params, function (data) {
                    $("input[name='ck']:checked").each(function () {
                        // 找到选中的复选框所在的行
                        $tr = $(this).eq(0).parent().parent();
                        //删除页面被选中的节点数据
                        $tr.remove();

                    });
                    layer.msg('已删除!', {icon: 1, time: 900});
                })
            }
        })
    }

    $('.table-sort').dataTable({
        "aaSorting": [[1, "desc"]],//默认第几个排序
        "bStateSave": true,//状态保存
        "pading": false,
        "aoColumnDefs": [
            //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
            {"orderable": false, "aTargets": [0, 8]}// 不参与排序的列
        ]
    });


    /*添加*/
    function article_add(title,url){
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }

    /*详情页面*/
    function article_detail(title,url,sellordercode,w,h){
        var index = layer.open({
            type: 2,
            title: title,
            content: url+"?sellordercode="+sellordercode
        });
        layer.full(index);
    }

    /*编辑*/
    function article_edit(title,url,sellordercode,w,h){
        var index = layer.open({
            type: 2,
            title: title,
            content: url+"?sellordercode="+sellordercode
        });
        layer.full(index);
    }

    /*删除*/
    function article_del(obj,sellordercode){
        layer.confirm('确认要删除订单编号为'+sellordercode+'的数据吗？',function(index){
            if(index) {
                var param = {"sellordercode": sellordercode};
                $.post("/sellorderSum/deleteOne", param, function (data) {
                    $(obj).parents("tr").remove();
                    layer.msg('已删除!', {icon: 1, time: 600});
                })
            }
        });
    }
</script>
</body>
</html>
