package com.kedacom.keda.utils;

import com.kedacom.keda.domain.Result;

/**
 * 实习期考核项目
 * com.kedacom.keda.utils
 * 2017-12-26-18:33
 * 2017科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2017-12-26.
 */
public class ResultUtil {

    public static Result success(Object object){
        Result result = new Result(0,"成功",object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code,String msg){
        Result result = new Result(code,msg);
        return result;
    }
}
