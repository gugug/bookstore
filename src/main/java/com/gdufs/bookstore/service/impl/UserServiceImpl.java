package com.gdufs.bookstore.service.impl;

import com.gdufs.bookstore.dao.UserMapper;
import com.gdufs.bookstore.model.User;
import com.gdufs.bookstore.service.UserService;
import com.gdufs.bookstore.util.aes.AESUtil;
import com.gdufs.bookstore.util.constant.AESConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gu on 2018/4/2.
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        try {
            password = AESUtil.Encrypt(password, AESConstant.cKey);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return userMapper.selectByUnameAndPwd(username, password);
    }

    @Override
    public Boolean validName(String username) {
        User user = userMapper.selectByUname(username);
        return user == null;
    }

    @Override
    public void register(User user) {
        String password = user.getPassword();
        try {
            String enString = AESUtil.Encrypt(password, AESConstant.cKey);
            user.setPassword(enString);
            userMapper.add(user);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
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

    @Override
    public void changepwd(long userid, String password) {
        try {
            password = AESUtil.Encrypt(password, AESConstant.cKey);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        userMapper.changepwd(userid, password);
    }
}
