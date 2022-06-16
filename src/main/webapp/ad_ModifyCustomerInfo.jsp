<%@ page import="com.cms.contractmanagementsystem.utils.Client" %><%--
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
    <%@include file="ad_AdminCSS.jsp" %>
</head>
<body>
<%--整体包裹容器--%>
<div id="wrapper">
    <%@include file="ad_AdminMenu.jsp" %>
    <%
        Client client = (Client)request.getAttribute("client");
    %>
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
                                <form role="form" action="${pageContext.request.contextPath}/ClientManage?type=modify_submit" method="post">
                                    <div>
                                        <input type="hidden" name="id" value="<%=client.GetId()%>">
                                    </div>
                                    <div class="form-group">
                                        <label>客户名称</label>
                                        <input class="form-control" name="customerName"
                                               value="<%=client.GetName()%>">
                                    </div>
                                    <div class="form-group">
                                        <label>电话</label>
                                        <input class="form-control" name="phone" value="<%=client.GetTel()%>">
                                    </div>
                                    <div class="form-group">
                                        <label>地址</label>
                                        <input class="form-control" name="address" value="<%=client.GetAddress()%>">
                                    </div>
                                    <div class="form-group">
                                        <label>传真</label>
                                        <input class="form-control" name="fax" value="<%=client.GetFax()%>">
                                    </div>
                                    <div class="form-group">
                                        <label>邮编</label>
                                        <input class="form-control" name="NewPostCode" value="<%=client.GetPostCode()%>">
                                    </div>
                                    <div class="form-group">
                                        <label>银行名称</label>
                                        <input class="form-control" name="bankName" value="<%=client.GetBankName()%>">
                                    </div>
                                    <div class="form-group">
                                        <label>银行账号</label>
                                        <input class="form-control" name="bankAccount"
                                               value="<%=client.GetBankAccount()%>">
                                    </div>
                                    <div class="form-group">
                                        <button type="submit" class="btn btn-primary">修改</button>
                                        <a href="${pageContext.request.contextPath}/ClientManage">
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
