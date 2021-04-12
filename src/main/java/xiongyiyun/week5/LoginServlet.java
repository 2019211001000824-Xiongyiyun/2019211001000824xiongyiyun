package xiongyiyun.week5;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException{
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sql="select id,username,password,email,gender,birthdate from usertable where username";
        try {
            ResultSet rs =con.createStatement().executeQuery(sql);
            if (rs.next()){
                request.setAttribute("id",rs.getInt("id"));
                request.setAttribute("username",rs.getString("username"));
                request.setAttribute("password",rs.getString("password"));
                request.setAttribute("email",rs.getString("email"));
                request.setAttribute("gender",rs.getString("gender"));
                request.setAttribute("birthdate",rs.getString("birthdate"));
                request.getRequestDispatcher("userInfo.jsp").forward(request,response);

            }else {
                request.setAttribute("message","Username or Password Error!!");
                request.getRequestDispatcher("login.jsp").forward(request,response);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        PrintWriter writer = response.getWriter();
//        writer.println("<br>username :"+username);
//        writer.println("<br>password :"+password);
    }
}
