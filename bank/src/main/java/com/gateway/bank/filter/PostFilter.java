package com.gateway.bank.filter;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletResponse;

import com.google.common.io.CharStreams;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import org.apache.commons.codec.CharEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostFilter extends ZuulFilter {

    Logger log = LoggerFactory.getLogger(PostFilter.class);

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();

        HttpServletResponse response = ctx.getResponse();
        //ctx.getResponse().setStatus(500);
        log.info("Response  Status= {}", response.getStatus());

        try (InputStream is = ctx.getResponseDataStream()) {
            String respData = CharStreams.toString(new InputStreamReader(is, CharEncoding.UTF_8));
            log.info("Response  Data = {}", respData);
            ctx.setResponseBody(respData);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

}