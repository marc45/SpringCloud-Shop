## 集成redis做缓存
>在集群模式下时，各应用服务器之间的缓存都是独立的，因此在不同服务器的进程间会存在缓存不一致的情况在一些要求高一致性（任何数据变化都能及时的被查询到）
的系统和应用中使用集中式缓存是个不错的选择。

### 集成步骤：
* 在pom.xml中引入cache依赖
````xml
    <!--引入cache依赖-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-cache</artifactId>
    </dependency>
    <!--引入redis依赖-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-redis</artifactId>
    </dependency>
````
* 在Spring Boot主类中增加@EnableCaching注解开启缓存功能
````java
    @SpringBootApplication
    @EnableEurekaClient
    @EnableCaching
    public class UserApplication {
    	public static void main(String[] args) {
    		SpringApplication.run(UserApplication.class, args);
    	}
    }
````
* 在数据访问接口中，增加缓存配置注解，如：
````java
    @CacheConfig(cacheNames = "users")
    public interface UserRepository extends JpaRepository<User,Long>{
    
        @Cacheable(key = "#p0")
        User findByName(String name);
    
        @CachePut(key = "#p0.name")
        User save(User user);
    }
````

* 集成完成

### 建立测试类进行测试
````java
    @RunWith(SpringRunner.class)
    @SpringBootTest
    public class RedisCacheTests {
        @Autowired
        private UserRepository userRepository;
    
        @Before
        public void before() {
            userRepository.save(new User("AAA","123456","18361246696"));
        }
    
        @Test
        public void test() throws Exception {
            User u1 = userRepository.findByName("AAA");
            System.out.println("第一次查询：" +u1.getPhone());
    
            User u2 = userRepository.findByName("AAA");
            System.out.println("第二次查询：" + u2.getPhone());
        }
    
    }
````
### 集成前测试结果:
    Hibernate: insert into `user` (`address`, `name`, `password`, `phone`) values (?, ?, ?, ?)
    2018-01-19 13:55:45.418  INFO 25848 --- [           main] o.h.h.i.QueryTranslatorFactoryInitiator  : HHH000397: Using ASTQueryTranslatorFactory
    Hibernate: select user0_.`id` as id1_0_, user0_.`address` as address2_0_, user0_.`name` as name3_0_, user0_.`password` as password4_0_, user0_.`phone` as phone5_0_ from `user` user0_ where user0_.`name`=?
    第一次查询：18361246696
    Hibernate: select user0_.`id` as id1_0_, user0_.`address` as address2_0_, user0_.`name` as name3_0_, user0_.`password` as password4_0_, user0_.`phone` as phone5_0_ from `user` user0_ where user0_.`name`=?
    第二次查询：18361246696
### 集成后测试结果:
    Hibernate: insert into `user` (`address`, `name`, `password`, `phone`) values (?, ?, ?, ?)
    第一次查询：18361246696
    第二次查询：18361246696

    通过结果分析可知 在调用save方法时，就已经将这条数据加入了redis缓存中
