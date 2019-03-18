package com.enjoy.controller;

import com.enjoy.service.IProductService;
import com.enjoy.vo.Product;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private IProductService iProductService;

    @Resource
    private DiscoveryClient client ; // 进行Eureka的发现服务


    @RequestMapping(value = "/get/{id}")  //不是？拼接的，这方式是rest风格的
    public Object get(@PathVariable("id") long id){
        return this.iProductService.get(id);
    }

    @RequestMapping(value = "/add")
    public Object add(@RequestBody Product product){
        return this.iProductService.add(product);
    }

    @RequestMapping(value = "/list")
    public Object list(){
        return this.iProductService.list();
    }

    @RequestMapping("/discover")
    public Object discover() { // 直接返回发现服务信息
        return this.client ;
    }


}
