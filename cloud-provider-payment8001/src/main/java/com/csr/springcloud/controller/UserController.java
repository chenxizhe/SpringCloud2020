package com.csr.springcloud.controller;

import com.csr.springcloud.entity.CommonResult;
import com.csr.springcloud.entity.User;
import com.csr.springcloud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author：csr
 * @date: 2024/5/7 0007
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/addUser")
    public CommonResult<User> create(@RequestBody User user) {
        this.userService.addUser(user);
        return new CommonResult<>(0,"操作成功"+ serverPort);
    }

    @GetMapping("/queryAllUser")
    public CommonResult<List<User>> queryAllUser() {
        List<User> list = this.userService.queryAllUser();
        return new CommonResult<>(200, "操作成功" + serverPort, list);
    }

    @GetMapping("discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        services.forEach(System.out::println);

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(instance -> {
            System.out.println(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        });

        return this.discoveryClient;
    }

}
