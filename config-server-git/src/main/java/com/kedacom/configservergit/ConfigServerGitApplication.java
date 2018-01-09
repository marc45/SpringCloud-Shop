package com.kedacom.configservergit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableConfigServer
@SpringBootApplication
@EnableEurekaClient
public class ConfigServerGitApplication {
	//启动项目后访问：http://localhost:1201/eureka-web/prod/master可查看到远程仓库配置文件信息
	//参考博客；http://blog.didispace.com/spring-cloud-starter-dalston-3/
	public static void main(String[] args) {
		SpringApplication.run(ConfigServerGitApplication.class, args);
	}
}
