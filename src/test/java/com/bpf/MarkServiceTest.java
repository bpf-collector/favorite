package com.bpf;

import com.bpf.bean.Link;
import com.bpf.bean.Mark;
import com.bpf.bean.User;
import com.bpf.result.BaseResult;
import com.bpf.service.LinkService;
import com.bpf.service.MarkService;
import com.bpf.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MarkServiceTest {

    @Autowired
    private MarkService markService;

    @Autowired
    private UserService userService;

    @Autowired
    private LinkService linkService;

    @Test
    public void testInsertMark() {
        Mark mark = new Mark();
        mark.setName("Java");
        markService.insertMark(mark);

        System.out.println(mark);
    }

    @Test
    public void testGetMarkByName() {
        System.out.println(markService.getMarkByName("Java"));
    }

    @Test
    public void testAllMark() {
        List<Mark> markList = markService.getAllMark();
        markList.forEach(System.out::println);
    }

    @Test
    public void testDeleteMark() {
        User user = userService.getUserById(1);

        Mark mark = markService.getMarkByNameAndUserId("工具", user.getId());
        if (mark == null) {
            // 标签不存在
            System.out.println("此标签不存在");
        }

        // 解除link_mark关系: 即从中间表中删除相应的记录
        mark.getLinkList().forEach(link -> {
            link.getMarks().removeIf(linkMark -> linkMark.getId().equals(mark.getId()));
            linkService.insertLink(link);
            userService.insertUser(user);
        });
        markService.deleteMark(mark.getId());
    }

    @Test
    public void testUpdateMark() {
        int userId = 1;
        Mark mark = markService.getMarkByNameAndUserId("C", userId);
        System.out.println("mark: " + mark);
        mark = markService.updateName(mark.getId(), "Java");
        System.out.println("mark: " + mark);
    }

    @Test
    public void testListAddAll() {
        Set<String> set = new HashSet<>();
        set.add("123");
        set.add("456");
        set.add("234");

        Set<String> set2 = new HashSet<>();
        set2.add("123");
        set2.add("789");

        set.addAll(set2);

        System.out.println(set);
    }
}
