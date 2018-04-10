package com.gdufs.bookstore.web.controller;

import com.gdufs.bookstore.model.Order;
import com.gdufs.bookstore.model.OrdersCustom;
import com.gdufs.bookstore.model.ShoppingCart;
import com.gdufs.bookstore.service.OrderService;
import com.gdufs.bookstore.service.ShoppingCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
    @Autowired
    ShoppingCartService shoppingCartService;

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

    @Transactional
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Map<String, Object> add(ShoppingCart shoppingCart) {
        Map<String, Object> result = new HashMap<>();
        try {
            orderService.add(shoppingCart);
            shoppingCartService.deleteByCartid(shoppingCart.getCartid());
            result.put("state", 200);
            LOG.info("{} cartid order successful", shoppingCart.getCartid());
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            result.put("state", 500);
        }
        return result;
    }

    @RequestMapping(value = "updateState", method = RequestMethod.POST)
    public Map<String, Object> updateState(Order order) {
        Map<String, Object> result = new HashMap<>();
        try {
            orderService.updateState(order);
            result.put("state", 200);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            result.put("state", 500);
        }
        return result;
    }

    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    public Map<String, Object> listAll() {
        Map<String, Object> result = new HashMap<>();
        try {
            List<OrdersCustom> ordersCustoms = orderService.listAll();
            result.put("state", 200);
            result.put("data", ordersCustoms);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            result.put("state", 500);
        }
        return result;
    }
}
