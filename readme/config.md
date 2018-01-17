# Config分布式统一配置中心
在微服务实践中将所有微服务的配置集中外置到配置中心统一管理，
通过将配置管理抽象成独立的服务来简化在不同的环境中的微服务配置管理，
帮助微服务无状态化和轻量部署以及调度，已经成为业内默认的最佳实践
## 1、创建Config Server
* pom.xml中引入spring-cloud-config-server依赖
````xml
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-config-server</artifactId>
    </dependency>
    <!--配置为服务-->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-eureka</artifactId>
    </dependency>
````
* 在Spring Boot的程序主类中添加@EnableConfigServer注解，开启Config Server
```java
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
```
* application.properties中配置服务信息以及git信息
````xml
    spring.application.name=config-server
    spring.cloud.config.server.git.uri=https://github.com/suxiongwei/config-repo-demo/
    server.port=1201
    
    eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka/
    
    spring.datasource.url=jdbc:mysql://localhost:3306/dbkeda?useUnicode=true&characterEncoding=UTF-8&sessionVariables=FOREIGN_KEY_CHECKS=0&autoReconnect=true
    spring.datasource.username=root
    spring.datasource.password=root
````

* 配置完成(可参见项目：[config-server-git](https://github.com/suxiongwei/keda/tree/master/config-server-git))

## 2、创建远程仓库
* [远程仓库地址](https://github.com/suxiongwei/config-repo-demo)

## 3、微服务应用中获取配置信息
* pom.xml中引入spring-cloud-starter-config依赖
```xml
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-config</artifactId>
    </dependency>
```
* 在bootstrap.yml中配置Config Server
````yaml
    # 构建配置中心
    spring:
      application:
        name: eureka-web
      cloud:
        config:
          uri: http://localhost:8764/CONFIG-SERVER/
          profile: default
          label: master
    server:
      port: 8771
````
注意：上面这些属性必须配置在bootstrap.properties中，config部分内容才能被正确加载。因为config的相关配置会先于application.properties，而bootstrap.properties的加载也是先于application.properties。
