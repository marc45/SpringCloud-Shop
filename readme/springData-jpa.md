# SpringData-JPA的集成
## 什么是JPA？
> JPA(Java Persistence API)是Sun官方提出的Java持久化规范。它为Java开发人员提供了一种对象/关联映射工具来管理Java应用中的关系数据。
它的出现主要是为了简化现有的持久化开发工作和整合ORM技术
JPA是一套规范，不是一套产品。Hibernate是一套产品，如果这些产品实现了JPA规范，那么我们可以叫它们为JPA的实现产品。
## 查询语言（JPQL）
> 通过面向对象而非面向数据库的查询语言查询数据，避免程序的SQL语句紧密耦合。
## 什么是Spring data jpa?
> Spring data jpa是在JPA规范下提供了Repository层的实现，但是使用哪一种ORM需要你来决定。虽然ORM框架都实现了JPA规范，但是在不同的ORM
框架之间切换仍然需要编写不同的代码，而通过使用Spring data jpa能够方便大家在不同的ORM框架之间进行切换而不要更改代码。
并且spring data jpa 对Repository层封装的很好，也省去了不少的麻烦。

## 集成步骤
* pom.xml中添加依赖(以MySql数据库为例)：
````xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>
```` 
* application.xml中配置数据库连接信息,自动创建表结构设置
```xml
    spring.datasource.url=jdbc:mysql://localhost:3306/dbkeda?useUnicode=true&characterEncoding=UTF-8&sessionVariables=FOREIGN_KEY_CHECKS=0&autoReconnect=true
    spring.datasource.username=root
    spring.datasource.password=root
    
    spring.jpa.properties.hibernate.hbm2ddl.auto=update
    spring.jpa.properties.hibernate.globally_quoted_identifiers=true
    spring.jpa.open-in-view=false
```
* 创建domain
````java
    @Entity
    public class User implements Serializable {
    
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    
        @Column(name = "name",length = 5)
        private String name;
    
        @Column(name = "password")
        private String password;
    
        @Column(name = "phone")
        private String phone;
    
        @Column(name = "address")
        private String address;
        //省略构造方法及set/get方法
    }
````
* 创建数据访问接口
    > 对数据访问,只需继承Spring-data-jpa提供的接口(这里以JpaRepository为例)即可完成对数据的访问
````java
    public interface UserRepository extends JpaRepository<User,Long>{
        User findByName(String name);
    }
````
* 集成完成，建立测试类可对其进行测试
