package com.itheima.tms.dto;

import com.itheima.tms.entity.Setmeal;
import com.itheima.tms.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
