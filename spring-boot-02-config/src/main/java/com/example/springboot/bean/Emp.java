package com.example.springboot.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ConfigurationProperties 告诉springboot将配置文件中的对应属性，映射到这个组件类中进行一一绑定
 * prefix = "emp" : 配置文件中的前缀名，配置了哪个前缀就会与下面的所有属性进行一一映射
 * @Component : 必须将当前组件作为 springboot中的一个组件来使用，这样子才会纳入容器中管理
 * @ConfigurationProperties 除了不支持spel表达式外，其他都支持
 * @PropertySource  加载局部配置文件
 */
@PropertySource(value = {"classpath:emp.properties"})
@Validated
@Component
@ConfigurationProperties(prefix = "emp")
public class Emp {

    /**
     * 类似于spring框架中使用配置文件中的数据注入方式
     * <bean class="Emp">
     *     <property name="lastname" value="字面量或者#{spel}  spring表达式/${key}从配置文件中获取"></property>
     * </bean>
     * @Value不支持数据校验
     */
//    @Value("${emp.lastname}")
    //@Email
    private String lastname;
//    @Value("#{10*2}")
    private String age;
//    @Value("8000")
    private String salary;
    private Boolean boss;
    private Date birthday;

    private Map map;
    private List list;

    @Override
    public String toString() {
        return "Emp{" +
                "lastname='" + lastname + '\'' +
                ", age='" + age + '\'' +
                ", salary='" + salary + '\'' +
                ", boss=" + boss +
                ", birthday=" + birthday +
                ", map=" + map +
                ", list=" + list +
                ", forte=" + forte +
                '}';
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Forte getForte() {
        return forte;
    }

    public void setForte(Forte forte) {
        this.forte = forte;
    }

    private Forte forte;
}
