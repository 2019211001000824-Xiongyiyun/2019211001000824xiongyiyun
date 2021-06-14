package com.week2;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//now its just a java class
//extend HttpServlet
public class HalloWorldServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        //when client request method is GET - here - inside doGet()
        //we want to send Hello to client
        //we need to write Hello in reponse
        //get writer - java.io
        final PrintWriter writer = response.getWriter();
        writer.println("Hello Client !!!");//that all
        //next we need to tell about this servlet to tomcat - how ? - web.xml


    }
    public void doPost(HttpServletRequest request,HttpServletResponse response){

        //when client request method is Post - here - inside doPost()
    }
}
