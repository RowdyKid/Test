<%@ page import="com.sdp.softwaredefectprediction.service.AttachmentService" %>
<%@ page import="com.sdp.softwaredefectprediction.service.impl.AttachmentServiceImpl" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>软件缺陷测试系统</title>
    <%--导入相关美化部件--%>
    <%@include file="user_CSS.jsp" %>
<%--    <%--%>
<%--        ArrayList<Attachment> attachments = (ArrayList<Attachment>) request.getAttribute("attachments");--%>
<%--    %>--%>
<%--    <%--%>
<%--        AttachmentService attachmentService = new AttachmentServiceImpl();--%>
<%--    %>--%>
    <script type="text/javascript">
        $(function (){
            $("#submitBtn").click(function (){
                var fileId = $("#fileId").val();
                if (fileId==""){
                    alert("请输入要预测的文件id！");
                    return false;
                }
            })
        })
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
            <h1 class="page-header" style="text-align: center">缺陷预测</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    缺陷预测
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <form action="<%=request.getContextPath()%>/Prediction" method="post">
                                <div>
                                    <label>选择缺陷预测模型</label>
                                    <div class="panel-body">
                                        <div class="col-lg-12">
                                            <div>
                                                <input type="radio" name="model" checked="checked" value="logistic" id="logistic">Logistic Regression
                                            </div>
                                            <div>
                                                <input type="radio" name="model" value="SVM" id="SVM">SVM
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div>
                                    <label>选择需要预测的数据集:</label>
                                    <input type="text" name="fileId" placeholder="请输入文件id" id="fileId"><br>
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <div class="table-responsive">
                                                <table class="table table-bordered table-hover table-striped">
                                                    <thead>
                                                    <tr>
                                                        <th>文件id</th>
                                                        <th>文件名</th>
                                                        <th>文件类型</th>
                                                        <th>上传时间</th>
                                                        <th>操作</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <c:forEach items="${requestScope.attachments}" var="attachment">
                                                        <tr>
                                                            <td>${attachment.id}</td>
                                                            <td>${attachment.filename}</td>
                                                            <td>${attachment.filetype}</td>
                                                            <td>${attachment.time}</td>
                                                            <td><a class="deleteClass" href="${pageContext.request.contextPath}/DeleteAttachment?action=delete&id=${attachment.id}">删除</a></td>
                                                        </tr>
                                                    </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="msg_cont">
                                        <%
                                            String message = (String) request.getAttribute("message");
                                        %>
                                        <span class="errorMsg">
                                            数据类型验证：
                                            <%=message==null?"请选择文件":message%>
                                        </span>
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <button style="top: 10px; bottom: 10px; background-color: #1ab7ea; color: white" type="submit" id="submitBtn">开始预测</button>
                                </div>
                                <div style="top: 10px; bottom: 10px" class="col-lg-12">
                                    预测分析:
                                    <a href="${pageContext.request.contextPath}/DownloadForm">下载报告</a>
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
