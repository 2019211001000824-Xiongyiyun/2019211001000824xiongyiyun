<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 2021/4/12
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User List</h1>
<table border=1>
    <tr>
        <<td>Username</td><td>password</td><td>Email</td><td>Gender</td><td>Birthday</td>
    </tr>
    <%
        ResultSet rs = (ResultSet) request.getAttribute("rsname");
        if(rs==null){
    %>
    <tr>
        <td>No Data!!!</td>
    </tr>
    <%}else {
        while (rs.next()) {
            out.println("<tr>");
            out.println("<td>" + rs.getString("username") + "</td>");
            out.println("<td>" + rs.getString("password") + "</td>");
            out.println("<td>" + rs.getString("email") + "</td>");
            out.println("<td>" + rs.getString("sex") + "</td>");
            out.println("<td>" + rs.getString("date") + "</td>");
            out.println("</tr>");
        }
    }
            %>

</table>
<%@include file="footer.jsp"%>