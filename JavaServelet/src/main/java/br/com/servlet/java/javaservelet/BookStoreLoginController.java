package br.com.servlet.java.javaservelet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.String.format;

@WebServlet(urlPatterns = "/login")
public class BookStoreLoginController extends HttpServlet {
    private static final String INDEX_URI = "'/bookstore'";
    private static final int MAX_AGE = 10 * 60;
    private static final String WELCOME_MESSAGE = "<h3>Welcome, %s!";
    private static final String HTML_H3_CLOSE_TAG = "</h3>";
    private static final String LOGGED_USER = "logged.user";
    private static final String USERNAME_PARAM = "username";
    private static final String PASSWORD_PARAM = "password";
    private static final String HTML_BODY_H_1_BOOKSTORE_LOGIN_TAG = "<html><body><h1>Bookstore::Login";
    private static final String CLOSE_BODY_AND_HTML_TAG = "</body></html>";
    private static final String HREF_TAG = "<a href=";
    private static final String CLOSE_HREF_TAG = "> back </a>";
    public static final String USERNAME_NOT_FOUND_MESSAGE = "<h3>Username %s not found!";
    private final UserService userService = new UserService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter(USERNAME_PARAM);
        String password = req.getParameter(PASSWORD_PARAM);

        PrintWriter writer = resp.getWriter();

        writer.println(HTML_BODY_H_1_BOOKSTORE_LOGIN_TAG);

        try {
            if(userService.authenticateUserByUsernameAndPassword(username, password)){
                User user = userService.findByUsername(username);
                HttpSession session = req.getSession();
                session.setMaxInactiveInterval(MAX_AGE);
                session.setAttribute(LOGGED_USER, user.toString());
                writer.println(format(WELCOME_MESSAGE, username).concat(HTML_H3_CLOSE_TAG));
            } else{
                writer.println(format(USERNAME_NOT_FOUND_MESSAGE, username).concat(HTML_H3_CLOSE_TAG));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            writer.println(CLOSE_BODY_AND_HTML_TAG);
        }
        writer.println(HREF_TAG.concat(INDEX_URI).concat(CLOSE_HREF_TAG));
    }
}
