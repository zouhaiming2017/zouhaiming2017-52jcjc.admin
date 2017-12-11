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
    <title>配货订单财务统计</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>配货订单财务统计表管理 <span class="c-gray en">&gt;</span> 配货订单财务统计表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="text-c">
        <form action="/pickorderSumByFinance/listForFinance" method="post">
            <button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button>
            <span class="select-box inline">
		<select name="supplier" class="select">
            <option value="0" selected="selected">供应商分类</option>
            <c:forEach var="supplier" items="${suppliers}">
                <option value="${supplier.supplier}">${supplier.supplier}</option>
            </c:forEach>
		</select>
        </span>
            <span class="select-box inline">
		<select name="address" class="select">
            <option value="0" selected="selected">收货地址分类</option>
            <c:forEach var="address" items="${addresses}">
                <option value="${address.address}">${address.address}</option>
            </c:forEach>
		</select>
        </span><br/><br/>
            <span class="select-box inline">
           <select name="allpaystatue" class="select">
           <option value="0" selected="selected">付款状态分类</option>
           <option value="已结清">已结清</option>
           <option value="未结清">未结清</option>
	    </select>
        </span>
            <span class="select-box inline">
        <select name="ticketstatus" class="select">
            <option value="0" selected="selected">开票状态分类</option>
            <option value="已开票">已开票</option>
            <option value="未开票">未开票</option>
		</select>
        </span>
            日期范围：
            <input type="text" value="<fmt:formatDate value="${pickdateMin}" pattern="yyyy-MM-dd"/>" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'logmax\')||\'%y-%M-%d\'}' })" id="logmin" name="pickdateMin" class="input-text Wdate" style="width:120px;">
            -
            <input type="text" value="<fmt:formatDate value="${pickdateMax}" pattern="yyyy-MM-dd"/>" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'logmin\')}',maxDate:'%y-%M-%d' })" id="logmax" name="pickdateMax" class="input-text Wdate" style="width:120px;">
            <br/><br/>
            <input type="text" name="pickordercode" id="pickordercode" value="${pickordercode}" placeholder="配货单号" style="width:250px" class="input-text">
            <button name=""  class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜配货订单</button>
        </form>
    </div>

    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
        </span>

        <span class="r">
            <shiro:hasPermission name="pickorderSumByFinance:exportExcelAsFinance"><button onclick="exportExcel()"  class="btn btn-warning-outline radius"><i class="Hui-iconfont">&#xe644;</i>导出</button></shiro:hasPermission>
        </span>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
            <thead>
            <tr class="text-c">
                <th width="25"><input type="checkbox" name="ckAll" value=""></th>
                <th width="160">配货单号</th>
                <th width="120">供应商</th>
                <%--<th width="80">地址</th>--%>
                <th width="80">总计</th>
                <th width="80">已付款</th>
                <th width="80">未付款</th>
                <th width="80">开票状态</th>
                <th width="80">发票单号</th>
                <th width="120">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="pickorderSum" items="${pickorderSums}">
                <tr class="text-c">
                    <td><input type="checkbox" value="" name="ck"></td>
                    <td>${pickorderSum.pickordercode}</td>
                    <td>${pickorderSum.supplier}</td>
                    <%--<td>${pickorderSum.address}</td>--%>
                    <td>${pickorderSum.allsum}</td>
                    <td>${pickorderSum.receivedsum}</td>
                    <td>${pickorderSum.noreceivedsum}</td>
                    <td class="td-status">
                        <c:if test="${pickorderSum.ticketstatus==0||pickorderSum.ticketstatus==null}">
                            <span class="label label-defaunt radius">未开票</span>
                        </c:if>

                        <c:if test="${pickorderSum.ticketstatus==1}">
                            <span class="label label-success radius">已开票</span>
                        </c:if>
                    </td>
                    <td>${pickorderSum.ticketno}</td>

                    <td class="f-14 td-manage">
                        <c:if test="${pickorderSum.ticketstatus==0||pickorderSum.ticketstatus==null}">
                            <shiro:hasPermission name="pickorderSumByFinance:update">
                                <a style="text-decoration:none" onClick="article_start(this,'${pickorderSum.pickordercode}')" href="javascript:;" title="开发票"><i class="Hui-iconfont">&#xe603;</i></a>
                                <a style="text-decoration:none" class="ml-5" onClick="article_edit('编辑','/pickorderSumByFinance/updateByFinance','${pickorderSum.pickordercode}')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a>
                            </shiro:hasPermission>
                            <a style="text-decoration:none" class="ml-5" onClick="article_detail('详情','/pickOrderSum/detail','${pickorderSum.pickordercode}')" href="javascript:;" title="详情"><i class="Hui-iconfont">&#xe715;</i></a>
                        </c:if>

                        <c:if test="${pickorderSum.ticketstatus==1}">
                            <shiro:hasPermission name="pickorderSumByFinance:update">
                                <a style="text-decoration:none" onClick="article_stop(this,'${pickorderSum.pickordercode}')" href="javascript:;" title="不开票"><i class="Hui-iconfont">&#xe6de;</i></a>
                                <a style="text-decoration:none" class="ml-5" onClick="article_edit('编辑','/pickorderSumByFinance/updateByFinance','${pickorderSum.pickordercode}')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a>
                            </shiro:hasPermission>
                            <a style="text-decoration:none" class="ml-5" onClick="article_detail('详情','/pickOrderSum/detail','${pickorderSum.pickordercode}')" href="javascript:;" title="详情"><i class="Hui-iconfont">&#xe715;</i></a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
            <thead>
            <tr class="text-c">
            <th colspan="3">价格汇总：</th>
            <th>${allsums}</th>
            <th>${receivedsums}</th>
            <th>${noreceivedsums}</th>
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
    /*详情页面*/
    function article_detail(title,url,pickordercode,w,h){
        var index = layer.open({
            type: 2,
            title: title,
            content: url+"?pickordercode="+pickordercode
        });
        layer.full(index);
    }

    /*开发票*/
    function article_start(obj,pickordercode){
        layer.confirm('确认要改为已开票吗？',function(index){
            var ticketno=prompt('请输入发票单号','');
            document.location.href="/pickorderSumByFinance/updateTicketStatusAsYes?pickordercode="+pickordercode+"&&ticketno="+ticketno;
            $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="article_stop(this,id)" href="javascript:;" title="不开票"><i class="Hui-iconfont">&#xe6de;</i></a>');
            $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已开票</span>');
            $(obj).remove();
            layer.msg('已开票!',{icon: 5,time:1000});
        });
    }

    /*未开票*/
    function article_stop(obj,pickordercode){
        layer.confirm('确认要改为未开票吗？',function(index){
            document.location.href="/pickorderSumByFinance/updateTicketStatusAsNo?pickordercode="+pickordercode;
            $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="article_start(this,id)" href="javascript:;" title="开发票"><i class="Hui-iconfont">&#xe603;</i></a>');
            $(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">未开票</span>');
            $(obj).remove();
            layer.msg('未开票!',{icon: 6,time:1000});
        });
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
        document.location.href="/pickorderSumByFinance/exportExcelAsFinance?pickordercodes="+checkedList.toString();
    }

    $('.table-sort').dataTable({
        "aaSorting": [[1, "desc"]],//默认第几个排序
        "bStateSave": true,//状态保存
        "pading": false,
        "aoColumnDefs": [
            //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
            {"orderable": false, "aTargets": [0, 7]}// 不参与排序的列
        ]
    });


    /*编辑*/
    function article_edit(title,url,pickordercode,w,h){
        var index = layer.open({
            type: 2,
            title: title,
            content: url+"?pickordercode="+pickordercode
        });
        layer.full(index);
    }

</script>
</body>
</html>