package com.jrt.tms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jrt.tms.common.ExportExcel;
import com.jrt.tms.entity.Driver;
import com.jrt.tms.mapper.DriverMapper;
import com.jrt.tms.service.DriverService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
@Slf4j
public class DriverServiceImp extends ServiceImpl <DriverMapper, Driver> implements DriverService {
    @Autowired
    DriverMapper reportMappe;


    @Override
    public void exportTest(OutputStream out, String excelTitle) throws IOException {
        // 定义列标 就是一个Excel的标题而已 下面有图介绍
        String[] rowsName = new String[]{"驾驶员姓名", "性别", "身份证号码", "电话号码","车牌号"};
        // 创建导出数据集合 后续会将dataList中的数据写到Excel
        List<Object[]> dataList = new ArrayList<Object[]>();
        // 从数据库查询用户列表
        QueryWrapper queryWrapper = new QueryWrapper();
        List<Driver> userList = reportMappe.selectList(queryWrapper);
        Driver user = null;
        // 将用户列表信息封装到一个Object数组
        // 我这里封装Object数组 是为了方便后续代码复用,不会将对象类型写死
        // 当然也可以在下一层使用反射来做,太麻烦了 还是这样转一下吧
        for (int i=0;i<userList.size();i++){
            //将数据库查到的每条数据 循环封装到Object[]
            user=userList.get(i);
            Object[] objs = new Object[]{user.getName(),user.getSex(),user.getIdNumber(),user.getPhone(),user.getVehicleId()};
            //将转换好的数据 存入dataList

            if(objs[1].equals("1")) objs[1]="男";
            if(objs[1].equals("1")) objs[1]="女";
            dataList.add(objs);
        }
        // 创建ExportExcel工具类对象 通过构造方法赋值
        ExportExcel ex = new ExportExcel(excelTitle, rowsName, dataList);
        try {
            // 调用生成Excel的方法,将数据通过输出流写出
            ex.export(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.flush();
        out.close();
    }
}
