package com.enjoy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.enjoy.mapper")
@EnableEurekaClient
@EnableDiscoveryClient
public class ProductConfigApp {
    public static void main(String[] args) {
        SpringApplication.run(ProductConfigApp.class,args);
    }
}
