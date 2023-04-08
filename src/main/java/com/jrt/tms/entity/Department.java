package com.jrt.tms.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

/**
 * 部门实体类
 */
@Data
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long deptCode;

    private String deptName;

    private Integer isDeleted;

    @TableField(fill = FieldFill.INSERT) //插入时填充字段
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE) //插入和更新时填充字段
    private LocalDateTime updateTime;

    @TableField(fill = FieldFill.INSERT) //插入时填充字段
    private Long createUser;

    @TableField(fill = FieldFill.INSERT_UPDATE) //插入和更新时填充字段
    private Long updateUser;

}
