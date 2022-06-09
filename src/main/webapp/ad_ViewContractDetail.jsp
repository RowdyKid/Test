<%--
  Created by IntelliJ IDEA.
  User: 王宇轩
  Date: 2022/6/4
  Time: 11:13
  查看选定合同的详细信息
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>合同管理系统</title>
    <%@include file="ad_AdminCSS.jsp" %>
</head>
<body>
<%@include file="ad_AdminMenu.jsp" %>

<%--在剩余页面放置合同表单，展示合同名称，客户名称，合同开始时间，结束时间，合同的原内容--%>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header" style="text-align: center">查看合同</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    合同详情表单
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-6">
                            <form role="form" action="#" method="post">
                                <div class="form-group">
                                    <label>合同名称</label>
                                    <input class="form-control" name="contractName" value="xx合同" readonly>
                                </div>
                                <div class="form-group">
                                    <label>客户名称</label>
                                    <input class="form-control" name="customerName" value="张三" readonly>
                                </div>
                                <div class="form-group">
                                    <label>合同开始时间</label>
                                    <input class="form-control" name="contractStartTime" value="2022-05-26"
                                           readonly>
                                </div>
                                <div class="form-group">
                                    <label>合同结束时间</label>
                                    <input class="form-control" name="contractEndTime" value="2022-05-27"
                                           readonly>
                                </div>
                                <div class="form-group">
                                    <label>合同内容</label>
                                    <textarea class="form-control"
                                              name="contractContent" rows="3" readonly>这里是合同内容</textarea>
                                </div>
                                <%--返回按钮--%>
                                <div class="form-group">
                                    <label>
                                        <a href="ad_SearchContract.jsp">
                                            <button type="button" class="btn btn-primary">返回</button>
                                        </a>
                                    </label>
                                </div>
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
