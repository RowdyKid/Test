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
    <%@include file="op_OperatorCSS.jsp" %>
</head>
<body>
<%--整体包裹容器--%>
<div id="wrapper">
    <%@include file="op_OperatorNavHead.jsp" %>
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
                                <td><a href="op_OperatorMainPage.jsp">返回</a></td>
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
