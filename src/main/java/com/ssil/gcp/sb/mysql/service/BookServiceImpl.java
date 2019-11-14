package com.ssil.gcp.sb.mysql.service;

import com.ssil.gcp.sb.mysql.exception.ResourceNotFoundExcetion;
import com.ssil.gcp.sb.mysql.model.Book;
import com.ssil.gcp.sb.mysql.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository repository;

    public Book getBook(Integer id) throws ResourceNotFoundExcetion {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExcetion("Book not found"));
    }

    public List<Book> getBooks() {
        return repository.findAll();
    }

    public void saveBook(Book book) {
        repository.save(book);
    }

    public void updateBook(Book book) {
        repository.save(book);
    }

    public void deleteBook(Book book) {
        repository.delete(book);
    }

}
