<%@ page import="com.cms.contractmanagementsystem.utils.Contract" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.cms.contractmanagementsystem.utils.Client" %><%--
  Created by IntelliJ IDEA.
  User: 王宇轩
  Date: 2022/6/3
  Time: 20:21
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
    <%
        ArrayList<Client> clients = (ArrayList<Client>) request.getAttribute("clients");
    %>
</div>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">客户管理</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    客户信息列表
                </div>
                <div class="panel-body">
                    <%--添加搜索栏，可通过搜索栏输入合同名称搜素合同信息，并在下方表格中展示--%>
                    <div class="row">
                        <div class="col-lg-12">
                            <form role="form" action="<%=request.getContextPath()%>/ClientManage?type=search"
                                  method="get">
                                <input type="hidden" name="type" value="search">
                                <label>
                                    <input class="form-control" name="clientName" placeholder="请输入客户名称">
                                </label>
                                <input type="submit" class="btn btn-default" value="搜索">

                            </form>
                        </div>
                    </div>
                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                        <thead>
                        <tr>
                            <th>客户ID</th>
                            <th>客户姓名</th>
                            <th>地址</th>
                            <th>联系电话</th>
                            <th>传真</th>
                            <th>邮编</th>
                            <th>银行</th>
                            <th>银行账户</th>
                            <th>修改信息</th>
                            <th>删除用户</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            if (clients != null && clients.size() > 0) {
                                for (Client client : clients) {
                        %>
                        <tr>
                            <td><%=client.GetId()%>
                            </td>
                            <td><%=client.GetName()%>
                            </td>
                            <td><%=client.GetAddress()%>
                            </td>
                            <td><%=client.GetTel()%>
                            </td>
                            <td><%=client.GetFax()%>
                            </td>
                            <td><%=client.GetPostCode()%>
                            </td>
                            <td><%=client.GetBankName()%>
                            </td>
                            <td><%=client.GetBankAccount()%>
                            </td>
                            <td><a href="<%=request.getContextPath()%>/ClientManage?type=revise&id=<%=client.GetId()%>">修改</a></td>
                            <td>
                                <a href="<%=request.getContextPath()%>/ClientManage?type=delete&id=<%=client.GetId()%>">删除</a>
                            </td>
                        </tr>
                        <%}%>
                        <%--否则显示没有数据--%>
                        <%} else {%>
                        <tr>
                            <td colspan="10">没有数据</td>
                        </tr>
                        <%}%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
