package com.gdufs.bookstore.service.impl;

import com.gdufs.bookstore.dao.ShippingAddressMapper;
import com.gdufs.bookstore.model.ShippingAddress;
import com.gdufs.bookstore.service.ShippingAddressService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gu on 2018/4/2.
 */
@Repository
public class ShippingAddressServiceImpl implements ShippingAddressService {

    @Resource
    ShippingAddressMapper shippingAddressMapper;

    @Override
    public List<ShippingAddress> selectByUid(long userid) {
        return shippingAddressMapper.selectByUid(userid);
    }

    @Override
    public void add(ShippingAddress shippingAddress) {
        shippingAddressMapper.add(shippingAddress);

    }

    @Override
    public void deletebyAddid(long addid) {
        shippingAddressMapper.deletebyAddid(addid);
    }
}
