package com.example.booksystem.service.impl;

import com.example.booksystem.dao.BookDao;
import com.example.booksystem.entity.Book;
import com.example.booksystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Book getById(long bookId) {
        return bookDao.queryById(bookId);
    }

    @Override
    public List<Book> getBookList() {
        return bookDao.queryAll(0, Integer.MAX_VALUE);
    }
}
