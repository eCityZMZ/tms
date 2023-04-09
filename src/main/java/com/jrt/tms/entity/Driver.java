package com.jrt.tms.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Driver implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name ;

    private String sex;

    private String idNumber;  //身份证号码

    private String phone;

    private String vehicle;  //车辆信息

    private String vehicleId; //车辆拍照

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    @TableField(fill = FieldFill.INSERT)
    private Long createUser;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateUser;


}
