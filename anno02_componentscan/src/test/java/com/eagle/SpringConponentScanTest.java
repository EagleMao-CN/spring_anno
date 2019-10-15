package com.eagle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.eagle.service.AccountService;
import com.eagle.service.UserService;

/**
 * 创建时间: 2019/10/15,10:31
 * 工程师: EagleMao
 * 功效:
 */
public class SpringConponentScanTest {
    public static void main(String[] args) {
        //1.创建容器
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("com/eagle/config");
        //2.获取对象
        UserService userService = ac.getBean("userService", UserService.class);
        AccountService accountService = ac.getBean("accountService", AccountService.class);
        //3.调用方法输出结果
        userService.saveUser();
        accountService.deleteAccount();

    }
}
