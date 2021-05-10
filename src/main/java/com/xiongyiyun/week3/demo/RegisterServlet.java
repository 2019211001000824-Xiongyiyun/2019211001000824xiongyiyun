package com.xiongyiyun.week3.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

//automatic -new --> servlet
@WebServlet(
        urlPatterns = {"/register"},loadOnStartup = 1
)
public class RegisterServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException{
        super.init();
//        ServletContext context=getServletContext();
//        String driver=context.getInitParameter("driver");
//        String url=context.getInitParameter("url");
//        String username=context.getInitParameter("username");
//        String password=context.getInitParameter("password");
//
//        try{
//            Class.forName(driver);
//            con = DriverManager.getConnection(url, username,password);
//            System.out.println("init()--> "+ con );
//        } catch (ClassNotFoundException | SQLException e){
//            e.printStackTrace();
//        }
        con= (Connection) getServletContext().getAttribute("con");

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);
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

        try {
            Statement st=con.createStatement();
            String sql="insert into usertable(username,password,email,sex,date)"+
                    "values('"+username+"','"+password+"','"+email+"','"+gander+"','"+date+"‘)";
            System.out.println("sql"+sql);
            int n =st.executeUpdate(sql);
            System.out.println("n-->"+n);
            sql="select username,password,email,sex,date from usertable";
            ResultSet rs=st.executeQuery(sql);
            //PrintWriter out=response.getWriter();
            //here is html code---move these html code in a jap page - userList.jsp
            //out.println("<html><title></title><body><table border=1><tr>");
            //out.println("<td>Username</td><td><password></td><td><email></td><td><sex></td><td><date></td><tr/>");
            /*while (rs.next()){
                out.println("<tr>");
                out.println("<td>"+rs.getString("username")+"</td>");
                out.println("<td>"+rs.getString("password")+"</td>");
                out.println("<td>"+rs.getString("email")+"</td>");
                out.println("<td>"+rs.getString("sex")+"</td>");
                out.println("<td>"+rs.getString("date")+"</td>");

                out.println("</tr>");
            }*/
            //out.println("</table></body><ml>");
            //request.setAttribute("name",rs);

            //.getRequestDispatcher("userList.jsp").forward(request,response);
            //at this point request given to user userList.jsp
            //url not change
            //no more here
            //System.out.println("i am in RegisterServlet-->doPost()--> after forward()");// see this line
        response.sendRedirect("login.jsp");
        }catch (SQLException e){
            e.printStackTrace();
        }
        //print - writer into response
        PrintWriter writer1 = response.getWriter();
        writer.println("<br>username :"+username);
        writer.println("<br>password :"+password);
        writer.println("<br>email :"+email);
        writer.println("<br>sex"+gander);
        writer.println("<br>date"+date);
        writer.close();
    }
}
