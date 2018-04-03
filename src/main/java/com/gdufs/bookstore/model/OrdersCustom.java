package com.gdufs.bookstore.model;

import lombok.Data;

/**
 * Created by gu on 2018/4/3.
 */
@Data
public class OrdersCustom extends Order {
    private String bookname;
    private String category;
    private String country;
    private String author;
    private String pic;
    private Integer sale;
    private String price;
    private String introduce;

}

