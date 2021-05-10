package com.xiongyiyun.week5;

import com.xiongyiyun.dao.UserDao;
import com.xiongyiyun.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {
    public Connection dbConn=null;
    @Override
    public void init() throws ServletException {
        super.init();
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
                if(req.getParameter("rememberMe")!=null&&req.getParameter("rememberMe").equals("1")) {
                    Cookie usernameCookie=new Cookie("cUsername",user.getUsername().trim());
                    Cookie passwordCookie=new Cookie("cPassword",user.getPassword().trim());
                    Cookie rememberMeCookie=new Cookie("rememberMeVal",req.getParameter("rememberMe").trim());
                    usernameCookie.setMaxAge(60*60*24*50);
                    passwordCookie.setMaxAge(60*60*24*50);
                    rememberMeCookie.setMaxAge(60*60*24*50);
                    System.out.println(usernameCookie.getValue());
                    resp.addCookie(usernameCookie);
                    resp.addCookie(passwordCookie);
                    resp.addCookie(rememberMeCookie);
                }
                HttpSession session=req.getSession();
                System.out.println(session.getId());
                session.setMaxInactiveInterval(60*60);
                session.setAttribute("user",user);
                req.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(req,resp);
            }
            else {
                req.setAttribute("message","username or Password Error!!!");
                req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req,resp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}