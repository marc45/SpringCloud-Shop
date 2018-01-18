package com.kedacom.keda.handle;

import com.kedacom.commons.api.Result;
import com.kedacom.commons.util.ResultUtil;
import com.kedacom.keda.exception.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 实习期考核项目
 * com.kedacom.keda.handle
 * 2017-12-26-18:44
 * 2017科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2017-12-26.
 */

//统一异常处理
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof MyException){
            MyException myException = (MyException) e;
            return ResultUtil.error(myException.getCode(),myException.getMessage());
        }else{
            logger.error("系统异常={}",e);
            return ResultUtil.error(-1,"未知错误");
        }
    }
}
