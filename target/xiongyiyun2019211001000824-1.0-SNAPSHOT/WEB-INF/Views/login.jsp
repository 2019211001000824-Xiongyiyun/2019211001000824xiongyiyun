<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<h1>login</h1>
<%
    if(!(request.getAttribute("message")==null)) {
        out.println(request.getAttribute("massage"));
    }
%>
<%
    Cookie[] allCookies = request.getCookies();
    String username="",password="",rememberMevale="";
    if (allCookies!=null){
        for (Cookie c:allCookies){
            if (c.getName().equals("cUsername")){
                username=c.getValue();
            }
            if (c.getName().equals("cpassword")){
                password=c.getValue();
            }
            if (c.getName().equals("cRememberMe")){
                rememberMevale=c.getValue();
            }

        }
    }
%>
<form method="post" action="login">
    username:<input type="text" id="username" name="username" value="<%=username%>"> <br>
    password:<input type="password" id="password" name="password" value="<%=password%>"><br>
    <input type="checkbox" name="rememberMe" value="1" <%=rememberMevale.equals("1")?"checked":"" %>checked/>RememberMe<br/>
    <input type="submit" value="Submit">
</form>

<%@include file="footer.jsp"%>