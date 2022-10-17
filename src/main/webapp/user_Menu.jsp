<%@ page import="com.sdp.softwaredefectprediction.pojo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 整体导航栏 -->
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
    <%--导航主页--%>
    <div class="navbar-header">
        <a class="navbar-brand" href="user_MainPage.jsp"><i class="fa fa-graduation-cap fa-fw"
                                                            aria-hidden="true"></i>软件缺陷测试系统</a>
    </div>

    <%--用户欢迎和退出列表--%>
    <ul class="nav navbar-top-links navbar-right">
        <%--用户信息--%>
        <%
            String userName = (String) session.getAttribute("nowUserName");
        %>
        <p class="navbar-brand">欢迎,<%=userName%>
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
                <li><a href="user_MainPage.jsp"><i class="fa fa-dashboard fa-fw"></i>系统首页</a></li>
                <li>
                    <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 数据上传<span class="fa arrow"></span></a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 缺陷预测<span class="fa arrow"></span></a>

                </li>
                <li>
                    <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 结果展示<span class="fa arrow"></span></a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/ModifyUserInfo.jsp"><i class="fa fa-bar-chart-o fa-fw"></i> 个人信息<span class="fa arrow"></span></a>
<%--                    <ul class="nav nav-second-level">--%>
<%--                        <li>--%>
<%--                            <a href="${pageContext.request.contextPath}/ad_Contract"></a>--%>
<%--                        </li>--%>
<%--                        <li>--%>
<%--                            <a href="${pageContext.request.contextPath}/ad_LogManager"></a>--%>
<%--                        </li>--%>
<%--                    </ul>--%>
                </li>
            </ul>
        </div>
    </div>
</nav>
