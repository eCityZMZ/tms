package com.itheima.tms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.tms.entity.Employee;
import com.itheima.tms.mapper.EmployeeMapper;
import com.itheima.tms.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper,Employee> implements EmployeeService{
}
