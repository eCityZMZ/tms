package com.jrt.tms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jrt.tms.entity.AddressBook;
import com.jrt.tms.mapper.AddressBookMapper;
import com.jrt.tms.service.AddressBookService;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {

}
