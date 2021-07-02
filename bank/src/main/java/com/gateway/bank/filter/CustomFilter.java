package com.gateway.bank.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomFilter extends ZuulFilter {

    
    Logger logger  = LoggerFactory.getLogger(PreSecondFilter.class);

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        String param = context.getRequest().getParameter("financial");
        return param != null && param.equals("medicines") ? false : true;
    }

    @Override
    public Object run() throws ZuulException {
        logger.info("Custom Filter");
        return null;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 5;
    }

}