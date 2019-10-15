package com.eagle.service.impl;

import com.eagle.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * 创建时间: 2019/10/15,10:50
 * 工程师: EagleMao
 * 功效:
 */

@Service(value = "accountService")
public class AccountServiceImpl implements AccountService {

    @Override
    public void deleteAccount() {
        System.out.println("删除成功");
    }
}
