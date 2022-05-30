<%--
  Created by IntelliJ IDEA.
  User: 王宇轩
  Date: 2022/5/30
  Time: 16:51
  已定稿合同信息
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>合同管理系统</title>
    <%--导入相关美化部件--%>
    <link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <link href="assets/metisMenu/metisMenu.min.css" rel="stylesheet">

    <link href="assets/sbadmin2/css/sb-admin-2.css" rel="stylesheet">

    <link href="assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <link href="assets/css/style.css" rel="stylesheet">

    <script src="assets/jquery/jquery.min.js"></script>

    <script src="assets/bootstrap/js/bootstrap.min.js"></script>

    <script src="assets/metisMenu/metisMenu.min.js"></script>

    <script src="assets/sbadmin2/js/sb-admin-2.js"></script>
</head>
<body>
<%--整体包裹容器--%>
<div id="wrapper">
    <!-- 整体导航栏 -->
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <%--导航主页--%>
        <div class="navbar-header">
            <a class="navbar-brand" href="OperatorMainPage.jsp"><i class="fa fa-graduation-cap fa-fw"
                                                                   aria-hidden="true"></i>合同管理系统</a>
        </div>

        <%--用户欢迎和退出列表--%>
        <ul class="nav navbar-top-links navbar-right">
            <%--用户信息--%>
            <%
                String userName = (String) session.getAttribute("userName");
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
                    <li><a href="OperatorMainPage.jsp"><i class="fa fa-dashboard fa-fw"></i>系统首页</a></li>
                    <li>
                        <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 创建合同<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="DraftContract.jsp">起草合同</a>
                            </li>

                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 会签合同<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="WaittingForCountersignContractList.jsp">待会签合同</a>
                            </li>
                            <li>
                                <a href="HaveCountersignContractList.jsp">已会签合同</a>
                            </li>

                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 定稿合同<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="WaittingForFinalizedContractList.jsp">待定稿合同</a>
                            </li>
                            <li>
                                <a href="HaveFinalizedContractList.jsp">已定稿合同</a>
                            </li>

                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 审批合同<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="WaittingForApproveContractList.jsp">待审批合同</a>
                            </li>
                            <li>
                                <a href="HaveApproveContractList.jsp">已审批合同</a>
                            </li>

                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 签订合同<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="WaittingForSignContractList.jsp">待签订合同</a>
                            </li>
                            <li>
                                <a href="HaveSignContractList.jsp">已签订合同</a>
                            </li>

                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<%--在剩余页面放置定稿合同表格，展示合同名称，客户名称，合同开始时间，结束时间，以上内容不可编辑，返回按钮--%>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">定稿合同</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    定稿合同列表
                </div>
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>合同名称</th>
                                <th>客户名称</th>
                                <th>合同开始时间</th>
                                <th>合同结束时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%--  <%
                                  List<Contract> contractList = (List<Contract>) session.getAttribute("contractList");
                                  for (Contract contract : contractList) {
                              %>--%>
                            <tr>
                                <%--  <td><%=contract.getContractName()%>
                                  </td>
                                  <td><%=contract.getCustomerName()%>
                                  </td>
                                  <td><%=contract.getStartTime()%>
                                  </td>
                                  <td><%=contract.getEndTime()%>
                                  </td>--%>
                                <td>
                                </td>
                                <td>
                                </td>
                                <td>
                                </td>
                                <td>
                                </td>
                                <td><a href="OperatorMainPage.jsp">返回</a></td>
                            </tr>
                            <%--  <%
                                  }
                              %>--%>
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
