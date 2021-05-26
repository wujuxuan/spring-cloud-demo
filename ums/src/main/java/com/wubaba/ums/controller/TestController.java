package com.wubaba.ums.controller;

import com.wubaba.ums.feignApi.ProductClients;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sun.rmi.runtime.Log;

import java.util.List;
import java.util.Map;

/**
 * @author wjx
 * @create 2021-05-25 16:02
 */
@RestController
@Slf4j
public class TestController {
    @Autowired
    private  DiscoveryClient discoveryClient;
    @Autowired
    private  LoadBalancerClient loadBalancerClient;
    @Autowired
    private  RestTemplate restTemplate;
    @Autowired
    private ProductClients productClients;


    //----------------------restTemplate -------------------------------------------------------------------   

    //基于restTemplate
    @Autowired
    @GetMapping("user/findAll")
    public String findAll(){
        log.info("调用用户服务...");
        //1.使用restTemplate调用商品服务
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject("http://localhost:9999/product/findAll",
                String.class);
        return forObject;
    }
    //----------------------restTemplate + ribbon-------------------------------------------------------------------   
    //基于discoveryClient获取服务列表
    @GetMapping("user/discoveryClient")
    public List discoveryClient(){
        log.info("discoveryClient==》获取服务列表...");
        List<ServiceInstance> products = discoveryClient.getInstances("pms");
        //获取服务列表
        products.forEach( item ->{
            log.info("服务主机:[{}]",item.getHost());
            log.info("服务端口:[{}]",item.getPort());
            log.info("服务地址:[{}]",item.getUri());
            log.info("====================================");
        });
        return products;
    }

    //基于loadBalancerClient（默认轮询获取单个）获取服务
    @GetMapping("user/loadBalancerClient")
    public ServiceInstance loadBalancerClient(){
        log.info("loadBalancerClient===》获取服务列表...");
        //根据负载均衡策略选取某一个服务调用
        ServiceInstance product = loadBalancerClient.choose("pms");
        //获取服务列表
        log.info("服务主机:[{}]",product.getHost());
        log.info("服务端口:[{}]",product.getPort());
        log.info("服务地址:[{}]",product.getUri());
        log.info("====================================");
        return product;
    }
    //基于restTemplate
    @GetMapping("user/test1/findAll")
    public String restTemplateFindAll(){
        log.info("XXX调用用户服务...");
//        1.使用restTemplate调用商品服务
//        这里不需要在写端口号和ip地址了
        String forObject = restTemplate.getForObject("http://PMS/product/findAll" , String.class);
        return forObject;
    }

    //----------------------open feign-------------------------------------------------------------------   
    @GetMapping("user/feign/findAll")
    public Map<String,Object> openFeignFindAll(){
        log.info("openFeignFindAll调用用户服务...");
        Map<String,Object> all = productClients.findAll();
        return all;
    }

}
