<%--
  Created by IntelliJ IDEA.
  User: 王宇轩
  Date: 2022/6/5
  Time: 19:04
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
<%--主体内容--%>
<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header" style="text-align: center">修改用户信息</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <form role="form" action="" method="post">
                                    <div class="form-group">
                                        <label>用户名称</label>
                                        <input class="form-control" name="customerName"
                                               value="张三">
                                    </div>
                                    <div class="form-group">
                                        <label>密码</label>
                                        <input class="form-control" name="phone" value="122222">
                                    </div>
                                    <div class="form-group">
                                        <label>确认密码</label>
                                        <input class="form-control" name="address" placeholder="请确认密码">
                                    </div>
                                    <div class="form-group">
                                        <button type="submit" class="btn btn-primary">修改</button>
                                        <a href="ad_SearchUser.jsp">
                                            <button type="button" class="btn btn-primary">返回</button>
                                        </a>
                                    </div>
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
