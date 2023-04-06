package com.jrt.tms.dto;

import com.jrt.tms.entity.Setmeal;
import com.jrt.tms.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
