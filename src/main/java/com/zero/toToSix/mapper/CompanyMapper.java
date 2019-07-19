package com.zero.toToSix.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zero.toToSix.model.Company;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface CompanyMapper extends BaseMapper<Company> {

    @Select("select * from company where id != #{id}")
    List<Company> testCompanySql(@Param("id") Integer id);

    @Select("select * from company where id = #{id}")
    Company getById(@Param("id") Integer id);

}