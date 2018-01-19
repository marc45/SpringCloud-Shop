## 基于ACCESS TOKEN的权限解决方案
REST 设计原则是statelessness的，而且但客户端是APP时，从APP发起的请求，不是基于bowers，无法带相同的sessionid，所以比较好的方案是每次请求
都带一个accesstoken进行验证。然后后台是根据token 找到用户，然后找到用户资源
网站应用一般使用Session进行登录用户信息的存储及验证，而在移动端使用Token则更加普遍。它们之间并没有太大区别，Token比较像是一个更加精简的自定义
的Session。Session的主要功能是保持会话信息，而Token则只用于登录用户的身份鉴权。所以在移动端使用Token会比使用Session更加简易并且有更高的安
全性，同时也更加符合RESTful中无状态的定义。
### 交互流程
- 客户端通过登录请求提交用户名和密码，服务端验证通过后生成一个Token与该用户进行关联，并将Token返回给客户端。
- 客户端在接下来的请求中都会携带Token，服务端通过解析Token检查登录状态。
- 当用户退出登录、其他终端登录同一账号（被顶号）、长时间未进行操作时Token会失效，这时用户需要重新登录。
### Cookie认证机制
Cookie认证机制就是为一次请求认证在服务端创建一个**Session对象**，同时在客户端的浏览器端创建了一个**Cookie对象**；通过客户端带上来Cookie对象来与服务
器端的session对象**匹配**来实现状态管理的。默认的，当我们关闭浏览器的时候，**cookie会被删除**。但可以通过修改cookie 的expire time使cookie在一定时
间内有效；

### Token机制优点
* 支持跨域访问: Cookie是不允许垮域访问的，这一点对Token机制是不存在的，前提是传输的用户认证信息通过**HTTP头传输**.
* 无状态(也称：服务端可扩展行):Token机制在服务端不需要存储session信息，因为Token 自身包含了所有登录用户的信息，只需要在客户端的cookie或本地介质存储状态信息.
* 更适用CDN: 可以通过内容分发网络请求你服务端的所有资料（如：javascript，HTML,图片等），而你的服务端只要提供API即可.
* 去耦: 不需要绑定到一个特定的身份验证方案。Token可以在任何地方生成，只要在你的API被调用的时候，你可以进行Token生成调用即可.
* 更适用于移动应用: 当你的客户端是一个原生平台（iOS, Android，Windows 8等）时，**Cookie是不被支持的**（你需要通过Cookie容器进行处理），这时采用Token认证机制就会简单得多。
* CSRF:因为不再依赖于Cookie，所以你就不需要考虑对CSRF（跨站请求伪造）的防范。
* 性能: 一次网络往返时间（通过数据库查询session信息）总比做一次HMACSHA256计算 的Token验证和解析要费时得多.
* 不需要为登录页面做特殊处理: 如果你使用Protractor 做功能测试的时候，不再需要为登录页面做特殊处理.
* 基于标准化:你的API可以采用标准化的 JSON Web Token (JWT). 这个标准已经存在多个后端库（.NET, Ruby, Java,Python, PHP）和多家公司的支持（如：Firebase,Google, Microsoft）.

### 参考博客
* [基于Token的WEB后台认证机制](https://www.cnblogs.com/xiekeli/p/5607107.html)
