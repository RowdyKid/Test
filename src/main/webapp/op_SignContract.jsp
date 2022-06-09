<%--
  Created by IntelliJ IDEA.
  User: 王宇轩
  Date: 2022/5/26
  Time: 10:34
  签订合同表单
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
</div>
<%--页面剩余部分展示签订合同表单，包括合同名称，客户名称,不可修改，签订信息，可修改，提交和重置按钮--%>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header" style="text-align: center">签订合同</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <i class="fa fa-bar-chart-o fa-fw"></i> 签订合同
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <form role="form" action="op_SignContract.jsp" method="post">
                                <div class="form-group">
                                    <label>合同名称</label>
                                    <label>
                                        <input class="form-control" name="contractName" value="xx合同" readonly>
                                    </label>
                                </div>
                                <div class="form-group">
                                    <label>客户名称</label>
                                    <label>
                                        <input class="form-control" name="customerName" value="张三" readonly>
                                    </label>
                                </div>
                                <div class="form-group">
                                    <label>签订信息</label>
                                    <textarea class="form-control" name="contractContent" rows="5">这里是签订信息</textarea>
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
