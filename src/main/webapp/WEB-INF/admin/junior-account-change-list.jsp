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
    <title>帐变记录列表</title>
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

<body>
<div class="am-cf am-padding am-padding-bottom-0">
    <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">代理商功能/帐变记录</strong> </div>
</div>
<hr>
<div class="am-g">
    <%--<c:choose>
        <c:when test="${startTime == null or endTime == null}">
            <c:set var="st" value="2013-09-09"/>
            <c:set var="et" value="2013-09-09"/>
        </c:when>
        <c:otherwise>
            <c:set var="st" value="${startTime}"/>
            <c:set var="et" value="${endTime}"/>
        </c:otherwise>
    </c:choose>--%>
    <div class="am-u-md-4">
        <input type="text" id="ag_start_time" value="${startTime}"
               class="am-form-field" placeholder="开始时间" data-am-datepicker readonly required />
    </div>
    <div class="am-u-md-4">
        <input type="text" id="ag_end_time" value="${endTime}"
               class="am-form-field" placeholder="结束时间" data-am-datepicker readonly required />
    </div>
    <div class="am-u-md-4"><button class="am-btn am-btn-primary" onclick="ag_search()">搜索</button></div>

</div>
<div class="am-g">
    <div class="am-u-sm-12">
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
            <tbody id="users">
            <c:choose>
                <c:when test="${requestScope.accountChanges == null}">
                    <script>
                        alert("无帐变记录信息可显示!");

                    </script>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${accountChanges}" var="item" varStatus="vs">
                        <tr>
                            <td>${item.username}</td>
                            <td>${item.type}</td>

                           <%-- <c:if test="${item.type eq '充值记录'}">
                                <td> +${item.money}</td>
                            </c:if>--%>

                            <c:choose>
                                <c:when test="${item.type eq '充值记录' or '中奖记录' or '(赠送)收入'}">
                                    <td class="money"> +${item.money}</td>
                                </c:when>
                                <c:otherwise>
                                    <td class="money"> -${item.money}</td>
                                </c:otherwise>
                            </c:choose>
                            <td>${item.balance}</td>
                            <td class="am-hide-sm-only">
                                <f:formatDate value="${item.time}" pattern="yyyy-MM-dd HH:mm:ss"/>
                            </td>
                        </tr>

                    </c:forEach>
                </c:otherwise>
            </c:choose>
            </tbody>
        </table>

        <div>
            <div class="am-al">共 ${page.total} 条记录 <span id="totle"></span></div>
            <div class="tcdPageCode">

                <script>
                    var s_time = $("#ag_start_time").val();
                    var e_time = $("#ag_end_time").val();
                    console.log("分页: s_time ==> " + s_time + "\te_time ==> "+ e_time);

                    $(".tcdPageCode").createPage({
                        pageCount:${page.pages},
                        current:${pn},
                        // 单击回调方法，p是当前页码
                        backFn:function(p){
                            if (s_time > e_time) {
                                alert('请选择正确的时间区间');
                            } else if (s_time == "" && e_time == ""){
                                location.href = "${pageContext.request.contextPath}/account-change/junior/"
                                        +"null/null?curAgentId=${sessionScope.userinfo.id}&pn=" + p;
                            } else if (s_time != "" && e_time == "" || s_time == "" && e_time != "") {
                                alert('请选择正确的时间区间');
                            } else {
                                location.href = "${pageContext.request.contextPath}/account-change/junior/"
                                        + s_time +"/"+ e_time + "?curAgentId=${sessionScope.userinfo.id}&pn=" + p;
                            }


                        }
                    });

                </script>

            </div>
        </div>
    </div>
</div>
<!-- content end -->

<footer class="admin-content-footer">
    <hr>
    <p class="am-padding-left">© 中远方舟科技有限公司版权所有</p>
</footer>

<script type="text/javascript">
    function ag_search() {
        var s_time = $("#ag_start_time").val();
        var e_time = $("#ag_end_time").val();
        console.log("ag_search : s_time ==> " + s_time + "\te_time ==> "+ e_time);
        if (s_time > e_time) {
            alert('请选择正确的时间区间');
        } else if (s_time == "" && e_time == ""){
            window.location.reload();
        } else if (s_time != "" && e_time == "" || s_time == "" && e_time != "") {
            alert('请选择正确的时间区间');
        } else {
            location.href = '<%=request.getContextPath()%>/account-change/junior/'
                    + s_time +'/'+ e_time + "?curAgentId=${sessionScope.userinfo.id}&pn=1";
        }
    }
    window.onload = totle();
    function totle() {
        var totle = 0;
        $(".money").each(function () {

            var x = parseInt($(this).text());

            totle += x;

        });
        $("#totle").text("该页帐变总金额:"+totle);
    }
</script>
</body>

</html>
