package com.bpf.controller;

import com.bpf.bean.Link;
import com.bpf.bean.Mark;
import com.bpf.bean.User;
import com.bpf.enums.ReasonEnum;
import com.bpf.result.BaseResult;
import com.bpf.service.LinkService;
import com.bpf.service.MarkService;
import com.bpf.service.UserService;
import com.bpf.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("link")
public class LinkController {

    @Autowired
    private LinkService linkService;

    @Autowired
    private UserService userService;

    @Autowired
    private MarkService markService;

    private static final String failedKey = "reason";

    private static final String successKey = "msg";

    @PostMapping("insert")
    @ResponseBody
    public BaseResult insertLink(Link link, Integer[] markIds, HttpServletRequest request) {
        UserVO userVO = (UserVO) request.getSession().getAttribute("user");
        if (userVO == null) {
            // 用户未登录
            return BaseResult.failed().addMsg(failedKey, ReasonEnum.NO_LOGIN.getMsg());
        }

        if (ObjectUtils.isEmpty(link.getName())) {
            // 标签名为空
            return BaseResult.failed().addMsg(failedKey, "标签名称为空");
        }

        if (ObjectUtils.isEmpty(link.getUrl())) {
            // 标签URL为空
            return BaseResult.failed().addMsg(failedKey, "标签URL为空");
        }

        link.setCreateTime(LocalDateTime.now());
        User user = userService.getUserById(userVO.getId());


        // 如果 markIds 为空，将链接添加到 未分类
        if (markIds == null || markIds.length == 0) {
            Mark unmark = markService.getMarkByNameAndUserId("未分类", userVO.getId());
            if (unmark == null) {
                // 若不存在 未分类，为用户新增分类
                unmark = new Mark();
                unmark.setName("未分类");
                user.getMarks().add(unmark);
                markService.insertMark(unmark);
            }

            user.getLinkList().add(link);
            link.getMarks().add(unmark);
            unmark.getLinkList().add(link);
            linkService.insertLink(link);
            user.setLinkCount((short) (user.getLinkList().size()));
            user.setMarkCount((short) (user.getMarks().size()));
            userService.insertUser(user);
        } else {
            Set<Mark> markSet = Arrays.stream(markIds)
                    .map(markId -> markService.getMarkById(markId))
                    .collect(Collectors.toSet());

            // 省略判断标签是否存在
            link.getMarks().addAll(markSet);
            linkService.insertLink(link);
            for (Mark mark : markSet) {
                mark.getLinkList().add(link);
                markService.insertMark(mark);
            }
            user.getLinkList().add(link);
            user.setLinkCount((short) (user.getLinkList().size()));
            userService.insertUser(user);
            linkService.insertLink(link);
        }
        BeanUtils.copyProperties(user, userVO);
        request.getSession().setAttribute("user", userVO);

        return BaseResult.ok().addMsg("msg", "添加成功");
    }

    /**
     * 删除所有标签内的同个ID链接
     * @param id
     * @param request
     * @return
     */
    @PostMapping("delete/{id}")
    @ResponseBody
    public BaseResult deleteLink(@PathVariable Integer id, HttpServletRequest request) {
        UserVO userVO = (UserVO) request.getSession().getAttribute("user");
        if (userVO == null) {
            // 用户未登录
            return BaseResult.failed().addMsg(failedKey, ReasonEnum.NO_LOGIN.getMsg());
        }

        if (id == null || id <= 0) {
            // 链接ID小于0
            return BaseResult.failed().addMsg(failedKey, "链接ID小于0");
        }

        User user = userService.getUserById(userVO.getId());
        Link link = linkService.getLinkById(id);

        link.getMarks().forEach(mark -> {
            // 此处使用 mark.getLinkList().remove(link) 一直失败！未知原因！
            mark.getLinkList().removeIf(markLink -> markLink.getId().equals(link.getId()));
            markService.insertMark(mark);
            userService.insertUser(user);
        });
        user.setLinkCount((short) (user.getLinkList().size() - 1));
        BeanUtils.copyProperties(user, userVO);
        request.getSession().setAttribute("user", userVO);
        linkService.deleteLinkById(link.getId());

        return BaseResult.ok().addMsg("msg", "删除成功");
    }

    /**
     * 删除指定标签内的ID链接
     * @param markId
     * @param id
     * @param request
     * @return
     */
    @PostMapping("delete/{markId}/{id}")
    @ResponseBody
    public BaseResult deleteLinkByMarkId(@PathVariable("markId") Integer markId,@PathVariable("id") Integer id, HttpServletRequest request) {
        UserVO userVO = (UserVO) request.getSession().getAttribute("user");
        if (userVO == null) {
            // 用户未登录
            return BaseResult.failed().addMsg(failedKey, ReasonEnum.NO_LOGIN.getMsg());
        }

        if (id == null || id <= 0) {
            // 链接ID小于0
            return BaseResult.failed().addMsg(failedKey, "链接ID小于0");
        }

        if (markId <= 0) {
            // 未指定标签
            return BaseResult.failed().addMsg(failedKey, "未指定标签");
        }

        User user = userService.getUserById(userVO.getId());
        Link link = linkService.getLinkById(id);

        link.getMarks().forEach(mark -> {
            if (mark.getId().equals(markId)) {
                mark.getLinkList().removeIf(markLink -> (markLink.getId().equals(link.getId())));
                markService.insertMark(mark);
                userService.insertUser(user);
            }
        });
        linkService.insertLink(link);
        user.setLinkCount((short) (user.getLinkList().size()));
        userService.updateUser(user);
        BeanUtils.copyProperties(user, userVO);
        request.getSession().setAttribute("user", userVO);

        if (link.getMarks().size() == 1) {
            user.setLinkCount((short) (user.getLinkList().size() - 1));
            // userService.updateUser(user);
            linkService.deleteLinkById(link.getId());
        }

        return BaseResult.ok().addMsg("msg", "删除成功");
    }

    @PostMapping("update")
    @ResponseBody
    public BaseResult updateLink(Link link, Integer[] markIds, HttpServletRequest request) {
        BaseResult failed = BaseResult.failed();
        Map<String, Object> map = new HashMap<>();

        UserVO userVO = (UserVO) request.getSession().getAttribute("user");
        if (userVO == null) {
            // 用户未登录
            return BaseResult.failed().addMsg(failedKey, ReasonEnum.NO_LOGIN.getMsg());
        }

        if (link == null || link.getId() == null || link.getId() <= 0 ) {
            return BaseResult.failed().addMsg("reason", "链接ID为空");
        }

        if (markIds == null || markIds.length == 0) {
            return BaseResult.failed().addMsg("reason", "链接没有指定分类");
        }

        Link old = linkService.getLinkById(link.getId());

        if (!ObjectUtils.isEmpty(link.getName())) {
            old.setName(link.getName());
        }
        if (!ObjectUtils.isEmpty(link.getUrl())) {
            old.setUrl(link.getUrl());
        }
        if (!ObjectUtils.isEmpty(link.getComment())) {
            old.setComment(link.getComment());
        }
        if (!ObjectUtils.isEmpty(link.getIcon())) {
            old.setIcon(link.getIcon());
        }

        User user = userService.getUserById(userVO.getId());
        Set<Mark> newMarks = Arrays.stream(markIds)
                .map(markId -> markService.getMarkById(markId))
                .collect(Collectors.toSet());

        // 省略判断标签是否存在

        // Set<Mark> oldMarks = link.getMarks();
        old.getMarks().clear();
        old.getMarks().addAll(newMarks);
        linkService.insertLink(old);

        // Set<Mark> allMarks = user.getMarks();
        // for (Mark mark : allMarks) {
        //     // 对于所有的分类，可能需要删除、添加、不操作link
        //
        //     // 如果旧标签中或新标签中不同时含有某个标签，则存在增删操作
        //     if (!oldMarks.contains(mark) || !newMarks.contains(mark)) {
        //         if (!oldMarks.contains(mark) && newMarks.contains(mark)) {
        //             // 旧标签中包含，但新标签中不包含，需要删除旧标签
        //
        //             mark.getLinkList().removeIf(markLink -> (markLink.getId().equals(link.getId())));
        //             markService.insertMark(mark);
        //             userService.insertUser(user);
        //             linkService.insertLink(link);
        //         }
        //     }

        //     mark.getLinkList().add(link);
        //     markService.insertMark(mark);
        // }


        // user.getLinkList().add(link);

        user.getMarks().forEach(mark -> {
            // 先删除所有标签中存在的link
            mark.getLinkList().removeIf(link1 -> link1.getId().equals(old.getId()));
            // 再将存在的link放回标签中
            if (newMarks.contains(mark)) {
                mark.getLinkList().add(old);
            }
            markService.insertMark(mark);
        });
        userService.insertUser(user);
        linkService.updateLink(old);

        return BaseResult.ok().addMsg("msg", "修改成功");
    }

    /**
     * com.fasterxml.jackson.databind.exc.InvalidDefinitionException: No serializer found for class
     * org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor and no properties discovered to create
     * BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS)
     * @param id
     * @return
     */
    @GetMapping("get/id/{id}")
    @ResponseBody
    public Link getLinkById(@PathVariable Integer id) {
        System.out.println("id = " + id);

        if (id == null || id <= 0) {
            return null;
        }

        System.out.println("id = " + id);

        return linkService.getLinkById(id);
    }

    @GetMapping("get/name/{name}")
    public String getLinksLikeName(@PathVariable String name, HttpServletRequest request, Model model) {
        UserVO userVO = (UserVO) request.getSession().getAttribute("user");
        if (userVO == null) {
            // 用户未登录
            return "user/login";
        }

        List<Link> linkList = null;

        if (ObjectUtils.isEmpty(name)) {
            linkList = userVO.getLinkList();
        } else {
            linkList = linkService.getLinksLikeName(name, userVO.getId());
        }

        model.addAttribute("linkList", linkList);

        return "link/result";
    }

    @GetMapping("get/url/{url}")
    @ResponseBody
    public List<Link> getLinksLikeUrl(@PathVariable String url, HttpServletRequest request) {
        UserVO userVO = (UserVO) request.getSession().getAttribute("user");
        if (userVO == null)
            return null;

        if (ObjectUtils.isEmpty(url))
            return null;

        return linkService.getLinksLikeUrl(url, userVO.getId());
    }

    @GetMapping("get/mark")
    public String selectLinkByMarks(Integer[] markIds, HttpServletRequest request, Model model) {
        UserVO userVO = (UserVO) request.getSession().getAttribute("user");
        if (userVO == null) {
            // 用户未登录
            return "user/login";
        }

        User user = userService.getUserById(userVO.getId());
        Set<Mark> markSet = null;
        Set<Link> linkSet = new HashSet<>();

        if (markIds == null || markIds.length == 0) {
            // 若没有传递标签ID，默认查询所有
            markSet = user.getMarks();
        } else {
            markSet = Arrays.stream(markIds)
                    .map(markId -> markService.getMarkById(markId))
                    .collect(Collectors.toSet());
        }

        for (Mark mark : markSet) {
            linkSet.addAll(mark.getLinkList());
        }

        List<Link> linkList = new ArrayList<>(linkSet);
        model.addAttribute("linkList", linkList);

        // 获取搜索的标签ID
        List<Integer> searchMarkIds = (markIds == null || markIds.length == 0) ? new ArrayList<>()
                : new ArrayList<>(Arrays.asList(markIds));
        model.addAttribute("search_mark_ids", searchMarkIds);

        return "link/result";
    }
}
