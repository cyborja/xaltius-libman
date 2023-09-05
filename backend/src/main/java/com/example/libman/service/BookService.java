package com.example.libman.service;

import com.example.libman.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book createBook(Book book);
    List<Book> getAllBooks();
    Optional<Book> getBookById(Integer id);
    Optional<Book> updateBookById(Integer id, Book book);
    Optional<Book> deleteBookById(Integer id);
}
