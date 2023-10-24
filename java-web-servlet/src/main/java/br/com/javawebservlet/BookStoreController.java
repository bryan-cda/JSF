package br.com.javawebservlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

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
    public static final String SUCCESS_ADD_NEW_BOOK_PAGE = "/WEB-INF/add_new_book_success.jsp";
    BooksService service = new BooksService();
    private static final String HTML_LI = "<li>";
    private static final String HTML_END_LI = "</li>";
    private static final String HTML_BREAK_LINE = "<br>";

    private BookStoreLoginService bookStoreLoginService = new BookStoreLoginService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Book book = new Book(req.getParameter(FILTER_PARAMETER));

        service.addBook(book);

        req.setAttribute("book", book.getTitle());

        RequestDispatcher dispatcher = req.getRequestDispatcher(SUCCESS_ADD_NEW_BOOK_PAGE);

        dispatcher.forward(req, resp);

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        String index = "'/bookstore'";

        String filter = req.getParameter("title");


        if(isNull(filter) || filter.isEmpty()){
            Set<Book> books = service.findAllBooks();
            req.setAttribute("books", books);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/list_books.jsp");
            dispatcher.forward(req,resp);

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
