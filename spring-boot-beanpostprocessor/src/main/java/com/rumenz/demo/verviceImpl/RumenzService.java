package com.rumenz.demo.verviceImpl;

import com.rumenz.demo.config.Routeing;
import com.rumenz.demo.service.RumenzHelloService;
import org.springframework.stereotype.Service;

/**
 * @className: RumenzService
 * @description: TODO 类描述
 * @author: mac
 * @date: 2021/8/30
 **/
@Service
public class RumenzService {

    @Routeing("RumenzHello2ServiceImpl")
    RumenzHelloService rumenzHelloService;

    public String index(){
        return rumenzHelloService.say();
    }
}
