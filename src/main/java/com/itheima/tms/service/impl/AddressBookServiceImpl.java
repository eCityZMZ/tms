package com.itheima.tms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.tms.entity.AddressBook;
import com.itheima.tms.mapper.AddressBookMapper;
import com.itheima.tms.service.AddressBookService;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {

}
