package com.example.demooauth2.service;

import com.example.demooauth2.model.Book;
import com.example.demooauth2.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Create or Update a Book
    public Book saveOrUpdateBook(Book book) {
        return bookRepository.save(book);
    }

    // Fetch all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Fetch a book by ID
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    // Delete a book by ID
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}

