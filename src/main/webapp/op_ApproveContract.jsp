<%--
  Created by IntelliJ IDEA.
  User: 王宇轩
  Date: 2022/5/26
  Time: 10:32
  审批合同表单
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--导入相关美化部件--%>
    <%@include file="op_OperatorCSS.jsp" %>
    <%
        int contractId = (int) request.getAttribute("contractId");
        String contractName = (String) request.getAttribute("contractName");
    %>
</head>
<body>
<div id="wrapper">
    <%@include file="op_OperatorNavHead.jsp" %>
</div>
<%--在页面剩余部分展示审批合同表单，包括合同名称（不可修改），审批意见，通过或拒绝勾选项，提交和重置按钮--%>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header" style="text-align: center">审批合同</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    审批合同
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-6">
                            <form role="form" action="${pageContext.request.contextPath}/op_ApproveContract" method="post">
                                <input type="hidden" name="type" value="approve">
                                <input type="hidden" name="contractid" value="<%=contractId%>">
                                <div class="form-group">
                                    <label>合同名称</label>
                                    <input class="form-control" name="contractName" value=<%=contractName%> readonly>
                                </div>
                                <div class="form-group">
                                    <label>审批意见</label>
                                    <textarea class="form-control" rows="3" name="approveOpinion"></textarea>
                                </div>
                                <div class="form-group">
                                    <label>审批结果</label>
                                    <label class="radio-inline">
                                        <input type="radio" name="approveResult" id="optionsRadiosInline1" value="1"
                                               checked>通过
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="approveResult" id="optionsRadiosInline2" value="0">拒绝
                                    </label>
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
