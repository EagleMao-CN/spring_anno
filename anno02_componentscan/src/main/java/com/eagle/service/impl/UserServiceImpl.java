package com.eagle.service.impl;

import com.eagle.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 创建时间: 2019/10/15,10:33
 * 工程师: EagleMao
 * 功效:
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Override
    public void saveUser() {
        System.out.println("保存用户成功");
    }
}
