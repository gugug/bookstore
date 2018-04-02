package com.gdufs.bookstore.dao;

import com.gdufs.bookstore.model.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gu on 2018/4/2.
 */
@Repository
@Mapper
public interface OrderMapper {

    @Select(value = "select bk.*,cart.num from book bk left join order ord " +
            "on bk.bookid = ord.bookid where userid=#{userid}")
    List<Book> selectOrderByUid(long userid);

    @Select(value = "select bk.*,cart.num from book bk left join order ord " +
            "on bk.bookid = ord.bookid where cartid=#{Oid}")
    List<Book> selectOrderByOid(long Oid);
}
