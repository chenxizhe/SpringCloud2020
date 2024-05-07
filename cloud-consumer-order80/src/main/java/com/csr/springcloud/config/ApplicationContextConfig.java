package com.csr.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author：csr
 * @date: 2024/5/7 0007
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced //让这个RestTemplate在请求时拥有客户端负载均衡的能力  //将此注解注释掉，使用自己的轮询算法不使用默认的
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
