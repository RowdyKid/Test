<%--
  Created by IntelliJ IDEA.
  User: 王宇轩
  Date: 2022/6/4
  Time: 10:47
  管理员表头
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 整体导航栏 -->
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
    <%--导航主页--%>
    <div class="navbar-header">
        <a class="navbar-brand" href="ad_AdminMainPage.jsp"><i class="fa fa-graduation-cap fa-fw"
                                                               aria-hidden="true"></i>合同管理系统</a>
    </div>

    <%--用户欢迎和退出列表--%>
    <ul class="nav navbar-top-links navbar-right">
        <%--用户信息--%>
        <%
            String userName = (String) session.getAttribute("nowUserName");
        %>
        <p class="navbar-brand">管理员,<%=userName%>
        </p>
        <%--退出按钮--%>
            <p><a href="Login.jsp"><i class="fa fa-sign-out fa-fw"></i>退出登录</a>
            </p>
    </ul>

    <%--导航栏左侧--%>
    <div class="navbar-default sidebar" role="navigation">
        <%--添加折叠栏--%>
        <div class="sidebar-nav navbar-collapse">
            <ul class="nav" id="side-menu">
                <li><a href="ad_AdminMainPage.jsp"><i class="fa fa-dashboard fa-fw"></i>系统首页</a></li>
                <li>
                    <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 合同信息管理<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="ad_AddContract.jsp">新增合同</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/ad_SearchContract">查询合同</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 客户信息管理<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="ad_AddCustomer.jsp">新增客户</a>
                        </li>
                        <li>
                            <a href="ad_SearchCustomer.jsp">查询客户</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 用户管理<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="${pageContext.request.contextPath}/search_userInfo">查询用户</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 系统管理<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="${pageContext.request.contextPath}/ad_Contract">分配合同</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/ad_LogManager">日志管理</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
