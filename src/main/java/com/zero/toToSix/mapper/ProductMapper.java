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

    List<Product> testXml(@Param("productArea") String productArea,@Param("price") Integer price);

    //这种是错的
    //@Select("select * from product where id in #{idList}")
    //ist<Product> testSqlList(@Param("idList") List<String> idList);

    List<Product> testXmlList(@Param("idList") List<Integer> idList);

    //不管是这种@Select的方式，还是写进xml的语句那种方式，都必须重启才会生效
    //可以只查出几个字段，只要这几个字段名字对得上
    @Select("select id,name from product where id = 5")
    List<Product> testReload();
}