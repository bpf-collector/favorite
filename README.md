## 项目构思

+ 数据库设计
+ 项目结构: 单体应用(小型化)
+ 配置文件: `application-dev.yml`

## 用户模块部分

```java
@DynamicInsert
@Entity
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 32)
    private String name;
    @Column(length = 32)
    private String password;
    @Column(columnDefinition = "char(8) default 'v39a470m'")
    private String salt;

    private LocalDateTime createTime;
}
```

### 模块包结构

+ utils
  - MD5加密工具类
  - Json转换工具类
+ dao: 使用 Spring Data JPA
+ service
+ controller
+ enum: 常用的枚举类
  - 返回结果代码枚举类
  - 错误原因枚举类
  - 用户权限枚举类
+ interceptor: 拦截器
  - 用户删除拦截器
  - 用户更新拦截器
+ result
  - 基本的返回类型
+ vo
  - 前端返回对象

> 用户模块基本能够实现 增、删、改、查、登录、登出功能，并且在删除和更新之前使用**拦截器**进行权限拦截，具有一定的安全性和可拓展性。

### 接口

| URL | ReqMe | Method |
| ---- | ---- | ---- |
| `/user/insert` | `POST` | `BaseResult insertUser(User user)` |
| `/user/delete/{id}` | `POST` | `BaseResult deleteUser(Integer id)` |
| `/user/update/{id}` | `POST` | `BaseResult updatePassword(Integer id, String password)` |
| `/user/get/{id}` | `POST` | `UserVO selectUser(Integer id)` |
| `/user/login` | `POST` | `BaseResult login(String name, String password)` |
| `/user/logout` | `POST` | `BaseResult logout()` |

### 遇到的问题

#### 懒加载

```shell script
org.hibernate.LazyInitializationException: could not initialize proxy [com.bpf.bean.User#6] - no Session
```

```yaml
# 解决方法
# https://blog.csdn.net/y_bccl27/article/details/116425789
spring:
  jpa:
    properties:
      hibernate:
        enable_lazy_load_no_trans: true
```

#### JPA 选择性插入字段

在 Bean 类上使用注解`@DynamicInsert`，当插入的时候会自动过滤null的字段。

