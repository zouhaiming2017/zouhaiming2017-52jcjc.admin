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
    <title>集兮车队订单列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>集兮车队订单列表管理 <span class="c-gray en">&gt;</span> 集兮车队订单列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="text-c">
        <form action="/jixitruckOrder/list" method="post">
            <button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button>
            日期范围：
            <input type="text" value="<fmt:formatDate value="${pickdateMin}" pattern="yyyy-MM-dd"/>" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'logmax\')||\'%y-%M-%d\'}' })" id="logmin" name="pickdateMin" class="input-text Wdate" style="width:120px;">
            -
            <input type="text" value="<fmt:formatDate value="${pickdateMax}" pattern="yyyy-MM-dd"/>" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'logmin\')}',maxDate:'%y-%M-%d' })" id="logmax" name="pickdateMax" class="input-text Wdate" style="width:120px;">
            <button name=""  class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜集兮车队订单</button>
        </form>
    </div>

    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <shiro:hasPermission name="jixitruckOrder:delete"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a></shiro:hasPermission>
            <shiro:hasPermission name="jixitruckOrder:add"><a onclick="article_add('添加集兮车队订单','/jixitruckOrder/add')" href="javascript:;" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加集兮车队订单</a></shiro:hasPermission>
        </span>

        <span class="r">
            <%--<shiro:hasPermission name="pickOrderSum:import"><a onclick="article_import('导入excel','/jixitruckOrder/excelUpload')" href="javascript:;" class="btn btn-secondary-outline  size-M radius"><i class="Hui-iconfont">&#xe645;</i> 导入excel文件</a></shiro:hasPermission>--%>
            <shiro:hasPermission name="jixitruckOrder:exportExcel"><button onclick="exportExcel()"  class="btn btn-warning-outline radius"><i class="Hui-iconfont">&#xe644;</i>导出</button></shiro:hasPermission>
        </span>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
            <thead>
            <tr class="text-c">
                <th width="25"><input type="checkbox" name="ckAll" value=""></th>
                <th width="180">订单编号</th>
                <th width="90">配送时间</th>
                <th width="120">供应商</th>
                <th width="180">运输路线</th>
                <th width="90">运费</th>
                <th width="120">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="jixitruckOrder" items="${jixitruckOrders}">
                <tr class="text-c">
                    <td><input type="checkbox" value="" name="ck"></td>
                    <td>${jixitruckOrder.sellordercode}</td>
                    <td><fmt:formatDate value="${jixitruckOrder.senddate}" pattern="yyyy-MM-dd"/></td>
                    <td>${jixitruckOrder.supplier}</td>
                    <td>${jixitruckOrder.address}</td>
                    <td>${jixitruckOrder.freight}</td>
                    <td class="f-14 td-manage">
                        <shiro:hasPermission name="jixitruckOrder:update"><a style="text-decoration:none" class="ml-5" onClick="article_edit('编辑','/jixitruckOrder/update','${jixitruckOrder.sellordercode}')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a></shiro:hasPermission>
                        <shiro:hasPermission name="jixitruckOrder:delete"><a style="text-decoration:none" class="ml-5" onClick="article_del(this,'${jixitruckOrder.sellordercode}')"  href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></shiro:hasPermission></td>
                </tr>
            </c:forEach>
            </tbody>
            <thead>
            <tr class="text-c">
                <th colspan="5">运费总计：</th>
                <th>${freights}</th>
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
    /*导入*/
    function upload() {
        var file = document.getElementById('myFile');
        var form1 = document.getElementById('importExcel');
        if (file.value == null || file.value == "") {
            alert("请选则文件！");
        } else {
            form1.action = "/jixitruckOrder/importExcel";
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
            // 找到此行中的pickordercodes所在td
            var $td = $tr.find("td").eq(1).text();
            checkedList.push($td);
        });

        document.location.href="/jixitruckOrder/exportExcel?sellordercodes="+checkedList.toString();

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
        layer.confirm('确认要删除订单编号为'+checkedList.toString()+'的集兮车队订单吗？',function(index){
            if(index) {
                $.post("/jixitruckOrder/delete", params, function (data) {
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
            {"orderable": false, "aTargets": [0, 6]}// 不参与排序的列
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

    /*导入excel*/
    function article_import(title,url){
        var index = layer.open({
            type: 2,
            title: title,
            content: url
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
        layer.confirm('确认要删除订单编号为'+sellordercode+'的集兮车队订单吗？',function(index){
            if(index) {
                var param = {"sellordercode": sellordercode};
                $.post("/jixitruckOrder/deleteOne", param, function (data) {
                    $(obj).parents("tr").remove();
                    layer.msg('已删除!', {icon: 1, time: 600});
                })
            }
        });
    }
</script>
</body>
</html>
