<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/15
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>xiaozhankai</title>
    <style type="text/css">
        input{
            padding: 0;
            margin: 0;
            /*居中显示*/
            position: absolute;
            left: 50%;
            top: 35%;
        }
        #a{
            width: 600px;
            height: 40px;
            border: 1px solid dodgerblue;
            transform: translate(-340px,0%);
            /*第一个百分数是左右，第二个是上下,具体的px算就完了*/
            background-color: transparent;
        }
        #b{
            width: 80px;
            height: 40px;
            border: 1px solid dodgerblue;
            transform: translate(260px,0%);
            background-color: dodgerblue;
        }
        #c{
            width: 60px;
            height: 20px;
            border: 0;
            transform: translate(260px,50px);
            background-color: transparent;
        }
    </style>
  <script type="text/javascript" >
        function msg(){
               alert("已重试！")
        }
    </script>
</head>
<body>


<span id="span">

    <%--循环，循环的是从request中获取的getLink，就是那个List，然后我们只显示一个，脑残的begin0end0了，实现就好--%>
    <form action="ReturnLink" method="post">
        <%--获取link也就是红包，float left是为了防止两个input之间有空隙--%>
        <a href="index.jsp">
        <input id="a" type="text" value="没有红包了请联系管理员更新，点击跳回主页" style="color: red" name="link" style="float: left;" disabled="disabled">
            </a>
        <%--submit就直接更新form了，先弹出一个弹窗再更新链接--%>
        <input id="b" type="submit" value="重试" style="color: white" onclick="msg()">
        <input id="c" type="text" value="余量：0" style="color: gray" disabled="disabled">
    </form>




</span>
</body>
</html>
