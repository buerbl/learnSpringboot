package com.example.lsbcrudplus.util;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description:
 * @Author: boolean
 * @Date: 2019/12/10 0:41
 */

public class LsbcrudplusException extends RuntimeException{
    public LsbcrudplusException(String msg){
        super(msg);
    }
}



