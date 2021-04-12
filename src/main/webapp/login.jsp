<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<h1>login</h1>
<%
    if(!(request.getAttribute("message")==null)) {
        out.println(request.getAttribute("massage"));
    }
%>
<form method="post" action="/login">
    username:<input type="text" id="username"> <br>
    password:<input type="password" id="password"><br>
    <input type="submit" value="login">
</form>

<%@include file="footer.jsp"%>