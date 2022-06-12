<%--
  Created by IntelliJ IDEA.
  User: 王宇轩
  Date: 2022/5/30
  Time: 16:56
  已签订合同信息
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>合同管理系统</title>
    <%--导入相关美化部件--%>
    <%@include file="op_OperatorCSS.jsp" %>
</head>
<body>
<%--整体包裹容器--%>
<div id="wrapper">
    <%@include file="op_OperatorNavHead.jsp" %>
    <%
      String contractName = (String) request.getAttribute("contractName");
      String customerName = (String)request.getAttribute("customerName");
      String contractText = (String)request.getAttribute("contractText");
    %>
</div>
<%--页面剩余部分展示合同签订信息表格，包括合同名称，客户名称,签订文本信息，以上都不可修改以及返回主页按钮--%>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">合同签订信息</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    合同签订信息
                </div>
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>合同名称</th>
                                <th>客户名称</th>
                                <th>签订信息</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td><%=contractName%>
                                </td>
                                <td><%=customerName%>
                                </td>
                                <td><%=contractText%>
                                </td>
                                <td>
                                    <a href="op_OperatorMainPage.jsp">返回</a>
                                </td>
                            </tr>
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
