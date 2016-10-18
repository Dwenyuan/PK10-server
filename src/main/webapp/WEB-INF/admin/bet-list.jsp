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
    <title>投注记录列表</title>
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
<c:if test="${requestScope.errorMsg != null}">
    <script>
        alert(${errorMsg});

    </script>
</c:if>
<div class="am-cf am-padding am-padding-bottom-0">
    <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">用户管理/投注记录</strong> </div>
</div>
<hr>
<div class="am-g">
    <div class="am-u-sm-12 am-u-md-3 am-u-md-offset-1 am-u-end">
        <div class="am-input-group am-input-group-sm">
            <input type="text" class="am-form-field" id="start_search_bet" value="" placeholder="这里输入起始期数"
                   onkeyup="(this.v=function(){
                       this.value=this.value.replace(/[^0-9-]+/,'');
                   }).call(this)" onblur="this.v();">
            <input type="text" class="am-form-field" id="end_search_bet" value="" placeholder="这里输入终止期数"
                   onkeyup="(this.v=function(){
                       this.value=this.value.replace(/[^0-9-]+/,'');
                   }).call(this)" onblur="this.v();">
            <span class="am-input-group-btn">
            <button class="am-btn am-btn-default" type="button" onclick="search_bet()">搜索</button>
          </span>
        </div>
    </div>
</div>
<div class="am-g">
    <div class="am-u-sm-12">
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
                <%--<th>是否兑奖</th>--%>
                <th>投注时间</th>
            </tr>
            </thead>
            <tbody id="users">
            <c:choose>
                <c:when test="${requestScope.bets == null}">
                    <script>
                        alert("无投注记录信息可显示!");

                    </script>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${bets}" var="bet" varStatus="vs">
                        <tr>
                            <td>${bet.userid}</td>
                            <td>${bet.idnum}</td>
                            <td>${bet.type.name}</td>
                            <td class="momey">${bet.betmoney}</td>
                            <td>${bet.mulit}</td>

                            <td>${bet.odds}</td>
                            <c:choose>
                                <c:when test="${bet.betnum == 'double'}">
                                    <td>双</td>
                                </c:when>
                                <c:when test="${bet.betnum == 'single'}">
                                    <td>单</td>
                                </c:when>
                                <c:when test="${bet.betnum == 'small'}">
                                    <td>小</td>
                                </c:when>
                                <c:when test="${bet.betnum == 'big'}">
                                    <td>大</td>
                                </c:when>
                                <c:otherwise>
                                    <td>${bet.betnum}</td>
                                </c:otherwise>
                            </c:choose>

                            <%--<c:choose>
                                <c:when test="${bet.state} == 0">
                                    <td>未兑奖</td>
                                </c:when>
                                <c:otherwise>
                                    <th>已兑奖</th>
                                </c:otherwise>
                            </c:choose>--%>


                            <td class="am-hide-sm-only">
                                <f:formatDate value="${bet.createdAt}" pattern="yyyy-MM-dd HH:mm:ss"/>
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
                    $(".tcdPageCode").createPage({
                        pageCount:${page.pages},
                        current:${pn},
                        backFn:function(p){

                            var s_idnum = '${startIdnum}';
                            var e_idnum = '${endIdnum}';
                            if (s_idnum == "" || s_idnum == undefined || e_idnum == "" || e_idnum == undefined) {
                                s_idnum = 0;
                                e_idnum = 0;
                            }

                            location.href = '<%=request.getContextPath()%>/userbet/' + s_idnum +'/'+ e_idnum +
                                    "?pn=" + p;

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
    function search_bet() {

        var s_idnum = $("#start_search_bet").val();
        var e_idnum = $("#end_search_bet").val();
        console.log("s_idnum ==> " + s_idnum + "\te_idnum ==> "+ e_idnum);
        if (s_idnum > e_idnum) {
            alert('请输入正确的开奖期数区间');
        } else if (s_idnum == "" && e_idnum == ""){
            window.location.reload();
        } else if (s_idnum != "" && e_idnum == "" || s_idnum == "" && e_idnum != "") {
            alert('请输入正确的开奖期数区间');
        } else {
            location.href = '<%=request.getContextPath()%>/userbet/' + s_idnum +'/'+ e_idnum + "?pn=1";
        }
    }
    window.onload = totle();
    function totle() {
        var totle = 0;

        $(".momey").each(function () {
            var x = parseInt($(this).text());
           totle += x;

        });
        $("#totle").text("该页下注总金额:"+totle);


        $("#start_search_bet").val(${startIdnum});
        $("#end_search_bet").val(${endIdnum});
    }
</script>
</body>

</html>
