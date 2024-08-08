package com.wisionweb.config;

import com.wisionweb.exception.UnAuthorizationException;
import com.wisionweb.util.MyCache;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 * 用于用户认证，从浏览器表头取token信息，与缓存中的token进行比对
 */
@Component
public class Authorization extends HandlerInterceptorAdapter {
    final static String TOKEN="wx-token";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token=request.getHeader(TOKEN);
        if(token==null){throw new UnAuthorizationException("token为空");}
        Object o= MyCache.get(token);
        if(o==null){throw new UnAuthorizationException("认证已过期");}
        return true;
    }
}
