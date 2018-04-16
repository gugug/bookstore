package com.gdufs.bookstore.web.controller;

import com.gdufs.bookstore.model.Book;
import com.gdufs.bookstore.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gu on 2018/4/2.
 */
@RestController
@RequestMapping("book")
public class BookController {

    private static final Logger LOG = LoggerFactory.getLogger(BookController.class);

    @Autowired
    BookService bookService;

    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    public Map<String, Object> listAll() {
        Map<String, Object> result = new HashMap<>();
        try {
            List<Book> books = bookService.listAll();
            result.put("state", 200);
            result.put("data", books);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            result.put("state", 500);
        }
        return result;
    }

    @RequestMapping(value = "seo", method = RequestMethod.GET)
    public Map<String, Object> seo(String str) {
        Map<String, Object> result = new HashMap<>();
        try {
            List<Book> books = bookService.selectByBknameOrAuthor(str);
            result.put("state", 200);
            result.put("data", books);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            result.put("state", 500);
        }
        return result;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Map<String, Object> update(Book book) {
        Map<String, Object> result = new HashMap<>();
        try {
            bookService.update(book);
            result.put("state", 200);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            result.put("state", 500);
        }
        return result;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Map<String, Object> add(Book book) {
        Map<String, Object> result = new HashMap<>();
        try {
            bookService.add(book);
            result.put("state", 200);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            result.put("state", 500);
        }
        return result;
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public Map<String, Object> remove(long bookid) {
        Map<String, Object> result = new HashMap<>();
        try {
            bookService.deletebyBkid(bookid);
            result.put("state", 200);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            result.put("state", 500);
        }
        return result;
    }
}
