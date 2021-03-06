package com.gdufs.bookstore.dao;

import com.gdufs.bookstore.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gu on 2018/4/2.
 */
@Repository
@Mapper
public interface UserMapper {

    @Insert(value = "insert into user(username,alias,password,email,tel) values (#{username},#{alias}, #{password}, #{email},#{tel})")
    void add(User user);

    @Select(value = "select * from user where username=#{username}")
    User selectByUname(String username);

    @Select(value = "select * from user where userid=#{userid}")
    User selectByUid(long userid);

    @Select(value = "select * from user where username=#{username} and password=#{password}")
    User selectByUnameAndPwd(@Param("username") String username, @Param("password") String password);

    @Delete(value = "delete from user where userid=#{userid}")
    void deleteByUid(long userid);

    @Update(value = "update user set password=#{password} where userid=#{userid}")
    void changepwd(@Param("userid") long userid, @Param("password") String password);

    @Update(value = "update user set username=#{username} where userid=#{userid}")
    void updateByUid(User user);

    @Select(value = "select * from user")
    List<User> listAll();

}
