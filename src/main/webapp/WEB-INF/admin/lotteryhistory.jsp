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
                <input id="lotteryId" type="text" class="am-form-field" placeholder="期数">
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
                        <th class="table-id">开奖期数</th>
                        <th class="table-title">开奖时间</th>
                        <th class="table-type">开奖结果</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach varStatus="vs" items="${lhData.rows}" var="lottery">
                        <tr>
                            <td>${lottery.id}</td>
                            <td><a href="#"><fmt:formatDate value="${lottery.createdAt}" pattern="yyyy-MM-dd HH:mm:ss"/></a></td>
                            <td>${lottery.lotterynums}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>


            <div class="am-cf">
                <spen class="total">共${lhData.total}条记录</spen>
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
                        <th>用户名</th>
                        <th>充值时间</th>
                        <th>充值金额</th>

                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td id="td1"></td>
                        <td id="td2"></td>
                        <td id="td3"></td>

                    </tr>
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
       function recharge() {
            $("#recharge").modal();
       }

       function gotoPage(pages) {
           window.location = 'toLotteryHistory?pages='+pages;
       }
       $(function(){

           // var current = $("#currentPage").val();
           // var total = $("#totalPage").val();
           // alert(current +"==" + total);
           $(".tcdPageCode").createPage({
               pageCount: Number(${lhData.totalPage}),
               current: Number(${lhData.currentPage}),
               backFn:function(p){

                   gotoPage(p);
               }
           });

       });

        function searchFor(){

            var lotteryId =Number($("#lotteryId").val());
            $.ajax({
                type: 'POST',
                contentType: 'application/json',
                url: '${pageContext.request.contextPath}/getRecordById',
                processData: false,
                dataType: 'json',
                data : '{"id":\"'+lotteryId+'\"}',
                success: function(data) {
                    var obj = eval('('+data+')');
                    var id = obj.id;
                    var createdAt =obj.createdAt;
                    var mydata = FormatDate(createdAt);
                    var lottery = obj.lotterynums;
                    document.getElementById('td1').innerHTML = "";
                    document.getElementById('td2').innerHTML = "";
                    document.getElementById('td3').innerHTML = "";
                    document.getElementById('td1').innerHTML += id;
                    document.getElementById('td2').innerHTML += mydata;
                    document.getElementById('td3').innerHTML += lottery;
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


    </script>
</body>

</html>
