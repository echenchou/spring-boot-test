猿：EC

有问题可联系QQ604257080

## 1.前言
这是一个由spring boot搭建的web工程，目的是为spring boot初学者提供一个demo参考。

## 2.主要框架
* Spring Boot (1.3.3.RELEASE)
* Spring MVC
* Spring Data JPA

## 3.环境工具
* Eclipse 4.5+ 或 Idea 2016.2+
* Mysql 数据库 5.7
* Java 1.7

## 4.代码说明
这个工程的代码是一个小型系统里面抽取出来，所以有些**不必要**的工具类以及部分配置遗留，可自行忽略。
**工程中没有Freemaker、Thymeleaf之类的模板页面，后续会补充。**

下面列出比较关键的文件：
* ec.boot.Application *启动类*
* ec.boot.GlobalInterceptor *拦截器*
* ec.boot.ServletInitializer *Servlet容器初始化类，打war包必须*
* application.properties *配置文件*