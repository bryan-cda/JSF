package br.com.servlet.java.javaservelet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "bookStore", urlPatterns = "/list")
public class BookStoreController extends HttpServlet {

    private static final String HTML_LI = "<li>";
    private static final String HTML_END_LI = "</li>";
    private static final String HTML_BREAK_LINE = "<br>";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<body>");

        for (String book : findAllBooks()){
            writer.println(HTML_LI.concat(book).concat(HTML_END_LI).concat(HTML_BREAK_LINE));
        }

        writer.println("</body>");
        writer.println("</html>");
    }

    public static List<String> findAllBooks(){
        List<String> books = new ArrayList<>();
        books.add("Em busca de Sentido");
        books.add("O príncipe");
        books.add("O pequeno príncipe");
        books.add("Sherlock Holmes");
        books.add("Assim disse Zaratustra");
        books.add("O morro dos ventos uivantes");
        books.add("12 Regras para vida");
        books.add("Pai rico, pai pobre");
        books.add("Franz Kafka");
        books.add("Assalto em Bagdá");
        return books;
    }
}
