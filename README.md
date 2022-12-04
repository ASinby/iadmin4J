# 一、工程简介

+ RH模型后台数据接口

# 二、延伸阅读

+ 接口类型采用常用的RESTful风格
```text
1. GET（SELECT）：从服务器取出资源（一项或多项）；

2. POST（CREATE）：在服务器新建一个资源；

3. PUT（UPDATE）：在服务器更新资源（客户端提供改变后的完整资源）；

4. PATCH（UPDATE）：在服务器更新资源（客户端提供改变的属性）；

5. DELETE（DELETE）：从服务器删除资源；

6. HEAD：获取资源的元数据；

7. OPTIONS：获取信息，关于资源的哪些属性是客户端可以改变的。
```

+ 加入Swagger，可通过 [SwaggerUI](http://localhost:8088/iadmin4J/swagger-ui.html) 查看接口信息

# 三、开发笔记

## 3.1 注解作用
+ **@JsonFormat**   `格式化从后台向前台传递日期值` 
+ **@DateTimeFormat**   `格式化接收从页面传到后台的日期值` 
