package com.rumenz.demo.verviceImpl;

import com.rumenz.demo.service.RumenzHelloService;
import org.springframework.stereotype.Service;

/**
 * @className: RumenzHelloServiceImpl
 * @description: TODO 类描述
 * @author: mac
 * @date: 2021/8/30
 **/

@Service("RumenzHelloServiceImpl")
public class RumenzHelloServiceImpl  implements RumenzHelloService {
    @Override
    public String say() {
        return "实现1";
    }
}
