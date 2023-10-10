package br.com.servlet.java.javaservelet;

import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BooksDAO {
    private Set<Book> books = new HashSet<>();

    public Book findOne(String title) throws NotFound {

        return books.stream().filter(book -> book.getTitle().toUpperCase().equals(title.toUpperCase()))
                .collect(Collectors.toList())
                .get(0);

    }

    public Set<Book> findAll() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }
}
