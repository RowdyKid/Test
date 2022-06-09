<%@ page import="com.cms.contractmanagementsystem.utils.*" %>
<%@ page import="com.cms.contractmanagementsystem.dao.*" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: 王宇轩
  Date: 2022/5/26
  Time: 10:29
  待定稿合同列表
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
<%--生成待定稿合同列表，表头包括合同名称，起草时间和操作--%>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header" style="text-align: center">待定稿合同</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    待定稿合同列表
                </div>
                <div class="panel-body">
                    <%--添加搜索栏，可通过搜索栏输入合同名称搜素待会签合同，并在下方表格中展示--%>
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
                    <%--表格主体--%>
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>合同编号</th>
                                <th>合同名称</th>
                                <th>开始时间</th>
                                <th>结束时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>

                            <% for (Contract contract : contracts) { %>

                            <tr>
                                <td><%=contract.GetId()%>
                                </td>
                                <td><%=contract.GetName()%>
                                </td>
                                <td><%=contract.GetStartTime()%>
                                </td>
                                <td><%=contract.GetFinishTime()%>
                                </td>
                                <td>
                                    <%--等待后续后端功能的实现，目前先直接跳转--%>
                                    <a href="op_FinalizedContract.jsp">定稿</a>
                                    <%--<a href="&lt;%&ndash;OperatorSignContract.jsp?contractId=<%=contractList.get(i).getContractId()%>&ndash;%&gt;">会签</a>--%>
                                </td>
                            </tr>

                            <% } %>

                            </tbody>
                        </table>
                    </div>
                    <%--将上述表格实现分页功能--%>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="dataTables_info" id="dataTables-example_info" role="alert"
                                 aria-live="polite" aria-relevant="all" id="pageInfo">显示 1 到 10 项，共 57 项
                            </div>
                            <div class="dataTables_paginate paging_simple_numbers" id="dataTables-example_paginate">
                                <ul class="pagination">
                                    <li class="paginate_button previous disabled" aria-controls="dataTables-example"
                                        tabindex="0" id="dataTables-example_previous"><a href="#">上一页</a></li>
                                    <li class="paginate_button next" aria-controls
                                        is="dataTables-example" tabindex="0" id="dataTables-example_next"><a
                                            href="#">下一页</a>
                                    </li>
                                </ul>
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
