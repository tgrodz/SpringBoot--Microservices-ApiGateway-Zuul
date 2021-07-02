package com.gateway.bank.filter;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PreFilter extends ZuulFilter {

    Logger logger = LoggerFactory.getLogger(PreFilter.class);

    /**
     * Operation to be performed
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        logger.info("Request Methd = {}, URL = {}", request.getMethod(), request.getRequestURI());
        return null;
    }

    /**
     * Specify the types on which filter will be executed 
     * eg. Type of header
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * Order
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public String filterType() {
        return "pre";
    }



}