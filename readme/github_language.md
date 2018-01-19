## 修改github上仓库的项目语言
github 是根据项目里文件数目最多的文件类型,识别项目类型。明明是一个Java项目，却被标记为css。
### 解决方案
在项目根目录添加 .gitattributes 文件, 内容如下 :
````xml
    *.js linguist-language=java
    *.css linguist-language=java
    *.html linguist-language=java
````
此时刷新即可看到项目已经被标记为Java
