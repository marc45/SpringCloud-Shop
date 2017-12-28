package com.kedacom.carouselservice.repository;

import com.kedacom.carouselservice.model.Carousel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 实习期考核项目
 * com.kedacom.carouselservice.repository
 * 2017-12-28-15:50
 * 2017科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2017-12-28.
 */

/**
 * @Author:suxiongwei
 * @Description:轮播服务数据访问
 * @Date:15:51 2017-12-28
 */

@Repository
public interface CarouselRepository extends JpaRepository<Carousel,Long> {

    List<Carousel> findByUsedFor(String usedFor);

    Carousel save(Carousel carousel);

}
