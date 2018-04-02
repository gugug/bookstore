package com.gdufs.bookstore.dao;

import com.gdufs.bookstore.model.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gu on 2018/4/2.
 */
@Repository
@Mapper
public interface BookMapper {

    @Insert(value = "insert into book(bookname,category,country,author,pic,sale,price,introduce) " +
            "values (#{bookname}, #{category}, #{country},#{author},#{pic},#{sale},#{price},#{introduce})")
    void add(Book book);

    @Select(value = "select * from book where bookname like #{str} or author like #{str}")
    Book selectByBknameOrAuthor(String str);

    @Select(value = "select * from book")
    List<Book> listAll();

    @Delete(value = "delete from book where bookid=#{bookid}")
    void deletebyBkid(long bookid);

    @Update(value = "update book set bookname=#{bookname},category=#{category},country=#{country}," +
            "author=#{author},pic=#{pic},price=#{price}, introduce=#{introduce} where userid=#{userid}")
    void updateByBkid(Book book);

}
