package com.kedacom.keda.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 实习期考核项目
 * com.kedacom.keda.exception
 * 2017-12-26-18:51
 * 2017科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2017-12-26.
 */
//自定义异常对象
public class MyException extends RuntimeException {

    private Integer code;

    public MyException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
