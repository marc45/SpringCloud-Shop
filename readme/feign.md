# Feign声明式服务调用
在Spring Cloud Netflix栈中，各个微服务都是以HTTP接口的形式暴露自身服务的，因此在调用远程服务时就必须使用HTTP客户端。我们可以使用JDK原生的
URLConnection、Apache的Http Client、Netty的异步HTTP Client, Spring的RestTemplate。但是，用起来最方便、最优雅的还是要属Feign了。
## Feign简介
Feign是一种声明式、模板化的HTTP客户端。在Spring Cloud中使用Feign, 我们可以做到使用HTTP请求远程服务时能与调用本地方法一样的编码体验，
开发者完全感知不到这是远程方法，更感知不到这是个HTTP请求。比如：
````java
    @Autowired UserService userService;
    /**
     * 用户登录
     * @param user
     * @param model
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public Result login(User user) {
        User u = userService.login(user);
        if(u.getPassword().equals(user.getPassword())){
            return ResultUtil.success();
        }
        return ResultUtil.error(2,"用户名或密码有误");
    }
````
userService.login()就能完成发送HTTP请求调用用户服务，完成登录操作。

## 配置及其使用方式(以web服务调用user服务为例)
- 在服务消费方(这里为web服务)的pom.xml中增加下面的依赖：
````xml
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-feign</artifactId>
    </dependency>
````
- 修改应用主类。通过@EnableFeignClients注解开启扫描Spring Cloud Feign客户端的功能：
````java
    @EnableDiscoveryClient
    @EnableFeignClients//开启扫描Spring Cloud Feign客户端的功能
    @SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
    public class KedaApplication {
    	public static void main(String[] args) {
    		new SpringApplicationBuilder(KedaApplication.class).web(true).run(args);
    	}
    }
````
- 创建一个Feign的客户端接口定义。使用@FeignClient注解来指定这个接口所要调用的服务名称，接口中定义的各个函数使用Spring MVC的注解就可以来绑定服务提供方的REST接口
````java
    @FeignClient("user-service")
    public interface UserService {
    
        @PostMapping("/user/login")
        User login(@RequestBody User user);
    
        @PostMapping("user/insertUser") Boolean register(@RequestBody User user);
    }
````
- 在Controller中注入定义的feign客户端来调用服务提供方的接口：
````java
    @Autowired UserService userService;
    /**
     * 用户登录
     * @param user
     * @param model
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public Result login(User user) {
        User u = userService.login(user);
        if(u.getPassword().equals(user.getPassword())){
            return ResultUtil.success();
        }
        return ResultUtil.error(2,"用户名或密码有误");
    }
````

## 参考博客
* [Spring Cloud构建微服务架构：服务消费（Feign）](http://blog.didispace.com/spring-cloud-starter-dalston-2-3/)
* [使用Spring Cloud Feign作为HTTP客户端调用远程HTTP服务](http://blog.csdn.net/neosmith/article/details/52449921)
