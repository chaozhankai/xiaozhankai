<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/13
  Time: 19:19
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
            position: absolute;
            left: 50%;
            top: 35%;
        }
        #a{
            width: 600px;
            height: 40px;
            border: 1px solid dodgerblue;
            transform: translate(-340px,0%);
            background-color: transparent;
            /*第一个百分数是左右，第二个是上下*/
        }
        #b{
            width: 80px;
            height: 40px;
            border: 1px solid dodgerblue;
            transform: translate(260px,0%);
            background-color: dodgerblue;
        }
        #c{
            width: 250px;
            height: 20px;
            border: 0;
            /*transform: translate(260px,50px);*/
            transform: translate(200px,50px);
            background-color: transparent;
        }
    </style>
    <script type="text/javascript">
        <%--弹出窗口，避免一次点多个浪费红包--%>
        function yuliang(){
            alert("aaa${remain}")
        }
    </script>
</head>
<body>

<input id="a" type="text"  name="link" style="float: left;" disabled="disabled">
<%--为了保持submit的样式，还能a标签跳转，套起来--%>
<a href="ReturnLink" >
    <input id="b" type="submit" value="获取新红包" style="color: white">
</a>
    <input id="c" type="text" value="逻辑小更新" style="color: gray" disabled="disabled">
<%--<intput id="c" type="text" value="余量：${remain}" style="color: gray" onclick="yuliang()">--%>
    <%--这也是能实现的一种方法，但是没必要再特意搞一个了，样式还不好看--%>
    <%--<a href="usedToOneServlet">更新</a>--%>
</body>
</html>
