<%@ page import="com.sdp.softwaredefectprediction.utils.Attachment" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>软件缺陷测试系统</title>
    <%--导入相关美化部件--%>
    <%@include file="user_CSS.jsp" %>

    <script type="text/javascript">
    </script>
</head>
<body>
<%--整体包裹容器--%>
<div id="wrapper">
    <%@include file="user_Menu.jsp" %>
    <%
        List<Attachment> attachments = (ArrayList<Attachment>) request.getAttribute("attachments");
    %>
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
                        <div class="col-lg-6">
                            <form role="form" action="${pageContext.request.contextPath}/prediction" method="post" enctype="multipart/form-data">
                                <div>
                                    <label>选择缺陷预测模型</label>
                                    <div class="panel-body">
                                        <div class="col-lg-7">
                                            <div>
                                                <input type="radio" name="model" checked="checked" value="logistic">Logistic Regression
                                            </div>
                                            <div>
                                                <input type="radio" name="model" value="SVM">SVM
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div>
                                    <label>选择需要预测的数据集</label>
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <div class="table-responsive">
                                                <table class="table table-bordered table-hover table-striped">
                                                    <thead>
                                                    <tr>
                                                        <th>文件id</th>
                                                        <th>文件名</th>
                                                        <th>文件路径</th>
                                                        <th>文件类型</th>
                                                        <th>上传时间</th>
                                                        <th>操作</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <%if (attachments != null && attachments.size() != 0) {%>
                                                    <%
                                                        for (int i=0;i<attachments.size();i++) {
                                                            Attachment attachment = attachments.get(i);
                                                    %>
                                                    <tr>
                                                        <td><%=attachment.GetId()%>
                                                        </td>
                                                        <td><%=attachment.getFilename()%>
                                                        </td>
                                                        <td><%=attachment.getFilepath()%>
                                                        </td>
                                                        <td><%=attachment.getFiletype()%>
                                                        </td>
                                                        <td><%=attachment.getTime()%>
                                                        </td>
                                                        <td>
                                                            <input type="radio" href="${pageContext.request.contextPath}/ChooseFile?id=<%=attachment.GetId()%>&type=revise">选择
                                                            <a href="${pageContext.request.contextPath}/DeleteFile?id=<%=attachment.GetId()%>">删除</a>
                                                        </td>
                                                    </tr>
                                                    <%}%>
                                                    <%--否则显示没有数据--%>
                                                    <%} else {%>
                                                    <tr>
                                                        <td colspan="6">没有数据</td>
                                                    </tr>
                                                    <%}%>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
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
