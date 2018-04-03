package com.gdufs.bookstore.model;

import lombok.Data;

/**
 * Created by gu on 2018/4/2.
 */
@Data
public class Order {
    private long orderid;
    private long userid;
    private long bookid;
    private java.sql.Timestamp ordertime;
    private int shippingState;
    private int num;
}
