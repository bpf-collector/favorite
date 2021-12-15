package com.bpf.service.impl;

import com.bpf.bean.User;
import com.bpf.dao.UserDao;
import com.bpf.enums.AuthorityEnum;
import com.bpf.service.UserService;
import com.bpf.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 新增用户
     *   1. 保证用户名唯一！
     *   2. 密码通过 MD5设置
     * @param user
     * @return
     */
    @Override
    public User insertUser(User user) {
        if (user == null)
            // 用户为空
            return null;

        // 判断用户名是否已存在
        if (isUserNameExists(user.getName()))
            // 用户名已存在
            return null;

        if (ObjectUtils.isEmpty(user.getPassword()))
            // 密码不能为空
            return null;

        String salt = UUID.randomUUID().toString().substring(0, 8);
        user.setSalt(salt);

        user.setPassword(MD5Utils.getMd5WithSalt(user.getPassword(), salt));
        user.setCreateTime(LocalDateTime.now());
        user.setAuthority(AuthorityEnum.COMMON.getAuth());
        user.setMarkCount((short) 0);
        user.setLinkCount((short) 0);

        return userDao.saveAndFlush(user);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        if (id == null || id <= 0)
            return null;

        return userDao.getById(id);
    }

    @Override
    public User getUserByName(String name) {
        if (ObjectUtils.isEmpty(name))
            return null;

        List<User> userList = userDao.findUserByName(name);
        if (userList != null && userList.size() == 1) {
            return userList.get(0);
        }

        return null;
    }

    @Override
    public User updatePasswordById(Integer id, String password) {
        if (id == null || id <= 0)
            return null;

        if (ObjectUtils.isEmpty(password))
            return null;


        User user = user = userDao.getById(id);
        user.setPassword(MD5Utils.getMd5WithSalt(password, user.getSalt()));

        return userDao.save(user);
    }

    @Override
    public User updateUser(User user) {
        if (user.getId() == null || user.getId() <= 0)
            return null;

        return userDao.saveAndFlush(user);
    }

    @Override
    public boolean isUserNameExists(String name) {
        List<User> userList = userDao.findUserByName(name);
        return !CollectionUtils.isEmpty(userList);
    }

    @Override
    public boolean deleteUser(Integer id) {
        if (id == null || id <= 0)
            return false;

        userDao.deleteById(id);
        return true;
    }

    @Override
    public User login(String name, String password) {

        List<User> userList = userDao.findUserByName(name);
        if (CollectionUtils.isEmpty(userList) || userList.size() > 1)
            return null;

        User user = userList.get(0);
        if (MD5Utils.getMd5WithSalt(password, user.getSalt()).equals(user.getPassword())) {
            return user;
        }

        return null;
    }
}
