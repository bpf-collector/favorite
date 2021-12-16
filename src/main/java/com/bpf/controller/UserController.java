package com.bpf.controller;

import com.bpf.bean.User;
import com.bpf.enums.ReasonEnum;
import com.bpf.result.BaseResult;
import com.bpf.service.UserService;
import com.bpf.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    private static final String failedKey = "reason";

    private static final String successKey = "msg";

    /**
     * 新增用户 POST
     * @return
     */
    @PostMapping("insert")
    @ResponseBody
    public BaseResult insertUser(User user) {
        if (user == null) {
            // 用户未登录
            return BaseResult.failed().addMsg(failedKey, ReasonEnum.NO_LOGIN.getMsg());
        }

        // 判断用户名是否已存在
        if (userService.isUserNameExists(user.getName())) {
            // 用户名已存在
            return BaseResult.failed().addMsg(failedKey, ReasonEnum.NAME_EXISTS.getMsg());
        }

        if (ObjectUtils.isEmpty(user.getPassword())) {
            // 密码不能为空
            return BaseResult.failed().addMsg(failedKey, ReasonEnum.NO_PASSWORD.getMsg());
        }

        return userService.insertUser(user)!=null ? BaseResult.ok().addMsg(successKey, "添加成功") :
                BaseResult.failed().addMsg(failedKey, "添加失败");
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @PostMapping("delete/{id}")
    @ResponseBody
    public BaseResult deleteUser(@PathVariable Integer id) {
        if (id == null || id <= 0) {
            // 用户ID不能为空
            return BaseResult.failed().addMsg(failedKey, ReasonEnum.NO_USER.getMsg());
        }

        return userService.deleteUser(id) ? BaseResult.ok().addMsg(successKey, "删除成功") :
                BaseResult.failed().addMsg(failedKey, "删除失败");
    }

    /**
     * 修改密码
     * @param name
     * @param password
     * @return
     */
    @PostMapping("update")
    @ResponseBody
    public BaseResult updatePassword(String name, String password) {
        if (ObjectUtils.isEmpty(password)) {
            // 用户名不能为空
            return BaseResult.failed().addMsg(failedKey, ReasonEnum.NO_NAME.getMsg());
        }

        if (ObjectUtils.isEmpty(password)) {
            // 密码不能为空
            return BaseResult.failed().addMsg(failedKey, ReasonEnum.NO_PASSWORD.getMsg());
        }

        try {
            User user = userService.getUserByName(name);
            if (user != null) {
                userService.updatePasswordById(user.getId(), password);
                return BaseResult.ok().addMsg("msg", "密码更新成功");
            }
        } catch (EntityNotFoundException e) {
            return BaseResult.failed().addMsg(failedKey, ReasonEnum.ID_NOT_EXISTS.getMsg());
        }

        return BaseResult.failed().addMsg("reason", "密码更新失败");
    }

    /**
     * 查询用户
     * @param id
     * @return
     */
    @GetMapping("get_json/{id}")
    @ResponseBody
    public UserVO selectUser(@PathVariable Integer id, HttpServletRequest request) {
        UserVO userVO = new UserVO();
        User user = null;
        try {
            user = userService.getUserById(id);
        } catch (EntityNotFoundException e) {
            // 用户ID不存在
            return null;
        }
        BeanUtils.copyProperties(user, userVO);

        request.getSession().setAttribute("user", userVO);
        return userVO;
    }

    /**
     * 查询用户
     * @param id
     * @return
     */
    @GetMapping("get/{id}")
    public String selectUser(@PathVariable Integer id, String target, HttpServletRequest request) {
        UserVO userVO = new UserVO();
        User user = null;
        try {
            user = userService.getUserById(id);
        } catch (EntityNotFoundException e) {
            // 用户ID不存在
            // return null;
        }
        BeanUtils.copyProperties(user, userVO);

        request.getSession().setAttribute("user", userVO);
        // return userVO;
        return ObjectUtils.isEmpty(target) ? "mark/list" : target;
    }

    /**
     * 用户登录
     * @return
     */
    @PostMapping("login")
    @ResponseBody
    public BaseResult login(String name, String password, HttpServletRequest request) {
        UserVO userVO = (UserVO) request.getSession().getAttribute("user");
        if (userVO != null) {
            // 用户已登录
            return BaseResult.failed().addMsg(successKey, "用户已登录");
        }

        if (ObjectUtils.isEmpty(name)) {
            // 用户名不能为空
            return BaseResult.failed().addMsg(failedKey, ReasonEnum.NO_NAME.getMsg());
        } else if (ObjectUtils.isEmpty(password)) {
            // 密码不能为空
            return BaseResult.failed().addMsg(failedKey, ReasonEnum.NO_PASSWORD.getMsg());
        }

        User user = null;
        if (userService.isUserNameExists(name)) {
            user = userService.login(name, password);
            if (user == null) {
                // 密码错误
                return BaseResult.failed().addMsg(failedKey, "密码错误");
            } else {
                // 将用户信息存放在Session中
                userVO = new UserVO();
                BeanUtils.copyProperties(user, userVO);
                request.getSession().setAttribute("user", userVO);
                return BaseResult.ok().addMsg(successKey, "登录成功");
            }
        }

        return BaseResult.failed().addMsg(failedKey, "您还没注册，请注册后再登录");
    }

    /**
     * 用户登出
     * @return
     */
    @RequestMapping("logout")
    @ResponseBody
    public BaseResult logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return BaseResult.ok().addMsg("msg", "登出成功");
    }
}
