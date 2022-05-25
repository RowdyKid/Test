<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 王宇轩
  Date: 2022/5/24
  Time: 17:26
  这个界面用来提醒新用户等待管理员赋予相应的权限
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>合同管理系统</title>
    <%--添加显示时间的脚本--%>
    <script>
        function showTime() {
            var nowtime = new Date();
            var year = nowtime.getFullYear();
            var month = nowtime.getMonth() + 1;
            date = nowtime.getDate();
            var hour = nowtime.getHours();
            var minite = nowtime.getMinutes();
            var second = nowtime.getSeconds();
            document.getElementById("timeText").innerText = "当前时间:" + year + "年" + month + "月" + date + "日" + hour + "时" + minite + "分" + second + "秒";
        }

        /*每隔一秒进行函数调用*/
        setInterval("showTime()", 1000);
    </script>
    <%--待添加css--%>
    <link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <link href="assets/metisMenu/metisMenu.min.css" rel="stylesheet">

    <link href="assets/sbadmin2/css/sb-admin-2.css" rel="stylesheet">

    <link href="assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <link href="assets/css/style.css" rel="stylesheet">

    <script src="assets/jquery/jquery.min.js"></script>

    <script src="assets/bootstrap/js/bootstrap.min.js"></script>

    <script src="assets/metisMenu/metisMenu.min.js"></script>

    <script src="assets/sbadmin2/js/sb-admin-2.js"></script>
</head>
<body>
<%--界面第一行显示欢迎使用合同管理系统 最右侧显示注销登录按钮 第二行提示用户没有权限，等待管理员授权--%>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header" style="text-align: center">合同管理系统</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">欢迎使用合同管理系统</h3>
                <p style="text-align: right"><a href="Login.jsp"><i class="fa fa-sign-out fa-fw"></i>退出登录</a></p>
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">提示</h3>
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="alert alert-info">
                                            <strong>您没有权限，请等待管理员授权</strong>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
