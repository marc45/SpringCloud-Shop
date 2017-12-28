package com.kedacom.keda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication
@EnableEurekaClient
public class KedaApplication {
	public static void main(String[] args) {
		SpringApplication.run(KedaApplication.class, args);
	}
}
