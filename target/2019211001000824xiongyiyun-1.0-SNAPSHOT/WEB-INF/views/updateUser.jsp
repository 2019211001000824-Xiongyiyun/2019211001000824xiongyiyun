<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 2021/4/24
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Update</h1>
<%
    User u=(User) session.getAttribute("user");

%>
<form method="post" action="updateUser">
    <input type="hidden" name="id" value="<%=u.getId()%>">
    Username:<input type="text" name="username" value="<%=u.getUsername()%>"> <br/>
    Password:<input type="password" name="password" value="<%=u.getPassword()%>" required minlength="8"><br/>
    email:<input type="email" name="email" value="<%=u.getEmail()%>"><br/>
    Gender:<input type="radio" name="gander" value="male" <%="male".equals(u.getGender())?"checked" :""%>>Male
    <input type="radio" name="gender" value="female" <%="male".equals(u.getGender())?"checked" :""%>>Female<br/>
    Date:<input type="date" name="date" placeholder="Date of Birt(yyyy-mm-dd)"value="<%=u.getBirth()%>"><br/>
    <input type="submit" value="Save Changes">
</form>
<%@include file="footer.jsp"%>
