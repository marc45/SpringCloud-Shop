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
- 1、[Redis在Window 下安装](http://blog.didispace.com/spring-boot-learning-1/)

## 演示步骤
- 1、分别启动：EurekaServerApplication、ApiGatewayApplication、CarouselServiceApplication、CategoryApplication、OrderApplication、UserApplication、KedaApplication
- 2、首页界面地址：http://localhost:8764/eureka-web
- 3、登录界面地址：http://localhost:8764/eureka-web/login.html
- 4、注册界面地址：http://localhost:8764/eureka-web/register.html

## 参考博客

- [Spring Boot基础教程](http://blog.didispace.com/Spring-Boot%E5%9F%BA%E7%A1%80%E6%95%99%E7%A8%8B/)
- [Spring-Cloud基础教程](http://blog.didispace.com/Spring-Cloud%E5%9F%BA%E7%A1%80%E6%95%99%E7%A8%8B/ )

