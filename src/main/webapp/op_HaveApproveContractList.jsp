<%@ page import="com.cms.contractmanagementsystem.utils.Contract" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 王宇轩
  Date: 2022/5/26
  Time: 11:42
  已审批合同列表.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>合同管理系统</title>
    <%--导入相关美化部件--%>
    <%@include file="op_OperatorCSS.jsp" %>
    <%
        ArrayList<Contract> contracts = (ArrayList<Contract>) request.getAttribute("contracts");
    %>
</head>
<body>
<%--整体包裹容器--%>
<div id="wrapper">
    <%@include file="op_OperatorNavHead.jsp" %>
</div>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header" style="text-align: center">已审批合同</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    已审批合同列表
                </div>
                <div class="panel-body">
                    <%--添加搜索栏，可通过搜索栏输入合同名称搜素已审批合同，并在下方表格中展示--%>
                        <div class="row">
                            <div class="col-lg-12">
                                <form role="form" action="<%=request.getContextPath()%>/FinalizedContract?type=search"
                                      method="get">
                                    <input type="hidden" name="type" value="search">
                                    <label>
                                        <input class="form-control" name="contractName" placeholder="请输入合同名称">
                                    </label>
                                    <input type="submit" class="btn btn-default" value="搜索">

                                </form>
                            </div>
                        </div>
                    <%--表格主体--%>
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>合同名称</th>
                                <th>起草时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%--如果返回的合同列表不为空，则遍历列表在table中展示--%>
                            <%if (contracts != null && contracts.size() != 0) {%>
                            <%for (Contract contract : contracts) {%>
                            <tr>
                                <td><%=contract.GetName()%>
                                </td>
                                <td><%=contract.GetStartTime()%>
                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/op_InfoOfApproveContract?id=<%=contract.GetId()%>">查看</a>
                                </td>
                            </tr>
                            <%}%>
                            <%--否则显示没有数据--%>
                            <%} else {%>
                            <tr>
                                <td colspan="3">没有数据</td>
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
</body>
</html>
