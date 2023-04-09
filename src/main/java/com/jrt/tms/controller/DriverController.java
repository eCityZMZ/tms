package com.jrt.tms.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jrt.tms.common.R;
import com.jrt.tms.entity.Driver;
import com.jrt.tms.service.DriverService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDateTime;

/**
 * 驾驶员管理
 */
@Slf4j
@RestController
@RequestMapping("/driver")
@CrossOrigin //允许跨域请求
public class DriverController {
    @Autowired
    private DriverService driverService;

    /**
     * 新增驾驶员
     * @param driver
     * @return
     */
    @PostMapping
    public R<String> save(HttpServletRequest request,@RequestBody Driver driver){
        log.info("新增驾驶员，驾驶员信息：{}",driver.toString());

        driver.setCreateTime(LocalDateTime.now());
        driver.setUpdateTime(LocalDateTime.now());

        // 填加创建者和修改者
        long empID=(Long) request.getSession().getAttribute("employee");
        driver.setCreateUser(empID);
        driver.setUpdateUser(empID);

        driverService.save(driver);

        return R.success("新增驾驶员成功");


    }

    /**
     * 驾驶员信息分页查询
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int page,int pageSize,String name,String phone,String idNumber,String vehicleId){
        log.info("driver/page ={},pageSize={},name={}",page,pageSize,name);


        //构造分页构造器
        Page pageInfo=new Page(page,pageSize);

        //构造条件构造器

        LambdaQueryWrapper<Driver> queryWrapper=new LambdaQueryWrapper();
        //添加一个过滤条件
        queryWrapper.like(StringUtils.isNotEmpty(name), Driver::getName,name);
        queryWrapper.like(StringUtils.isNotEmpty(phone), Driver::getPhone,phone);
        queryWrapper.like(StringUtils.isNotEmpty(idNumber), Driver::getIdNumber,idNumber);
        queryWrapper.like(StringUtils.isNotEmpty(vehicleId), Driver::getVehicleId,vehicleId);

        // 添加排序条件 更新时间
        queryWrapper.orderByDesc(Driver::getUpdateTime);

        //执行查询
        driverService.page(pageInfo,queryWrapper);

        return R.success(pageInfo);
    }

    @PutMapping
    public R<String> update(HttpServletRequest request,@RequestBody Driver driver){
        log.info("修改驾驶员信息:"+driver.toString());

//        Long empId =(Long) request.getSession().getAttribute("employee");
        driver.setUpdateTime(LocalDateTime.now());
//        driver.setUpdateUser(empId);
        driverService.updateById(driver);

        return R.success("驾驶员信息修改成功");
    }

    /**
     * 根据ID查询驾驶员
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R<Driver> getById(@PathVariable Long id){
        log.info("根据id查询员工信息...");
        Driver driver =driverService.getById(id);
        if(driver!=null) {
            return R.success(driver);
        }
        return R.error("没有查询到对应驾驶员信息");

    }

    @GetMapping("/reportExport/prodTest")
    public Object prodTest(HttpServletResponse response, String excelTitle) throws IOException {
        // 创建导出文件名称 当前日期+前台传递过来的标题名（excelTitle）
        String fileName = excelTitle+".xls";
        // 设置返回的消息头和返回值类型 并设置编码 不设置编码文件名为中文的话 不会显示
        // 当设置成如下返回值时，浏览器才会执行下载文件动作
        response.setHeader("Content-disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));
        response.setContentType("APPLICATION/OCTET-STREAM;charset=UTF-8");
        // 创建输出流，调用service中exportTest方法，参数：输出流 标题名
        driverService.exportTest(response.getOutputStream(), excelTitle);
        return null;
    }

}
