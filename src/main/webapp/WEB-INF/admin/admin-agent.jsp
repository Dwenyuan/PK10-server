<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html class="no-js fixed-layout">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>数字互娱</title>
  <meta name="description" content="后台管理页面">
  <meta name="keywords" content="index">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin.css">

</head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

<header class="am-topbar am-topbar-inverse admin-header">
  <div class="am-topbar-brand">
    <strong>游戏</strong> <small>后台管理</small>
  </div>

  <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

  <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

    <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list"> 
      <li class="am-dropdown" data-am-dropdown>
        <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
          <span class="am-icon-users"></span> ${sessionScope.userinfo.username} <span class="am-icon-caret-down"></span>
        </a>
        <ul class="am-dropdown-content">
          <li><a href="${pageContext.request.contextPath}/adminloginout"><span class="am-icon-power-off"></span> 退出</a></li>
        </ul>
      </li>
      <li class="am-hide-sm-only"><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>
    </ul>
  </div>
</header>

<div class="am-cf admin-main">
  <!-- sidebar start -->
  <div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
    <div class="am-offcanvas-bar admin-offcanvas-bar">
      <ul class="am-list admin-sidebar-list">

        <%--<li><a  class="am-cf am-collapsed" data-am-collapse="{target: '#collapse-nav1'}"><span class="am-icon-table"></span> 充值管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>--%>
          <%--<ul class="am-list am-collapse admin-sidebar-sub " id="collapse-nav1">--%>
            <%--<li><a href="${pageContext.request.contextPath}/money-manager" class="am-cf" target="subject"><span class="am-icon-check"></span> 用户金币管理</a></li>--%>
          <%--</ul>--%>
        <%--</li>--%>

        <li class="admin-parent">
          <a class="am-cf am-collapsed" data-am-collapse="{target: '#collapse-nav4'}"><span class="am-icon-pencil-square-o"></span> 代理商功能 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
          <ul class="am-list am-collapse admin-sidebar-sub " id="collapse-nav4">
            <li><a href="toAddDistributor" class="am-cf" target="subject"><span class="am-icon-check"></span> 创建普通会员</a></li>
            <li><a href="${pageContext.request.contextPath}/junior/users/${sessionScope.userinfo.id}/1" class="am-cf" target="subject"><span class="am-icon-check"></span> 查看下级用户</a></li>
            <li><a href="toRateHistory" target="subject"><span class="am-icon-puzzle-piece"></span>返点信息记录</a></li>
            <li><a href="${pageContext.request.contextPath}/money-add-record/null/null?curAgentId=${sessionScope.userinfo.id}&pn=1" class="am-cf" target="subject"><span class="am-icon-check"></span> 下级充值记录</a></li>
            <li><a href="${pageContext.request.contextPath}/userbet/junior/${sessionScope.userinfo.id}/0/0?pn=1 " class="am-cf" target="subject"><span class="am-icon-check"></span> 下级投注记录</a></li>
            <li><a href="${pageContext.request.contextPath}/account-change/junior/null/null?curAgentId=${sessionScope.userinfo.id}&pn=1 " class="am-cf" target="subject"><span class="am-icon-check"></span> 下级帐变记录</a></li>
          </ul>
        </li>

        <li><a href="${pageContext.request.contextPath}/adminloginout"><span class="am-icon-sign-out"></span> 注销</a></li>
      </ul>

      <div class="am-panel am-panel-default admin-sidebar-panel">
        <div class="am-panel-bd">
          <p><span class="am-icon-bookmark"></span> 公告</p>
          <p>时光静好，与君语；细水流年，与君同。—— ZYARK </p>
        </div>
      </div>

      <div class="am-panel am-panel-default admin-sidebar-panel">
        <div class="am-panel-bd">
          <p><span class="am-icon-tag"></span> wiki</p>
          <p>Welcome to the ZYARK wiki!</p>
        </div>
      </div>
    </div>
  </div>
  <!-- sidebar end -->

  <!-- content start -->
  <div class="admin-content" style="overflow-y:hidden;">

    <iframe src="" name="subject" class="admin-content-body"></iframe>
  
   <!-- <div class="admin-content-body">
  <div class="am-cf am-padding">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">首页</strong></div>
      </div>

      <ul class="am-avg-sm-1 am-avg-md-4 am-margin am-padding am-text-center admin-content-list ">
        <li><a href="#" class="am-text-success"><span class="am-icon-btn am-icon-file-text"></span><br/>宝贝数量<br/>2300</a></li>
        <li><a href="#" class="am-text-warning"><span class="am-icon-btn am-icon-briefcase"></span><br/>今日访问<br/>308</a></li>
        <li><a href="#" class="am-text-danger"><span class="am-icon-btn am-icon-recycle"></span><br/>昨日访问<br/>80082</a></li>
        <li><a href="#" class="am-text-secondary"><span class="am-icon-btn am-icon-user-md"></span><br/>总访问<br/>883000</a></li>
      </ul>

      <div class="am-g">
        <div class="am-u-sm-12">
          <strong class="am-text-danger am-text-lg">热门宝贝</strong>
          <table class="am-table am-table-bd am-table-striped admin-content-table">
            <thead>
            <tr>
              <th>ID</th><th>宝贝名称</th><th>优惠券</th><th>领券数</th><th>管理</th>
            </tr>
            </thead>
            <tbody>
            <tr><td>1</td><td>John Clark</td><td><a href="#">Business management</a></td> <td><span class="am-badge am-badge-success">+20</span></td>
              <td>
                <div class="am-dropdown" data-am-dropdown>
                  <button class="am-btn am-btn-default am-btn-xs am-dropdown-toggle" data-am-dropdown-toggle><span class="am-icon-cog"></span> <span class="am-icon-caret-down"></span></button>
                  <ul class="am-dropdown-content">
                    <li><a href="#">1. 编辑</a></li>
                    <li><a href="#">2. 下载</a></li>
                    <li><a href="#">3. 删除</a></li>
                  </ul>
                </div>
              </td>
            </tr>
            <tr><td>2</td><td>风清扬</td><td><a href="#">公司LOGO设计</a> </td><td><span class="am-badge am-badge-danger">+2</span></td>
              <td>
                <div class="am-dropdown" data-am-dropdown>
                  <button class="am-btn am-btn-default am-btn-xs am-dropdown-toggle" data-am-dropdown-toggle><span class="am-icon-cog"></span> <span class="am-icon-caret-down"></span></button>
                  <ul class="am-dropdown-content">
                    <li><a href="#">1. 编辑</a></li>
                    <li><a href="#">2. 下载</a></li>
                    <li><a href="#">3. 删除</a></li>
                  </ul>
                </div>
              </td>
            </tr>
            <tr><td>3</td><td>詹姆斯</td><td><a href="#">开发一款业务数据软件</a></td><td><span class="am-badge am-badge-warning">+10</span></td>
              <td>
                <div class="am-dropdown" data-am-dropdown>
                  <button class="am-btn am-btn-default am-btn-xs am-dropdown-toggle" data-am-dropdown-toggle><span class="am-icon-cog"></span> <span class="am-icon-caret-down"></span></button>
                  <ul class="am-dropdown-content">
                    <li><a href="#">1. 编辑</a></li>
                    <li><a href="#">2. 下载</a></li>
                    <li><a href="#">3. 删除</a></li>
                  </ul>
                </div>
              </td>
            </tr>
            <tr><td>4</td><td>云适配</td><td><a href="#">适配所有网站</a></td><td><span class="am-badge am-badge-secondary">+50</span></td>
              <td>
                <div class="am-dropdown" data-am-dropdown>
                  <button class="am-btn am-btn-default am-btn-xs am-dropdown-toggle" data-am-dropdown-toggle><span class="am-icon-cog"></span> <span class="am-icon-caret-down"></span></button>
                  <ul class="am-dropdown-content">
                    <li><a href="#">1. 编辑</a></li>
                    <li><a href="#">2. 下载</a></li>
                    <li><a href="#">3. 删除</a></li>
                  </ul>
                </div>
              </td>
            </tr>

            <tr>
              <td>5</td><td>呵呵呵</td>
              <td><a href="#">基兰会获得BUFF</a></td>
              <td><span class="am-badge">+22</span></td>
              <td>
                <div class="am-dropdown" data-am-dropdown>
                  <button class="am-btn am-btn-default am-btn-xs am-dropdown-toggle" data-am-dropdown-toggle><span class="am-icon-cog"></span> <span class="am-icon-caret-down"></span></button>
                  <ul class="am-dropdown-content">
                    <li><a href="#">1. 编辑</a></li>
                    <li><a href="#">2. 下载</a></li>
                    <li><a href="#">3. 删除</a></li>
                  </ul>
                </div>
              </td>
            </tr>
            </tbody>
          </table>
        </div>
      </div>

      
    </div>

    <footer class="admin-content-footer">
      <hr>
      <p class="am-padding-left">© 2014 AllMobilize, Inc. Licensed under MIT license.</p>
    </footer>
  <a href="#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"></a>


</div> -->
   

  </div>
<a href="#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"></a>


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
  </div>
</body>
</html>
