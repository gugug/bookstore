package com.gdufs.bookstore.web.controller;

import com.gdufs.bookstore.model.ShippingAddress;
import com.gdufs.bookstore.service.ShippingAddressService;
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
@RequestMapping("address")
public class ShippingAddressController {

    private static final Logger LOG = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    ShippingAddressService shippingAddressService;

    @RequestMapping(value = "list", method = RequestMethod.POST)
    public Map<String, Object> list(long userid) {
        Map<String, Object> result = new HashMap<>();
        try {
            List<ShippingAddress> shippingAddresses = shippingAddressService.selectByUid(userid);
            result.put("state", 200);
            result.put("data", shippingAddresses);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            result.put("state", 500);
        }
        return result;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Map<String, Object> add(ShippingAddress shippingAddress) {
        Map<String, Object> result = new HashMap<>();
        try {
            shippingAddressService.add(shippingAddress);
            result.put("state", 200);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            result.put("state", 500);
        }
        return result;
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public Map<String, Object> delete(long addid) {
        Map<String, Object> result = new HashMap<>();
        try {
            shippingAddressService.deletebyAddid(addid);
            result.put("state", 200);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            result.put("state", 500);
        }
        return result;
    }
}
