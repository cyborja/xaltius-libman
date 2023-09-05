package com.example.libman.service.impl;

import com.example.libman.model.Book;
import com.example.libman.model.User;
import com.example.libman.repository.BookRepository;
import com.example.libman.repository.UserRepository;
import com.example.libman.service.BookManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookManageServiceImpl implements BookManageService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<Book> borrowBook(Integer bookId, Integer userId) {
        Optional<Book> existingBook = bookRepository.findById(bookId);
        if (existingBook.isPresent()) {
            Optional<User> existingUser = userRepository.findById(userId);
            if (existingUser.isPresent()) {
                existingBook.get().setBorrowedBy(existingUser.get());
                bookRepository.save(existingBook.get());
                return existingBook;
            }
        }
        return existingBook;
    }

    @Override
    public Optional<Book> returnBook(Integer bookId) {
        Optional<Book> existingBook = bookRepository.findById(bookId);
        if (existingBook.isPresent()) {
            existingBook.get().setBorrowedBy(null);
            bookRepository.save(existingBook.get());
            return existingBook;
        }
        return existingBook;
    }
}
