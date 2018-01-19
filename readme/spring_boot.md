# Spring Boot

## Spring Boot简单介绍
### 介绍
* 是一个全新的框架，目的是为了简化Spring应用的搭建和开发过程
* 该框架使开发人员不需要定义样板化的配置
* 从根本上来讲，是一些库的集合，构建项目，无需自行管理这些库的版本</br>

    > SpringBoot中内建了一些聚合模块，通常称为“启动者”。
    这些启动模块中是一些类库的已知的、良好的、具备互操作性的版本的组合，这些类库能够为应用程序提供某些方面的功能。
    Boot能够通过应用程序的配置对这些类库的进行设置，这也为整个开发周期中带来了配置胜于约定的便利性，达到开箱即用的微服务效果。
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
    <packaging>war</packaging>
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
    >多数Spring Boot微服务应用最终是要部署在Docker
    1、每一个微服务足够构成一个独立的小应用(从DB到UI)
    2、微服务之间只能通过service api进行交互
    3、在运行时，每个实例通常是一个云虚拟机或者 Docker容器。
### 开发过程中遇到的问题及其解决方案
报错：<font color=red>Cannot determine embedded database driver class for database type NONE</font></br>
原因：springboot启动时会自动注入数据源和配置jpa</br>
解决方案：解决：在@SpringBootApplication中排除其注入 **@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})**
