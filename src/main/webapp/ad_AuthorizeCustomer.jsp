<%--
  Created by IntelliJ IDEA.
  User: 王宇轩
  Date: 2022/6/3
  Time: 20:23
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
<%--页面剩余部分显示权限配置表单，要求显示用户名，和角色选择，可勾选操作员或管理员，有提交和返回按钮--%>
<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header" style="text-align: center">
                    权限配置
                </h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        权限分配
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <form role="form" action="" method="post">
                                    <div class="form-group">
                                        <label>用户名</label>
                                        <input class="form-control" name="username" value="张三" readonly>
                                    </div>
                                    <div class="form-group">
                                        <label>权限配置</label>
                                        <select class="form-control" name="role">
                                            <option value="0">操作员</option>
                                            <option value="1">管理员</option>
                                        </select>
                                    </div>
                                    <button type="submit" class="btn btn-default">提交</button>
                                    <button type="reset" class="btn btn-default">重置</button>
                                </form>
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
