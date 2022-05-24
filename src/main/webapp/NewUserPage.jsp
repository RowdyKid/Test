<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 王宇轩
  Date: 2022/5/24
  Time: 17:26
  这个界面用来提醒新用户等待管理员赋予相应的权限
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>合同管理系统</title>
    <%--添加显示时间的脚本--%>
    <script>
        function showTime() {
            var nowtime = new Date();
            var year = nowtime.getFullYear();
            var month = nowtime.getMonth() + 1;
            date = nowtime.getDate();
            var hour = nowtime.getHours();
            var minite = nowtime.getMinutes();
            var second = nowtime.getSeconds();
            document.getElementById("timeText").innerText = "当前时间:" + year + "年" + month + "月" + date + "日" + hour + "时" + minite + "分" + second + "秒";

        }

        /*每隔一秒进行函数调用*/
        setInterval("showTime()", 1000);
    </script>
    <%--待添加css--%>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <div id="logo">
            <span>
                <a href="index.jsp" style="text-decoration:none">合同管理系统</a>
            </span>
            <%--获取当前用户的用户名以作展示--%>
            <%
                String userName = (String) session.getAttribute("userName");
            %>
            <span style="float:right">【<a href="Login.jsp">注销登录</a>】</span>
            <span style="float:right">您好,<%=userName%>,欢迎使用合同管理系统!</span>

        </div>
    </div>
    <br>
    <br>
    <div id="page">
        <div id="content">
            <div class="post">
                <div class="entry">
                    <p>
                        <%--待添加提示信息--%>
                        您是新用户，没有合同操作权限，等待管理员为您配置权限！
                    </p>
                </div>
                <div id="showTime">
                    <p id="timeText"></p>
                </div>
            </div>
        </div>
        <div style="clear: both;">&nbsp;</div>
    </div>
    <div id="footer">
        <p>Copyright &copy; 合同管理系统</p>
    </div>
</div>
</body>
</html>
