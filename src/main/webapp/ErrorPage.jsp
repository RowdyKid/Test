<%--
  Created by IntelliJ IDEA.
  User: 祁麟
  Date: 2022/9/23
  Time: 23:17
  该界面用来为异常界面，当程序发生异常时跳转到此界面.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>错误页面</title>
    <%@include file="cssImport.jsp" %>
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
                        <a href="Login.jsp" class="btn btn-lg btn-success btn-block">返回主页</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
