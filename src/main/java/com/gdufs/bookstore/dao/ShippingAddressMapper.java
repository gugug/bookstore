package com.gdufs.bookstore.dao;

import com.gdufs.bookstore.model.ShippingAddress;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by gu on 2018/4/2.
 */
@Repository
@Mapper
public interface ShippingAddressMapper {
    @Select(value = "select * from shipping_address where userid=#{userid}")
    ShippingAddress selectByUid(long userid);

    @Insert(value = "insert into shipping_address(userid,name,tel,address) " +
            "values (#{userid}, #{name}, #{tel},#{address})")
    void add(ShippingAddress shippingAddress);

    @Delete(value = "delete from shipping_address where addid=#{addid}")
    void deletebyAddid(long addid);

}
