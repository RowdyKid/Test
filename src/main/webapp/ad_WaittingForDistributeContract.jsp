<%--
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
                                            <th>合同状态</th>
                                            <th>合同开始时间</th>
                                            <th>合同结束时间</th>
                                            <th>操作</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <%--遍历合同列表--%>
                                        <%--<%for(int i=0;i<contractList.size();i++){%>--%>
                                        <tr>
                                            <%-- <td><%=contractList.get(i).getContractId()%></td>
                                             <td><%=contractList.get(i).getContractName()%></td>
                                             <td><%=contractList.get(i).getContractStatus()%></td>
                                             <td><%=contractList.get(i).getContractCreateTime()%></td>
                                             <td><%=contractList.get(i).getContractEndTime()%></td>--%>
                                            <td>111
                                            </td>
                                            <td>111
                                            </td>
                                            <td>111
                                            </td>
                                            <td>111
                                            </td>
                                            <td>111
                                            </td>
                                            <td>
                                                <a href="ad_AllocateContract.jsp">分配</a>
                                            </td>
                                        </tr>
                                        <%--<%}%>--%>
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
