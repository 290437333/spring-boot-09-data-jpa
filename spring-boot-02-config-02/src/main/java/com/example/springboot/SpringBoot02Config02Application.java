package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 配置文件是按照优先级从低到高进行加载，高优先级的会覆盖低优先级的配置内容
 */
@SpringBootApplication
public class SpringBoot02Config02Application {

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        SpringApplication.run(SpringBoot02Config02Application.class, args);
    }

}
