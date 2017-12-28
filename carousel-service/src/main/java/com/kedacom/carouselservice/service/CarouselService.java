package com.kedacom.carouselservice.service;

import com.kedacom.carouselservice.model.Carousel;

import java.util.List;

/**
 * 实习期考核项目
 * com.kedacom.carouselservice.service
 * 2017-12-28-15:51
 * 2017科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2017-12-28.
 */

/**
 * @Author:suxiongwei
 * @Description:轮播服务接口
 * @Date:15:52 2017-12-28
 */
public interface CarouselService {

    List<Carousel> findByUsedFor(String usedFor);

    Carousel findOne(Long id);

    Carousel save(Carousel carousel);

    void delete(Long id);

}
