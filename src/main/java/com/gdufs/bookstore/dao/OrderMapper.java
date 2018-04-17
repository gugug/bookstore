package com.gdufs.bookstore.dao;

import com.gdufs.bookstore.model.Order;
import com.gdufs.bookstore.model.OrdersCustom;
import com.gdufs.bookstore.model.ShoppingCart;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gu on 2018/4/2.
 */
@Repository
@Mapper
public interface OrderMapper {

    @Select(value = " select bk.*,ords.orderid,ords.orderTime,ords.shippingState,ords.num " +
            "from book bk left join orders ords on bk.bookid = ords.bookid where userid=#{userid}")
    List<OrdersCustom> selectOrdersByUid(long userid);

    @Select(value = "select bk.*,ords.orderid,ords.orderTime,ords.shippingState,ords.num " +
            "from book bk left join orders ords on bk.bookid = ords.bookid where orderid=#{orderid}")
    List<OrdersCustom> selectOrderByOid(long orderid);

    @Insert(value = "insert into orders(userid,bookid,num) values (#{userid}, #{bookid}, #{num})")
    void add(ShoppingCart shoppingCart);

    @Update(value = "update orders set shippingState=#{shippingState} where orderid=#{orderid}")
    void updateState(Order order);

    @Select(value = "select bk.*,ords.orderid,ords.orderTime,ords.shippingState,ords.num " +
            "from orders ords left join book bk on bk.bookid = ords.bookid")
    List<OrdersCustom> listAll();
}
