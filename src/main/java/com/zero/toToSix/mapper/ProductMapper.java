package com.zero.toToSix.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import com.zero.toToSix.model.Product;

import java.util.List;
import java.util.Map;

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

    //可以只查出几个字段，只要这几个字段名字对得上
    @Select("select id,name from product where id = 5")
    List<Product> testReload();

    //如果不想给建一个实体类，可以用Map去代替
    @Select("select * from product")
    List<Map> testMap();

    //联表查询
    @Select("select p.*,c.name as company_name from product p left join company c on p.company_id = c.id order by id asc")
    List<Map> testJoinTable();

    //有判断条件的sql的写法，和写在xml里的语法类似，不过个人还是喜欢写在Mapper里，不需要切来切去，缺点是没有语法高亮
    @Select({
            "<script>",
                "select * from product where id in ",
                "<foreach collection='idList' item='id' open='(' separator=',' close=')'>",
                    "#{id}",
                "</foreach>",
            "</script>"
    })
    List<Product> testScript(@Param("idList") List<String> idList);

}