package com.enjoy.controller;

import com.enjoy.service.IProductClientService;
import com.enjoy.service.IZUUlClientService;
import com.enjoy.vo.Product;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/consumer")   ///consumer/product/list
public class ConsumerProductController {


    @Resource
    private IProductClientService iProductClientService;

    @Resource
    private IZUUlClientService izuUlClientService;


    @RequestMapping("/product/get")
    public Object getProduct(long id) {
        return  iProductClientService.getProduct(id);
    }

    @RequestMapping("/product/list")
    public  Object listProduct() {
        return iProductClientService.listProduct();
    }

    @RequestMapping("/product/add")
    public Object addPorduct(Product product) {
        return  iProductClientService.addPorduct(product);
    }

    @RequestMapping("/product/getProductAndUser")
    public Object getProductAndUser(long id) {
        Map<String,Object> result = new HashMap();
        result.put("product",izuUlClientService.getProduct(id));
        result.put("user",izuUlClientService.getUsers(id+""));
        return  result;
    }



    /*以前用的*/
//    private static final String PRODUCT_GET_URL = "http://localhost:8080/product/get/";
//    private static final String PRODUCT_LIST_URL="http://localhost:8080/product/list/";
//    private static final String PRODUCT_ADD_URL = "http://localhost:8080/product/add/";

//    private static final String PRODUCT_GET_URL = "http://SPRING-CLOUD-PRODUCT/product/get/";
//    private static final String PRODUCT_LIST_URL="http://SPRING-CLOUD-PRODUCT/product/list/";
//    private static final String PRODUCT_ADD_URL = "http://SPRING-CLOUD-PRODUCT/product/add/";

//    @Resource
//    private RestTemplate restTemplate;

    //没使用springSecurity
/*    @RequestMapping("/product/get")
    public Object getProduct(long id){
        return restTemplate.getForObject(PRODUCT_GET_URL + id, Product.class);
    }

    @RequestMapping("/product/list")
    public Object listProduct(){
        return restTemplate.getForObject(PRODUCT_LIST_URL, List.class);
    }

    @RequestMapping("/product/add")
    public Object addProduct(Product product){
        return restTemplate.postForObject(PRODUCT_ADD_URL, product, Boolean.class);
    }*/


    //使用了springSecurity
   /* @Resource
    private HttpHeaders httpHeaders;*/

    //增加一个LoadBalancerClient
    /*@Resource
    private LoadBalancerClient loadBalancerClient;*/

    /*@RequestMapping("/product/get")
    public Object getProduct(long id) {
        return  restTemplate.exchange(PRODUCT_GET_URL + id, HttpMethod.GET,new HttpEntity<Object>(httpHeaders), Product.class).getBody();
    }*/

    /*@RequestMapping("/product/list")
    public  Object listProduct() {
        return  restTemplate.exchange(PRODUCT_LIST_URL,HttpMethod.GET,new HttpEntity<Object>(httpHeaders), List.class).getBody();
    }*/

   /* @RequestMapping("/product/list")
    public  Object listProduct() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("SPRING-CLOUD-PRODUCT") ;
        System.out.println(
                "【*** ServiceInstance ***】host = " + serviceInstance.getHost()
                        + "、port = " + serviceInstance.getPort()
                        + "、serviceId = " + serviceInstance.getServiceId());
        return  restTemplate.exchange(PRODUCT_LIST_URL,HttpMethod.GET,new HttpEntity<Object>(httpHeaders), List.class).getBody();
    }


    @RequestMapping("/product/add")
    public Object addPorduct(Product product) {
        return  restTemplate.exchange(PRODUCT_ADD_URL, HttpMethod.POST,new HttpEntity<Object>(product,httpHeaders), Boolean.class).getBody();
    }*/



}
