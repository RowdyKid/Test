<%--
  Created by IntelliJ IDEA.
  User: 王宇轩
  Date: 2022/5/30
  Time: 16:37
  审批合同详情页面
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
</div>
<%--在页面剩余部分展示审批合同信息表单，包括合同名称，审批意见，是否通过，返回按钮，以上信息均不可修改--%>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">审批合同</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    审批合同
                </div>
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>合同名称</th>
                                <th>审批意见</th>
                                <th>是否通过</th>
                                <th>返回</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%
                                String contractName = (String)request.getAttribute("contractName");
                                String approvalOpinion = (String) request.getAttribute("approvalOpinion");
                                String isPass = (String) request.getAttribute("isPass");
                            %>
                            <tr>
                                <td><%=contractName%>
                                </td>
                                <td><%=approvalOpinion%>
                                </td>
                                <td><%=isPass%>
                                </td>
                                <td><a href="op_OperatorMainPage.jsp">返回</a></td>
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
