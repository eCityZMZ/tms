package com.itheima.tms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.tms.entity.ShoppingCart;
import com.itheima.tms.mapper.ShoppingCartMapper;
import com.itheima.tms.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {

}
