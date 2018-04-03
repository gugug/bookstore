package com.gdufs.bookstore.web.controller;

import com.gdufs.bookstore.model.Comment;
import com.gdufs.bookstore.service.CommentService;
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
 * Created by gu on 2018/4/3.
 */
@RestController
@RequestMapping("comment")
public class CommentController {

    private static final Logger LOG = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    CommentService commentService;

    @RequestMapping(value = "list", method = RequestMethod.POST)
    public Map<String, Object> list(long bookid) {
        Map<String, Object> result = new HashMap<>();
        try {
            List<Comment> comments = commentService.selectByBkid(bookid);
            result.put("state", 200);
            result.put("data", comments);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            result.put("state", 500);
        }
        return result;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Map<String, Object> add(Comment comment) {
        Map<String, Object> result = new HashMap<>();
        try {
            commentService.add(comment);
            result.put("state", 200);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            result.put("state", 500);
        }
        return result;
    }

}
