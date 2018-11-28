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
        output{
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
    <script type="text/javascript">

        <%--弹出窗口，避免一次点多个浪费红包--%>
        function msg(){
            alert("已刷新！")
        }
        //防止F5无限刷新表单
        document.addEventListener("keydown", function (e) {
            if(e.keyCode==116) {
                e.preventDefault();
                //要做的其他事情
                alert("别再按F5了啊我心慌，答应我好嘛！")
            }
        }, false);
    </script>
</head>

<body>

<span id="span">
    <%
        if (request.getAttribute("remain")==null){
            out.print("好像是redirect出错了，应该…………不能用了吧");
        }
        Integer a = (Integer)request.getAttribute("remain");
        if (a == -1){
            response.sendRedirect("/eleme/NoMore.jsp");
        }

//        if("-1".equals(request.getAttribute("remain"))){
//            response.sendRedirect("/eleme/NoMore.jsp");
//        }
    %>
    <%--循环，循环的是从request中获取的getLink，就是那个List，然后我们只显示一个，脑残的begin0end0了，实现就好--%>
    <form action="ReturnLink" method="post">
    <c:forEach var="E" items="${getLink}" begin="0" end="0">

        <%--获取link也就是红包，float left是为了防止两个input之间有空隙--%>
        <%--2018/10/25修改，更改为点击跳转链接--%>
        <a href="${E.link}">
        <input id="a" type="text" value="随机最大点击拥有（目前仅支持饿了么品质，通用及美团私聊）" name="link" style="color: red" style="float: left;" disabled="disabled">
            </a>
        <%--submit就直接更新form了，先弹出一个弹窗再更新链接--%>
        <input id="b" type="submit" value="获取新红包" style="color: white" onclick="msg()">
        <input id="c" type="text" value="余量：${remain}" style="color: gray" disabled="disabled">

    </c:forEach>
        </form>
</span>
</body>
</html>
