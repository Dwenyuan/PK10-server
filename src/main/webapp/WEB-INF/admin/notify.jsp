<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <style>
        *{ margin:0; padding:0; list-style:none;}
        a{ text-decoration:none;}
        a:hover{ text-decoration:none;}
        .tcdPageCode{padding: 15px 20px;text-align: left;color: #ccc;text-align:center;}
        .tcdPageCode a{display: inline-block;color: #428bca;display: inline-block;height: 25px;	line-height: 25px;	padding: 0 10px;border: 1px solid #ddd;	margin: 0 2px;border-radius: 4px;vertical-align: middle;}
        .tcdPageCode a:hover{text-decoration: none;border: 1px solid #428bca;}
        .tcdPageCode span.current{display: inline-block;height: 25px;line-height: 25px;padding: 0 10px;margin: 0 2px;color: #fff;background-color: #428bca;	border: 1px solid #428bca;border-radius: 4px;vertical-align: middle;}
        .tcdPageCode span.disabled{	display: inline-block;height: 25px;line-height: 25px;padding: 0 10px;margin: 0 2px;	color: #bfbfbf;background: #f2f2f2;border: 1px solid #bfbfbf;border-radius: 4px;vertical-align: middle;}
    </style>
    <script type="text/javascript">



    </script>

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

                    <c:forEach varStatus="vs" items="${notices.rows}" var="notice">
                        <tr>
                            <td>${vs.index+1}</td>
                            <td>${notice.title}</td>
                            <td><a href="#">${notice.content}</a></td>
                            <td>${notice.createdAt}<fmt:formatDate value="${agent.createdAt}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                            <td>
                                <div class="am-dropdown" data-am-dropdown>
                                    <button class="am-btn am-btn-default am-btn-xs am-dropdown-toggle" data-am-dropdown-toggle><span class="am-icon-cog"></span> <span class="am-icon-caret-down"></span></button>
                                    <ul class="am-dropdown-content">
                                        <li><a href="#" onclick="change(${notice.id},'${notice.title}','${notice.content}')">1. 编辑</a></li>
                                        <li><a href="#" onclick="deleteNotice(${notice.id})">2. 删除</a></li>
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
                            <input type="hidden" id="id">
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
        <div class="am-cf">
            <spen class="total">共${notices.total}条记录</spen>
            <div class="am-fr">
                <div class="tcdPageCode"></div>
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
        <script src="${pageContext.request.contextPath}/assets/js/jquery.page.js"></script>
        <script type="text/javascript">
        function add() { showmodel();}
        function change(id,title,content) {

            $("#title").val(title);
            $("#content").val(content);
            $("#id").val(id);


            showmodel();
        }
        function showmodel() {
            $('#add_notify').modal({
                relatedTarget: this,
                onConfirm: function(options) {
                    var id = $("#id").val();
                    var title_val = $("#title").val();
                    var content_val = $("#content").val();
                    $("#title").val("");
                    $("#content").val("");
                    $("#id").val("");

                    if(id == "" || id == undefined || id == null){
                        $.ajax({
                            type: 'POST',
                            contentType: 'application/json',
                            url: '${pageContext.request.contextPath}/savaNotice',
                            processData: false,
                            dataType: 'json',
                            data : '{"title":\"'+title_val+'\","content":\"'+content_val+'\"}',
                            success: function(data) {
                                window.location = 'toNotice?pages='+${notices.totalPage};
                            },
                            error: function() {
                                alert('Err...');
                            }
                        });
                    }else {
                        $.ajax({
                            type: 'POST',
                            contentType: 'application/json',
                            url: '${pageContext.request.contextPath}/updateNotice',
                            processData: false,
                            dataType: 'json',
                            data : '{"id":\"'+id+'\","title":\"'+title_val+'\","content":\"'+content_val+'\"}',
                            success: function(data) {
                                window.location = 'toNotice?pages='+${notices.currentPage};
                            },
                            error: function() {
                                alert('Err...');
                            }
                        });
                    }
                },
                // closeOnConfirm: false,
                onCancel: function() {
                    $("#title").val("");
                    $("#content").val("");
                }
            });
        }

        function gotoPage(pages) {

            window.location = 'toNotice?pages='+pages;
        }

        function deleteNotice(id){
            $.ajax({
                type: 'POST',
                contentType: 'application/json',
                url: '${pageContext.request.contextPath}/deleteNotice',
                processData: false,
                dataType: 'json',
                data : '{"id":\"'+id+'\"}',
                success: function(data) {
                    window.location = 'toNotice?pages='+${notices.currentPage};
                },
                error: function() {
                    alert('Err...');
                }
            });
        }
        $(function(){

            // var current = $("#currentPage").val();
            // var total = $("#totalPage").val();
            // alert(current +"==" + total);
            $(".tcdPageCode").createPage({
                pageCount: Number(${notices.totalPage}),
                current: Number(${notices.currentPage}),
                backFn:function(p){

                    gotoPage(p);
                }
            });

        });
        </script>
        </div>
 </body>

</html>
