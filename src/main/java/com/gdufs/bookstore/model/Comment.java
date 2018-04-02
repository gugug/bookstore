package com.gdufs.bookstore.model;

import lombok.Data;

/**
 * Created by gu on 2018/4/2.
 */
@Data
public class Comment {

    private long userid;
    private long bookid;
    private java.sql.Timestamp ctime;
    private String comments;

}
