package br.com.servlet.java.javaservelet;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.String.format;

@WebServlet(urlPatterns = "/login")
public class BookStoreLoginController extends HttpServlet {
    private final UserService userService = new UserService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        PrintWriter writer = resp.getWriter();
        writer.println("<html><body><h1>Bookstore::Login");
        try {
            if(userService.authenticateUserByUsernameAndPassword(username, password)){
               writer.println(format("<h3>Welcome, %s!", username).concat("</h3>"));
                Cookie cookie = new Cookie("logged.user", username);
                resp.addCookie(cookie);

            } else{
                writer.println(format("<h3>Username %s not found!", username).concat("</h3>"));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            writer.println("</body></html>");
        }
    }
}
