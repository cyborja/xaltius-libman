package com.example.libman.service.impl;

import com.example.libman.model.Book;
import com.example.libman.repository.BookRepository;
import com.example.libman.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Integer id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> updateBookById(Integer id, Book book) {
        Optional<Book> existingBook = bookRepository.findById(id);
        if (existingBook.isPresent()) {
            existingBook.get().setTitle(book.getTitle());
            existingBook.get().setAuthor(book.getAuthor());
            existingBook.get().setBorrowed(book.getBorrowed());
            Book updatedBook = bookRepository.save(existingBook.get());
            return Optional.of(updatedBook);
        }
        return existingBook;
    }

    @Override
    public Optional<Book> deleteBookById(Integer id) {
        Optional<Book> existingBook = bookRepository.findById(id);
        if (existingBook.isPresent()) {
            bookRepository.deleteById(id);
            return existingBook;
        }
        return existingBook;
    }
}
