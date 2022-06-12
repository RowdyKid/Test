<%@ page import="com.cms.contractmanagementsystem.utils.Contract" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 王宇轩
  Date: 2022/6/3
  Time: 20:20
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
        ArrayList<Contract> contracts = (ArrayList<Contract>) request.getAttribute("contracts");
        String status = (String) request.getAttribute("status");
    %>
</div>
<%--在剩余页面添加合同搜索栏，和对应的合同信息显示表格，要求显示合同名称，客户，开始时间，结束实现，当前状态和查看、修改、删除操作按钮--%>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">合同信息管理</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <i class="fa fa-bar-chart-o fa-fw"></i> 合同信息管理
                </div>
                <div class="panel-body">
                    <%--添加搜索栏，可通过搜索栏输入合同名称搜素合同信息，并在下方表格中展示--%>
                    <div class="row">
                        <div class="col-lg-12">
                            <form role="form" action="<%=request.getContextPath()%>/ad_SearchContract?type=search"
                                  method="get">
                                <input type="hidden" name="type" value="search">
                                <label>
                                    <input class="form-control" name="contractName" placeholder="请输入合同名称">
                                </label>
                                <input type="submit" class="btn btn-default" value="搜索">
                            </form>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover table-striped">
                                    <thead>
                                    <tr>
                                        <th>合同名称</th>
                                        <th>客户</th>
                                        <th>开始时间</th>
                                        <th>结束时间</th>
                                        <th>当前状态</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <%if (contracts != null && contracts.size() != 0) {%>
                                    <%
                                        for (Contract contract : contracts) {
                                    %>
                                    <tr>
                                        <td><%=contract.GetName()%>
                                        </td>
                                        <td><%=contract.GetClientNo()%>
                                        </td>
                                        <td><%=contract.GetStartTime()%>
                                        </td>
                                        <td><%=contract.GetFinishTime()%>
                                        </td>
                                        <td><%=status%>
                                        </td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/ad_ViewContractDetail?id=<%=contract.GetId()%>?type=view">查看</a>
                                            <a href="${pageContext.request.contextPath}/ad_ViewContractDetail?id=<%=contract.GetId()%>?type=revise">修改</a>
                                            <a href="${pageContext.request.contextPath}/ad_DeleteContractDetail?id=<%=contract.GetId()%>">删除</a>
                                        </td>
                                    </tr>
                                    <%}%>
                                    <%--否则显示没有数据--%>
                                    <%} else {%>
                                    <tr>
                                        <td colspan="6">没有数据</td>
                                    </tr>
                                    <%}%>
                                    </tbody>
                                </table>
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
