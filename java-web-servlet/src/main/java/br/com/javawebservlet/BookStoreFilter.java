package br.com.javawebservlet;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static java.lang.String.format;

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
        Object user = request.getSession().getAttribute("logged.user");

        System.out.println(format("URI ::: [%s]",request.getRequestURI()));
        System.out.println(format("Being accessed by the user: [%s]", user));

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
    }
}
