<%--
  Created by IntelliJ IDEA.
  User: 王宇轩
  Date: 2022/5/24
  Time: 20:00
  这是系统管理员登陆后的主页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>合同管理系统</title>
    <%--导入相关美化部件--%>
    <%@include file="AdminCSS.jsp" %>
</head>
<body>
<%--整体包裹容器--%>
<div id="wrapper">
    <%@include file="AdminMenu.jsp" %>
</div>
<%--主页展示界面--%>
<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12" style="background-size: cover">
                <%--将hi标签居中--%>
                <h1 class="page-header" style="text-align: center">欢迎登入后台管理系统</h1>
            </div>
        </div>
    </div>
</div>
</body>
</html>
