package br.com.servlet.java.javaservelet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static java.util.Objects.isNull;

@WebServlet(name = "bookStore", urlPatterns = "/store")
public class BookStoreController extends HttpServlet {

    public static final String HTML_TAG = "<html>";
    public static final String BODY_TAG = "<body>";
    public static final String INDEX_URI = "'/bookstore'";
    public static final String FILTER_PARAMETER = "title";
    public static final String ADD_BOOK_MESSAGE = "book added successfully! <br>";
    public static final String HREF = "<a href=";
    public static final String BACK_HREF = "> back </a>";
    public static final String CLOSE_BODY_TAG = "</body>";
    public static final String CLOSE_HTML_TAG = "</html>";
    BooksService service = new BooksService();
    private static final String HTML_LI = "<li>";
    private static final String HTML_END_LI = "</li>";
    private static final String HTML_BREAK_LINE = "<br>";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println(HTML_TAG);
        writer.println(BODY_TAG);

        String index = INDEX_URI;

        Book book = new Book(req.getParameter(FILTER_PARAMETER));

        service.addBook(book);

        writer.println(ADD_BOOK_MESSAGE);
        writer.println(HREF.concat(index).concat(BACK_HREF));
        writer.println(CLOSE_BODY_TAG);
        writer.println(CLOSE_HTML_TAG);

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        String index = "'/bookstore'";

        String filter = req.getParameter("title");


        if(isNull(filter) || filter.isEmpty()){
            for (Book book : service.findAllBooks()){
                writer.println(HTML_LI.concat(book.getTitle()).concat(HTML_END_LI).concat(HTML_BREAK_LINE));
            }
        } else{
            for (Book book : service.findAllBooks()){
                if(book.getTitle().toUpperCase().contains(filter.toUpperCase())){
                    writer.println(HTML_LI.concat(book.getTitle()).concat(HTML_END_LI).concat(HTML_BREAK_LINE));
                }
            }
        }
        writer.println("<a href=".concat(index).concat("> back </a>"));
        writer.println("</body>");
        writer.println("</html>");
    }
}
