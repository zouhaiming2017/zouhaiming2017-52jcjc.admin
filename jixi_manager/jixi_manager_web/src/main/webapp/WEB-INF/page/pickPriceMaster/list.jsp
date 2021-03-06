<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/8
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>供应商报价列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 供应商报价列表管理 <span class="c-gray en">&gt;</span> 供应商报价列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="text-c">
        <form action="/pickPriceMaster/like" method="post">
        <button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button>
        <span class="select-box inline">
		<select name="supplier" class="select">
            <option value="0" selected="selected">供应商分类</option>
            <c:forEach var="supplier" items="${suppliers}">
                <option value="${supplier.supplier}">${supplier.supplier}</option>
            </c:forEach>
		</select>
        </span>
        <input type="text" name="itemname" id="itemname" value="${itemname}" placeholder="商品名称" style="width:250px" class="input-text">
        <button name=""  class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜供应商报价</button>
        </form>
    </div>
    <br/>

    <shiro:hasPermission name="pickPriceMaster:import">
    <div class="text-c">
    <form method="post" enctype="multipart/form-data" id="importExcel">
        <!--上传按钮-->
        <span class="btn-upload">
            <a href="javascript:void();" class="btn btn-default radius"><i class="Hui-iconfont">&#xe642;</i> 浏览文件</a>
            <input type="file" multiple name="myFile" class="input-file" id="myFile">
        </span>
        <button name=""  class="btn btn-secondary-outline  size-M radius" onclick="upload()"><i class="Hui-iconfont">&#xe645;</i>导入Excel-（供应商报价表）</button>
    </form>
    </div>
    </shiro:hasPermission>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <shiro:hasPermission name="pickPriceMaster:delete"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> </shiro:hasPermission>
            <shiro:hasPermission name="pickPriceMaster:add"><a onclick="article_add('添加供应商报价','/pickPriceMaster/add')" href="javascript:;" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加供应商报价</a></shiro:hasPermission>
        </span>
        <span class="r">
            <shiro:hasPermission name="pickPriceMaster:export"><a href="/pickPriceMaster/exportExcel"><button name=""  class="btn btn-warning-outline size-M radius"><i class="Hui-iconfont">&#xe644;</i>导出</button></a></shiro:hasPermission>
        </span>
    </div>
    <div class="mt-20">
        <table id="pickpriceMasterList" class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
            <thead>
            <tr class="text-c">
                <th width="25"><input type="checkbox" name="ckAll" value=""></th>
                <th width:100>商品编码</th>
                <th width:120>商品名称</th>
                <th width:80>规格</th>
                <th width:80>型号</th>
                <th width:80>品牌</th>
                <th width:80>计价单位</th>
                <th width:70>进价</th>
                <th width:80>包装规格</th>
                <th width:160>供应商名</th>
                <th width:160>供应编码</th>
                <th width="120">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="pickpriceMaster" items="${pickpriceMasters}">
            <tr class="text-c">
                <td><input type="checkbox" value="" name="ck"></td>
                <td>${pickpriceMaster.itemcode}</td>
                <td>${pickpriceMaster.itemname}</td>
                <td>${pickpriceMaster.standard}</td>
                <td>${pickpriceMaster.model}</td>
                <td>${pickpriceMaster.brandname}</td>
                <td>${pickpriceMaster.chargeunit}</td>
                <td>${pickpriceMaster.inprice}</td>
                <td>${pickpriceMaster.packingsize}</td>
                <td>${pickpriceMaster.supplier}</td>
                <td>${pickpriceMaster.suppliercode}</td>
                <td class="f-14 td-manage"> <shiro:hasPermission name="pickPriceMaster:update"><a style="text-decoration:none" class="ml-5" onClick="article_edit('编辑','/pickPriceMaster/update','${pickpriceMaster.itemcode}')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> </shiro:hasPermission>
                    <shiro:hasPermission name="pickPriceMaster:delete"><a style="text-decoration:none" class="ml-5" onClick="article_del(this,'${pickpriceMaster.itemcode}')"  href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></shiro:hasPermission></td>
                </tr>
            </c:forEach>
            </tbody>
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
            form1.action = "/pickPriceMaster/importExcel";
            form1.submit();
            layer.msg('上传成功!', {icon: 1, time: 900});
        }
    }

    /*批量删除*/
    function datadel() {
        // 判断是否至少选择一项
        var checkedNum = $("input[name='ck']:checked").length;
        if (checkedNum == 0) {
            layer.alert("请选择至少一项！");
            return;
        }

        // 批量选择
        var checkedList = new Array();
        var $tr;
        $("input[name='ck']:checked").each(function () {
            // 找到选中的复选框所在的行
             $tr = $(this).eq(0).parent().parent();
            // 找到此行中的itemcode所在td
            var $td = $tr.find("td").eq(1).text();
            checkedList.push($td);
        });


        //设置传到controller层的参数
        var params = {"itemcodes": checkedList.toString()};
        layer.confirm('确认要删除商品编码为'+checkedList.toString()+'的报价数据吗？',function(index){
            if(index) {
                $.post("/pickPriceMaster/delete", params, function (data) {
                    $("input[name='ck']:checked").each(function () {
                        // 找到选中的复选框所在的行
                        $tr = $(this).eq(0).parent().parent();
                        //删除页面被选中的节点数据
                        $tr.remove();

                    });
                    layer.msg('已删除!', {icon: 1, time: 600});
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
                {"orderable": false, "aTargets": [0, 11]}// 不参与排序的列
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
    /*编辑*/
    function article_edit(title,url,itemCode,w,h){
            var index = layer.open({
                type: 2,
                title: title,
                content: url+"?itemCode="+itemCode
            });
            layer.full(index);
    }

    /*删除*/
    function article_del(obj,itemCode){
        layer.confirm('确认要删除商品编码为'+itemCode+'的报价数据吗？',function(index){
           if(index) {
               var param = {"itemCode": itemCode};
               $.post("/pickPriceMaster/deleteOne", param, function (data) {
                   $(obj).parents("tr").remove();
                   layer.msg('已删除!', {icon: 1, time: 600});
               })
           }
        });
    }
</script>
</body>
</html>
