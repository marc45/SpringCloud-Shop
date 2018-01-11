# 基于Spring Boot的微服务应用
## 应用介绍：
实现电商应用基础服务，包括用户服务，商品服务，订单服务,功能包括用户注册，用户鉴权，商品列表，商品详情，下单，查看订单列表，订单详情
## 技术点:
* 使用Spring Boot, Spring JPA实现底层服务的CRUD 
* 单元测试，API测试 
* 符合RESTful API规范 
* 实现webservice接口查询订单
* 实现服务注册发现组件 
* 实现服务网关组件 
* 实现服务的高可用 


## 演示步骤:
* 1、分别启动：EurekaServerApplication、ApiGatewayApplication、CarouselServiceApplication、CategoryApplication、OrderApplication、UserApplication、KedaApplication
* 2、首页界面地址：http://localhost:8764/eureka-web
* 3、登录界面地址：http://localhost:8764/eureka-web/login.html
* 4、注册界面地址：http://localhost:8764/eureka-web/register.html
