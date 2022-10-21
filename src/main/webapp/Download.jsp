<%--
  Created by IntelliJ IDEA.
  User: sheen
  Date: 2022/10/20
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>软件缺陷测试系统</title>
    <%--导入相关美化部件--%>
    <%@include file="user_CSS.jsp" %>
    <script type="text/javascript">
        // function exportReport(){
        //     window.open('http://localhost:8080/Test_demo_war_exploded/download')
        // }


    </script>
</head>
<body>
<%--整体包裹容器--%>
<div id="wrapper">
    <%@include file="user_Menu.jsp" %>
</div>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header" style="text-align: center">结果展示</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    下载报告
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-6">
                            <form role="form" action="${pageContext.request.contextPath}/DownloadServlet" method="get">
                                <button type="submit" class="btn btn-default">下载</button>
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

