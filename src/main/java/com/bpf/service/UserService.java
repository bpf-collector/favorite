package com.bpf.service;

import com.bpf.bean.User;

import java.util.List;

public interface UserService {

    // 新增用户
    User insertUser(User user);

    // 列出所有用户
    List<User> getAllUser();

    // 通过ID查找用户
    User getUserById(Integer id);

    // 同通过用户名查找用户
    User getUserByName(String name);

    // 修改用户密码
    User updatePasswordById(Integer id, String password);

    // 更新用户信息
    User updateUser(User user);

    // 判断用户名是否存在
    boolean isUserNameExists(String name);

    // 删除用户
    boolean deleteUser(Integer id);

    // 用户登录
    User login(String name, String password);
}
