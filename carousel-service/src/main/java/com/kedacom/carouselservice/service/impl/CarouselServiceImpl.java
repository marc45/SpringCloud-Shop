package com.kedacom.carouselservice.service.impl;

/**
 * 实习期考核项目
 * com.kedacom.carouselservice.service.impl
 * 2017-12-28-15:52
 * 2017科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2017-12-28.
 */

import com.kedacom.carouselservice.model.Carousel;
import com.kedacom.carouselservice.repository.CarouselRepository;
import com.kedacom.carouselservice.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:suxiongwei
 * @Description:轮播服务Spring Data JPA实现
 * @Date:15:53 2017-12-28
 */
@Service
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    private CarouselRepository carouselRepository;

    @Override
    public List<Carousel> findByUsedFor(String usedFor) {
        return carouselRepository.findByUsedFor(usedFor);
    }

    @Override
    public Carousel findOne(Long id) {
        return carouselRepository.findOne(id);
    }

    @Override
    public Carousel save(Carousel carousel) {
        return carouselRepository.save(carousel);
    }

    @Override
    public void delete(Long id) {
        carouselRepository.delete(id);
    }
}
