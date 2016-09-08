<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html class="no-js">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>竞猜游戏后台</title>
    <meta name="description" content="这是一个 table 页面">
    <meta name="keywords" content="table">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
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
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">系统设置/倍率设置</strong></div>
    </div>
    <div class="am-g">
        <div class="am-u-md-12">
               
        </div>
    </div>
    <hr>
    <form>
     <div class="am-g am-margin-top">
          <div class="am-u-sm-4 am-u-md-2 am-text-right">
                游戏
          </div>
          <div class="am-u-sm-8 am-u-md-4 am-u-end">
               <select data-am-selected>
                   <c:forEach items="${jsonArray}" var="bean">
                    <option value="${bean.gName}">${bean.gName}</option>
                   </c:forEach>
                </select>
          </div>
    </div>
    <div class="am-g am-margin-top">
          <div class="am-u-sm-4 am-u-md-2 am-text-right">
                类型
          </div>
          <div class="am-u-sm-8 am-u-md-4 am-u-end">
               <select data-am-selected>
                    <option value="a">大小单双</option>
                    <option value="a">0-9</option>
                </select>
          </div>
    </div>
    <div class="am-g am-margin-top">
          <div class="am-u-sm-4 am-u-md-2 am-text-right">
                倍率
          </div>
          <div class="am-u-sm-8 am-u-md-4 am-u-end">
              <input type="text" class="am-input-sm">
          </div>
    </div>

    <div class="am-g am-margin-top">
      <div class="am-u-sm-offset-3 am-u-sm-6 am-u-md-offset-2 am-u-md-4">
      <button type="button"  onclick="sub()" class="am-btn am-btn-primary am-btn-xs" >提交保存</button>
      <button type="reset" class="am-btn am-btn-primary am-btn-xs">放弃保存</button>
      </div>
    </div>
    </form>
    <footer class="admin-content-footer">
        <hr>
        <p class="am-padding-left">© 中远方舟 ©版权所有.</p>
    </footer>
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
</body>

</html>
