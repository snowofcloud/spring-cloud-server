package com.enjoy;

import com.fun.config.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "SPRING-CLOUD-PRODUCT", configuration = RibbonConfig.class)
@EnableFeignClients("com.enjoy.service")
public class ConsumerFeignApp {

    //上面注解的name 只服务的名称，如果需要有多个服务提供方，这个时候可以使用@RibbonClients进行配置
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignApp.class, args);
    }

}
