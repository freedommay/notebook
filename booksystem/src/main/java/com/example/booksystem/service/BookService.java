package com.example.booksystem.service;

import com.example.booksystem.entity.Book;

import java.util.List;

public interface BookService {
    Book getById(long bookId);

    List<Book> getBookList();
}
