package com.example.springboot.config;

import com.example.springboot.component.MyLocaleResolver;
import com.example.springboot.interceptor.LoginHandderInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MySpringMvcConfigurer {

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer(){
            //添加视图控制
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("main/login");
                registry.addViewController("/index.html").setViewName("main/login");
                registry.addViewController("/main.html").setViewName("main/index");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandderInterceptor())
                        //指定要拦截的路径
                        .addPathPatterns("/**")
                        //排除不需要拦截的路径
                        .excludePathPatterns("/","/index.html","/login")
                        //springboot2之后需要将静态资源的访问路径也排除
                        .excludePathPatterns("/css/*","/img/*","/js/*");
            }
        };
    }

    //区域解析器
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
