<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <title>下级用户列表</title>
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
        alert('${errorMsg}');

    </script>
</c:if>
<div class="am-cf am-padding am-padding-bottom-0">
    <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">代理商功能/下级用户列表</strong> </div>
</div>
<hr>
<div class="am-g">
    <div class="am-u-sm-12 am-u-md-2">
        <div class="am-form-group">
            <select data-am-selected="{btnSize: 'sm'}" id="agent" onchange="agentclick()">
                <option value="option1">所有代理商</option>
            </select>
        </div>
    </div>
    <%--<div class="am-u-sm-12 am-u-md-2 am-u-md-offset-1" >
        <div class="am-form-group">
            <select data-am-selected="{btnSize: 'sm'}" id="nextagent">
                <option value="option1">所有分销商</option>
            </select>
        </div>
    </div>--%>
    <div class="am-u-sm-12 am-u-md-3 am-u-md-offset-1 am-u-end">
        <div class="am-input-group am-input-group-sm">
            <input type="text" class="am-form-field" id="search_username">
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
                            <td><a href="#">${user.nickname}</a></td>
                            <td>${user.username}</td>
                            <td class="am-hide-sm-only">${user.money}</td>
                            <td class="am-hide-sm-only">
                                <f:formatDate value="${user.createdAt}" pattern="yyyy-MM-dd HH:mm:ss"/>
                            </td>
                            <td>
                                <div class="am-btn-toolbar">
                                    <div class="am-btn-group am-btn-group-xs">
                                        <button class="am-btn am-btn-default am-btn-xs am-text-warning" onclick="recharge_c(${user.id})">
                                            <span class="am-icon-pencil-square-o"></span>充值</button>
                                        <button class="am-btn am-btn-default am-btn-xs am-text-warning" onclick="userbet_c(${user.id})">
                                            <span class="am-icon-pencil-square-o"></span>投注</button>
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
                            location.href = "/users?pn=" + p;
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
                    <th>代理商ID</th>
                    <th>代理商用户名</th>
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
                    <th>ID</th>
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

<!-- edit -->
<div class="am-modal am-modal-alert" tabindex="-1" id="userinfo">
    <div class="am-modal-dialog">
        <div class="am-modal-hd">编辑用户信息</div>
        <div class="am-modal-bd">
            <form id="edit_user" method="post" action="/user">
                <input id="ui_id" type="hidden" name="id" value="">
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
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        等级
                    </div>
                    <div class="am-u-sm-8 am-u-md-4 am-u-end">
                        <input id="ui_isa" type="text" name="isagent" value="">
                    </div>
                </div>

                <div class="am-g am-margin-top">
                    <div class="am-u-sm-offset-3 am-u-sm-6 am-u-md-offset-2 am-u-md-4">
                        <button type="submit" class="am-btn am-btn-primary am-btn-xs" >更新</button>
                        <button type="reset" class="am-btn am-btn-primary am-btn-xs">重置</button>
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
                    html += '<td>' + item.addAgentId + '</td>'
                    html += '<td>' + item.addAgentName + '</td>'
                    html += '<td>' + item.addMoney + '</td>'
                    html += '<td>' + item.addTime + '</td>'
                    html += '</tr> ';
                    $("#recharge_record").empty().append(html);
                });
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
                    html += '<td>'+item.id+'</td>'
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

    // 编辑
    function edit_user_c(id, username, password, tel, isagent) {
        console.log(id + ":" + username);
        $("#ui_id")[0].value = id;
        $("#ui_un")[0].value = username;
        $("#ui_pwd")[0].value = password;
        $("#ui_tel")[0].value = tel;
        $("#ui_isa")[0].value = isagent;
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
                    html = '<option value="'+item.id+'" id="agent_id">'+item.username+'</option>';
                    $("#agent").append(html);
                });

            },
            error: function() {
                alert('agent: 没有记录!');
            }
        });
    }

    function agentclick() {



        var id = $("#agent").val();
        if(id== 0) {
            return;
        }
        window.location="<%=request.getContextPath()%>/junior/users/" + id;
        <%--$.ajax({--%>
            <%--type: 'get',--%>
            <%--url: '<%=request.getContextPath()%>/junior/users/' + id,--%>
            <%--processData: false,--%>
            <%--dataType: 'json',--%>
            <%--success: function(data) {--%>
                <%--var html="";--%>
                <%--$("#nextagent").empty();--%>
                <%--$("#nextagent").append("<option value='0'>所有分销商</option>");--%>
                <%--$.each(data.ownersOfAgents, function(idx, item) {--%>
                    <%--html = '<option value="'+item.id+'" id="nextagent_id">'+item.username+'</option>';--%>
                    <%--$("#nextagent").append(html);--%>
                <%--});--%>
            <%--},--%>
            <%--error: function(data) {--%>
                <%--alert('agentclick: 没有记录!');--%>
            <%--}--%>
        <%--});--%>

    }

    function search_user() {
        var isagent = $("#agent_id").val();
        var s_name = $("#search_username").val();
        // console.log("agent:" + isagent + "\ts_name:" + s_name);
        // var owner = $("#nextagent_id").val();
        if (isagent == "") {
            alert('请选择代理商');
        } else if (s_name == "") {
            location.href = '<%=request.getContextPath()%>/null/agent/' + isagent;
        } else {
            location.href = '<%=request.getContextPath()%>/' + s_name + '/agent/' + isagent;
        }
    }

</script>
</body>

</html>

