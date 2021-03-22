package xiongyiyun.week3.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

//automatic -new --> servlet
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");//<input type="text" name="username"><br/>
        String password = request.getParameter("password");//<input type="password" name="password" required minlength="8">
        String email = request.getParameter("email");//<input type="email" name="email">
        String gander = request.getParameter("gander");//<input type="radio" name="gander" value="male">
        String date = request.getParameter("date");//<input type="date" name="date" placeholder="Date of Birt(yyyy-mm-dd)">

        PrintWriter writer = response.getWriter();
        writer.println("<br>username :"+username);
        writer.println("<br>password :"+password);
        writer.println("<br>email :"+email);
        writer.println("<br>gander :"+gander);
        writer.println("<br>date :"+date);
        writer.close();


    }
}
