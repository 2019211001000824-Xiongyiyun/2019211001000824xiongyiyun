package com.xiongyiyun.controller;

import com.xiongyiyun.dao.Userdao;
import com.xiongyiyun.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UpdateUserServlet", value = "/UpdateUser")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("in");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String mail=request.getParameter("email");
        String sex=request.getParameter("sex");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birth= null;
        try {
            System.out.println(request.getParameter("birth").trim());

            birth = simpleDateFormat.parse(request.getParameter("birth").trim());
        } catch (ParseException e) {
            System.out.println(e);
        }
        String id=request.getParameter("id");
        User u=new User(Integer.valueOf(id),username,password,mail,sex,birth);
        Userdao userDao=new Userdao();
        try {
            userDao.updateUser((Connection)getServletContext().getAttribute("con"),u);
        } catch (SQLException e) {
            System.out.println(e);
        }
        System.out.println(birth);
        request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }
}
