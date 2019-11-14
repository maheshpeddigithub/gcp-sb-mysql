package com.ssil.gcp.sb.mysql.service;

import com.ssil.gcp.sb.mysql.exception.ResourceNotFoundExcetion;
import com.ssil.gcp.sb.mysql.model.Book;

import java.util.List;

public interface BookService {

    Book getBook(Integer id) throws ResourceNotFoundExcetion;
    List<Book> getBooks();
    void saveBook(Book book);
    void updateBook(Book book);
    void deleteBook(Book book);

}
