<%--
  Created by IntelliJ IDEA.
  User: 王宇轩
  Date: 2022/6/3
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>合同管理系统</title>
    <%--导入相关美化部件--%>
    <%@include file="ad_AdminCSS.jsp" %>
</head>
<body>
<%--整体包裹容器--%>
<div id="wrapper">
    <%@include file="ad_AdminMenu.jsp" %>
</div>
<%--用户表格，显示用户名称，对应的角色名称和操作--%>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">用户管理</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    用户列表
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="请输入客户名称">
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="button">搜索</button>
                                </span>
                            </div>
                        </div>
                    </div>
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>用户名</th>
                                <th>角色</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <% for (int i = 0; i < 3; i++) { %>
                            <tr>
                                <td>用户名</td>
                                <td>角色</td>
                                <td>
                                    <a href="ad_ModifyUserInfo.jsp">修改</a>
                                    <a href="ad_AuthorizeCustomer.jsp">授权</a>
                                    <a href="">删除</a>
                                </td>
                            </tr>
                            <% } %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
