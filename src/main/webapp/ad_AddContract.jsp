<%--
  Created by IntelliJ IDEA.
  User: 王宇轩
  Date: 2022/6/3
  Time: 19:45
  合同信息管理目录下新增合同功能，和操作员的起草合同相同
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>合同管理系统</title>
    <%--导入相关美化部件--%>
    <%@include file="ad_AdminCSS.jsp" %>
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
    <%@include file="ad_AdminMenu.jsp" %>
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
                            <form role="form" action="#" method="post">
                                <div class="form-group">
                                    <label>合同名称</label>
                                    <input class="form-control" placeholder="请输入合同名称" name="contractName">
                                </div>
                                <div class="form-group">
                                    <label>客户名称</label>
                                    <input class="form-control" placeholder="请输入客户名称" name="customerName">
                                </div>
                                <div class="form-group">
                                    <label>开始时间</label>
                                    <input type="date" class="form-control" id="startTime" name="startTime"
                                           placeholder="请输入开始时间">
                                </div>
                                <div class="form-group">
                                    <label>结束时间</label>
                                    <input type="date" class="form-control" id="endTime" name="endTime"
                                           placeholder="请输入结束时间">
                                </div>
                                <div class="form-group">
                                    <label>合同内容
                                        <textarea class="form-control" rows="4" cols="73" id="contractContent"
                                                  name="contractContent"
                                                  placeholder="请输入合同内容"></textarea>
                                    </label>
                                </div>
                                <div class="form-group">
                                    <label>附件</label>
                                    <input type="file" name="file">
                                </div>
                                <button type="submit" class="btn btn-default" onclick="checkInfo">提交</button>
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
