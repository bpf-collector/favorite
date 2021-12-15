package com.bpf.controller;

import com.bpf.bean.Link;
import com.bpf.bean.Mark;
import com.bpf.service.LinkService;
import com.bpf.service.MarkService;
import com.bpf.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PageController {

    @Autowired
    private MarkService markService;

    @Autowired
    private LinkService linkService;

    @GetMapping("{page}")
    public String page(@PathVariable String page) {
        return page;
    }

    @GetMapping("login")
    public String login() {
        return "user/login";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    // 右侧侧边栏
    @GetMapping("lay_right")
    public String indexRight() {
        return "layout/layouts-right";
    }

    // 重置密码
    @GetMapping("/user/reset")
    public String resetPassword() {
        return "user/reset_password";
    }

    // 个人信息
    @GetMapping("/user/profile")
    public String profile() {
        return "user/profile";
    }

    // 添加标签
    @GetMapping("/mark/add")
    public String addMark() {
        return "mark/add";
    }

    // 修改标签
    @GetMapping("/mark/update/{id}")
    public String editMark(@PathVariable Integer id, HttpServletRequest request, Model model) {
        UserVO userVO = (UserVO) request.getSession().getAttribute("user");
        if (userVO == null || userVO.getId() == null) {
            // 未登录
            return "user/login";
        }

        // 通过ID查找标签
        Mark mark = markService.getMarkById(id);
        // 判断标签是否属于这个用户
        mark = markService.getMarkByNameAndUserId(mark.getName(), userVO.getId());
        model.addAttribute("mark", mark);

        return "mark/edit";
    }

    // 修改链接
    @GetMapping("/link/update/{id}")
    public String editLink(@PathVariable Integer id, HttpServletRequest request, Model model) {
        UserVO userVO = (UserVO) request.getSession().getAttribute("user");
        if (userVO == null || userVO.getId() == null) {
            // 未登录
            return "user/login";
        }

        Link link = linkService.getLinkById(id);
        link = linkService.getLinkByName(link.getName(), userVO.getId());
        model.addAttribute("link", link);

        // 获取这个链接的所有标签ID
        List<Integer> linkMarkIDs = link.getMarks().stream().map(Mark::getId).collect(Collectors.toList());
        model.addAttribute("link_mark_ids", linkMarkIDs);

        return "link/edit";
    }

    // 多选标签查询链接
    @GetMapping("link/search")
    public String searchLink(HttpServletRequest request, Model model) {
        UserVO userVO = (UserVO) request.getSession().getAttribute("user");
        if (userVO == null || userVO.getId() == null) {
            // 未登录
            return "user/login";
        }

        return "mark/search";
    }
}
