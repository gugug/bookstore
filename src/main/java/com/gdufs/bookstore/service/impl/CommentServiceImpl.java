package com.gdufs.bookstore.service.impl;

import com.gdufs.bookstore.dao.CommentMapper;
import com.gdufs.bookstore.model.Comment;
import com.gdufs.bookstore.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gu on 2018/4/2.
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    CommentMapper commentMapper;

    @Override
    public List<Comment> selectByBkid(long bookid) {
        return commentMapper.selectByBkid(bookid);
    }

    @Override
    public void add(Comment comment) {
        commentMapper.add(comment);
    }
}
