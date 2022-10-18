<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>合同管理系统</title>
    <%--导入相关美化部件--%>
    <%@include file="user_CSS.jsp" %>
    <%--创建check（）方法
验证
(1)	验证填写信息不能为空，否则给出提示 起草失败。
(2)	若上传了附件，则验证附件为 doc、 jpg、 jpeg、png、bmp 或 gif 格式。
(3)	保存合同信息和状态信息，返回起草合同页面给出提示“起草成功！”。
若发生系统异常，跳转到异常页面。
--%>
    <script type="text/javascript">
        function check() {
            var contract_name = document.getElementById("contractName").value;
            var customer_name = document.getElementById("customerName").value;
            if (contract_name == "" || customer_name == "") {
                alert("起草失败！");
                return false;
            }
            /*验证添加的附件为 doc或jpg或 jpeg或png、或bmp 或 gif 格式。*/
            var file = document.getElementById("file").value;
            var fileType = file.substring(file.lastIndexOf(".") + 1, file.length);
            if (fileType != "doc" || fileType != "jpg" || fileType != "jpeg" || fileType != "png" || fileType != "bmp" || fileType != "gif") {
                alert("起草失败！");
                return false;
            } else {
                alert("起草成功！");
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
            <h1 class="page-header" style="text-align: center">添加合同</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    添加合同
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-6">
                            <form role="form" action="${pageContext.request.contextPath}/ad_AddContract?type=addOper" method="post">
                                <div class="form-group">
                                    <label>附件</label>
                                    <input type="file" name="fileField" class="file" id="fileField" onchange="document.getElementById('textfield').value=this.value">
                                    <input type="text" name="textfield" id="textfield" readonly="">
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
</body>
</html>
