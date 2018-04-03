package com.gdufs.bookstore.dao;

import com.gdufs.bookstore.model.Book;
import com.gdufs.bookstore.model.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gu on 2018/4/2.
 */
@Repository
@Mapper
public interface CommentMapper {
    @Select(value = "select * from comment where bookid=#{bookid}")
    List<Comment> selectByBkid(long bookid);

    @Insert(value = "insert into comment(userid,bookid,comments) values (#{userid},#{bookid},#{comments})")
    void add(Comment comment);
}
