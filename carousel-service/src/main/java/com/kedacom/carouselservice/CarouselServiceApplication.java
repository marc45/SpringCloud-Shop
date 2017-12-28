package com.kedacom.carouselservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CarouselServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarouselServiceApplication.class, args);
	}
}
