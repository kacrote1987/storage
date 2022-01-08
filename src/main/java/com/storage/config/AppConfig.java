package com.storage.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author zhangyq
 * @create 2019-09-10 20:20
 */
@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Resource
    Authorization authorizationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        InterceptorRegistration addInterceptor = registry.addInterceptor(authorizationInterceptor);

        addInterceptor.excludePathPatterns("/user/login",
                "/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**",
                "/",
                "",
                "/index")
                .addPathPatterns("/**");
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

    }

}
