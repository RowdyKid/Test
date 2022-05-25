<%--
  Created by IntelliJ IDEA.
  User: 王宇轩
  Date: 2022/5/24
  Time: 17:06
  该界面用来为异常界面，当程序发生异常时跳转到此界面.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>错误页面</title>
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
<%--异常异常展示界面，提示用户他的操作导致了一个异常发生，提供按钮供用户返回主页--%>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">错误页面</h3>
                </div>
                <div class="panel-body">
                    <div class="alert alert-danger">
                        当前操作导致异常发生
                        <%--<%=exception.getMessage()%>--%>
                    </div>
                    <div class="form-group">
                        <a href="index.jsp" class="btn btn-lg btn-success btn-block">返回主页</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
