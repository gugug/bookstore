package com.gdufs.bookstore.service.impl;

import com.gdufs.bookstore.dao.OrderMapper;
import com.gdufs.bookstore.model.Order;
import com.gdufs.bookstore.model.OrdersCustom;
import com.gdufs.bookstore.model.ShoppingCart;
import com.gdufs.bookstore.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gu on 2018/4/2.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderMapper orderMapper;

    @Override
    public List<OrdersCustom> selectOrdersByUid(long userid) {
        return orderMapper.selectOrdersByUid(userid);
    }

    @Override
    public List<OrdersCustom> selectOrderByOid(long orderid) {
        return orderMapper.selectOrderByOid(orderid);
    }

    @Override
    public void add(ShoppingCart shoppingCart) {
        orderMapper.add(shoppingCart);
    }

    @Override
    public void updateState(Order order) {
        orderMapper.updateState(order);
    }

    @Override
    public List<OrdersCustom> listAll() {
        return orderMapper.listAll();
    }

}
