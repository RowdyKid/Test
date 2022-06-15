<%@ page import="com.cms.contractmanagementsystem.pojo.Log" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 王宇轩
  Date: 2022/6/3
  Time: 20:25
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
<%--主体页面，首先包含搜索栏，然后是信息表格，表格包括日志ID，用户ID，日志内容和操作时间--%>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">日志管理</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    日志列表
                </div>
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>日志ID</th>
                                <th>用户ID</th>
                                <th>日志内容</th>
                                <th>操作时间</th>
                            </tr>
                            </thead>
                            <tbody>

                            <%
                                List<Log> logs = (List<Log>) request.getAttribute("logs");
                            %>
                            <% for (int i = 0; i < logs.size(); i++) { %>
                            <tr>
                                <td><%=logs.get(i).getId()%></td>
                                <td><%=logs.get(i).getOperator()%></td>
                                <td><%=logs.get(i).getContent()%></td>
                                <td><%=logs.get(i).getTime()%></td>
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
