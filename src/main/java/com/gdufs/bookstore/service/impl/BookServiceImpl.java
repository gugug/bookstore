package com.gdufs.bookstore.service.impl;

import com.gdufs.bookstore.dao.BookMapper;
import com.gdufs.bookstore.model.Book;
import com.gdufs.bookstore.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gu on 2018/4/2.
 */
@Service
public class BookServiceImpl implements BookService {

    @Resource
    BookMapper bookMapper;

    @Override
    public List<Book> listAll() {
        return bookMapper.listAll();
    }

    @Override
    public List<Book> selectByBknameOrAuthor(String str) {
        str = "%" + str + "%";
        return bookMapper.selectByBknameOrAuthor(str);
    }

    @Override
    public void update(Book book) {
        bookMapper.update(book);
    }

    @Override
    public void add(Book book) {
        bookMapper.add(book);

    }

    @Override
    public void deletebyBkid(long bookid) {
        bookMapper.deletebyBkid(bookid);
    }
}
