# 应用集成Spring Session

## 概念基础
* 由于http协议是无状态的协议，为了能够记住请求的状态，于是引入了Session和Cookie的机制。</br>

* 客户端服务端是通过**JSESSIONID**进行交互的：</br>
    * 当服务端往session中保存一些数据时，Response中自动添加了一个**Cookie：JSESSIONID：xxxx**，</br>
在后续的请求中，浏览器也是自动的带上了这个Cookie，**服务端根据Cookie中的JSESSIONID取到了对应的session**。</br>

    * 添加和携带key为JSESSIONID的Cookie都是tomcat和浏览器自动帮助我们完成的。</br>
    * 不同浏览器，访问是隔离的，甚至重新打开同一个浏览器，JSESSIONID也是不同的。</br>

* 存放在客户端的Cookie是**存在安全问题**的：</br>
    * 可以通过工具篡改浏览器的JSESSIONID“骗”过服务器。因为，服务器只能通过Cookie中的JSESSIONID来辨别身份。
### Session介绍
* Session是存在于**服务器端**的，在单体式应用中，他是由tomcat管理的，存在于**tomcat的内存**中。</br>
* 当我们为了解决分布式场景中的session共享问题时，引入了**redis**，其**共享内存，以及支持key自动过期**的特性，非常契合session的特性，我们在企业开发中最常用的也就是这种模式。</br>
当然，也可以选择存储在JDBC，Mongo中，这些，spring都提供了默认的实现，在大多数情况下，我们只需要引入配置即可。</br>
### Cookie介绍
* Cookie则是存在于**客户端**，更方便理解的说法，可以说存在于浏览器。Cookie并不常用，http协议允许从服务器返回Response时携带一些Cookie，并且同一个域下对Cookie的数量有所限制，之前说过Session的持久化依赖于服务端的策略，而Cookie的持久化则是依赖于本地文件。</br>
虽然说Cookie并不常用，但是有一类特殊的Cookie却是我们需要额外关注的，那便是与**Session相关的sessionId**，他是真正维系客户端和服务端的桥梁。
             
## 集成Spring Session步骤
- 1、引入依赖
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.session</groupId>
    <artifactId>spring-session-data-redis</artifactId>
</dependency>
```              
- 2、配置类开启Redis Http Session
```java
/**
 * 开启spring session支持
 */
@Configuration
@EnableRedisHttpSession
public class RedisSessionConfig {
    //Spring Session替换了默认的tomcat httpSession
}
```
参见web服务 package com.kedacom.keda.config包下的 RedisSessionConfig
- 3、配置文件application.yml，配置连接的redis信息
```properties
#配置redis服务器的位置
spring.redis.host=localhost
spring.redis.port=6379
spring.redis.database=0
```
- 4、集成Spring Session完成

## 测试
正常情况下新建一个Spring Boot程序，根据以上步骤已经成功的将Spring Session集成到应用中来，可以通过一个Controller进行测试。
```java
    @RequestMapping("/test/cookie")
    public String cookie(@RequestParam("browser") String browser, HttpServletRequest request, HttpSession session) {
        //取出session中的browser
        Object sessionBrowser = session.getAttribute("browser");
        if (sessionBrowser == null) {
            System.out.println("不存在session，设置browser=" + browser);
            session.setAttribute("browser", browser);
        } else {
            System.out.println("存在session，browser=" + sessionBrowser.toString());
        }
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + " : " + cookie.getValue());
            }
        }
        return "index";
    }
```
参见web服务 package com.kedacom.keda.controller;包下的 CookieController</br>
* 访问http://localhost:8771/test/cookie?browser=chrome </br>
    * 观察控制台打印出的信息可发现Spring Session集成成功。</br>
* 访问http://localhost:8764/eureka-web/test/cookie?browser=chrome </br>
    * 但是本项目集成了**Spring Cloud Zuul**，服务会进行自动路由转发，当访问以上链接时无法演示出测试效果，每一次的session都是一个新的session。</br>
* 针对此问题提供解决方案如下:

## 会话无法保持的问题解决
* 当我们将Spring Cloud Zuul作为API网关接入网站类应用时，往往都会碰到会话无法保持的问题：</br>
通过跟踪一个HTTP请求经过Zuul到具体服务，再到返回结果的全过程。发现在传递的过程中，HTTP请求头信息中的**Cookie**和 **Authorization**(授权信息) 等敏感头信息被忽略掉了，
没有正确地传递给具体服务，所以最终导致会话状态没有得到保持的现象。
- 解决方案:全局设置：zuul.sensitive-headers=
```yaml
zuul:
  sensitive-headers: 
```

## 参考博客
- [Zuul处理Cookie和重定向](http://blog.didispace.com/spring-cloud-zuul-cookie-redirect/)

