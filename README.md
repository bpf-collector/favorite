### 项目名称: 网站收藏夹

### 项目描述

&emsp;&emsp;本项目是基于**标签分类**的网站收藏夹，与浏览器中的收藏夹功能类似，但本项目是基于标签分类而非目录层级。

&emsp;&emsp;每个网站链接 `Link` 和 标签 `Mark` 按照用户隔离，不同用户之间相互不影响。

### 工具与技术

+ 语言： Java 1.8
+ IDE： IDEA 2020.2.2
+ 数据库： MySQL 5.7
+ 项目技术： Spring Boot、 Spring Data JPA
+ 前端模板： Bootstrap
+ 前端模板引擎： Freemarker

### 项目功能

+ 用户: 登录、注册、重置密码、个人信息

<div style="text-align: center">
    <img style="width: 700px" title="用户登录" src="https://img2020.cnblogs.com/blog/1623101/202112/1623101-20211216131220366-606227340.jpg">
    <img style="width: 700px" title="个人信息" src="https://img2020.cnblogs.com/blog/1623101/202112/1623101-20211216131340643-582233017.jpg">
</div>

+ 标签: 添加、删除、修改、根据一个或多个标签查询链接

<div style="text-align: center">
    <img style="width: 700px" title="添加标签" src="https://img2020.cnblogs.com/blog/1623101/202112/1623101-20211216131257656-1227908583.jpg">
    <img style="width: 700px" title="所有标签" src="https://img2020.cnblogs.com/blog/1623101/202112/1623101-20211216131401975-129998285.jpg">
</div>

+ 链接: 添加、删除、修改、根据链接名称模糊查询链接

<div style="text-align: center">
    <img style="width: 700px" title="添加链接" src="https://img2020.cnblogs.com/blog/1623101/202112/1623101-20211216131432915-2128348065.jpg">
    <img style="width: 700px" title="所有链接" src="https://img2020.cnblogs.com/blog/1623101/202112/1623101-20211216131446889-2007136819.jpg">
    <img style="width: 700px" title="选择查询的标签" src="https://img2020.cnblogs.com/blog/1623101/202112/1623101-20211216131540158-1884934246.jpg">
    <img style="width: 700px" title="查询链接" src="https://img2020.cnblogs.com/blog/1623101/202112/1623101-20211216131500079-1295122117.jpg">
</div>

### 下版本可提升

+ 使用缓存
+ 用户权限之管理员功能
+ 用户头像设置
