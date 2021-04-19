package com.xiongyiyun.week6.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class JDBCServletContextListener implements ServletContextListener{
    public Connection dbConn;
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed).
         You can initialize servlet context related data here.
      */
        System.out.println("inti...");
        try {
            Class.forName(sce.getServletContext().getInitParameter("driver"));
            dbConn= DriverManager.getConnection(sce.getServletContext().getInitParameter("url"),sce.getServletContext().getInitParameter("Username"),sce.getServletContext().getInitParameter("Password"));
            System.out.println(dbConn);
        } catch (Exception e) {
            System.out.println(e);
        }
        sce.getServletContext().setAttribute("con",dbConn);
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context
         (the Web application) is undeployed or
         Application Server shuts down.
      */
        sce.getServletContext().removeAttribute("con");
    }

}

