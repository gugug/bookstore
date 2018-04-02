package com.gdufs.bookstore.service.impl;

import com.gdufs.bookstore.dao.OrderMapper;
import com.gdufs.bookstore.model.Book;
import com.gdufs.bookstore.service.OrderService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gu on 2018/4/2.
 */
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderMapper orderMapper;

    @Override
    public List<Book> selectOrderByUid(long userid) {
        return orderMapper.selectOrderByUid(userid);
    }

    @Override
    public List<Book> selectOrderByOid(long oid) {
        return orderMapper.selectOrderByOid(oid);
    }
}
