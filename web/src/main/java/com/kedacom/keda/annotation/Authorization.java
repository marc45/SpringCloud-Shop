package com.kedacom.keda.annotation;

/**
 * 实习考核项目
 * com.kedacom.apigateway.authorization.annotation
 * 2018-01-18-13:48
 * 2018科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2018-01-18.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 在Controller的方法上使用此注解，该方法在映射时会检查用户是否登录，未登录返回401错误
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Authorization {
}
