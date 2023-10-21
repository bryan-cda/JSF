package br.com.servlet.java.javaservelet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@WebServlet(urlPatterns = "/logout")
public class BookStoreLogoutController extends HttpServlet {
    public static final String INDEX_URI = "'/bookstore'";

    public static final String LOGGED_USER = "logged.user";
    public static final String HTML_LOGOUT_MESSAGE = "<h1>logged out user!</h1> <br>";
    public static final String ALREADY_LOGGED_OUT_MESSAGE = "<h1>user is already logged out</h1> <br>";
    public static final int EXPIRY = 0;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

        List<Cookie> cokkieList = Arrays.stream(cookies).sequential().collect(Collectors.toList());

        PrintWriter writer = resp.getWriter();

        writer.println("<html><body>");

        Cookie userLoggedCookie = null;

        for(Cookie cookie : cokkieList){
            if(cookie.getName().equalsIgnoreCase(LOGGED_USER)){
                userLoggedCookie = cookie;
            }
        }

        if (nonNull(userLoggedCookie)){
            userLoggedCookie.setMaxAge(EXPIRY);
            writer.println(HTML_LOGOUT_MESSAGE);
            resp.addCookie(userLoggedCookie);
        }

        writer.println("<a href=".concat(INDEX_URI).concat("> back </a>"));
        writer.println("</body></html>");
    }
}
