package com.gdufs.bookstore.model;

import lombok.Data;

/**
 * Created by gu on 2018/4/2.
 */
@Data
public class User {

    private long userid;
    private String username;
    private String password;
    private String email;
    private String tel;
}
