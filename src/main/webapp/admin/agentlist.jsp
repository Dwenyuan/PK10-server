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
                <input type="text" class="am-form-field">
                <span class="am-input-group-btn">
            <button class="am-btn am-btn-default" type="button">搜索</button>
          </span>
            </div>
        </div>
    </div>
    <div class="am-g">
        <div class="am-u-sm-12">
            <table class="am-table am-table-striped am-table-hover table-main">
                <thead>
                    <tr>
                        <th class="table-check">
                            <input type="checkbox" />
                        </th>
                        <th class="table-id">代理商ID</th>
                        <th class="table-title">昵称</th>
                        <th class="table-type">密码</th>
                        <th class="table-date am-hide-sm-only">创建时间</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <input type="checkbox" />
                        </td>
                        <td>1dsadas</td>
                        <td><a href="#">张三</a></td>
                        <td>123456</td>

                        <td class="am-hide-sm-only">2014年9月4日 7:28:47</td>
                        
                    </tr>
                     <tr>
                        <td>
                            <input type="checkbox" />
                        </td>
                        <td>1</td>
                        <td><a href="#">张三</a></td>
                        <td>123456</td>

                        <td class="am-hide-sm-only">2014年9月4日 7:28:47</td>
                        
                    </tr>
                     <tr>
                        <td>
                            <input type="checkbox" />
                        </td>
                        <td>1</td>
                        <td><a href="#">张三</a></td>
                        <td>123456</td>

                        <td class="am-hide-sm-only">2014年9月4日 7:28:47</td>
                        
                    </tr>
                     <tr>
                        <td>
                            <input type="checkbox" />
                        </td>
                        <td>1</td>
                        <td><a href="#">张三</a></td>
                        <td>123456</td>

                        <td class="am-hide-sm-only">2014年9月4日 7:28:47</td>
                        
                    </tr>
                     <tr>
                        <td>
                            <input type="checkbox" />
                        </td>
                        <td>1</td>
                        <td><a href="#">张三</a></td>
                        <td>123456</td>

                        <td class="am-hide-sm-only">2014年9月4日 7:28:47</td>
                        
                    </tr>
                     <tr>
                        <td>
                            <input type="checkbox" />
                        </td>
                        <td>1</td>
                        <td><a href="#">张三</a></td>
                        <td>123456</td>

                        <td class="am-hide-sm-only">2014年9月4日 7:28:47</td>
                        
                    </tr>
                     <tr>
                        <td>
                            <input type="checkbox" />
                        </td>
                        <td>1</td>
                        <td><a href="#">张三</a></td>
                        <td>123456</td>

                        <td class="am-hide-sm-only">2014年9月4日 7:28:47</td>
                        
                    </tr>
                </tbody>
            </table>
            <div class="am-cf">
                共 10 条记录
                <div class="am-fr">
                    <ul class="am-pagination">
                        <li class="am-disabled"><a href="#">«</a></li>
                        <li class="am-active"><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li><a href="#">»</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    </div>
    <!-- content end -->
   
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
       function recharge(id) {
            $("#recharge").modal();
       }
    </script>
</body>

</html>
