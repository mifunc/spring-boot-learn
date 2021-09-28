package com.rumenz.proxy.demo.serviceImpl;

import com.rumenz.proxy.demo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @className: UserServiceImpl
 * @description: TODO 类描述
 * @author: mac
 * @date: 2021/9/23
 **/
@Service
public class UserServiceImpl implements UserService {
    @Override
    public String say() {
        return "说话";
    }

    @Override
    public String eat() {
        return "吃饭";
    }
}
