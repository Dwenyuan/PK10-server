<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<!--<![endif]-->
<script src="${pageContext.request.contextPath}/assets/js/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/app.js"></script>

<html class="no-js">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="keywords" content="table">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <title>用户金币管理</title>
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/assets/i/app-icon72x72@2x.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin.css">
    <style type="text/css">
    body {
        overflow-x: hidden;
        overflow-y: scroll;
    }
    
    ul li a span {
        padding-top: 11px;
    }
    </style>
</head>

<body>
    <div class="am-cf am-padding">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">用户管理/金币管理</strong></div>
    </div>
    <hr>

    <div class="am-g">
        <form id="search_user" method="get" action="user">

           <div class="am-u-sm-12 am-u-md-3 am-u-md-offset-2 am-u-end">
                ${errorMsg}
                <div class="am-input-group am-input-group-sm">
                    <input type="text" class="am-form-field"  placeholder="用户名" name="username" value="${user.username}">
                    <span class="am-input-group-btn">
                        <button class="am-btn am-btn-default" type="submit" >搜索</button>
                    </span>
                </div>
            </div>
        </form>
    </div>

    <form id="add_user" method="post" action="user">
        <input type="hidden" name="id" value="${user.id}">
        <div class="am-g am-margin-top">
              <div class="am-u-sm-4 am-u-md-2 am-text-right">
                    用户名
              </div>
              <div class="am-u-sm-8 am-u-md-4 am-u-end">
                   <input type="text" name="username" value="${user.username}" disabled="true">
              </div>
        </div>
        <div class="am-g am-margin-top">
              <div class="am-u-sm-4 am-u-md-2 am-text-right">
                    昵称
              </div>
              <div class="am-u-sm-8 am-u-md-4 am-u-end">
                   <input type="text" name="name" value="${user.nickname}" disabled="true">
              </div>
        </div>
        <div class="am-g am-margin-top">
              <div class="am-u-sm-4 am-u-md-2 am-text-right">
                    金币
              </div>
              <div class="am-u-sm-8 am-u-md-4 am-u-end">
                   <input type="text" name="money" value="${user.money}" disabled="true">
              </div>
        </div>
        <div class="am-g am-margin-top">
              <div class="am-u-sm-4 am-u-md-2 am-text-right">
                    代理商ID
              </div>
              <div class="am-u-sm-8 am-u-md-4 am-u-end">
                   <input type="text" name="agent" value="${user.owner}" disabled="true">
              </div>
        </div>
        <div class="am-g am-margin-top">
              <div class="am-u-sm-4 am-u-md-2 am-text-right">
                    充值金额
              </div>
              <div class="am-u-sm-8 am-u-md-4 am-u-end">
                  <input type="text" class="am-input-sm" name="charge_money">
              </div>
        </div>

        <div class="am-g am-margin-top">
          <div class="am-u-sm-offset-3 am-u-sm-6 am-u-md-offset-2 am-u-md-4">
          <button type="submit" class="am-btn am-btn-primary am-btn-xs" >充值</button>
          <button type="reset" class="am-btn am-btn-primary am-btn-xs">重置</button>
          </div>
        </div>
    </form>
    <footer class="admin-content-footer">
        <hr>
        <p class="am-padding-left">© 中远方舟科技有限公司版权所有</p>
    </footer>

</body>

</html>
