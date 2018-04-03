package com.gdufs.bookstore.service.impl;

import com.gdufs.bookstore.dao.ShoppingCartMapper;
import com.gdufs.bookstore.model.Book;
import com.gdufs.bookstore.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gu on 2018/4/2.
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Resource
    ShoppingCartMapper shoppingCartMapper;

    @Override
    public List<Book> selectCartByUid(long userid) {
        return shoppingCartMapper.selectCartByUid(userid);
    }

    @Override
    public void deleteByCartid(long cartid) {
        shoppingCartMapper.deleteByCartid(cartid);
    }

}
