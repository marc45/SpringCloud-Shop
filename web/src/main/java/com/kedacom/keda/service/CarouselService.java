package com.kedacom.keda.service;

import com.kedacom.model.Carousel;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 实习期考核项目
 * com.kedacom.keda.service
 * 2018-01-03-9:19
 * 2018科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2018-01-03.
 */
@FeignClient("carousel-service")
public interface CarouselService {

    @GetMapping("/carousels/getCarousels/{usedFor}") List<Carousel> getCarousels(@PathVariable("usedFor") String usedFor);
}
