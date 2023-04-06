package com.jrt.tms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jrt.tms.entity.Category;

public interface CategoryService extends IService<Category> {

    public void remove(Long id);

}
