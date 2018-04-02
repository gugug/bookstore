package com.gdufs.bookstore.service;

import com.gdufs.bookstore.model.ShippingAddress;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gu on 2018/4/2.
 */
@Repository
public interface ShippingAddressService {

    /**
     * 8.获取用户的收货地址
     *
     * @param userid
     * @return
     */
    List<ShippingAddress> selectByUid(long userid);

    /**
     * 9.增加用户的收货地址
     *
     * @param shippingAddress
     */
    void add(ShippingAddress shippingAddress);

    /**
     * 10.删除用户的收货地址
     *
     * @param addid
     */
    void deletebyAddid(long addid);
}
