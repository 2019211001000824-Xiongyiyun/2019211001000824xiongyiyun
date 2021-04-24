package com.xiongyiyun.week5;

import com.xiongyiyun.dao.UserDao;
import com.xiongyiyun.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    public Connection dbConn=null;
    @Override
    public void init() throws ServletException{
//        try {
//            Class.forName(getServletConfig().getServletContext().getInitParameter("driver"));
//            dbConn= DriverManager.getConnection(getServletConfig().getServletContext().getInitParameter("url"),getServletConfig().getServletContext().getInitParameter("Username"),getServletConfig().getServletContext().getInitParameter("Password"));
//            System.out.println(dbConn);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
            dbConn=(Connection)getServletContext().getAttribute("con");
        }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        UserDao userDao=new UserDao();
        try {
            User user=userDao.findByUsernamePassword(dbConn,username,password);
            if(user!=null) {
                req.setAttribute("user",user);
                req.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(req,resp);
            }
            else {
                req.setAttribute("message","username or Password Error!!!");
                req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req,resp);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
//        PrintWriter writer = response.getWriter();
//        writer.println("<br>username :"+username);
//        writer.println("<br>password :"+password);
    }
}
