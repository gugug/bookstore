package com.gdufs.bookstore.web.controller;

import com.gdufs.bookstore.model.OrdersCustom;
import com.gdufs.bookstore.service.OrderService;
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
@RequestMapping("order")
public class OrderController {
    private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "list", method = RequestMethod.POST)
    public Map<String, Object> list(long userid) {
        Map<String, Object> result = new HashMap<>();
        try {
            List<OrdersCustom> books = orderService.selectOrdersByUid(userid);
            result.put("state", 200);
            result.put("data", books);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            result.put("state", 500);
        }
        return result;
    }

    @RequestMapping(value = "info", method = RequestMethod.POST)
    public Map<String, Object> info(long orderid) {
        Map<String, Object> result = new HashMap<>();
        try {
            List<OrdersCustom> books = orderService.selectOrderByOid(orderid);
            result.put("state", 200);
            result.put("data", books);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            result.put("state", 500);
        }
        return result;
    }
}
