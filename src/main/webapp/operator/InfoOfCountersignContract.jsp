<%--
  Created by IntelliJ IDEA.
  User: 王宇轩
  Date: 2022/5/30
  Time: 16:47
  已会签合同信息
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>合同管理系统</title>
    <%--导入相关美化部件--%>
    <%@include file="OperatorCSS.jsp" %>
</head>
<body>
<%--整体包裹容器--%>
<div id="wrapper">
    <%@include file="OperatorNavHead.jsp" %>
</div>
<%--在该页面剩余部分创建会签同表格，内容包括合同名称，会签意见，返回按钮--%>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">会签合同</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    会签合同
                </div>
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>合同名称</th>
                                <th>会签意见</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%
                                String contractName = (String) session.getAttribute("contractName");
                                String contractId = (String) session.getAttribute("contractId");
                                String contractSignOpinion = (String) session.getAttribute("contractSignOpinion");
                            %>
                            <tr>
                                <td><%=contractName%>
                                </td>
                                <td><%=contractSignOpinion%>
                                </td>
                                <td>
                                    <a href="OperatorMainPage.jsp">返回</a>
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
