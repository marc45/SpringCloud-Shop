# 基于Spring Boot的微服务应用

本项目内容基于Spring Boot、Spring Cloud开发。实现电商应用基础服务，包括用户服务，商品服务，订单服务,功能包括用户注册，用户鉴权，商品列表，商品详情，下单，查看订单列表，订单详情。

- 使用Spring Boot, Spring JPA实现底层服务的CRUD 
- 单元测试，API测试 
- 符合RESTful API规范 
- 实现webservice接口查询订单
- 实现服务注册发现组件
- 实现服务网关组件
- 实现服务的高可用

## 学习记录
- [微服务框架](https://github.com/suxiongwei/keda/blob/master/readme/micro_service.md)
- [Spring Boot](https://github.com/suxiongwei/keda/blob/master/readme/spring_boot.md)
- [Redis在Window 下的安装](https://github.com/suxiongwei/keda/blob/master/readme/redis.md)
- [Spring Session的集成](https://github.com/suxiongwei/keda/blob/master/readme/spring_session.md)
- [Spring Boot配置事务管理](https://github.com/suxiongwei/keda/blob/master/readme/transactional.md)
- [Spring Cloud:注册中心Eureka](https://github.com/suxiongwei/keda/blob/master/readme/eureka.md)
- [Spring Cloud:负载均衡Ribbon](https://github.com/suxiongwei/keda/blob/master/readme/ribbon.md)
- [Feign声明式服务调用](https://github.com/suxiongwei/keda/blob/master/readme/feign.md)
- [Zuul实现微服务网关](https://github.com/suxiongwei/keda/blob/master/readme/zuul.md)
- [Config分布式统一配置中心](https://github.com/suxiongwei/keda/blob/master/readme/config.md)
- [SpringData-JPA的集成](https://github.com/suxiongwei/keda/blob/master/readme/springData-jpa.md)
- [编码规范](https://github.com/suxiongwei/keda/blob/master/readme/coding_standards.md)
- [基于ACCESS TOKEN的权限解决方案](https://github.com/suxiongwei/keda/blob/master/readme/access_token.md)
## 服务介绍
* api-gateway:服务网关
* eureka-server:服务注册中心
* config-server-git:分布式配置中心
* category-service:商品服务
* order-service:订单服务
* user-service:用户服务
* web:web服务
## 演示步骤
- 1、开启Redis和MySQL服务
- 2、分别启动：EurekaServerApplication、ApiGatewayApplication、ConfigServerGitApplication、CategoryApplication、OrderApplication、UserApplication、KedaApplication
- 3、首页界面地址：http://localhost:8080
- 4、登录界面地址：http://localhost:8080/login.html
- 5、注册界面地址：http://localhost:8080/register.html

## 参考博客
- [Spring Boot基础教程](http://blog.didispace.com/Spring-Boot%E5%9F%BA%E7%A1%80%E6%95%99%E7%A8%8B/)
- [Spring-Cloud基础教程](http://blog.didispace.com/Spring-Cloud%E5%9F%BA%E7%A1%80%E6%95%99%E7%A8%8B/ )

