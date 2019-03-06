package com.example.booksystem.controller;

import com.example.booksystem.entity.Book;
import com.example.booksystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;


    @RequestMapping(value = "/list")
    private String list(Model model) {
        List<Book> books = bookService.getBookList();
        model.addAttribute("books", books);
        return "list";

    }
    @RequestMapping(value = "/{bookId}/detail", method = RequestMethod.GET)
    private String detail(@PathVariable("bookId") long bookId, Model model) {
        Book book = bookService.getById(bookId);
        model.addAttribute("book", book);
        return "detail";
    }
}
