<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>LOG-IN | 数字互娱</title>
    <!-- Set render engine for 360 browser -->
    <meta name="renderer" content="webkit">
    <!-- No Baidu Siteapp-->
    <meta http-equiv="cache-control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/assets/i/favicon.png">
    <!-- Add to homescreen for Chrome on Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="${pageContext.request.contextPath}/assets/i/app-icon72x72@2x.png">
    <!-- Add to homescreen for Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/assets/i/app-icon72x72@2x.png">
    <!-- Tile icon for Win8 (144x144 + tile color) -->
    <meta name="msapplication-TileImage" content="${pageContext.request.contextPath}/assets/i/app-icon72x72@2x.png">
    <meta name="msapplication-TileColor" content="#0e90d2">
    <!-- SEO: If your mobile URL is different from the desktop URL, add a canonical link to the desktop page https://developers.google.com/webmasters/smartphone-sites/feature-phones -->
    <!--
  <link rel="canonical" href="http://www.example.com/">
  -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/amazeui.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/register.css">
</head>

<body>
<header>
    <div class="log-header">
        <h1><a href="/">数字互娱</a> </h1>
    </div>
    <div class="log-re">
        <a href="/userlogin.html" class="am-btn am-btn-default am-radius log-button" style="color:#fff;">登 录</a>
    </div>
</header>
<div class="log">
    <div class="am-g">
        <div class="am-u-lg-3 am-u-md-6 am-u-sm-8 am-u-sm-centered log-content">
            <h1 class="log-title am-animation-slide-top">数字互娱</h1>
            <br>
            ${success_response} ${error_response}
            <form class="am-form" id="log-form" action="${pageContext.request.contextPath}/reg-user" method="post">
                <input type="hidden" name="owner" id="owner" value="${owner}">

                <div class="am-input-group am-radius am-animation-slide-left" id="vld-username">
                    <input type="text" id="doc-vld-username" name="username" class="am-radius" data-validation-message="请输入正确用户名" placeholder="字母和数字组合的用户名" onblur="userv()" />
                    <span class="am-input-group-label log-icon am-radius"><i class="am-icon-user am-icon-sm am-icon-fw"></i></span>
                </div>
                <br>
                <div class="am-input-group am-animation-slide-left log-animation-delay">
                    <input type="password" id="log-password" name="password" class="am-form-field am-radius log-input" placeholder="密码" minlength="6" maxlength="16" required>
                    <span class="am-input-group-label log-icon am-radius"><i class="am-icon-lock am-icon-sm am-icon-fw"></i></span>
                </div>
                <br>
                <div class="am-input-group am-animation-slide-left log-animation-delay-a">
                    <input type="password" data-equal-to="#log-password" class="am-form-field am-radius log-input" placeholder="确认密码" data-validation-message="请确认密码一致" required>
                    <span class="am-input-group-label log-icon am-radius"><i class="am-icon-lock am-icon-sm am-icon-fw"></i></span>
                </div>
                <br>
                <div class="am-input-group am-animation-slide-left log-animation-delay-a" id="vphone">
                    <input type="tel" id="vld-phone" name="tel" class="am-form-field am-radius log-input" placeholder="手机号" data-validation-message="请输入正确的手机号" pattern="^\s*1\d{10}\s*$" required>
                    <span class="am-input-group-label log-icon am-radius"><i class="am-icon-phone am-icon-sm am-icon-fw"></i></span>
                </div>
                <br>
                <div class="am-input-group am-animation-slide-left log-animation-delay-a">
                    <input type="text" name="code" class="am-form-field am-radius log-input"  data-validation-message="请输入4位的验证码" placeholder="验证码" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')" onafterpaste="this.value=this.value.replace(/[^0-9]/g,'')" width="50%" minlength="4" required>

                    <span class="am-input-group-label log-icon am-radius" onclick="vldcode()" id="code">获取验证码</span>
                </div>
                <br>
                <button type="submit" onclick="return vld()" class="am-btn am-btn-primary am-btn-block am-btn-lg am-radius am-animation-slide-bottom log-animation-delay-b">注 册</button>
                <br>
                <div class="am-btn-group am-animation-slide-bottom log-animation-delay-b">
                </div>
            </form>
        </div>
    </div>
    <footer class="log-footer">
        ©中远方舟版权所有
    </footer>
</div>
<!--[if (gte IE 9)|!(IE)]><!-->
<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<!--<![endif]-->
<!--[if lte IE 8 ]>
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>

<![endif]-->
<script src="${pageContext.request.contextPath}/assets/js/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/register.js"></script>
<script type="text/javascript">
    var check = true;

    function userv() {
        if($("#usererror").length <= 0 ) {
            $alert = $('<div class="log-alert am-alert am-alert-danger am-radius" id="usererror"></div>').hide();
            $("#vld-username").append($alert);
        }
        else {
            $alert = $("#usererror").hide();
        }
        var value = $("#doc-vld-username").val();
        var zhcheck = /^[A-Za-z0-9]+$/;
        var msg = $("#doc-vld-username").data("validationMessage");
        if (!zhcheck.test(value)) {
            msg = "请输入字母和数字的组合";
            $alert.html(msg).show();
            check = false;
        } else {
            if (value.length < 3) {
                msg = "请输入至少2位的字母和数字的组合";
                $alert.html(msg).show();
                check = false;
            } else {

                $.ajax({
                    type: 'get',
                    url: '<%=request.getContextPath()%>/checkusername',
                    data: ["username", value],
                    dataType: "json",
                    success: function(data) {
                        console.log("userv ==> success: data = " + eval(data));
                        if (data) {
                            check = true;
                        } else {
                            msg = "该用户名不可用";
                            $alert.html(msg).show();
                            check = false;
                        }
                    }
                });
            }
        }

    }


    function vld() {
        userv();
        return check;
    }

    var b_code = true;
    var t;
    var c = 60;

    function sendCaptcha(tel) {
        console.log("sendCaptcha: tel = " + tel);
        $.ajax({
            type: 'post',
            url: '<%=request.getContextPath()%>/sms/captcha/' + tel,
            dataType: "json",
            success: function (data) {
                console.log("sendCaptcha ==> success: data = " + eval(data));
                if (data) {
                    countdown();
                    b_code = false;
                } else {
                    alert("您发送的频率过快!");
                }
            },
            error: function (data) {
                console.log("sendCaptcha ==> error: data = " + eval(data));
                alert("网络超时");
                clearTimeout(t);
                b_code = true;
                var msg = "获取验证码";
                $("#code").text(msg);
                c = 60;
            }
        });
    }

    function vldcode() {
        if (b_code) {
            var cc = /^\s*1\d{10}\s*$/;
            var value = $("#vld-phone").val();
            if (cc.test(value)) {
                $.ajax({
                    type: 'get',
                    url:'<%=request.getContextPath()%>/check-tel/' + value,
                    dataType: 'json',
                    success: function(data) {
                        console.log("vldcode ==> success: data = " + eval(data));
                        if (data) {
                            sendCaptcha(value);
                        } else {
                            alert("手机号已被占用!")
                        }
                    }
                });

            }

        }
    }

    function countdown() {
        var msg = c + "秒后重新获取";
        $("#code").text(msg);
        c--;
        t = setTimeout("countdown()", 1000);
        if (c == 0) {
            clearTimeout(t);
            b_code = true;
            var msg = "获取验证码";
            $("#code").text(msg);
            c = 60;
        }
    }
</script>
</body>

</html>

