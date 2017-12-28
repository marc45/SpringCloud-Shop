package com.kedacom.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients//开启扫描Spring Cloud Feign客户端的功能
public class ConsumerApplication {

	@Bean
	@LoadBalanced//Spring Cloud Ribbon
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		//		SpringApplication.run(ClientApplication.class, args);
		new SpringApplicationBuilder(ConsumerApplication.class).web(true).run(args);
	}
}
