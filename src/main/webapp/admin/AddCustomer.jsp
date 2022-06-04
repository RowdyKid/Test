<%--
  Created by IntelliJ IDEA.
  User: 王宇轩
  Date: 2022/6/3
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>合同管理系统</title>
    <%--导入相关美化部件--%>
    <%@include file="AdminCSS.jsp" %>
    <%--判断表单信息是否正确，要求客户姓名、电话和地址不能为空--%>
    <script type="text/javascript">
        function check() {
            if (document.getElementById("customerName").value == "") {
                alert("客户姓名不能为空！");
                return false;
            }
            if (document.getElementById("customerPhone").value == "") {
                alert("客户电话不能为空！");
                return false;
            }
            if (document.getElementById("customerAddress").value == "") {
                alert("客户地址不能为空！");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<%--整体包裹容器--%>
<div id="wrapper">
    <%@include file="AdminMenu.jsp" %>
</div>
<%--页面显示添加客户表单，要求输入客户名称，电话，地址，传真，邮箱，银行名称，银行账号，备注等信息，
包含提交和重置按钮--%>
<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">添加客户</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <form role="form" action="AddCustomer.jsp" method="post">
                                    <div class="form-group">
                                        <label>客户名称</label>
                                        <input class="form-control" name="customerName" id="customerName"
                                               placeholder="请输入客户名称">
                                    </div>
                                    <div class="form-group">
                                        <label>客户电话</label>
                                        <input class="form-control" name="customerPhone" id="customerPhone"
                                               placeholder="请输入客户电话">
                                    </div>
                                    <div class="form-group">
                                        <label>客户地址</label>
                                        <input class="form-control" name="customerAddress" id="customerAddress"
                                               placeholder="请输入客户地址">
                                    </div>
                                    <div class="form-group">
                                        <label>客户传真</label>
                                        <input class="form-control" name="customerFax" placeholder="请输入客户传真">
                                    </div>
                                    <div class="form-group">
                                        <label>客户邮箱</label>
                                        <input class="form-control" name="customerEmail" placeholder="请输入客户邮箱">
                                    </div>
                                    <div class="form-group">
                                        <label>客户银行名称</label>
                                        <input class="form-control" name="customerBankName" placeholder="请输入客户银行名称">
                                    </div>
                                    <div class="form-group">
                                        <label>客户银行账号</label>
                                        <input class="form-control" name="customerBankAccount" placeholder="请输入客户银行账号">
                                    </div>
                                    <div class="form-group">
                                        <label>备注</label>
                                        <textarea class="form-control"
                                                  name="contractContent" rows="3" placeholder="请输入备注"></textarea>
                                    </div>
                                    <button type="submit" class="btn btn-default" onclick="check()">提交</button>
                                    <button type="reset" class="btn btn-default">重置</button>
                                </form>
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
