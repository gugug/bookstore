package com.gdufs.bookstore.service.impl;

import com.gdufs.bookstore.dao.UserMapper;
import com.gdufs.bookstore.model.User;
import com.gdufs.bookstore.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gu on 2018/4/2.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        return userMapper.selectByUnameAndPwd(username, password);
    }

    @Override
    public Boolean validName(String username) {
        User user = userMapper.selectByUname(username);
        return user == null;
    }

    @Override
    public void register(User user) {
        userMapper.add(user);
    }

    @Override
    public List<User> listAll() {
        return userMapper.listAll();
    }

    @Override
    public User selectByUname(String username) {
        return userMapper.selectByUname(username);
    }

    @Override
    public User selectByUid(long userid) {
        return userMapper.selectByUid(userid);
    }
}
