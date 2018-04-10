package com.gdufs.bookstore.model;

import lombok.Data;

/**
 * Created by gu on 2018/4/2.
 */
@Data
public class ShoppingCart {
    private long cartid;
    private long userid;
    private long bookid;
    private int num;
    private int shippingState;
}
