package com.xiongyiyun.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//import java.net.http.HttpRequest;

@WebFilter("/*")
public class FrontEndAuthenticationFilter implements Filter {

    private HttpServletRequest httpRequest;
    private  static final  String[] loginRequiredURLs={"/updateUser","/logout","/myCart"};
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        httpRequest=(HttpServletRequest)req;
        String path=httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
        if(path.startsWith("/admin/")) {
            chain.doFilter(req,resp);
            return;
        }
        HttpSession session=httpRequest.getSession(false);
        boolean isLoggedIn=(session != null && session.getAttribute("userList") != null);
        String loginURI = httpRequest.getContextPath()+"/login";
        boolean isLoginRequest =httpRequest.getRequestURI().equals(loginURI);
        boolean isLoginPage=httpRequest.getRequestURI().endsWith("login");
        if(isLoggedIn&&(isLoginRequest||isLoginPage)) {
            httpRequest.getRequestDispatcher("/").forward(req,resp);
        }
        else if(!isLoggedIn&&isLoginRequired()) {
            String loginPage="/login";
            RequestDispatcher dispatcher=httpRequest.getRequestDispatcher(loginPage);
            dispatcher.forward(req,resp);
        }
        else {
            chain.doFilter(req,resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }
    private  boolean isLoginRequired() {
        String requestURL = httpRequest.getRequestURL().toString();
        for(String loginRequiredURL :loginRequiredURLs) {
            if(requestURL.contains(loginRequiredURL)) {
                return true;
            }
        }
        return false;
    }
}
