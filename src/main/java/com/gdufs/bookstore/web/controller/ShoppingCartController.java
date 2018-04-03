package com.gdufs.bookstore.web.controller;

import com.gdufs.bookstore.model.Book;
import com.gdufs.bookstore.service.ShoppingCartService;
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
@RequestMapping("cart")
public class ShoppingCartController {
    private static final Logger LOG = LoggerFactory.getLogger(ShoppingCartController.class);
    @Autowired
    ShoppingCartService shoppingCartService;

    @RequestMapping(value = "list", method = RequestMethod.POST)
    public Map<String, Object> list(long userid) {
        Map<String, Object> result = new HashMap<>();
        try {
            List<Book> books = shoppingCartService.selectCartByUid(userid);
            result.put("state", 200);
            result.put("data", books);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            result.put("state", 500);
        }
        return result;
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public Map<String, Object> delete(long cartid) {
        Map<String, Object> result = new HashMap<>();
        try {
            shoppingCartService.deleteByCartid(cartid);
            result.put("state", 200);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            result.put("state", 500);
        }
        return result;
    }
}
