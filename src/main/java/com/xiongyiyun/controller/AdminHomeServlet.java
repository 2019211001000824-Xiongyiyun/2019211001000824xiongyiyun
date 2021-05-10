package com.xiongyiyun.controller;

import com.xiongyiyun.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;

@WebServlet(name = "AdminHomeServlet",value ="/admin/home" )
public class AdminHomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("1");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("2");
        HttpSession session =request.getSession(false);
        if(session!=null&&session.getAttribute("user")!=null) {
            System.out.println("1");
            User user=(User) session.getAttribute("user");
            System.out.println(user.getUsername());
            if("admin".equals(user.getUsername().trim())) {
                request.getRequestDispatcher("../WEB-INF/views/admin/index.jsp").forward(request,response);
            }
            else {
                session.invalidate();
                request.setAttribute("message","Unauthorizd Access admin module!");
                request.getRequestDispatcher("../WEB-INF/views/login.jsp").forward(request,response);
            }
        }
        else {
            System.out.println("2");
            request.setAttribute("message","Please login as admin!");
            request.getRequestDispatcher("../WEB-INF/views/login.jsp").forward(request,response);
        }
    }
}
