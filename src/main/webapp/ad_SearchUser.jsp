<%@ page import="com.cms.contractmanagementsystem.pojo.User" %>
<%@ page import="java.util.List" %><%--
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
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>编号</th>
                                <th>用户名</th>
                                <th>密码</th>
                                <th>角色</th>
                                <th>状态</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%
                                List<User> users = (List<User>) request.getAttribute("users");
                                for (int i = 0; i < users.size(); i++) { %>
                            <tr>
                                <td><%=users.get(i).getId()%>
                                </td>
                                <td><%=users.get(i).getUsername()%>
                                </td>
                                <td><%=users.get(i).getPassword()%>
                                </td>
                                <td><%
                                    Integer id = users.get(i).getRid();
                                    if (id == 1) {
                                        out.print("新用户");
                                    } else if (id == 2) {
                                        out.print("系统管理员");
                                    } else {
                                        out.print("合同管理员");
                                    }
                                %></td>
                                <td><%=users.get(i).getDel().equals("1") ? "已删除" : "正常"%>
                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/updateUser_userInfo?id=<%=users.get(i).getId()%>">修改</a>
                                    <a href="${pageContext.request.contextPath}/ad_AuthorizeCustomer?id=<%=users.get(i).getId()%>">授权</a>
                                    <% if (users.get(i).getDel().equals("1")) {
                                    %>
                                    <a style="color: red!important;"
                                       href="${pageContext.request.contextPath}/delete_userInfo?id=<%=users.get(i).getId()%>">恢复</a>
                                    <%
                                    } else {%>
                                    <a href="${pageContext.request.contextPath}/delete_userInfo?id=<%=users.get(i).getId()%>">删除</a>
                                    <%
                                        }
                                    %>
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
