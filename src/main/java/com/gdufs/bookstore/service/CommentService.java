package com.gdufs.bookstore.service;

import com.gdufs.bookstore.model.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gu on 2018/4/2.
 */
@Repository
public interface CommentService {

    /**
     * 7.获取书对应的评论
     *
     * @param bookid
     * @return
     */
    List<Comment> selectByBkid(long bookid);

    /**
     * 17.在订单内书本进行评论
     */
    void add(Comment comment);
}
