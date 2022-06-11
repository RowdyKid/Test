<%--
  Created by IntelliJ IDEA.
  User: 王宇轩
  Date: 2022/5/26
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<!-- 整体导航栏 -->
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
    <%--导航主页--%>
    <div class="navbar-header">
        <a class="navbar-brand" href="op_OperatorMainPage.jsp"><i class="fa fa-graduation-cap fa-fw"
                                                                  aria-hidden="true"></i>合同管理系统</a>
    </div>

    <%--用户欢迎和退出列表--%>
    <ul class="nav navbar-top-links navbar-right">
        <%--用户信息--%>
        <%
            String userName = (String) session.getAttribute("nowUserName");
        %>
        <p class="navbar-brand">你好,<%=userName%>
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
                <li><a href="op_OperatorMainPage.jsp"><i class="fa fa-dashboard fa-fw"></i>系统首页</a></li>
                <li>
                    <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 创建合同<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="op_DraftContract.jsp">起草合同</a>
                        </li>

                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 会签合同<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="${pageContext.request.contextPath}/WaitingCountersignContract">待会签合同</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/HaveCountersignContract">已会签合同</a>
                        </li>

                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 定稿合同<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="${pageContext.request.contextPath}/FinalizedContract">待定稿合同</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/HaveFinalizedContract">已定稿合同</a>
                        </li>

                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 审批合同<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="${pageContext.request.contextPath}/WaitingApproveContract">待审批合同</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/HaveApproveContract">已审批合同</a>
                        </li>

                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 签订合同<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="${pageContext.request.contextPath}/WaitingSignContract">待签订合同</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/HaveSignContract">已签订合同</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
