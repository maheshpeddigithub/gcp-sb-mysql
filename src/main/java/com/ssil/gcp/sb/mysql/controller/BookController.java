package com.ssil.gcp.sb.mysql.controller;

import com.ssil.gcp.sb.mysql.model.Book;
import com.ssil.gcp.sb.mysql.exception.ErrorMessage;
import com.ssil.gcp.sb.mysql.exception.ResourceNotFoundExcetion;
import com.ssil.gcp.sb.mysql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    BookService service;

    @GetMapping()
    public ResponseEntity<List<Book>> getBooks() {
        return new ResponseEntity<List<Book>>(service.getBooks(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> getBook(@PathVariable Integer id) throws ResourceNotFoundExcetion {
        return new ResponseEntity<Book>(service.getBook(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Void> saveBook(@RequestBody Book book) {
        service.saveBook(book);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateBook(@PathVariable Integer id, @RequestBody Book book) throws ResourceNotFoundExcetion {
        Book updatedBook = service.getBook(id);
        updatedBook.setId(book.getId());
        updatedBook.setTitle(book.getTitle());
        service.updateBook(updatedBook);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id) throws ResourceNotFoundExcetion {
        Book deleteBook = service.getBook(id);
        service.deleteBook(deleteBook);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(ResourceNotFoundExcetion.class)
    public ResponseEntity<ErrorMessage> resourceNotFoundExcetionHandler(ResourceNotFoundExcetion ex) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
        errorMessage.setErrorMessage(ex.getMessage());
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.PRECONDITION_FAILED);
    }
}
