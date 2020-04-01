package com.zshuai.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Filter;

/**
 * Created by zshuai
 *
 * @Date :2020/4/1 9:40 AM
 * @Version 1.0
 **/
@Component
public class LoginFilter extends ZuulFilter {
    @Override
    public String filterType() {
        //登录校验，前置拦截
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER -1 ;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //登录校验逻辑
        //1) 获取Zuul提供的请求上下文对象
        RequestContext ctx = RequestContext.getCurrentContext();
        //2) 在上下文中获取request对象
        HttpServletRequest request = ctx.getRequest();
        //3) 在request中获取token
        String token = request.getParameter("access-token");
        //4)判断
        if (StringUtils.isBlank(token)){
            //不存在，未登录。拦截
            ctx.setSendZuulResponse(false);

            //返回403
            ctx.setResponseStatusCode(HttpStatus.FORBIDDEN.value());
        }
        return null;
    }
}
