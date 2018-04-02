package com.gdufs.bookstore.model;

import lombok.Data;

/**
 * Created by gu on 2018/4/2.
 */
@Data
public class Book {

    private long bookid;
    private String bookname;
    private String category;
    private String country;
    private String author;
    private String pic;
    private Integer sale;
    private String price;
    private String introduce;

}
