# Spring Boot

## Spring Boot简单介绍
### 介绍
* 是一个全新的框架，目的是为了简化Spring应用的搭建和开发过程
* 该框架使开发人员不需要定义样板化的配置
* 从根本上来讲，是一些库的集合，构建项目，无需自行管理这些库的版本
### 特点
* 创建独立的Spring应用程序
* 嵌入的Tomcat，无需部署WAR文件
* 自动配置Spring
* 提供生产就绪型功能，如指标、健康管理和外部配置
### 使用场景
* 开发restful风格的微服务架构
* 微服务、自动化、横向扩展
* 精简配置与整合其它工具
### 发布方式
* 构建Jar包，命令行运行Spring Boot程序</br>
命令行切换到jar所在目录，输入命令"java -jar 项目的jar名"
* 构建War包，发布到Tomcat
    * 1、修改pom</br>
    ```xml
    <packaging>jar</packaging>
    ```
    * 2、导入依赖
    ````xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-tomcat</artifactId>
    </dependency>
    ````
    * 3、修改启动类
    ````java
    @EnableDiscoveryClient
    @SpringBootApplication
    @EnableFeignClients//开启扫描Spring Cloud Feign客户端的功能
    public class KedaApplication extends SpringBootServletInitializer {
    
    	@Override protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    		return builder.sources(KedaApplication.class);
    	}
    
    	public static void main(String[] args) {
  	        new SpringApplicationBuilder(KedaApplication.class).web(true).run(args);
    	}
    }
    ````
