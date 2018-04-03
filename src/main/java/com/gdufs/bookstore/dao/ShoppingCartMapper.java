package com.gdufs.bookstore.dao;

import com.gdufs.bookstore.model.Book;
import com.gdufs.bookstore.model.ShoppingCart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gu on 2018/4/2.
 */
@Repository
@Mapper
public interface ShoppingCartMapper {
    @Select(value = "select bk.*,cart.cartid,cart.num from book bk left join shopping_cart cart " +
            "on bk.bookid = cart.bookid where userid=#{userid}")
    List<Book> selectCartByUid(long userid);

    @Delete(value = "delete from shopping_cart where cartid=#{cartid}")
    void deleteByCartid(long cartid);

    @Insert(value = "insert into shopping_cart(userid,bookid,num) values (#{userid}, #{bookid}, #{num})")
    void addtoCart(ShoppingCart shoppingCart);

    @Insert(value = "replace into shopping_cart(cartid,userid,bookid,num) values (#{cartid},#{userid}, #{bookid}, #{num})")
    void addnum(ShoppingCart shoppingCart);

}
