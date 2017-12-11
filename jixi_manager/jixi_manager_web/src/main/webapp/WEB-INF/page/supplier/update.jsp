<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/8
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--_meta 作为公共模版分离出去-->
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="Bookmark" href="favicon.ico" >
    <link rel="Shortcut Icon" href="favicon.ico" />
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

    <title>更新供应商信息</title>
    <meta name="keywords" content="H-ui.admin v3.1,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
    <meta name="description" content="H-ui.admin v3.1，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container">
    <form class="form form-horizontal" id="form-article-update">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">供应商编码：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${supplier.suppliercode}" placeholder="" id="suppliercode" name="suppliercode">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">公司：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${supplier.suppliername}" placeholder="" id="suppliername" name="suppliername">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">联系人：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${supplier.linkman}" placeholder="" id="linkman" name="linkman">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">联系电话：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${supplier.phone}" placeholder="" id="phone" name="phone">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">税点：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${supplier.taxpoint}" placeholder="" id="taxpoint" name="taxpoint">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">所在区域：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${supplier.address}" placeholder="" id="address" name="address">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">供应类别：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${supplier.vip}" placeholder="" id="vip" name="vip">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">供应指数：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${supplier.supplierindex}" placeholder="" id="supplierindex" name="supplierindex">
            </div>
        </div>

        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
                <button onClick="article_save_submit();" class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i>保存并提交</button>
                <button onClick="removeIframe();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
            </div>
        </div>
    </form>
</article>
<%----%>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="../lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="../static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="../static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="../lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="../lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="../lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="../lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="../lib/webuploader/0.1.5/webuploader.min.js"></script>
<script type="text/javascript" src="../lib/ueditor/1.4.3/ueditor.config.js"></script>
<script type="text/javascript" src="../lib/ueditor/1.4.3/ueditor.all.min.js"> </script>
<script type="text/javascript" src="../lib/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
    function article_save_submit(){
        $('.skin-minimal input').iCheck({
            checkboxClass: 'icheckbox-blue',
            radioClass: 'iradio-blue',
            increaseArea: '20%'
        });


        //表单验证
        $("#form-article-update").validate({
            rules:{
                suppliercode:{
                    required:true,
                },
                suppliername:{
                    required:true,
                },
                linkman:{
                    required:false,
                },
                phone:{
                    required:false,
                },
                taxpoint:{
                    required:false,
                },
                address:{
                    required:true,
                },
                vip:{
                    required:true,
                },
                supplierindex:{
                    required:true,
                },
            },

            onkeyup:false,
            focusCleanup:true,
            success:"valid",
            submitHandler:function(form){
                $.post("/supplier/update", $("#form-article-update").serialize(), function (data) {
                    console.info(data);
                });
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
            }
        });

    }

    function removeIframe() {
        document.getElementById('form-article-update').reset();
    }
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>
