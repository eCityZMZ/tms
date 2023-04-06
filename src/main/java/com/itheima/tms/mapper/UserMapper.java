package com.itheima.tms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.tms.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User>{
}
