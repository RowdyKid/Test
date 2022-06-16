<%@ page import="com.cms.contractmanagementsystem.utils.Contract" %>
<%@ page import="java.util.List" %>
<%@ page import="com.cms.contractmanagementsystem.utils.Client" %><%--
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
</head>
<body>
<script type="text/javascript" language="javascript"
        src="//cdn.datatables.net/1.10.3/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" language="javascript" src="dataTables.bootstrap.js"></script>
<%--整体包裹容器--%>
<div id="wrapper">
    <%@include file="ad_AdminMenu.jsp" %>
</div>
<%--主体内容--%>
<div id="page-wrapper">
    <div class="container-fluid">
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
                                <form role="form" action="<%=request.getContextPath()%>/AdContactSplitAdd" id="formChat"
                                      method="post">
                                    合同编号：<input type="text" readonly name="id"
                                                value="<%=request.getAttribute("id") %>"/>
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
                                                <select class="form-control" id="signer1" name="signerone" size="10">
                                                    <%
                                                        List<Client> clients = (List<Client>) request.getAttribute("clients");
                                                    %>
                                                    <%
                                                        for (int i = 0; i < clients.size(); i++) {
                                                    %>
                                                    <option value="<%=clients.get(i).GetId()%>"><%=clients.get(i).GetName()%>
                                                    </option>
                                                    <%} %>
                                                </select>
                                            </td>
                                            <td style="text-align: center;vertical-align: middle">
                                                <button type="button" id="signer-1l" class="btn btn-default">>>
                                                </button>
                                                <br><br>
                                                <button type="button" id="signer-1r" class="btn btn-default"><<
                                                </button>
                                            </td>
                                            <td>
                                                <select class="form-control" id="signer11" name="signer11"
                                                        size="10"></select>
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
                                                <select class="form-control" id="signer2" name="signertwo" size="10">
                                                    <%
                                                        List<Client> clientss = (List<Client>) request.getAttribute("clients");
                                                    %>
                                                    <%
                                                        for (int i = 0; i < clientss.size(); i++) {
                                                    %>
                                                    <option value="<%=clientss.get(i).GetId()%>"><%=clientss.get(i).GetName()%>
                                                    </option>
                                                    <%} %>
                                                </select>
                                            </td>
                                            <td style="text-align: center;vertical-align: middle">
                                                <button type="button" id="signer-2l" class="btn btn-default">>>
                                                </button>
                                                <br><br>
                                                <button type="button" id="signer-2r" class="btn btn-default"><<
                                                </button>
                                            </td>
                                            <td>
                                                <select class="form-control" id="signer22" name="signer22" size="10">
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
                                                <select class="form-control" id="signer3" name="signerthree" size="10">
                                                    <%
                                                        List<Client> client = (List<Client>) request.getAttribute("clients");
                                                    %>
                                                    <%
                                                        for (int i = 0; i < client.size(); i++) {
                                                    %>
                                                    <option value="<%=client.get(i).GetId()%>"><%=client.get(i).GetName()%>
                                                    </option>
                                                    <%} %>
                                                </select>
                                            </td>
                                            <td style="text-align: center;vertical-align: middle">
                                                <button type="button" id="signer-3l" class="btn btn-default">>>
                                                </button>
                                                <br><br>
                                                <button type="button" id="signer-3r" class="btn btn-default"><<
                                                </button>
                                            </td>
                                            <td>
                                                <select class="form-control" id="signer33" name="signerss" size="10">
                                                </select>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <table>
                                        <tr>
                                            <td colspan="4" style="text-align:center;">
                                                <button type="submit" id="submitText" class="btn btn-default">确定
                                                </button>
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
<script type="text/javascript">
    $(function () {
        $("#signer-1l").click(function () {
            var text = $("#signer1").find("option:selected").text().trim();
            var textValue = $("#signer1").find("option:selected").val().trim();
            $("#signer11").empty()
            $("#signer11").append("<option name='signer11' value=" + textValue + ">" + text + "</option>")
        })

        $("#signer-1r").click(function () {
            $("#signer11").empty()
        })

        $("#signer-2l").click(function () {
            var text = $("#signer2").find("option:selected").text().trim();
            var textValue = $("#signer2").find("option:selected").val().trim();
            $("#signer22").empty()
            $("#signer22").append("<option name='signer22'  value=" + textValue + ">" + text + "</option>")
        })

        $("#signer-2r").click(function () {
            $("#signer22").empty()
        })

        $("#signer-3l").click(function () {
            var text = $("#signer3").find("option:selected").text().trim();
            var textValue = $("#signer3").find("option:selected").val().trim();
            $("#signer33").empty()
            $("#signer33").append("<option name='signer33'  value=" + textValue + ">" + text + "</option>")
        })

        $("#signer-3r").click(function () {
            $("#signer33").empty()
        })

        $("#submitText").submit(function () {
            var text1 = $("#signer11").find("option:selected").text().trim();
            var text2 = $("#signer22").find("option:selected").text().trim();
            var text3 = $("#signer33").find("option:selected").text().trim();
            console.log(text1);
            console.log(text2);
            console.log(text3);
            if (text1 == null || text2 == null || text3 == null) {
                alert("请确保给合同分配具体人员！！！");
                return false;
            }
            if (text1 == "" || text2 == "" || text3 == "") {
                alert("请确保给合同分配具体人员！！！");
                return false;
            }
            return true;
        })

    })

</script>
</html>
