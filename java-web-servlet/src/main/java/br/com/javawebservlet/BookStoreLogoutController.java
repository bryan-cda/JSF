package br.com.javawebservlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/logout")
public class BookStoreLogoutController extends HttpServlet {
    public static final String LOGGED_USER = "logged.user";
    public static final String LOGOUT_HTML = "/WEB-INF/logout.html";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute(LOGGED_USER);
        RequestDispatcher dispatcher = req.getRequestDispatcher(LOGOUT_HTML);
        dispatcher.forward(req, resp);
    }
}
