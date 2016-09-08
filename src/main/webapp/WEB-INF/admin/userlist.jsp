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
        <div class="am-u-sm-12 am-u-md-offset-2 am-u-md-2">
            <div class="am-form-group">
                <select data-am-selected="{btnSize: 'sm'}">
                    <option value="option1">所有代理商</option>
                    <option value="option2">代理1号</option>
                    <option value="option2">代理2号</option>
                    <option value="option2">代理3号</option>
                    <option value="option2">代理4号</option>
                    <option value="option2">代理5号</option>
                </select>
            </div>
        </div>
        <div class="am-u-sm-12 am-u-md-3 am-u-end">
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
                        <th class="table-id">用户ID</th>
                        <th class="table-title">姓名</th>
                        <th class="table-type">密码</th>
                        <th class="table-author am-hide-sm-only">金币</th>
                        <th class="table-date am-hide-sm-only">创建时间</th>
                        <th class="table-set">操作</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <input type="checkbox" />
                        </td>
                        <td>1</td>
                        <td><a href="#">张三</a></td>
                        <td>123456</td>
                        <td class="am-hide-sm-only">10000000</td>
                        <td class="am-hide-sm-only">2014年9月4日 7:28:47</td>
                        <td>
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                    <button class="am-btn am-btn-default am-btn-xs am-text-warning" onclick="recharge(1)"><span class="am-icon-pencil-square-o"></span>充值</button>
                                    <button class="am-btn am-btn-default am-btn-xs am-text-warning"><span class="am-icon-pencil-square-o"></span>投注</button>
                                    <button class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span> 编辑</button>
                                    <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> 删除</button>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="checkbox" />
                        </td>
                        <td>1</td>
                        <td><a href="#">张三</a></td>
                        <td>123456</td>
                        <td class="am-hide-sm-only">10000000</td>
                        <td class="am-hide-sm-only">2014年9月4日 7:28:47</td>
                        <td>
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                    <button class="am-btn am-btn-default am-btn-xs am-text-warning"><span class="am-icon-pencil-square-o"></span>充值</button>
                                    <button class="am-btn am-btn-default am-btn-xs am-text-warning"><span class="am-icon-pencil-square-o"></span>投注</button>
                                    <button class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span> 编辑</button>
                                    <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> 删除</button>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="checkbox" />
                        </td>
                        <td>1</td>
                        <td><a href="#">张三</a></td>
                        <td>123456</td>
                        <td class="am-hide-sm-only">10000000</td>
                        <td class="am-hide-sm-only">2014年9月4日 7:28:47</td>
                        <td>
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                    <button class="am-btn am-btn-default am-btn-xs am-text-warning"><span class="am-icon-pencil-square-o"></span>充值</button>
                                    <button class="am-btn am-btn-default am-btn-xs am-text-warning"><span class="am-icon-pencil-square-o"></span>投注</button>
                                    <button class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span> 编辑</button>
                                    <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> 删除</button>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="checkbox" />
                        </td>
                        <td>1</td>
                        <td><a href="#">张三</a></td>
                        <td>123456</td>
                        <td class="am-hide-sm-only">10000000</td>
                        <td class="am-hide-sm-only">2014年9月4日 7:28:47</td>
                        <td>
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                    <button class="am-btn am-btn-default am-btn-xs am-text-warning"><span class="am-icon-pencil-square-o"></span>充值</button>
                                    <button class="am-btn am-btn-default am-btn-xs am-text-warning"><span class="am-icon-pencil-square-o"></span>投注</button>
                                    <button class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span> 编辑</button>
                                    <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> 删除</button>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="checkbox" />
                        </td>
                        <td>1</td>
                        <td><a href="#">张三</a></td>
                        <td>123456</td>
                        <td class="am-hide-sm-only">10000000</td>
                        <td class="am-hide-sm-only">2014年9月4日 7:28:47</td>
                        <td>
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                    <button class="am-btn am-btn-default am-btn-xs am-text-warning"><span class="am-icon-pencil-square-o"></span>充值</button>
                                    <button class="am-btn am-btn-default am-btn-xs am-text-warning"><span class="am-icon-pencil-square-o"></span>投注</button>
                                    <button class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span> 编辑</button>
                                    <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> 删除</button>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="checkbox" />
                        </td>
                        <td>1</td>
                        <td><a href="#">张三</a></td>
                        <td>123456</td>
                        <td class="am-hide-sm-only">10000000</td>
                        <td class="am-hide-sm-only">2014年9月4日 7:28:47</td>
                        <td>
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                    <button class="am-btn am-btn-default am-btn-xs am-text-warning"><span class="am-icon-pencil-square-o"></span>充值</button>
                                    <button class="am-btn am-btn-default am-btn-xs am-text-warning"><span class="am-icon-pencil-square-o"></span>投注</button>
                                    <button class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span> 编辑</button>
                                    <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> 删除</button>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="checkbox" />
                        </td>
                        <td>1</td>
                        <td><a href="#">张三</a></td>
                        <td>123456</td>
                        <td class="am-hide-sm-only">10000000</td>
                        <td class="am-hide-sm-only">2014年9月4日 7:28:47</td>
                        <td>
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                    <button class="am-btn am-btn-default am-btn-xs am-text-warning"><span class="am-icon-pencil-square-o"></span>充值</button>
                                    <button class="am-btn am-btn-default am-btn-xs am-text-warning"><span class="am-icon-pencil-square-o"></span>投注</button>
                                    <button class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span> 编辑</button>
                                    <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> 删除</button>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="checkbox" />
                        </td>
                        <td>1</td>
                        <td><a href="#">张三</a></td>
                        <td>123456</td>
                        <td class="am-hide-sm-only">10000000</td>
                        <td class="am-hide-sm-only">2014年9月4日 7:28:47</td>
                        <td>
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                    <button class="am-btn am-btn-default am-btn-xs am-text-warning"><span class="am-icon-pencil-square-o"></span>充值</button>
                                    <button class="am-btn am-btn-default am-btn-xs am-text-warning"><span class="am-icon-pencil-square-o"></span>投注</button>
                                    <button class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span> 编辑</button>
                                    <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> 删除</button>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="checkbox" />
                        </td>
                        <td>1</td>
                        <td><a href="#">张三</a></td>
                        <td>123456</td>
                        <td class="am-hide-sm-only">10000000</td>
                        <td class="am-hide-sm-only">2014年9月4日 7:28:47</td>
                        <td>
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                    <button class="am-btn am-btn-default am-btn-xs am-text-warning"><span class="am-icon-pencil-square-o"></span>充值</button>
                                    <button class="am-btn am-btn-default am-btn-xs am-text-warning"><span class="am-icon-pencil-square-o"></span>投注</button>
                                    <button class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span> 编辑</button>
                                    <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> 删除</button>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="checkbox" />
                        </td>
                        <td>1</td>
                        <td><a href="#">张三</a></td>
                        <td>123456</td>
                        <td class="am-hide-sm-only">10000000</td>
                        <td class="am-hide-sm-only">2014年9月4日 7:28:47</td>
                        <td>
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                    <button class="am-btn am-btn-default am-btn-xs am-text-warning"><span class="am-icon-pencil-square-o"></span>充值</button>
                                    <button class="am-btn am-btn-default am-btn-xs am-text-warning"><span class="am-icon-pencil-square-o"></span>投注</button>
                                    <button class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span> 编辑</button>
                                    <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> 删除</button>
                                </div>
                            </div>
                        </td>
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
    <div class="am-modal am-modal-alert" tabindex="-1" id="recharge">
        <div class="am-modal-dialog">
            <div class="am-modal-hd">充值记录</div>
            <div class="am-modal-bd">
                <table class="am-table am-table-striped am-table-hover table-main">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>类型</th>
                            <th>充值金额</th>
                            <th>充值时间</th>
                        </tr>
                    </thead>
                    <tbody>
                      <tr>
                      <td>123456</td>
                      <td>在线充值</td>
                      <td>100</td>
                      <td>2016/9/6 7:22:22</td>
                      </tr>
                      <tr>
                      <td>123456</td>
                      <td>在线充值</td>
                      <td>100</td>
                      <td>2016/9/6 7:22:22</td>
                      </tr>
                      <tr>
                      <td>123456</td>
                      <td>在线充值</td>
                      <td>100</td>
                      <td>2016/9/6 7:22:22</td>
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
    <script type="text/javascript">
       function recharge(id) {
            $("#recharge").modal();
       }
    </script>
</body>

</html>
