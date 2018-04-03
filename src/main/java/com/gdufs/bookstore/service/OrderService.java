package com.gdufs.bookstore.service;

import com.gdufs.bookstore.model.OrdersCustom;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gu on 2018/4/2.
 */
@Repository
public interface OrderService {
    /**
     * 13.获取用户对应的订单列表
     *
     * @param userid
     * @return
     */
    List<OrdersCustom> selectOrdersByUid(long userid);

    /**
     * 16.根据订单号获取订单
     *
     * @param orderid
     * @return
     */
    List<OrdersCustom> selectOrderByOid(long orderid);
}
