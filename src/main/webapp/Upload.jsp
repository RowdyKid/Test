<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>软件缺陷测试系统</title>
    <%--导入相关美化部件--%>
    <%@include file="user_CSS.jsp" %>

    <script type="text/javascript">
        function check() {

            var file = document.getElementById("file").value;
            var fileType = file.substring(file.lastIndexOf(".") + 1, file.length);
            if (fileType != "doc" || fileType != "doxc" || fileType != "txt" || fileType != "csv" ) {
                alert("文件格式错误！");
                return false;
            } else {
                alert("上传成功！");
                return true;
            }
        }
    </script>
</head>
<body>
<%--整体包裹容器--%>
<div id="wrapper">
    <%@include file="user_Menu.jsp" %>
</div>
<%--在该页面剩余位置生成合同起草表单，填写内容包括合同名称，客户名称，开始时间，结束时间，合同内容，可以添加附件，包含提交和重置按钮--%>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header" style="text-align: center">数据上传</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    数据上传
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-6">
                            <form role="form" action="${pageContext.request.contextPath}/UploadServlet" method="post" enctype="multipart/form-data">
<%--                                <div class="form-group">--%>
<%--                                    <label>附件</label>--%>
<%--                                    <input type="file" name="fileField" class="file" id="fileField" onchange="document.getElementById('textfield').value=this.value">--%>
<%--                                    <input type="text" name="textfield" id="textfield" readonly="">--%>
<%--                                </div>--%>
<%--                                <button type="submit" class="btn btn-default" onclick="check()">提交</button>--%>
<%--                                <button type="reset" class="btn btn-default">重置</button>--%>
                                <input type="file" name="file"><br>
                                <input type="submit" value="上传">
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
