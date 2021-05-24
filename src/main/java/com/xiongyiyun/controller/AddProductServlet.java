package com.xiongyiyun.controller;

import com.xiongyiyun.dao.ProductDao;
import com.xiongyiyun.model.Category;
import com.xiongyiyun.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/admin/addProduct")
@MultipartConfig(maxFileSize = 16177215)
public class AddProductServlet extends HttpServlet {
    private Connection con=null;
    private static final Logger log=Logger.getLogger(String.valueOf(AddProductServlet.class));
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        con=(Connection)getServletContext().getAttribute("con");
        String productName=request.getParameter("productName");
        Double price=request.getParameter("price")!=null?Double.parseDouble(request.getParameter("price")):0.0;
        int categoryId=request.getParameter("categoryId")!=null?Integer.parseInt(request.getParameter("categoryId")):0;
        String productDescription =request.getParameter("productDescription");
        InputStream inputStream=null;
        Part filePart =request.getPart("picture");
        if(filePart!=null) {
            System.out.println(filePart.getName()+"size:"+filePart.getSize());
            inputStream=filePart.getInputStream();
        }
        Product product=new Product();
        product.setProductName(productName);
        product.setPrice(price);
        product.setProductDescription(productDescription);
        product.setCategoryId(categoryId);
        ProductDao dao= new ProductDao();
        int i=0;
        try{
            i=dao.save(product,inputStream,con);
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category=new Category();
        List<Category> categoryList= null;
        try {
            categoryList = category.findAllCategory(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("categoryList",categoryList);
        String path="/WEB-INF/views/admin/addProduct.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }
}