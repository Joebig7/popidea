package com.mamba.popidea.conf;

import com.mamba.popidea.handler.AuthorizationHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/21 12:35
 * @description Jwt注册配置
 */
@Configuration
public class JwtConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private AuthorizationHandlerInterceptor authorizationHandlerInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizationHandlerInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/user/register/**")
                .excludePathPatterns("/user/login/**")
                .excludePathPatterns("/swagger-ui.html/**", "/swagger-resources/**", "/v2/api-docs/**", "/configuration/**", "/webjars/**", "/images/**");

//        registry.addInterceptor();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}