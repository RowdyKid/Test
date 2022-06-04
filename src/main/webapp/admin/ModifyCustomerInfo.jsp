<%--
  Created by IntelliJ IDEA.
  User: 王宇轩
  Date: 2022/6/4
  Time: 17:32
 修改客户信息界面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>合同管理系统</title>
    <%--导入相关美化部件--%>
    <%@include file="AdminCSS.jsp" %>
</head>
<body>
<%--整体包裹容器--%>
<div id="wrapper">
    <%@include file="AdminMenu.jsp" %>
</div>
<%--主体内容--%>
<%--根据客户id生成表单，显示客户名称，电话，地址，传真，邮箱，银行名称，银行账号等信息，均可修改，
有提交和重置按钮--%>
<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header" style="text-align: center">修改客户信息</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <form role="form" action="UpdateCustomer.jsp" method="post">
                                    <div class="form-group">
                                        <label>客户名称</label>
                                        <input class="form-control" name="customerName"
                                               value="张三">
                                    </div>
                                    <div class="form-group">
                                        <label>电话</label>
                                        <input class="form-control" name="phone" value="13816548934">
                                    </div>
                                    <div class="form-group">
                                        <label>地址</label>
                                        <input class="form-control" name="address" value="北京市海淀区">
                                    </div>
                                    <div class="form-group">
                                        <label>传真</label>
                                        <input class="form-control" name="fax" value="0231-xxx">
                                    </div>
                                    <div class="form-group">
                                        <label>邮箱</label>
                                        <input class="form-control" name="email" value="10086@qq.com">
                                    </div>
                                    <div class="form-group">
                                        <label>银行名称</label>
                                        <input class="form-control" name="bankName" value="渤海银行">
                                    </div>
                                    <div class="form-group">
                                        <label>银行账号</label>
                                        <input class="form-control" name="bankAccount"
                                               value="20220604">
                                    </div>
                                    <div class="form-group">
                                        <button type="submit" class="btn btn-primary">修改</button>
                                        <a href="SearchCustomer.jsp">
                                            <button type="button" class="btn btn-primary">返回</button>
                                        </a>
                                    </div>
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
