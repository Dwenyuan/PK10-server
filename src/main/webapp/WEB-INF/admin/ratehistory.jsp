<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">开奖管理</strong> </div>
    </div>
    <hr>
    <div class="am-g">
        <div class="am-u-sm-12 ">
            <input type="hidden" id="currentPage" value="${lhData.currentPage}">
            <input type="hidden" id="totalPage" value="${lhData.totalPage}">
        </div>
        <div class="am-u-sm-12 am-u-md-3 am-u-md-offset-4 am-u-end">
            <div class="am-input-group am-input-group-sm">
                <input id="username" type="text" class="am-form-field" placeholder="充值账号">
                <span class="am-input-group-btn" >
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
                        <th class="table-type">用户名</th>
                        <th class="table-type">充值时间</th>
                        <th class="table-type">充值金额</th>
                        <th class="table-type">分销商</th>
                        <th class="table-type">分销商返点金额</th>
                        <th class="table-type">代理商</th>
                        <th class="table-type">代理商返点金额</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach varStatus="vs" items="${rateHistory.rows}" var="rateRecord">
                        <tr>
                            <td>${rateRecord.normaluser}</td>
                            <td><a href="#"><fmt:formatDate value="${rateRecord.creatat}" pattern="yyyy-MM-dd HH:mm:ss"/></a></td>
                            <td>${rateRecord.userAdd}</td>
                            <td>${rateRecord.distributor}</td>
                            <td>${rateRecord.distributorget}</td>
                            <td>${rateRecord.agent}</td>
                            <td>${rateRecord.agentget}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>


            <div class="am-cf">
                <spen class="total">共${rateHistory.total}条记录</spen>
                <div class="am-fr">
                    <div class="tcdPageCode"></div>
                </div>
            </div>

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
                        <th class="table-type">用户名</th>
                        <th class="table-type">充值时间</th>
                        <th class="table-type">充值金额</th>
                        <th class="table-type">分销商</th>
                        <th class="table-type">分销商返点</th>
                        <th class="table-type">代理商</th>
                        <th class="table-type">代理商返点</th>
                    </tr>
                    </thead>
                    <tbody id="tb">

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
    <

    <script src="${pageContext.request.contextPath}/assets/js/jquery.page.js"></script>
    <script type="text/javascript">
       function recharge() {
            $("#recharge").modal();
       }

       function gotoPage(pages) {
           window.location = 'toRateHistory?pages='+pages;
       }
       $(function(){

           // var current = $("#currentPage").val();
           // var total = $("#totalPage").val();
           // alert(current +"==" + total);
           $(".tcdPageCode").createPage({
               pageCount: Number(${rateHistory.totalPage}),
               current: Number(${rateHistory.currentPage}),
               backFn:function(p){

                   gotoPage(p);
               }
           });

       });

        function searchFor(){

            var normaluser =Number($("#username").val());
            $.ajax({
                type: 'POST',
                contentType: 'application/json',
                url: '${pageContext.request.contextPath}/getRateHistoryByUsername',
                processData: false,
                dataType: 'json',
                data : '{"normaluser":\"'+normaluser+'\"}',
                success: function(data) {


                    $("#tb").html("");

                    for(var j=0;j<data.length;j++)
                    {

                       var tString= "<tr>"+
                                            "<td>"+(data[j].normaluser)+"</td>" +
                                            "<td>"+(FormatDate(data[j].creatat))+"</td>" +
                                            "<td>"+(data[j].userAdd)+"</td>" +
                                            "<td>"+(data[j].distributor)+"</td>" +
                                            "<td>"+(data[j].distributorget)+"</td>" +
                                            "<td>"+(data[j].agent)+"</td>" +
                                            "<td>"+(data[j].agentget)+"</td>" +
                                     "</tr>";
                        $("#tb").append(tString);
                    }
                    recharge();

                },
                error: function() {
                    alert('请输入正确用户名');
                }
            });

            function FormatDate (strTime) {
                var date = new Date(strTime);
                return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+"/"+date.getHours()+"时"+date.getMinutes()+"分"+date.getMilliseconds()+"秒";
            }
            //var lotteryId = Number($("#lotteryId").val());
           // window.location = 'getLotteryById?id='+lotteryId;
        }



    </script>
</body>

</html>
