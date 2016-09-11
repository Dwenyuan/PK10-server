<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">用户管理/用户列表</strong> </div>
    </div>
    <hr>
    <div class="am-g">
        <div class="am-u-sm-12 ">
            
        </div>
        <div class="am-u-sm-12 am-u-md-3 am-u-md-offset-4 am-u-end">
            <div class="am-input-group am-input-group-sm">
                <input type="text" class="am-form-field" id="agentUsername">
                <span class="am-input-group-btn">
            <button class="am-btn am-btn-default" type="button" onclick="searchFor()">搜索</button>
          </span>
            </div>
        </div>
    </div>
    <div class="am-g">
        <div class="am-u-sm-12">
            <table class="am-table am-table-striped am-table-hover table-main">
                <thead>
                    <tr>
                        <th class="table-id">序号</th>
                        <th class="table-id">代理商ID</th>
                        <th class="table-title">昵称</th>
                        <th class="table-type">密码</th>
                        <th class="table-type">手机</th>
                        <th class="table-type">返点</th>
                        <th class="table-date am-hide-sm-only">创建时间</th>
                        <th>管理</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach varStatus="vs" items="${agentDatagrid.rows}" var="agent">
                        <tr>
                            <td>${vs.index}</td>
                            <td>${agent.username}</td>
                            <td><a href="#">${agent.nickname}</a></td>
                            <td>${agent.password}</td>
                            <td>${agent.tel}</td>
                            <td>${agent.rebate}</td>
                            <td class="am-hide-sm-only">${agent.createdAt}</td>
                            <td>
                                <div class="am-dropdown" data-am-dropdown>
                                    <button class="am-btn am-btn-default am-btn-xs am-dropdown-toggle" data-am-dropdown-toggle><span class="am-icon-cog"></span> <span class="am-icon-caret-down"></span></button>
                                    <ul class="am-dropdown-content">
                                        <li><a href="#" onclick="change(${agent.id},'${agent.username}','${agent.nickname}','${agent.password}','${agent.tel}','${agent.rebate}')">1. 编辑</a></li>
                                        <li><a href="#" onclick="deleteAgent('${agent.username}')">2. 删除</a></li>
                                    </ul>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="am-modal am-modal-alert" tabindex="-1" id="add_agent">
            <div class="am-modal-dialog">
                <div class="am-modal-hd">新增通知</div>
                <div class="am-modal-bd">
                    <div class="am-g am-margin-top">
                        <div class="am-u-sm-4 am-u-md-2 am-text-right">
                            用户ID
                        </div>
                        <div class="am-u-sm-8 am-u-md-8 am-u-end">
                            <input type="hidden" id="id">
                            <input type="text" readOnly="true" class="am-input-sm" id="username">
                        </div>
                    </div>
                    <div class="am-g am-margin-top">
                        <div class="am-u-sm-4 am-u-md-2 am-text-right">
                            昵称
                        </div>
                        <div class="am-u-sm-8 am-u-md-8 am-u-end">
                            <input type="text" class="am-input-sm" id="nickname"></textarea>
                        </div>
                    </div>
                    <div class="am-g am-margin-top">
                        <div class="am-u-sm-4 am-u-md-2 am-text-right">
                            密码
                        </div>
                        <div class="am-u-sm-8 am-u-md-8 am-u-end">
                            <input type="text" class="am-input-sm" id="password"></textarea>
                        </div>
                    </div>
                    <div class="am-g am-margin-top">
                        <div class="am-u-sm-4 am-u-md-2 am-text-right">
                            手机
                        </div>
                        <div class="am-u-sm-8 am-u-md-8 am-u-end">
                            <input type="text" class="am-input-sm" id="tel"></textarea>
                        </div>
                    </div>
                    <div class="am-g am-margin-top">
                        <div class="am-u-sm-4 am-u-md-2 am-text-right">
                            返点
                        </div>
                        <div class="am-u-sm-8 am-u-md-8 am-u-end">
                            <input type="text" class="am-input-sm" id="rebate"></textarea>
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
            <spen class="total">共${agentDatagrid.total}条记录</spen>
            <div class="am-fr">
                <div class="tcdPageCode"></div>
            </div>
        </div>

    </div>

    <!-- content end -->
    <div class="am-modal am-modal-alert" tabindex="-1" id="recharge">
        <div class="am-modal-dialog">
            <div class="am-modal-hd"></div>
            <div class="am-modal-bd">
                <table class="am-table am-table-striped am-table-hover table-main">
                    <thead>
                    <tr>
                        <th class="table-type">代理商</th>
                        <th class="table-type">昵称</th>
                        <th class="table-type">密码</th>
                        <th class="table-type">手机</th>
                        <th class="table-type">返点</th>
                        <th class="table-type">创建时间</th>

                    </tr>
                    </thead>
                    <tbody id="tb">
                        <td id="td1"></td>
                        <td id="td2"></td>
                        <td id="td3"></td>
                        <td id="td4"></td>
                        <td id="td5"></td>
                        <td id="td6"></td>
                    </tbody>
                </table>
            </div>
            <div class="am-modal-footer">
                <span class="am-modal-btn">确定</span>
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
       function recharge(id) {
            $("#recharge").modal();
       }
       function change(id,username,nickname,password,tel,rebate) {


           $("#id").val(id);
           $("#username").val(username);
           $("#nickname").val(nickname);
           $("#password").val(password);
           $("#tel").val(tel);
           $("#rebate").val(rebate);


           showmodel();
       }
       function showmodel() {
           $('#add_agent').modal({
               relatedTarget: this,
               onConfirm: function(options) {
                   var id = $("#id").val();
                   var username = $("#username").val();
                   var nickname = $("#nickname").val();
                   var password = $("#password").val();
                   var tel = $("#tel").val();
                   var rebate = $("#rebate").val();
                   $("#id").val("");
                   $("#username").val("");
                   $("#nickname").val("");
                   $("#password").val("");
                   $("#tel").val("");
                   $("#rebate").val("");

                       $.ajax({
                           type: 'POST',
                           contentType: 'application/json',
                           url: '${pageContext.request.contextPath}/updateAgentInfo',
                           processData: false,
                           dataType: 'json',
                           data : '{"id":\"'+id+'\","username":\"'+username+'\","nickname":\"'+nickname+'\","password":\"'+password+'\","tel":\"'+tel+'\","rebate":\"'+rebate+'\"}',
                           success: function(data) {
                               window.location = 'toAgentList?pages='+${agentDatagrid.currentPage};
                           },
                           error: function() {
                               alert('Err...');
                           }
                       });
               },
               // closeOnConfirm: false,
               onCancel: function() {
                   $("#id").val("");
                   $("#username").val("");
                   $("#nickname").val("");
                   $("#password").val("");
                   $("#tel").val("");
                   $("#rebate").val("");
               }
           });
       }

       function gotoPage(pages) {

           window.location = 'toAgentList?pages='+pages;
       }

       function deleteAgent(username){
           $.ajax({
               type: 'POST',
               contentType: 'application/json',
               url: '${pageContext.request.contextPath}/deleteAgent',
               processData: false,
               dataType: 'json',
               data : '{"username":\"'+username+'\"}',
               success: function(data) {
                   window.location = 'toAgentList?pages='+${agentDatagrid.currentPage};
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
               pageCount: Number(${agentDatagrid.totalPage}),
               current: Number(${agentDatagrid.currentPage}),
               backFn:function(p){

                   gotoPage(p);
               }
           });

       });


       function searchFor(){

           var username =$("#agentUsername").val();
           $.ajax({
               type: 'POST',
               contentType: 'application/json',
               url: '${pageContext.request.contextPath}/getUserByUsername',
               processData: false,
               dataType: 'json',
               data : '{"username":\"'+username+'\"}',
               success: function(data) {



                   var username = data.username;
                   var nickname =data.nickname;
                   var password =data.password;
                   var tel =data.tel;
                   var rebate =data.rebate;
                   var createdAt =data.createdAt;
                   var mydata = FormatDate(createdAt);

                   document.getElementById('td1').innerHTML = "";
                   document.getElementById('td2').innerHTML = "";
                   document.getElementById('td3').innerHTML = "";
                   document.getElementById('td4').innerHTML = "";
                   document.getElementById('td5').innerHTML = "";
                   document.getElementById('td6').innerHTML = "";
                   document.getElementById('td1').innerHTML += username;
                   document.getElementById('td2').innerHTML += nickname;
                   document.getElementById('td3').innerHTML += password;
                   document.getElementById('td4').innerHTML += tel;
                   document.getElementById('td5').innerHTML += rebate;
                   document.getElementById('td6').innerHTML += mydata;
                   recharge();

               },
               error: function() {
                   alert('Err...');
               }
           });

           function FormatDate (strTime) {
               var date = new Date(strTime);
               return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+"/"+date.getHours()+"时"+date.getMinutes()+"分"+date.getMilliseconds()+"秒";
           }
           //var lotteryId = Number($("#lotteryId").val());
           // window.location = 'getLotteryById?id='+lotteryId;
       }
       function recharge() {
           $("#recharge").modal();
       }
    </script>
</body>

</html>
