package com.zero.toToSix.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import com.zero.toToSix.model.Product;

import java.util.List;

@Component
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

    @Select("select * from product where product_area = #{productArea}")
    List<Product> testSql(@Param("productArea") String productArea);

    List<Product> testXml(@Param("productArea") String productArea);

}