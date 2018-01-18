package com.kedacom.keda;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients//开启扫描Spring Cloud Feign客户端的功能
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class KedaApplication {//extends SpringBootServletInitializer

//	@Override protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(KedaApplication.class);
//	}

	public static void main(String[] args) {
		new SpringApplicationBuilder(KedaApplication.class).web(true).run(args);
	}
}
