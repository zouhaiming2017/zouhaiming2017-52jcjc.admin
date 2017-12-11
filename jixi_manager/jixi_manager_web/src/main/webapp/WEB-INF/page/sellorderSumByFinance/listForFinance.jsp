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
    <title>客户订单财务统计</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>客户订单财务统计表管理 <span class="c-gray en">&gt;</span> 客户订单财务统计表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="text-c">
        <form action="/sellorderSumByFinance/listForFinance" method="post">
            <button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button>
            <span class="select-box inline">
        <select name="projectName" class="select">
            <option value="0" selected="selected">项目分类</option>
            <c:forEach var="projectName" items="${projectNames}">
                <option value="${projectName.projectname}">${projectName.projectname}</option>
            </c:forEach>
		</select>
        </span>
            <span class="select-box inline">
        <select name="company" class="select">
            <option value="0" selected="selected">公司分类</option>
            <c:forEach var="company" items="${companys}">
                <option value="${company.company}">${company.company}</option>
            </c:forEach>
		</select>
        </span>
            <span class="select-box inline">
        <select name="customername" class="select">
            <option value="0" selected="selected">客户分类</option>
            <c:forEach var="customername" items="${customerNames}">
                <option value="${customername.customername}">${customername.customername}</option>
            </c:forEach>
		</select>
        </span>
        <span class="select-box inline">
        <select name="customertype" class="select">
            <option value="0" selected="selected">客户类型分类</option>
            <c:forEach var="customerType" items="${customerTypes}">
                <option value="${customerType.customertype}">${customerType.customertype}</option>
            </c:forEach>
		</select>
        </span>
            <span class="select-box inline">
        <select name="sellman" class="select">
            <option value="0" selected="selected">业务员分类</option>
            <c:forEach var="sellman" items="${sellmen}">
                <option value="${sellman.sellmanname}">${sellman.sellmanname}</option>
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
            <input type="text" value="<fmt:formatDate value="${selldateMin}" pattern="yyyy-MM-dd"/>" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'logmax\')||\'%y-%M-%d\'}' })" id="logmin" name="selldateMin" class="input-text Wdate" style="width:120px;">
            -
            <input type="text" value="<fmt:formatDate value="${selldateMax}" pattern="yyyy-MM-dd"/>" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'logmin\')}',maxDate:'%y-%M-%d' })" id="logmax" name="selldateMax" class="input-text Wdate" style="width:120px;">
            <br/><br/>
            <input type="text" name="sellordercode" id="sellordercode" value="${sellordercode}" placeholder="订单编号" style="width:250px" class="input-text">
            <button name=""  class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜客户订单</button>
        </form>
    </div>

    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
        </span>

        <span class="r">
            <shiro:hasPermission name="sellorderSumByFinance:exportExcelAsFinance"><button onclick="exportExcel()"  class="btn btn-warning-outline radius"><i class="Hui-iconfont">&#xe644;</i>导出</button></shiro:hasPermission>
        </span>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
            <thead>
            <tr class="text-c">
                <th width="25"><input type="checkbox" name="ckAll" value=""></th>
                <th width="160">订单编号</th>
                <th width="120">项目名称</th>
                <th width="80">业务员</th>
                <th width="80">总计</th>
                <th width="80">已收款</th>
                <th width="80">未收款</th>
                <th width="80">开票状态</th>
                <th width="80">发票单号</th>
                <th width="120">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="sellorderSum" items="${sellorderSums}">
                <tr class="text-c">
                    <td><input type="checkbox" value="" name="ck"></td>
                    <td>${sellorderSum.sellordercode}</td>
                    <td>${sellorderSum.projectname}</td>
                    <td>${sellorderSum.sellman}</td>
                    <td>${sellorderSum.discountprice}</td>
                    <td>${sellorderSum.receivedsum}</td>
                    <td>${sellorderSum.noreceivedsum}</td>
                    <td class="td-status">
                        <c:if test="${sellorderSum.ticketstatus==0||sellorderSum.ticketstatus==null}">
                            <span class="label label-defaunt radius">未开票</span>
                        </c:if>

                        <c:if test="${sellorderSum.ticketstatus==1}">
                            <span class="label label-success radius">已开票</span>
                        </c:if>
                    </td>
                    <td>${sellorderSum.ticketno}</td>

                    <td class="f-14 td-manage">
                        <c:if test="${sellorderSum.ticketstatus==0||sellorderSum.ticketstatus==null}">
                            <shiro:hasPermission name="sellorderSumByFinance:update">
                            <a style="text-decoration:none" onClick="article_start(this,'${sellorderSum.sellordercode}')" href="javascript:;" title="开发票"><i class="Hui-iconfont">&#xe603;</i></a>
                            <a style="text-decoration:none" class="ml-5" onClick="article_edit('编辑','/sellorderSumByFinance/updateByFinance','${sellorderSum.sellordercode}')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a>
                            </shiro:hasPermission>
                            <a style="text-decoration:none" class="ml-5" onClick="article_detail('详情','/sellorderSum/detail','${sellorderSum.sellordercode}')" href="javascript:;" title="详情"><i class="Hui-iconfont">&#xe715;</i></a>
                        </c:if>

                        <c:if test="${sellorderSum.ticketstatus==1}">
                            <shiro:hasPermission name="sellorderSumByFinance:update">
                            <a style="text-decoration:none" onClick="article_stop(this,'${sellorderSum.sellordercode}')" href="javascript:;" title="不开票"><i class="Hui-iconfont">&#xe6de;</i></a>
                            <a style="text-decoration:none" class="ml-5" onClick="article_edit('编辑','/sellorderSumByFinance/updateByFinance','${sellorderSum.sellordercode}')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a>
                            </shiro:hasPermission>
                            <a style="text-decoration:none" class="ml-5" onClick="article_detail('详情','/sellorderSum/detail','${sellorderSum.sellordercode}')" href="javascript:;" title="详情"><i class="Hui-iconfont">&#xe715;</i></a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
            <thead>
                <tr class="text-c">
                    <th colspan="4">价格汇总：</th>
                    <th>${discountprices}</th>
                    <th>${receivedsums}</th>
                    <th>${noReceivedsums}</th>
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
    function article_detail(title,url,sellordercode,w,h){
        var index = layer.open({
            type: 2,
            title: title,
            content: url+"?sellordercode="+sellordercode
        });
        layer.full(index);
    }

    /*开发票*/
    function article_start(obj,sellordercode){
        layer.confirm('确认要改为已开票吗？',function(index){
            var ticketno=prompt('请输入发票单号','');
            document.location.href="/sellorderSumByFinance/updateTicketStatusAsYes?sellordercode="+sellordercode+"&&ticketno="+ticketno;
            $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="article_stop(this,id)" href="javascript:;" title="不开票"><i class="Hui-iconfont">&#xe6de;</i></a>');
            $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已开票</span>');
            $(obj).remove();
            layer.msg('已开票!',{icon: 5,time:1000});
        });
    }

    /*未开票*/
    function article_stop(obj,sellordercode){
        layer.confirm('确认要改为未开票吗？',function(index){
            document.location.href="/sellorderSumByFinance/updateTicketStatusAsNo?sellordercode="+sellordercode;
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
        document.location.href="/sellorderSumByFinance/exportExcelAsFinance?sellordercodes="+checkedList.toString();
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


    /*编辑*/
    function article_edit(title,url,sellordercode,w,h){
        var index = layer.open({
            type: 2,
            title: title,
            content: url+"?sellordercode="+sellordercode
        });
        layer.full(index);
    }

</script>
</body>
</html>