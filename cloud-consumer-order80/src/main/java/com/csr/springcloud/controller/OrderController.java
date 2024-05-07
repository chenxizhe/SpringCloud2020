package com.csr.springcloud.controller;

import com.csr.springcloud.entity.CommonResult;
import com.csr.springcloud.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @description:
 * @author：csr
 * @date: 2024/5/7 0007
 */
@RestController
@Slf4j
@RequestMapping("consumer")
public class OrderController {
    @Resource
    private RestTemplate  restTemplate;
    public static final String PAYMENT_URL = "http://localhost:8001";

    @PostMapping("/users/addUser")
    public CommonResult<User> create(@RequestBody User user) {
        return restTemplate.postForObject(PAYMENT_URL + "/users/addUser", user, CommonResult.class);
    }



    @GetMapping("/users/queryAllUser")
    public CommonResult queryAllByLimit() {
        return restTemplate.getForObject(
                PAYMENT_URL + "/users/queryAllUser", CommonResult.class);
    }
}
