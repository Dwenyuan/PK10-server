<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

<html class="no-js">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="keywords" content="table">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <title>用户列表</title>
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/assets/i/app-icon72x72@2x.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/app.css">

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

<body onload="agent()">
    <c:if test="${requestScope.errorMsg != null}">
        <script>
            alert(${errorMsg});
        </script>
    </c:if>
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">用户管理/用户列表</strong> </div>
    </div>
    <hr>
    <div class="am-g">
        <div class="am-u-sm-12 am-u-md-2">
            <div class="am-form-group">
                <select data-am-selected="{btnSize: 'sm'}" id="agent">
                    <option value="option1">所有代理商</option>
                </select>
            </div>
        </div>
  <%--      <div class="am-u-sm-12 am-u-md-2 am-u-md-offset-1" >
            <div class="am-form-group">
                <select data-am-selected="{btnSize: 'sm'}" id="nextagent">
                    <option value="option1">所有分销商</option>
                </select>
            </div>
        </div>--%>
        <div class="am-u-sm-12 am-u-md-3 am-u-md-offset-1 am-u-end">
            <div class="am-input-group am-input-group-sm">
                <input type="text" class="am-form-field" id="search_username" placeholder="这里输入用户名">
                <span class="am-input-group-btn">
            <button class="am-btn am-btn-default" type="button" onclick="search_user()">搜索</button>
          </span>
            </div>
        </div>
    </div>
    <div class="am-g">
        <div class="am-u-sm-12">
            <table class="am-table am-table-striped am-table-hover table-main">
                <thead>
                    <tr>
                        <%--<th class="table-check">
                            <input type="checkbox" />
                        </th>--%>
                        <th class="table-id">用户ID</th>
                        <th class="table-id">上级用户名</th>
                        <th class="table-title">姓名</th>
                        <th class="table-type">用户名</th>
                        <th class="table-author am-hide-sm-only">金币</th>
                        <th class="table-date am-hide-sm-only">创建时间</th>
                        <th class="table-set">操作</th>
                    </tr>
                </thead>
                <tbody id="users">
                <c:choose>
                    <c:when test="${requestScope.users == null} && ${requestScope.records == null}">
                        <script>
                            alert("无用户信息可显示!");

                        </script>
                    </c:when>
                    <c:otherwise>
                        <c:forEach items="${users}" var="user" varStatus="vs">
                            <tr>
                                <%--<td>
                                    <input type="checkbox" />
                                </td>--%>
                                <td>${user.id}</td>
                                <td>${user.ownerUsername}</td>
                                <td><a href="#">${user.nickname}</a></td>
                                <td>${user.username}</td>
                                <td class="am-hide-sm-only">${user.money}</td>
                                <td class="am-hide-sm-only">
                                    <fmt:formatDate value="${user.createdAt}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td>
                                    <div class="am-btn-toolbar">
                                        <div class="am-btn-group am-btn-group-xs">
                                            <button class="am-btn am-btn-default am-btn-xs am-text-warning" onclick="recharge_c(${user.id})">
                                                <span class="am-icon-pencil-square-o"></span>充值</button>
                                            <button class="am-btn am-btn-default am-btn-xs am-text-warning" onclick="userbet_c(${user.id})">
                                                <span class="am-icon-pencil-square-o"></span>投注</button>
                                            <button class="am-btn am-btn-default am-btn-xs am-text-warning" onclick="given_c('${user.username}')">
                                                <span class="am-icon-pencil-square-o"></span>赠送</button>
                                            <button class="am-btn am-btn-default am-btn-xs am-text-warning" onclick="moneychange_c(${user.id})">
                                                <span class="am-icon-pencil-square-o"></span>帐变</button>
                                            <button class="am-btn am-btn-default am-btn-xs am-text-secondary"
                                                    onclick="edit_user_c('${user.id}', '${user.username}', '${user.password}', '${user.tel}', '${user.isagent}')">
                                                <span class="am-icon-pencil-square-o"></span> 编辑</button>
                                            <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" onclick="delete_c(${user.id})">
                                                <span class="am-icon-trash-o"></span> 删除</button>
                                        </div>
                                    </div>
                                </td>
                            </tr>

                        </c:forEach>
                    </c:otherwise>
                </c:choose>
                </tbody>
            </table>

            <div>
                <div class="am-al">共 ${page.total} 条记录</div>
                <div class="tcdPageCode">

                   <script>
                        $(".tcdPageCode").createPage({
                            pageCount:${page.pages},
                            current:${pn},
                            backFn:function(p){
                                // 单击回调方法，p是当前页码
                                location.href = "${pageContext.request.contextPath}/users?pn=" + p;
                            }
                        });

                    </script>

                </div>
            </div>
        </div>
    </div>
    <!-- content end -->
    <!-- recharge -->
    <div class="am-modal am-modal-alert" tabindex="-1" id="recharge">
        <div class="am-modal-dialog">
            <div class="am-modal-hd">充值记录</div>
            <div class="am-modal-bd">
                <table class="am-table am-table-striped am-table-hover table-main">
                    <thead>
                        <tr>
                            <th>用户名</th>
                            <th>充值人用户名</th>
                            <th>充值金额</th>
                            <th>充值时间</th>
                        </tr>
                    </thead>
                    <tbody id="recharge_record">
                    ${errorMsg}
                    </tbody>
                </table>
            </div>
            <div class="am-modal-footer">
                <span class="am-modal-btn" id="btn-ok">确定</span>
            </div>
        </div>
    </div>

    <!-- 投注 -->
    <div class="am-modal am-modal-alert" tabindex="-1" id="userbet">
        <div class="am-modal-dialog">
            <div class="am-modal-hd">投注记录</div>
            <div class="am-modal-bd">
                <table class="am-table am-table-striped am-table-hover table-main">
                    <thead>
                    <tr>
                        <th>用户ID</th>
                        <th>开奖期数</th>
                        <th>玩法</th>
                        <th>下注金额</th>
                        <th>下注倍数</th>
                        <th>此次下注赔率</th>
                        <th>下注号码</th>
                        <th>投注时间</th>
                    </tr>
                    </thead>
                    <tbody id="userbet_record">
                    ${errorMsg}
                    </tbody>
                </table>
            </div>
            <div class="am-modal-footer">
                <span class="am-modal-btn" id="bet-ok">确定</span>
            </div>
        </div>
    </div>

    <!-- 帐变 -->
    <div class="am-modal am-modal-alert" tabindex="-1" id="moneychange">
        <div class="am-modal-dialog">
            <div class="am-modal-hd">帐变记录</div>
            <div class="am-modal-bd">
                <div>
                    <div class="am-u-md-4">
                        <input type="text" id="startTime" class="am-form-field" placeholder="开始时间" data-am-datepicker readonly required />
                    </div>
                    <div class="am-u-md-4">
                        <input type="text" id="endTime" class="am-form-field" placeholder="结束时间" data-am-datepicker readonly required />
                    </div>
                    <div class="am-u-md-4"><button class="am-btn am-btn-primary" onclick="account_change()">搜索</button></div>
                </div>
                <table class="am-table am-table-striped am-table-hover table-main">
                    <thead>
                    <tr>
                        <th>用户名</th>
                        <th>帐变类型</th>
                        <th>金额</th>
                        <th>余额</th>
                        <th>时间</th>
                    </tr>
                    </thead>
                    <tbody id="account_change_record">
                    ${errorMsg}
                    </tbody>
                </table>
            </div>
            <div class="am-modal-footer">
                <span class="am-modal-btn" id="change-ok">确定</span>
            </div>
        </div>
    </div>

    <!-- 赠送记录 -->
    <div class="am-modal am-modal-alert" tabindex="-1" id="given">
        <div class="am-modal-dialog">
            <div class="am-modal-hd">赠送记录</div>
            <div class="am-modal-bd">
                <div>
                    <div class="am-u-md-4">
                        <input type="text" id="given_start_time" class="am-form-field" placeholder="开始时间" data-am-datepicker readonly required />
                    </div>
                    <div class="am-u-md-4">
                        <input type="text" id="given_end_time" class="am-form-field" placeholder="结束时间" data-am-datepicker readonly required />
                    </div>
                    <div class="am-u-md-4"><button class="am-btn am-btn-primary" onclick="given_search()">搜索</button></div>
                </div>
                <table class="am-table am-table-striped am-table-hover table-main">
                    <thead>
                    <tr>
                        <th>用户名</th>
                        <th>类型</th>
                        <th>金额</th>
                        <th>当前用户余额</th>
                        <th>对方用户名</th>
                        <th>时间</th>
                    </tr>
                    </thead>
                    <tbody id="given_record">
                    ${errorMsg}
                    </tbody>
                </table>
            </div>
            <div class="am-modal-footer">
                <span class="am-modal-btn" id="given_ok">确定</span>
            </div>
        </div>
    </div>
    <!-- edit -->
    <div class="am-modal am-modal-alert" tabindex="-1" id="userinfo">
        <div class="am-modal-dialog">
            <div class="am-modal-hd">编辑用户信息</div>
            <div class="am-modal-bd">
                <form id="edit_user" method="post" action="${pageContext.request.contextPath}/user">
                    <input id="ui_id" type="hidden" name="id" value="">
                    <input id="ui_isagent" type="hidden" name="isagent" value="">

                    <div class="am-g am-margin-top">
                        <div class="am-u-sm-4 am-u-md-2 am-text-right">
                            用户名
                        </div>
                        <div class="am-u-sm-8 am-u-md-4 am-u-end">
                            <input id="ui_un" type="text" name="username" value="">
                        </div>
                    </div>
                    <div class="am-g am-margin-top">
                        <div class="am-u-sm-4 am-u-md-2 am-text-right">
                            密码
                        </div>
                        <div class="am-u-sm-8 am-u-md-4 am-u-end">
                            <input id="ui_pwd" type="text" name="password" value="">
                        </div>
                    </div>
                    <div class="am-g am-margin-top">
                        <div class="am-u-sm-4 am-u-md-2 am-text-right">
                            电话
                        </div>
                        <div class="am-u-sm-8 am-u-md-4 am-u-end">
                            <input id="ui_tel" type="text" name="tel" value="">
                        </div>
                    </div>

                    <div class="am-g am-margin-top">
                        <div class="am-u-sm-offset-3 am-u-sm-6 am-u-md-offset-2 am-u-md-4">
                            <button type="submit" class="am-btn am-btn-primary am-btn-xs" >更新</button>
                        </div>
                    </div>
                </form>
            </div>

        </div>
    </div>

    <footer class="admin-content-footer">
        <hr>
        <p class="am-padding-left">© 中远方舟科技有限公司版权所有</p>
    </footer>

    <script type="text/javascript">
       function recharge_c(id) {
           $.ajax({
               type: 'get',
               contentType: 'application/json',
               url: '<%=request.getContextPath()%>/money-add-record/record-list?id=' + id,
               processData: false,
               dataType: 'json',
               success: function (data) {
                   var jsonData = eval('(' + data + ')');
                   var html = "";
                   $.each(jsonData.records, function (idx, item) {
                       html += '<tr>'
                       html += '<td>' + item.userName + '</td>'
                       html += '<td>' + item.addAgentName + '</td>'
                       html += '<td>' + item.addMoney + '</td>'
                       html += '<td>' + item.addTime + '</td>'
                       html += '</tr> ';

                   });
                   $("#recharge_record").empty().append(html);
                   $("#recharge").modal();

               },
               error: function () {
                   alert('没有记录!');
               }
           });
       }

       // 投注
       function userbet_c(id) {
           $.ajax({
               type: 'get',
               contentType: 'application/json',
               url: '<%=request.getContextPath()%>/userbet/list?id=' + id,
               processData: false,
               dataType: 'json',
               success: function(data) {
                   var jsonData = eval('('+data+')');
                   var html="";
                   $.each(jsonData.userbets, function(idx, item) {
                       html += '<tr>'
                       html += '<td>'+item.userid+'</td>'
                       html += '<td>'+item.idnum+'</td>'
                       html += '<td>'+item.type+'</td>'
                       html += '<td>'+item.betmoney +'</td>'
                       html += '<td>'+item.mulit +'</td>'
                       html += '<td>'+item.odds +'</td>'
                       html += '<td>'+item.betnum +'</td>'
                       html += '<td>'+item.createdAt +'</td>'
                       html += '</tr> ';
                   });

                   $("#userbet_record").empty().append(html);
                   $("#userbet").modal();
               },
               error: function() {
                   alert('没有记录!');
               }
           });
       }

       //帐变
       var curUserId;
       function moneychange_c(id) {
           curUserId = id;
           $("#account_change_record").empty();
           $("#moneychange").modal();
       }

       function account_change() {
           var startTime = $("#startTime").val();
           var endTime = $("#endTime").val();
           console.log("account_change: startTime ==> " + startTime + ", endTime ==> " + endTime);

           $.ajax({
               url: "account-change/" + curUserId,
               type: "GET",
               data: {
                   startTime: startTime,
                   endTime: endTime
               },
               dataType: "json",
               success: function (result) {
                   console.log("success: result <== ");
                   console.log(result);
                   var html = "";
                   $.each(result.accountChanges, function(i, item) {
                       html += '<tr>'
                       html += '<td>'+item.username+'</td>'
                       html += '<td>'+item.type+'</td>'
                       if(item.type == "充值记录" || item.type == "中奖记录" || item.type == "(赠送)收入") {
                           html += '<td>' + '+' +item.money+'</td>'
                       } else {
                           html += '<td>' + '-' +item.money+'</td>'
                       }
                       html += '<td>'+item.balance+'</td>'
                       html += '<td>'+item.time +'</td>'
                       html += '</tr> ';

                   });
                   $("#account_change_record").empty().append(html);
               },
               error: function (result) {
                   console.log("error: result <== ");
                   console.log(result);
                   alert("服务器异常,请稍后重试!");
               }

           });
       }
       // 赠送记录
       var given_id;
       function given_c(id)  {
           given_id = id;
           $("#given_record").empty();
           $("#given").modal();
       }
       function given_search() {
           var start_time = $("#given_start_time").val();
           var end_time = $("#given_end_time").val();
           if(start_time == "" || end_time == "") {
               return ;
           }
           $.ajax({
               url: "given-money/" + given_id,
               type: "GET",
               data: {
                   startTime: start_time,
                   endTime: end_time
               },
               dataType: "json",
               success: function (result) {
                   console.log("success: result <== ");
                   console.log(result);
                   var html = "";
                   $.each(result, function(i, item) {
                       html += '<tr>'
                       html += '<td>'+given_id+'</td>'

                       if(item.opposingUsername == given_id) {
                           html += '<td>(赠送)收入</td>'
                           html += '<td>' + '+' +item.givenMoney+'</td>'
                           html += '<td>'+item.opposingMoney+'</td>'
                           html += '<td>'+item.currentUsername +'</td>'
                       } else {
                           html += '<td>(赠送)支出</td>'
                           html += '<td>' + '-' +item.givenMoney+'</td>'
                           html += '<td>'+item.currentMoney+'</td>'
                           html += '<td>'+item.opposingUsername +'</td>'
                       }

                       html += '<td>'+item.time +'</td>'
                       html += '</tr> ';

                   });
                   $("#given_record").empty().append(html);
               },
               error: function (result) {
                   console.log("error: result <== ");
                   console.log(result);
                   alert("服务器异常,请稍后重试!");
               }

           });

       }

       // 编辑
       function edit_user_c(id, username, password, tel, isagent) {
           console.log(id + ":" + username);
            $("#ui_id")[0].value = id;
            $("#ui_isagent")[0].value = isagent;
            $("#ui_un")[0].value = username;
            $("#ui_pwd")[0].value = password;
            $("#ui_tel")[0].value = tel;
            $("#userinfo").modal();
       }

       function delete_c(id) {
           $.ajax({
               type: 'delete',
                url:  "<%=request.getContextPath()%>/user/" + id,
               dataType: 'json',
               success: function (data) {
                   console.log(data);
                   alert(data.successMsg);
                   window.location.reload();

               },
               error: function (data) {
                   alert(data.errorMsg);
                   window.location.reload();
               }
           });
       }

       function agent() {
           $("#agent").empty();
           $("#agent").append("<option value='0'>所有代理商</option>");
           $.ajax({
               type: 'get',
               url: '<%=request.getContextPath()%>/isagent/' + 2,
               processData: false,
               dataType: 'json',
               success: function(data) {
                   var html="";
                   $.each(data.agents, function(idx, item) {
                       html += '<option value="'+item.id+'">'+item.username+'</option>';
                   });
                   $("#agent").append(html);

               },
               error: function() {
                   alert('agent: 没有记录!');
               }
           });
       }

       function search_user() {

           var agent_id = $("#agent").val();
           var s_name = $("#search_username").val();
           // console.log("agent:" + isagent + "\ts_name:" + s_name);
           // var owner = $("#nextagent_id").val();
           if (agent_id == "" || agent_id == undefined) {
               alert('请选择代理商');
           } else if (s_name == "") {
               location.href = '<%=request.getContextPath()%>/false/null/agent/' + agent_id;
           } else {
               location.href = '<%=request.getContextPath()%>/false/' + s_name + '/agent/' + agent_id;
           }


       }

    </script>
</body>

</html>
