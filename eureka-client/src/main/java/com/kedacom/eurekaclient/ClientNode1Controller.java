package com.kedacom.eurekaclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 实习期考核项目
 * com.kedacom.eureka
 * 2017-12-26-14:01
 * 2017科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2017-12-26.
 */

@RestController
public class ClientNode1Controller {
    @GetMapping({"","/"})
    public String index(){
        return "Hi,dy_bom! this is  provider-node1 of peer!";
    }

    /**
     * 用来测试与节点2.3的负载均衡
     * @return
     */
    @GetMapping("/index")
    public String providerIndex(){
        return "Hi,dy_bom! this is  provider-node1 of peer!";
    }
}
