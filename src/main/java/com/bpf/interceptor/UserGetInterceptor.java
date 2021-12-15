package com.bpf.interceptor;

import com.bpf.bean.User;
import com.bpf.enums.AuthorityEnum;
import com.bpf.enums.ReasonEnum;
import com.bpf.result.BaseResult;
import com.bpf.service.UserService;
import com.bpf.utils.JsonUtil;
import com.bpf.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 拦截 /user/update/{id}?password=xxx
 *    权限是管理员 或 权限是普通用户，但只能修改自己的
 *
 */
@Component
public class UserGetInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        BaseResult failed = BaseResult.failed();
        Map<String, Object> map = new HashMap<>();

        // 验证是否登录
        UserVO userVO = (UserVO) request.getSession().getAttribute("user");
        if (userVO == null || userVO.getId() == null) {
            map.put("reason", ReasonEnum.NO_LOGIN.getMsg());
            failed.setExt(map);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=UTF-8");
            // response.getWriter().write(JsonUtil.object2JsonStr(failed));
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }

        if ("GET".equalsIgnoreCase(request.getMethod())) {
            // 判断当前用户是否是 管理员
            User user = userService.getUserById(userVO.getId());
            if (user.getAuthority().equals(AuthorityEnum.ADMINISTRATOR.getAuth())) {
                return true;
            } else if (user.getAuthority().equals(AuthorityEnum.COMMON.getAuth())) {
                // 如果是普通用户，验证ID是否相同(即修改自己的密码)
                String[] split = request.getRequestURI().split("/");
                if (split != null && split.length > 0) {
                    Integer userId = Integer.parseInt(split[split.length - 1]);
                    if (user.getId().equals(userId)) {
                        return true;
                    }
                }
            }
        }

        map.put("reason", ReasonEnum.NO_AUTH.getMsg());
        failed.setExt(map);
        response.getWriter().write(JsonUtil.object2JsonStr(failed));

        return false;
    }
}
