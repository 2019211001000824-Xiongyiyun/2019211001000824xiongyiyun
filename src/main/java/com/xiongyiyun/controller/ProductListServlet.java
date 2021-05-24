package com.xiongyiyun.controller;

import com.xiongyiyun.dao.ProductDao;
import com.xiongyiyun.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "ProductListServlet",value = "/admin/productList")
public class ProductListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            ProductDao productDao=new ProductDao();
            List<Product> productList=productDao.findAll((Connection)getServletContext().getAttribute("con"));
            System.out.println(productList);
            request.setAttribute("productList",productList);
        }catch (Exception e) {
            System.out.println(e);
        }
        String path="/WEB-INF/views/admin/productList.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }
}