<%--
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
    <%@include file="AdminCSS.jsp" %>
</head>
<body>
<%--整体包裹容器--%>
<div id="wrapper">
    <%@include file="AdminMenu.jsp" %>
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
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="请输入合同名称">
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="button">搜索</button>
                                </span>
                            </div>
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
                                    <%-- <%
                                         List<Contract> contractList = (List<Contract>) session.getAttribute("contractList");
                                         for (Contract contract : contractList) {
                                     %>--%>
                                    <tr>
                                        <%-- <td><%=contract.getContractName()%>
                                         </td>
                                         <td><%=contract.getCustomer().getCustomerName()%>
                                         </td>
                                         <td><%=contract.getStartTime()%>
                                         </td>
                                         <td><%=contract.getEndTime()%>
                                         </td>
                                         <td><%=contract.getContractStatus()%>
                                         </td>--%>
                                        <td>xx合同
                                        </td>
                                        <td>张三
                                        </td>
                                        <td>2022-01-01
                                        </td>
                                        <td>2022-01-02
                                        </td>
                                        <td>已审批
                                        </td>
                                        <td>
                                            <a href="ViewContractDetail.jsp">查看</a>
                                            <a href="ReviseContract.jsp">修改</a>
                                            <a href="#">删除</a>
                                        </td>
                                    </tr>
                                    <%-- <%
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
    </div>
</div>
</body>
</html>
