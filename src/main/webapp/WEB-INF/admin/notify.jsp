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
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">系统设置/通知设置</strong></div>
    </div>
    <hr>
    <div class="am-g am-margin-top">
        <div class=" am-u-sm-6 am-u-md-4">
            <button type="button" onclick="add()" class="am-btn am-btn-primary am-btn-xs">新增通知</button>
        </div>
    </div>
    <div class="am-g">
        <div class="am-u-sm-12">
            <table class="am-table am-table-bd am-table-striped admin-content-table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>通知标题</th>
                        <th>通知内容</th>
                        <th>创建时间</th>
                        <th>管理</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach items="${notices}" var="notice">
                        <tr>
                            <td>${notice.id}</td>
                            <td>${notice.title}</td>
                            <td><a href="#">${notice.content}</a></td>
                            <td><span class="am-lg ">${notice.createdAt}</span></td>
                            <td>
                                <div class="am-dropdown" data-am-dropdown>
                                    <button class="am-btn am-btn-default am-btn-xs am-dropdown-toggle" data-am-dropdown-toggle><span class="am-icon-cog"></span> <span class="am-icon-caret-down"></span></button>
                                    <ul class="am-dropdown-content">
                                        <li><a href="#" onclick="change('${notice.title}','${notice.content}')">1. 编辑</a></li>
                                        <li><a href="#">2. 删除</a></li>
                                    </ul>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
        <div class="am-modal am-modal-alert" tabindex="-1" id="add_notify">
            <div class="am-modal-dialog">
                <div class="am-modal-hd">新增通知</div>
                <div class="am-modal-bd">
                    <div class="am-g am-margin-top">
                        <div class="am-u-sm-4 am-u-md-2 am-text-right">
                            标题
                        </div>
                        <div class="am-u-sm-8 am-u-md-8 am-u-end">
                            <input type="text" class="am-input-sm" id="title">
                        </div>
                    </div>
                    <div class="am-g am-margin-top">
                        <div class="am-u-sm-4 am-u-md-2 am-text-right">
                            内容
                        </div>
                        <div class="am-u-sm-8 am-u-md-8 am-u-end">
                            <textarea class="" rows="5" id="content"></textarea>
                        </div>
                    </div>
                </div>
                <div class="am-modal-footer">
                    <span class="am-modal-btn" data-am-modal-cancel>取消</span>
                    <span class="am-modal-btn" data-am-modal-confirm>保存</span>
                </div>
            </div>
        </div>
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
        <script type="text/javascript">
        function add() { showmodel();}
        function change(title,content) {
            $("#title").val(title);
            $("#content").val(content);
            showmodel();
        }
        function showmodel() {
            $('#add_notify').modal({
                relatedTarget: this,
                onConfirm: function(options) {
                    var title_val = $("#title").val();
                    var content_val = $("#content").val();
                    $("#title").val("");
                    $("#content").val("");
                },
                // closeOnConfirm: false,
                onCancel: function() {
                    $("#title").val("");
                    $("#content").val("");
                }
            });
        }
        </script>
        </div>
 </body>

</html>
