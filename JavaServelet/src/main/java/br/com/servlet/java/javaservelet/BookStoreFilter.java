package br.com.servlet.java.javaservelet;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

import static java.lang.String.format;
import static java.util.Objects.nonNull;

@WebFilter(urlPatterns = "/*")
public class BookStoreFilter implements Filter {

    public static final String LOGGED_USER_COOKIE = "logged.user";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        Cookie[] cookies = request.getCookies();

        if(nonNull(request) && nonNull(cookies)){
            String URI = request.getRequestURI();
            for (Cookie cookie : cookies){
                String loggedUser = cookie.getValue();
                if(cookie.getName().equals(LOGGED_USER_COOKIE)){
                    System.out.println(format("URI ::: [%s] ::: LOGGED USER [%s]",URI, loggedUser));
                }
            }
        }

        System.out.println(format("URI ::: [%s]",request.getRequestURI()));

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
    }
}
