package com.jrt.tms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jrt.tms.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User>{
}
