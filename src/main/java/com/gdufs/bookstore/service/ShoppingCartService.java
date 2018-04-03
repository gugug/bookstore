package com.gdufs.bookstore.service;

import com.gdufs.bookstore.model.Book;
import com.gdufs.bookstore.model.ShoppingCart;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gu on 2018/4/2.
 */
@Repository
public interface ShoppingCartService {

    /**
     * 11.获取用户对应的购物车列表
     *
     * @param userid
     * @return
     */
    List<Book> selectCartByUid(long userid);

    /**
     * 12.删除用户的购物车某项
     *
     * @param cartid
     */
    void deleteByCartid(long cartid);

    /**
     * 18.添加购物车
     *
     * @param shoppingCart
     */
    void addtoCart(ShoppingCart shoppingCart);

    /**
     * 19.修改购物车数目
     * @param shoppingCart
     */
    void addnum(ShoppingCart shoppingCart);


}
