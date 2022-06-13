<%--
  Created by IntelliJ IDEA.
  User: 王宇轩
  Date: 2022/6/5
  Time: 19:20
  分配合同界面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>合同管理系统</title>
    <%--导入相关美化部件--%>
    <%@include file="ad_AdminCSS.jsp" %>

    <script type="text/javascript">
        /*将si列表中选中的元素移除并转移到s2列表中*/
        function moveSigner(s1, s2) {
            // 存储选项列表的value和text
            var arrSelValue = [];
            var arrSelText = [];
            // 存储以选择的value
            var arrValueTextRelation = [];
            var index = 0;

            // 将选择列表中的元素进行存储
            for (var i = 0; i < s1.options.length; i++) {
                if (s1.options[i].selected) {
                    arrSelValue[index] = s1.options[i].value;
                    arrSelText[index] = s1.options[i].text;
                    //建立匹配关系
                    arrValueTextRelation[arrSelValue[index]] = s1.options[i];
                    index++;
                }
            }

            // 将选择的元素移除并添加到目标列表中
            for (var i = 0; i < arrSelText.length; i++) {
                var oOption = document.createElement("option");
                oOption.text = arrSelText[i];
                oOption.value = arrSelValue[i];
                s2.add(oOption);
                s2.options[i].selected = true;
                s1.removeChild(arrValueTextRelation[arrSelValue[i]]);
            }
        }
    </script>
</head>
<body>
<%--整体包裹容器--%>
<div id="wrapper">
    <%@include file="ad_AdminMenu.jsp" %>
</div>
<%--主体内容--%>
<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header" style="text-align: center">
                    <%--页面标题--%>
                    分配合同
                </h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <%--面板标题--%>
                        分配合同
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <%--以下为分配合同表单，表单包括分配会签人，分配审批人，分配签订人三张表格，，每个表格有三列，
                                分别为待分配人员列表，分配按钮和已分配人员列表--%>
                                <form role="form" name="assignOpFrom" action="#"
                                      method="post">
                                    <%--分配会签人h3标题--%>
                                    <h3>分配会签人</h3>
                                    <%--第一个表格，表格分三列，表头为待分配人员列表，分配按钮和已分配人员列表--%>
                                    <table class="table table-bordered table-hover table-striped">
                                        <thead>
                                        <tr>
                                            <th>待分配人员列表</th>
                                            <th style="text-align: center">分配</th>
                                            <th>已分配人员列表</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>
                                                <select class="form-control" name="dfphqSigner" size="10">
                                                    <%
                                                        for (int i = 0; i < 3; i++) {
                                                    %>
                                                    <option value="<%=i%>">张<%=i%>
                                                    </option>
                                                    <%} %>
                                                </select>
                                            </td>
                                            <td style="text-align: center;vertical-align: middle">
                                                <button type="button" class="btn btn-default"
                                                        onclick="moveSigner(document.assignOpFrom.dfphqSigner,document.assignOpFrom.yfphqSigner)">
                                                    >>
                                                </button>
                                                <br><br>
                                                <button type="button" class="btn btn-default"
                                                        onclick="moveSigner(document.assignOpFrom.yfphqSigner,document.assignOpFrom.dfphqSigner)">
                                                    <<
                                                </button>
                                            </td>
                                            <td>
                                                <select class="form-control" name="yfphqSigner" size="10">
                                                </select>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <%--第二个表格，表格分三列，表头为待分配人员列表，分配按钮和已分配人员列表--%>
                                    <h3>分配审批人</h3>
                                    <table class="table table-bordered table-hover table-striped">
                                        <thead>
                                        <tr>
                                            <th>待分配人员列表</th>
                                            <th style="text-align: center">分配</th>
                                            <th>已分配人员列表</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>
                                                <select class="form-control" name="dfpspSigner" size="10">
                                                    <%
                                                        for (int i = 0; i < 3; i++) {
                                                    %>
                                                    <option value="<%=i%>">张<%=i%>
                                                    </option>
                                                    <%} %>
                                                </select>
                                            </td>
                                            <td style="text-align: center;vertical-align: middle">
                                                <button type="button" class="btn btn-default"
                                                        onclick="moveSigner(document.assignOpFrom.dfpspSigner,document.assignOpFrom.yfpspSigner)">
                                                    >>
                                                </button>
                                                <br><br>
                                                <button type="button" class="btn btn-default"
                                                        onclick="moveSigner(document.assignOpFrom.yfpspSigner,document.assignOpFrom.dfpspSigner)">
                                                    <<
                                                </button>
                                            </td>
                                            <td>
                                                <select class="form-control" name="yfpspSigner" size="10">
                                                </select>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <%--第三个表格，表格分三列，表头为待分配人员列表，分配按钮和已分配人员列表--%>
                                    <h3>分配签订人</h3>
                                    <table class="table table-bordered table-hover table-striped">
                                        <thead>
                                        <tr>
                                            <th>待分配人员列表</th>
                                            <th style="text-align: center">分配</th>
                                            <th>已分配人员列表</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>
                                                <select class="form-control" name="dfpqdSigner" size="10">
                                                    <%
                                                        for (int i = 0; i < 3; i++) {
                                                    %>
                                                    <option value="<%=i%>">张<%=i%>
                                                    </option>
                                                    <%} %>
                                                </select>
                                            </td>
                                            <td style="text-align: center;vertical-align: middle">
                                                <button type="button" class="btn btn-default"
                                                        onclick="moveSigner(document.assignOpFrom.dfpqdSigner,document.assignOpFrom.yfpqdSigner)">
                                                    >>
                                                </button>
                                                <br><br>
                                                <button type="button" class="btn btn-default"
                                                        onclick="moveSigner(document.assignOpFrom.yfpqdSigner,document.assignOpFrom.dfpqdSigner)">
                                                    <<
                                                </button>
                                            </td>
                                            <td>
                                                <select class="form-control" name="yfpqdSigner" size="10">
                                                </select>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <table>
                                        <tr>
                                            <td colspan="4" style="text-align:center;">
                                                <button type="submit" class="btn btn-default">确定</button>
                                                <a href="ad_WaittingForDistributeContract.jsp"
                                                   class="btn btn-default">取消</a>
                                            </td>
                                        </tr>
                                    </table>
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
