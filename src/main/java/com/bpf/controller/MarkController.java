package com.bpf.controller;

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
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("mark")
public class MarkController {

    @Autowired
    private MarkService markService;

    @Autowired
    private UserService userService;

    @Autowired
    private LinkService linkService;

    private static final String failedKey = "reason";

    private static final String successKey = "msg";

    /**
     * 新增标签
     * @param mark
     * @return
     */
    @PostMapping("insert")
    public BaseResult insertMark(Mark mark, HttpServletRequest request) {
        UserVO userVO = (UserVO) request.getSession().getAttribute("user");

        if (userVO == null || userVO.getId() == null) {
            // 用户未登录
            return BaseResult.failed().addMsg(failedKey, ReasonEnum.NO_LOGIN.getMsg());
        }

        if (ObjectUtils.isEmpty(mark.getName())) {
            // 标签名为空
            return BaseResult.failed().addMsg(failedKey, "标签名称为空");
        }

        if (markService.getMarkByNameAndUserId(mark.getName(), userVO.getId()) != null) {
            // 标签名重复
            return BaseResult.failed().addMsg(failedKey, "标签名称已存在");
        }

        // 符合要求，添加标签
        User user = userService.getUserById(userVO.getId());
        markService.insertMark(mark);
        user.getMarks().add(mark);
        user.setLinkCount((short) (user.getLinkList().size()));
        user.setMarkCount((short) (user.getMarks().size()));
        userService.updateUser(user);
        BeanUtils.copyProperties(user, userVO);
        request.getSession().setAttribute("user", userVO);

        return BaseResult.ok().addMsg(successKey, "添加成功");
    }

    /**
     * 通过标签名称删除标签
     * @param name
     * @return
     */
    @PostMapping("delete/{name}")
    public BaseResult deleteMark(@PathVariable String name, HttpServletRequest request) {
        UserVO userVO = (UserVO) request.getSession().getAttribute("user");
        if (userVO == null || userVO.getId() == null) {
            // 未登录
            return BaseResult.failed().addMsg(failedKey, ReasonEnum.NO_LOGIN.getMsg());
        }

        if (ObjectUtils.isEmpty(name)) {
            // 标签名为空
            return BaseResult.failed().addMsg(failedKey, "标签名称为空");
        }

        Mark mark = markService.getMarkByNameAndUserId(name, userVO.getId());
        if (mark == null) {
            // 标签不存在
            return BaseResult.failed().addMsg(failedKey, "此标签不存在");
        }

        User user = userService.getUserById(userVO.getId());

        // 解除link_mark关系: 即从中间表中删除相应的记录
        mark.getLinkList().forEach(link -> {
            link.getMarks().removeIf(mark1 -> mark1.getId().equals(mark.getId()));
            linkService.insertLink(link);
            userService.insertUser(user);
        });
        user.setLinkCount((short) (user.getLinkList().size()));
        user.setMarkCount((short) (user.getMarks().size() - 1));
        userService.updateUser(user);
        BeanUtils.copyProperties(user, userVO);
        request.getSession().removeAttribute("user");
        request.getSession().setAttribute("user", userVO);
        markService.deleteMark(mark.getId());

        return BaseResult.ok().addMsg("msg", "删除成功");
    }

    /**
     * 更新标签名称
     * @param id
     * @param newName
     * @return
     */
    @PostMapping("update/{id}")
    public BaseResult updateMarkName(@PathVariable Integer id, String newName, HttpServletRequest request) {
        UserVO userVO = (UserVO) request.getSession().getAttribute("user");
        if (userVO == null || userVO.getId() == null) {
            // 未登录
            return BaseResult.failed().addMsg(failedKey, ReasonEnum.NO_LOGIN.getMsg());
        }

        if (ObjectUtils.isEmpty(newName)) {
            // 标签名为空
            return BaseResult.failed().addMsg(failedKey, "标签名称为空");
        }

        if (newName.equals(markService.getMarkById(id).getName())) {
            // 标签名称不变
            return BaseResult.ok().addMsg(successKey, "标签名称未更改");
        }

        Mark tmpMark = markService.getMarkByNameAndUserId(newName, userVO.getId());
        if (tmpMark != null) {
            // 标签名已存在
            return BaseResult.failed().addMsg(failedKey, "此标签名已存在");
        }

        Mark mark = markService.getMarkById(id);
        if (mark != null) {
            mark.setName(newName);
        }

        markService.insertMark(mark);

        return BaseResult.ok().addMsg(successKey, "标签名称修改成功");
    }

    /**
     * 通过标签名称查询标签
     * @param name
     * @return
     */
    @GetMapping("get/{name}")
    public Mark selectMark(@PathVariable String name, HttpServletRequest request) {
        UserVO userVO = (UserVO) request.getSession().getAttribute("user");
        if (userVO == null || userVO.getId() == null) {
            // 未登录
            return null;
        }

        return markService.getMarkByNameAndUserId(name, userVO.getId());
    }

    /**
     * 查询所有标签
     * @return
     */
    @GetMapping("get")
    public List<Mark> selectAllMark() {
        return markService.getAllMark();
    }
}
