package com.example.springbootweb01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 此实例的作用：对员工的crud，并实现了spring拦截器检查session中是否有登陆信息，来控制首页的访问。
 */
@SpringBootApplication
public class SpringbootWeb01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWeb01Application.class, args);
    }
}
