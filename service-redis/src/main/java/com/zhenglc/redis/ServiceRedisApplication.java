package com.zhenglc.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @Author: zhenglc
 * @Descriptions:
 * @Data: Created in 17:18 2019/1/2
 * @Modified By:
 * @Version:
 */
@SpringBootApplication
public class ServiceRedisApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceRedisApplication.class, args);
    }
}
