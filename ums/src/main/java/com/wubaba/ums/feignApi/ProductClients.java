package com.wubaba.ums.feignApi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * @author wjx
 * @create 2021-05-26 10:18
 */

@FeignClient("PMS")
public interface ProductClients {

    @GetMapping("product/findAll") //书写服务调用路径
    Map<String,Object> findAll();
}
