package com.csr.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @description:
 * @author：csr
 * @date: 2024/5/7 0007
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class order80 {

    public static void main(String[] args) {
        SpringApplication.run(order80.class,args);
    }
}
