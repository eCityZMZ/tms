package com.jrt.tms.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jrt.tms.common.R;
import com.jrt.tms.entity.Department;
import com.jrt.tms.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * 新增部门
     *
     * @param department
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @PostMapping
    public R<String> save(@RequestBody Department department) {
        log.info("新增部门，部门信息：{}", department.toString());

        departmentService.save(department);

        return R.success("新增部门成功");
    }

    /**
     * 部门信息分页查询
     *
     * @param page
     * @param pageSize
     * @param deptName
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, String deptName) {
        log.info("page = {},pageSize = {},name = {}", page, pageSize, deptName);

        //构造分页构造器
        Page<Department> pageInfo = new Page(page, pageSize);

        //构造条件构造器
        LambdaQueryWrapper<Department> lqw = new LambdaQueryWrapper();

        //添加过滤条件
        lqw.like(StringUtils.isNotEmpty(deptName), Department::getDeptName, deptName)
                .orderByDesc(Department::getUpdateTime)
                .eq(Department::getIsDeleted, 0);

        //执行查询
        departmentService.page(pageInfo, lqw);

        return R.success(pageInfo);
    }

    /**
     * 根据id修改部门信息
     *
     * @param department
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @PutMapping
    public R<String> update(@RequestBody Department department) {
        log.info(department.toString());

        long id = Thread.currentThread().getId();
        log.info("线程id为：{}", id);

        departmentService.updateById(department);

        return R.success("部门信息修改成功");
    }

    /**
     * 根据id查询部门信息
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R<Department> getById(@PathVariable Long id) {
        log.info("根据id查询部门信息...");
        Department department = departmentService.getById(id);
        if (department != null) {
            return R.success(department);
        }
        return R.error("没有查询到对应部门信息");
    }

}
