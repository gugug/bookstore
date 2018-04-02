package com.gdufs.bookstore.service;

import com.gdufs.bookstore.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gu on 2018/4/2.
 */
@Repository
public interface BookService {

    /**
     * 4.获取所有书单
     *
     * @return
     */
    List<Book> listAll();

    /**
     * 5.根据书名或者作者获取书单
     *
     * @param str
     * @return
     */
    List<Book> selectByBknameOrAuthor(String str);

    /**
     * 6.给出书的id 修改书的对应信息
     *
     * @param book
     */
    void update(Book book);

    void add(Book book);

    void deletebyBkid(long bookid);

}
