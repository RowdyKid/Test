<%--
  Created by IntelliJ IDEA.
  User: 王宇轩
  Date: 2022/5/23
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        html {
            height: 100%;
        }

        body {
            height: 100%;
            font-family: JetBrains Mono Medium;
            display: flex;
            align-items: center;
            justify-content: center;
            background: url('assets/imgs/city.png') no-repeat;
            background-size: 100% 100%;
        }

        .form-wrapper {
            width: 300px;
            background-color: rgba(41, 45, 62, .8);
            color: #fff;
            border-radius: 2px;
            padding: 50px;
        }

        .form-wrapper .header {
            text-align: center;
            font-size: 35px;
            text-transform: uppercase;
            line-height: 100px;
        }

        .form-wrapper .input-wrapper input {
            background-color: rgb(41, 45, 62);
            border: 0;
            width: 100%;
            text-align: center;
            font-size: 15px;
            color: #fff;
            outline: none;
        }

        .form-wrapper .input-wrapper input::placeholder {
            text-transform: uppercase;
        }

        .form-wrapper .input-wrapper .border-wrapper {
            background-image: linear-gradient(to right, #e8198b, #0eb4dd);
            width: 100%;
            height: 50px;
            margin-bottom: 20px;
            border-radius: 30px;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .form-wrapper .input-wrapper .border-wrapper .border-item {
            height: calc(100% - 4px);
            width: calc(100% - 4px);
            border-radius: 30px;
        }

        .form-wrapper .action {
            display: flex;
            justify-content: center;
        }

        .form-wrapper .action .btn {
            width: 60%;
            text-transform: uppercase;
            border: 2px solid #0e92b3;
            text-align: center;
            line-height: 50px;
            border-radius: 30px;
            cursor: pointer;
        }

        .form-wrapper .action .btn:hover {
            background-image: linear-gradient(120deg, #84fab0 0%, #8fd3f4 100%);
        }

        .form-wrapper .icon-wrapper i {
            font-size: 20px;
            color: rgb(187, 187, 187);
            cursor: pointer;
            border: 1px solid #fff;
            padding: 5px;
            border-radius: 20px;
        }

        .form-wrapper .icon-wrapper i:hover {
            background-color: #0e92b3;
        }

        a {
            text-decoration: none;
            width: 55%;
            text-transform: uppercase;
            text-align: center;
            line-height: 50px;
            border-radius: 30px;
            cursor: pointer;
        }

        #backBtn {
            width: 145px;
            text-transform: uppercase;
            border: 2px solid #0e92b3;
            text-align: center;
            line-height: 50px;
            border-radius: 30px;
            cursor: pointer;
        }

        #registerBtn {
            font-size: 15px;
            width: 152px;
            text-transform: uppercase;
            text-align: center;
            line-height: 50px;
            border-radius: 30px;
            cursor: pointer;
            background-color: transparent;
            border: 0px;
            color: #fff;
        }
    </style>
    <script type="text/javascript" src="assets/js/jquery-3.5.1.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#registerBtn").click(function () {
                // 校验注册信息
                // 验证用户名，必须由字母，数字，下划线组成，并且长度为5到12位
                // 获取用户名输入框里的内容，创建正则表达式对象，用test方法验证，提示用户结果
                var username = $("#username").val();
                var reg = /^\w{5,12}$/;
                if (!reg.test(username)) {
                    alert("用户名必须由字母，数字，下划线组成，并且长度为5到12位");
                    return false;
                }

                var psw1 = $("#psw1").val();
                var psw2 = $("#psw2").val();
                if (!reg.test(psw1)) {
                    alert("密码必须由字母，数字，下划线组成，并且长度为5到12位");
                    return false;
                }

                if (psw1 != psw2) {
                    alert("前后两次密码不一致");
                    return false;
                }
            })
        })
    </script>

</head>
<body>
<%--设置整体容器--%>
<div class="form-wrapper">
    <%--注册标签--%>
    <div class="header">
        register
    </div>
    <%--输入表单--%>
    <form action=Login.jsp method="post">
        <div class="input-wrapper">
            <div class="border-wrapper">
                <input type="text" name="username" placeholder="username" class="border-item" autocomplete="off"
                       id="username">
            </div>
            <div class="border-wrapper">
                <input type="password" name="password" placeholder="password" class="border-item" autocomplete="off"
                       id="psw1">
            </div>
            <div class="border-wrapper">
                <input type="password" name="confirmPassword" placeholder="confirm password" class="border-item "
                       autocomplete="off" id="psw2">
            </div>
        </div>
        <%--注册、返回按钮--%>
        <div class="action">
            <div class="btn">
                <input type="submit" value="register" id="registerBtn">
            </div>
            <a href="Login.jsp " style="color:#fff; text-decoration:none ">
                <div class="btn" id="backBtn">back</div>
            </a>
        </div>
    </form>
</div>
</body>
</html>