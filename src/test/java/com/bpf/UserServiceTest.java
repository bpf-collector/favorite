package com.bpf;

import com.bpf.bean.User;
import com.bpf.service.UserService;
import com.bpf.utils.MD5Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setName("Tim");
        user.setPassword("123456");
        user.setCreateTime(LocalDateTime.now());
        System.out.println(user);

        userService.insertUser(user);

        System.out.println(user);
    }

    @Test
    public void testSelectAllUser() {
        List<User> userList = userService.getAllUser();
        userList.forEach(System.out::println);
    }

    @Test
    public void testUpdatePassword() {
        /**
         * 出现问题:
         *    org.hibernate.LazyInitializationException: could not initialize proxy [com.bpf.bean.User#6] - no Session
         * 解决: 开启懒加载
         *    https://blog.csdn.net/y_bccl27/article/details/116425789
         *    {@Code spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true}
         */
        User user = userService.updatePasswordById(6, "aksocl");

        System.out.println(user);

        System.out.println("New password: "+ MD5Utils.getMd5WithSalt("aksocl", user.getSalt()));
    }

    @Test
    public void testUserExist() {
        System.out.println(userService.isUserNameExists("Tom"));
        System.out.println(userService.isUserNameExists("tim"));
        System.out.println(userService.isUserNameExists("Marry"));
        System.out.println(userService.isUserNameExists("merry"));
    }

    @Test
    public void testLogin() {
        User user = userService.login("tim", "123456");
        System.out.println(user);
    }
}
