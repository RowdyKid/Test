<%--
  Created by IntelliJ IDEA.
  User: 王宇轩
  Date: 2022/6/3
  Time: 19:49
  修改合同，同定稿合同
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>合同管理系统</title>
    <%--导入相关美化部件--%>
    <%@include file="ad_AdminCSS.jsp" %>
    <%
        String contractName = (String) request.getAttribute("contractName");
        String customerName = (String) request.getAttribute("customerName");
        String contractStartTime = (String) request.getAttribute("contractStartTime");
        String contractEndTime = (String) request.getAttribute("contractEndTime");
        String contractContent = (String) request.getAttribute("contractContent");
        int id= (int) request.getAttribute("id");
    %>
</head>
<body>
<%--整体包裹容器--%>
<div id="wrapper">
    <%@include file="ad_AdminMenu.jsp" %>
</div>
<%--在剩余页面放置定稿合同表单，展示合同名称，客户名称，合同开始时间，结束时间，以上内容不可编辑，合同的原内容（可修改），提供提交和重置按钮--%>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header" style="text-align: center">修改合同</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    修改合同表单
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-6">
                            <form role="form" action="${pageContext.request.contextPath}/ad_ReviseContract" method="post">
                                <input type="hidden" name="id" value=<%=id%>>
                                <div class="form-group">
                                    <label>合同名称</label>
                                    <input class="form-control" name="NewContractName" value=<%=contractName%> readonly>
                                </div>
                                <div class="form-group">
                                    <label>客户名称</label>
                                    <input class="form-control" name="customerName" value=<%=customerName%> readonly>
                                </div>
                                <div class="form-group">
                                    <label>合同开始时间</label>
                                    <input class="form-control" name="contractStartTime" value=<%=contractStartTime%>
                                            readonly>
                                </div>
                                <div class="form-group">
                                    <label>合同结束时间</label>
                                    <input class="form-control" name="contractEndTime" value=<%=contractEndTime%>
                                            readonly>
                                </div>
                                <div class="form-group">
                                    <label>合同内容</label>
                                    <textarea class="form-control"
                                              name="contractContent" rows="3"><%=contractContent%></textarea>
                                </div>
                                <button type="submit" class="btn btn-default">修改</button>
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
