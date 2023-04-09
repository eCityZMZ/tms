package com.jrt.tms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jrt.tms.entity.Driver;

import java.io.IOException;
import java.io.OutputStream;

public interface DriverService extends IService <Driver>{
    void exportTest(OutputStream out, String excelTitle) throws IOException;
}
