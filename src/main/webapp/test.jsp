<%--
  Created by IntelliJ IDEA.
  User: ron
  Date: 16-9-3
  Time: 下午3:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script src="http://code.jquery.com/jquery-1.8.0.min.js"></script>
    <script language="javascript" type="text/javascript">
        function test() {
            var mydata = '{"id":1} ';
            alert(mydata);
            $.ajax({
                type: 'POST',
                contentType: 'application/json',
                url: 'http://localhost:8081/pk10/getUserForAgent',
                processData: false,
                dataType: 'json',
                data: mydata,
                success: function(data) {
                    alert(data);
                },
                error: function() {
                    alert('Err...');
                }
            });
        }
    </script>
    <Button onclick="test()">TEST</Button>
</head>
<body>

</body>
</html>
