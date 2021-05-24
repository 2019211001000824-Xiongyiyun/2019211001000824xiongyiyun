<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 2021/3/14
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>

<%@include file="header.jsp"%>
    <form method="post" action="/register">
        Username:<input type="text" name="username"><br/>
        Password:<input type="password" name="password" required minlength="8"><br/>
        email:<input type="email" name="email"><br/>
        Gender:<input type="radio" name="gander" value="male">Male<input type="radio" name="gender" value="female">Female<br/>
        Date:<input type="date" name="date" placeholder="Date of Birt(yyyy-mm-dd)"><br/>
        <input type="submit" value="register">
    </form>
<%@include file="footer.jsp"%>
