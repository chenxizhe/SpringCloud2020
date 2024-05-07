package com.csr.springcloud.controller;

import com.csr.springcloud.entity.CommonResult;
import com.csr.springcloud.entity.User;
import com.csr.springcloud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addUser")
    public CommonResult<User> create(@RequestBody User user) {
        this.userService.addUser(user);
        return new CommonResult<>(0,"操作成功");
    }

    @GetMapping("/queryAllUser")
    public CommonResult<List<User>> queryAllUser() {
        List<User> list = this.userService.queryAllUser();
        return new CommonResult<>(200, "操作成功" + serverPort, list);
    }




}
