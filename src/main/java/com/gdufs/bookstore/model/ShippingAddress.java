package com.gdufs.bookstore.model;

import lombok.Data;

/**
 * Created by gu on 2018/4/2.
 */
@Data
public class ShippingAddress {
    private long addid;
    private long userid;
    private String name;
    private String tel;
    private String address;

}
