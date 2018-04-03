package com.gdufs.bookstore.web.controller;

import com.gdufs.bookstore.model.User;
import com.gdufs.bookstore.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gu on 2018/4/2.
 */
@RestController
@RequestMapping("user")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Map<String, Object> login(String username, String password) {
        Map<String, Object> result = new HashMap<>();
        try {
            User user = userService.login(username, password);
            if (user != null) {
                LOG.info("username {}, password: {} login successful", username, password);
                result.put("state", 200);
                result.put("data", user);
            } else {
                LOG.info("username {}, password: {} login failed", username, password);
                result.put("state", 404);
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            result.put("state", 500);
        }
        return result;
    }

    @RequestMapping(value = "validName", method = RequestMethod.POST)
    public Map<String, Object> validName(String username) {
        Map<String, Object> result = new HashMap<>();
        try {
            Boolean validName = userService.validName(username);
            if (validName) {
                LOG.info("username {} is valid", username);
                result.put("state", 200);
            } else {
                LOG.info("username {}, password: {} is invalid", username);
                result.put("state", 404);
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            result.put("state", 500);
        }
        return result;
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public Map<String, Object> register(User user) {
        Map<String, Object> result = new HashMap<>();
        try {
            userService.register(user);
            LOG.info("username {} register successful", user);
            result.put("state", 200);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            result.put("state", 500);
        }
        return result;
    }

    @RequestMapping(value = "info", method = RequestMethod.POST)
    public Map<String, Object> info(String username) {
        Map<String, Object> result = new HashMap<>();
        try {
            User user = userService.selectByUname(username);
            result.put("state", 200);
            result.put("data", user);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            result.put("state", 500);
        }
        return result;
    }

    @RequestMapping(value = "listall", method = RequestMethod.POST)
    public Map<String, Object> listall() {
        Map<String, Object> result = new HashMap<>();
        try {
            List<User> users = userService.listAll();
            result.put("state", 200);
            result.put("data", users);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            result.put("state", 500);
        }
        return result;
    }

}
