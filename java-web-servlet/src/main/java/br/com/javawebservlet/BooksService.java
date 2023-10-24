package br.com.javawebservlet;

import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.util.Set;

public class BooksService {
    private BooksDAO dao = new BooksDAO();
    public Book findBookByTitle(String title) throws NotFound {
        return dao.findOne(title);
    }

    public Set<Book> findAllBooks(){
        return dao.findAll();
    }

    public void addBook(Book book) {
        dao.addBook(book);
    }
}

