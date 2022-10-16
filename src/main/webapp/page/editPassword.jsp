<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="static/css/base.css">
    <link rel="stylesheet" href="static/css/inner.css">
    <link rel="stylesheet" href="static/fonts/iconfont.css">
    <link rel="shortcut icon" href="static/img/bitbug_favicon.ico">
</head>

<body>

<%@ include file="/common-bars/topbar.jsp" %>

<div class="main">

    <%@ include file="/common-bars/sidebar.jsp" %>

    <div class="right">

        <form action="/bookmanagement/login/updatePassword" class="form" method="post">

            <div>
                修改密码
                <input type="text"  class="form-input" name="password" placeholder="Password"/>
            </div>
            <div>
                <input type="submit" class="btn" value="发送">
            </div>
            <c:if test="${success != null}"><div class="tip">修改成功!</div></c:if>
        </form>

    </div>

</div>
</body>
</html>