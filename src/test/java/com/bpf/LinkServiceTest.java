package com.bpf;

import com.bpf.bean.Link;
import com.bpf.bean.Mark;
import com.bpf.bean.User;
import com.bpf.service.LinkService;
import com.bpf.service.MarkService;
import com.bpf.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LinkServiceTest {

    @Autowired
    private LinkService linkService;

    @Autowired
    private UserService userService;

    @Autowired
    private MarkService markService;

    // 只能删除中间表中没有记录的Link，否则需要先删除中间表的记录，然后再删除t_link表
    @Test
    public void testDeleteLink() {
        User user = userService.getUserById(1);

        Link link = linkService.getLinkById(7);

        // 清除中间表记录
        Set<Mark> marks = user.getMarks();

        marks.forEach(mark -> {
            mark.getLinkList().remove(link);
            markService.insertMark(mark);
            userService.insertUser(user);
        });

        linkService.deleteLinkById(link.getId());
    }
}
