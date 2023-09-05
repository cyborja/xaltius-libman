package com.example.libman.controller;

import com.example.libman.model.Book;
import com.example.libman.service.BookManageService;
import com.example.libman.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookManageService bookManageService;

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book savedBook = bookService.createBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Book>> getBookById(@PathVariable Integer id) {
        Optional<Book> book = bookService.getBookById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Optional<Book>> updateBookById(@PathVariable Integer id, @RequestBody Book book) {
        Optional<Book> updateBook = bookService.updateBookById(id, book);
        return new ResponseEntity<>(updateBook, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Optional<Book>> deleteBookById(@PathVariable Integer id) {
        Optional<Book> updateBook = bookService.deleteBookById(id);
        return new ResponseEntity<>(updateBook, HttpStatus.OK);
    }

    @PostMapping(path = "/{bookId}/borrow/{userId}")
    public ResponseEntity<Optional<Book>> borrowBook(@PathVariable Integer bookId, @PathVariable Integer userId) {
        Optional<Book> updateBook = bookManageService.borrowBook(bookId, userId);
        return new ResponseEntity<>(updateBook, HttpStatus.OK);
    }

    @PostMapping(path = "/{bookId}/return")
    public ResponseEntity<Optional<Book>> returnBook(@PathVariable Integer bookId) {
        Optional<Book> updateBook = bookManageService.returnBook(bookId);
        return new ResponseEntity<>(updateBook, HttpStatus.OK);
    }
}
