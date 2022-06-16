<%@ page import="com.cms.contractmanagementsystem.utils.Contract" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 王宇轩
  Date: 2022/6/4
  Time: 10:15
  待分配合同列表
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
<%--主体内容--%>
<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header" style="text-align: center">
                    待分配合同列表
                </h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <i class="fa fa-bar-chart-o fa-fw"></i>
                        待分配合同列表
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="table-responsive">
                                    <table class="table table-bordered table-hover table-striped">
                                        <thead>
                                        <tr>
                                            <th>合同编号</th>
                                            <th>合同名称</th>
                                            <th>会签人编号</th>
                                            <th>审批人编号</th>
                                            <th>签订人编号</th>
                                            <th>合同开始时间</th>
                                            <th>合同结束时间</th>
                                            <th>操作</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <%--遍历合同列表--%>

                                        <%
                                            List<Contract> contractList = (List<Contract>) request.getAttribute("contracts");
                                            for (int i = 0; i < contractList.size(); i++) {

                                        %>
                                        <tr>
                                            <td><%=contractList.get(i).getId()%>
                                            </td>
                                            <td><%=contractList.get(i).getName()%>
                                            </td>
                                            <td><%=contractList.get(i).getCounterSignerNo() != 0 ? contractList.get(i).getCounterSignerNo() : ""%>
                                            </td>
                                            <td><%=contractList.get(i).getApproverNo() != 0 ? contractList.get(i).getApproverNo() : ""%>
                                            </td>
                                            <td><%=contractList.get(i).getSignerNo() != 0 ? contractList.get(i).getSignerNo() : ""%>
                                            </td>
                                            <td><%=contractList.get(i).getStartTime()%>
                                            </td>
                                            <td><%=contractList.get(i).getFinishTime()%>
                                            </td>
                                            <td>
                                                <a href="${pageContext.request.contextPath}/AdContactSplit?id=<%=contractList.get(i).getId()%>">分配</a>
                                            </td>
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
</div>
</body>
</html>
