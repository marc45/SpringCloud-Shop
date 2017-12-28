package com.kedacom.apigateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * 实习期考核项目
 * com.kedacom.apigateway
 * 2017-12-27-13:29
 * 2017科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2017-12-27.
 */
//Zuul过滤器,在实现了自定义过滤器之后，它并不会直接生效，我们还需要为其创建具体的Bean才能启动该过滤器(应用主类中创建)
//可定义一些与业务无关的通用逻辑实现对请求的过滤和拦截，比如：签名校验、权限校验、请求限流等功能。
public class AccessFilter extends ZuulFilter{

    private static Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    //过滤器的类型，它决定过滤器在请求的哪个生命周期中执行。
    @Override public String filterType() {
        return "pre";//pre，代表会在请求被路由之前执行
    }

    //过滤器的执行顺序
    @Override public int filterOrder() {
        return 0;
    }

    //判断该过滤器是否需要被执行
    @Override public boolean shouldFilter() {
        return true;
    }

    @Override public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        logger.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());

        Object accessToken = request.getParameter("accessToken");//http://localhost:8764/eureka-provider/index?accessToken=token
        if(accessToken == null) {
            logger.warn("access token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
        logger.info("access token ok");
        return null;
    }
}
