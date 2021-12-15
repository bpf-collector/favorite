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
 * 拦截 /user/delete/{id}
 *    权限必须是 管理员
 */
@Component
public class UserDeleteInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        BaseResult failed = BaseResult.failed();
        Map<String, Object> map = new HashMap<>();
        response.setCharacterEncoding("UTF-8");
        // response.setContentType("application/json;charset=UTF-8");

        // 验证是否登录
        UserVO userVO = (UserVO) request.getSession().getAttribute("user");
        if (userVO == null || userVO.getId() == null) {
            map.put("reason", ReasonEnum.NO_LOGIN.getMsg());
            failed.setExt(map);
            // response.getWriter().write(JsonUtil.object2JsonStr(failed));
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }

        if ("POST".equalsIgnoreCase(request.getMethod())) {
            // 判断当前用户是否是 管理员
            User user = userService.getUserById(userVO.getId());
            if (user.getAuthority().equals(AuthorityEnum.ADMINISTRATOR.getAuth())) {
                return true;
            } else {
                map.put("reason", ReasonEnum.NO_AUTH.getMsg());
                failed.setExt(map);
                response.getWriter().write(JsonUtil.object2JsonStr(failed));
            }
        }

        return false;
    }
}
