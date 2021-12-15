package com.bpf.interceptor;

import com.bpf.enums.ReasonEnum;
import com.bpf.result.BaseResult;
import com.bpf.utils.JsonUtil;
import com.bpf.vo.UserVO;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Component
public class MarkInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        BaseResult failed = BaseResult.failed();
        Map<String, Object> map = new HashMap<>();

        UserVO userVO = (UserVO) request.getSession().getAttribute("user");
        if (userVO == null || userVO.getId() == null) {
            map.put("reason", ReasonEnum.NO_LOGIN.getMsg());
            failed.setExt(map);
            response.setCharacterEncoding("UTF-8");
            // response.setContentType("application/json;charset=UTF-8");
            // response.getWriter().write(JsonUtil.object2JsonStr(failed));
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }

        return true;
    }
}
