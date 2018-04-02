package com.gdufs.bookstore.service;

import com.gdufs.bookstore.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gu on 2018/4/2.
 */
@Repository
public interface UserService {

    /**
     * 1.用户登录验证帐号密码
     *
     * @param userid
     * @param password
     * @return
     */
    Boolean login(long userid, String password);

    /**
     * 2.用户注册验证用户名是否存在
     *
     * @param username
     * @return
     */
    Boolean validName(String username);

    /**
     * 3.注册用户
     *
     * @param user
     * @return
     */
    void register(User user);

    /**
     * 14.获取用户所有的信息
     *
     * @return
     */
    List<User> listAll();

    /**
     * 15.根据用户名获取用户
     *
     * @param username
     * @return
     */
    User selectByUname(String username);

}
