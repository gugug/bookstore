package com.gdufs.bookstore.dao;

import com.gdufs.bookstore.model.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by gu on 2018/4/2.
 */
@Repository
@Mapper
public interface ShoppingCartMapper {
    @Select(value = "select bk.*,cart.num from book bk left join shopping_cart cart " +
            "on bk.bookid = cart.bookid where userid=#{userid} and orderState=0")
    Book selectCartByUid(long userid);

    @Delete(value = "delete from shopping_cart where cartid=#{cartid}")
    void deleteByCartid(long cartid);

    @Select(value = "select bk.*,cart.num from book bk left join shopping_cart cart " +
            "on bk.bookid = cart.bookid where userid=#{userid} and orderState=1")
    Book selectOrderByUid(long userid);

    @Select(value = "select bk.*,cart.num from book bk left join shopping_cart cart " +
            "on bk.bookid = cart.bookid where cartid=#{cartid} and orderState=1")
    Book selectCartByCartid(long cartid);

}
