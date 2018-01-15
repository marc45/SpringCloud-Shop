# Spring Boot中的事务管理

## 基础概念
事务的作用就是为了保证用户的每一个操作都是可靠的，事务中的每一步操作都必须成功执行，
只要有发生异常就回退到事务开始未进行操作的状态。</br>

在Spring Boot中，当我们使用了spring-boot-starter-jdbc或spring-boot-starter-data-jpa
依赖的时候，框架会自动默认分别注入DataSourceTransactionManager或JpaTransactionManager。
所以我们不需要任何额外配置就可以用`@Transactional`注解进行事务的使用。</br>

真正在开发业务逻辑时，我们通常在controller层接口中使用`@Transactional`来对各个业务逻辑进行事务管理的配置。</br>
例如:</br>
```java
     /**
     * 测试事务
     * @return
     */
    @RequestMapping("/test/testTransactional")
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public String testTransactional(){
        // 创建3条记录
        userService.save(new User("AAA", "123456"));
        //name长度不能超过5位，会抛出异常，来测试事务是否会回滚
        userService.save(new User("测试测试测试测试", "123456"));
        userService.save(new User("BBB", "123456"));
        return "成功";
    }
```
参见user-service服务 package com.kedacom.user.api 下的testTransactional方法</br>

## 事务详解
上面我们使用了默认的事务配置，可以满足一些基本的事务需求，但是当我们项目较大较复杂时（比如，有多个数据源等），这时候需要在声明事务时，指定不同的事务管理器。
在声明事务时，只需要通过value属性指定配置的事务管理器名即可，例如：`@Transactional(value="transactionManagerPrimary")`。

### 隔离级别
隔离级别是指若干个并发的事务之间的隔离程度，与我们开发时候主要相关的场景包括：脏读取、重复读、幻读。
* DEFAULT：这是默认值，表示使用底层数据库的默认隔离级别。对大部分数据库而言，通常这值就是：READ_COMMITTED。
* READ_UNCOMMITTED：该隔离级别表示一个事务可以读取另一个事务修改但还没有提交的数据。该级别不能防止脏读和不可重复读，因此很少使用该隔离级别。
* READ_COMMITTED：该隔离级别表示一个事务只能读取另一个事务已经提交的数据。该级别可以防止脏读，这也是大多数情况下的推荐值。
* REPEATABLE_READ：该隔离级别表示一个事务在整个过程中可以多次重复执行某个查询，并且每次返回的记录都相同。即使在多次查询之间有新增的数据满足该查询，这些新增的记录也会被忽略。该级别可以防止脏读和不可重复读。
* SERIALIZABLE：所有的事务依次逐个执行，这样事务之间就完全不可能产生干扰，也就是说，该级别可以防止脏读、不可重复读以及幻读。但是这将严重影响程序的性能。通常情况下也不会用到该级别。

通过使用isolation属性设置</br>
```java
@Transactional(isolation = Isolation.DEFAULT)
```
### 传播行为
所谓事务的传播行为是指，如果在开始当前事务之前，一个事务上下文已经存在，此时有若干选项可以指定一个事务性方法的执行行为。
* REQUIRED：如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。
* SUPPORTS：如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务的方式继续运行。
* MANDATORY：如果当前存在事务，则加入该事务；如果当前没有事务，则抛出异常。
* REQUIRES_NEW：创建一个新的事务，如果当前存在事务，则把当前事务挂起。
* NOT_SUPPORTED：以非事务方式运行，如果当前存在事务，则把当前事务挂起。
* NEVER：以非事务方式运行，如果当前存在事务，则抛出异常。
* NESTED：如果当前存在事务，则创建一个事务作为当前事务的嵌套事务来运行；如果当前没有事务，则该取值等价于REQUIRED。

使用propagation属性设置</br>
```java
@Transactional(propagation = Propagation.REQUIRED)
```
## 其它
* service类标签(或接口,一般**不建议**)上添加@Transactional，将整个类纳入spring事务管理；每个业务方法执行时都会开启一个事务，不过这些事务采用相同的管理方式。
* @Transactional 注解只能应用到 **public** 可见度的方法上。 
## 参考博客
- [Spring Boot中的事务管理](http://blog.didispace.com/springboottransactional/)

