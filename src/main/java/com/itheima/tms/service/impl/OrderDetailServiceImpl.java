package com.itheima.tms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.tms.entity.OrderDetail;
import com.itheima.tms.mapper.OrderDetailMapper;
import com.itheima.tms.service.OrderDetailService;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {

}