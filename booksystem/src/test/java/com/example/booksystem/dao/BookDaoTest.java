package com.example.booksystem.dao;

import com.example.booksystem.BaseTest;
import com.example.booksystem.entity.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BookDaoTest extends BaseTest {

    @Autowired
    private BookDao bookDao;

    @Test
    public void testQueryById() {
        long bookId = 1000;
        Book book = bookDao.queryById(bookId);
        assertEquals("book1", book.getName());
    }

    @Test
    public void testQueryAll() {
        List<Book> bookList = bookDao.queryAll(0, 10);
        assertEquals(4, bookList.size());
    }
}
