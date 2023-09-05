package com.example.libman.service;

import com.example.libman.model.Book;

import java.util.Optional;

public interface BookManageService {
    Optional<Book> borrowBook(Integer bookId, Integer userId);
    Optional<Book> returnBook(Integer bookId);
}
