package com.jrt.tms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jrt.tms.entity.OrderDetail;
import com.jrt.tms.mapper.OrderDetailMapper;
import com.jrt.tms.service.OrderDetailService;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {

}