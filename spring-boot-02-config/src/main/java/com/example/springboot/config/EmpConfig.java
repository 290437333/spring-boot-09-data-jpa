package com.example.springboot.config;

import com.example.springboot.service.EmpService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration 它是spring里的注解，用于标识当前类是一个配置类，来表示对应spirng配置文件
 */
@Configuration
public class EmpConfig {

    /**
     * @Bean 标识的方法用于向容器中注入组件
     * @return
     */
    @Bean
    public EmpService empService2(){
        System.out.println("EmpService组件注入成功");
        return new EmpService();
    }
}
