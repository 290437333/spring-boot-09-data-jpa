package com.example.springboot;

import com.example.springboot.bean.Emp;
import com.example.springboot.service.EmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot02ConfigApplicationTests {

    @Autowired
    Emp emp;

    @Autowired
    ApplicationContext context;

    @Test
    public void testXml(){
        //empService为spring01.xml的id
//        EmpService empService = (EmpService) context.getBean("empService");
//        System.out.println(empService);
//        empService.add();

        EmpService empService2 = (EmpService) context.getBean("empService2");
        System.out.println("empservice2:"+empService2);
    }

    @Test
    public void contextLoads() {
        System.out.println(emp);
    }

}
