package com.zhenglc.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.zhenglc.ribbon.service.HelloService;

/**
 * @Author: zhenglc
 * @Descriptions:
 * @Data: Created in 14:13 2018/12/28
 * @Modified By:
 * @Version:
 */
@RestController
public class HelloController {
    @Autowired
    HelloService helloService;
    @GetMapping("hi")
    public String hi(@RequestParam String name){
        return helloService.hiService(name);
    }
}
