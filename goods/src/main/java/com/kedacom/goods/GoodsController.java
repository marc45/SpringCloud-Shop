package com.kedacom.goods;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 实习期考核项目
 * com.kedacom.goods
 * 2017-12-28-12:27
 * 2017科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2017-12-28.
 */
@RestController
public class GoodsController {
    @GetMapping("/goods")
    public String index(){
        return "商品服务";
    }
}
