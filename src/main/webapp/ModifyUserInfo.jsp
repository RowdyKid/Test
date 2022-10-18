<%@ page import="com.sdp.softwaredefectprediction.pojo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>软件缺陷测试系统</title>
    <%--导入相关美化部件--%>
    <%@include file="user_CSS.jsp" %>
</head>
<body>
<%--整体包裹容器--%>
<div id="wrapper">
    <%@include file="user_Menu.jsp" %>
</div>
<%--主体内容--%>
<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header" style="text-align: center">个人信息管理</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <%
//                                    User user = (User)request.getAttribute("userInfo");
                                    String username = (String) session.getAttribute("nowUserName");
                                    Integer userid = (Integer) session.getAttribute("nowUserId");
                                    String email = (String) session.getAttribute("nowUserEmail");
                                    String password = (String) session.getAttribute("nowUserPassword");
                                %>
                                <form role="form" action="<%=request.getContextPath()%>/update_add_userInfo" method="post">
                                    <div class="form-group">
                                        <label>用户编号</label>
<%--                                        <input class="form-control" readonly name="id" value="<%=user.getId()%>">--%>
                                        <input class="form-control" readonly name="id" value="<%=userid%>">
                                    </div>

                                    <div class="form-group">
                                        <label>用户名称</label>
<%--                                        <input class="form-control" readonly name="username" value="<%=user.getUsername()%>">--%>
                                        <input class="form-control" readonly name="username" value="<%=username%>">
                                    </div>
                                    <div class="form-group">
                                        <label>邮箱地址</label>
                                        <input class="form-control" readonly name="email" value="<%=email%>">
                                    </div>
                                    <div class="form-group">
                                        <label>新的密码</label>
<%--                                        <input class="form-control" name="password" value="<%=user.getPassword()%>">--%>
                                        <input class="form-control" name="password" value="<%=password%>">
                                    </div>
                                    <div class="form-group">
                                        <button type="submit" class="btn btn-primary">修改</button>
                                        <a href="user_MainPage.jsp">
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
