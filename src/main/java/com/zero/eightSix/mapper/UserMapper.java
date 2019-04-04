package com.zero.eightSix.mapper;

import com.zero.eightSix.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
