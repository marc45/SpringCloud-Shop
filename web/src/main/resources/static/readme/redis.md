# Redis 在Windows环境下的安装

## 安装步骤
- 1、下载安装包：https://github.com/MSOpenTech/redis/releases
![](https://github.com/suxiongwei/keda/blob/master/web/src/main/resources/static/img/readme/download.png)
- 2、下载压缩包到 C 盘，解压后，将文件夹重新命名为 redis。</br>
打开一个 cmd 窗口 使用cd命令切换目录到 C:\redis 运行 **redis-server.exe redis.windows.conf** 输入之后，会显示如下界面：
![](https://github.com/suxiongwei/keda/blob/master/web/src/main/resources/static/img/readme/redis_start.png)    
- 3、另启一个cmd窗口，原来的不要关闭，不然就无法访问服务端了。切换到redis目录下运行 **redis-cli.exe -h 127.0.0.1 -p 6379** 
- 4、安装完成。
             
             
