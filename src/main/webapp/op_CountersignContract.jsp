<%--
  Created by IntelliJ IDEA.
  User: 王宇轩
  Date: 2022/5/25
  Time: 22:38
  会签合同正式页面
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
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
        int contractId = (int) request.getAttribute("contractId");
        String contractName = (String) request.getAttribute("contractName");
    %>
</div>
<%--在该页面剩余部分创建会签同表单，内容包括合同名称，会签意见，提交和重置按钮--%>
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
                    <h3 class="panel-title"><i class="fa fa-bar-chart-o fa-fw"></i>会签合同</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <form role="form" action="${pageContext.request.contextPath}/op_CountersignContract"
                                  method="post">
                                <input type="hidden" name="type" value="countersign">
                                <input type="hidden" name="contractid" value="<%=contractId%>">
                                <div class="form-group">
                                    <label>合同名称</label>
                                    <input class="form-control" name="contractName" value=<%=contractName%> readonly>
                                </div>
                                <div class="form-group">
                                    <label>会签意见</label>
                                    <textarea class="form-control" rows="4" name="countersignOpinion"></textarea>
                                </div>
                                <button type="submit" class="btn btn-default">提交</button>
                                <button type="reset" class="btn btn-default">重置</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
