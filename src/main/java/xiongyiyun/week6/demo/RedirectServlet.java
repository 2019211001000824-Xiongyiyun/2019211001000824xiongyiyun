package xiongyiyun.week6.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RedirectServlet", value = "/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("bedore redirect ");
    //response.sendRedirect("index.jsp");
    System.out.println("after redirect");
    response.sendRedirect("/2019211001000824xiongyiyun_war/index.jsp");
    ///2019211001000824xiongyiyun_war

        response.sendRedirect("http://www.baidu.com/");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }
}
