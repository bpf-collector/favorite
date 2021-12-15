package com.bpf.service.impl;

import com.bpf.bean.Mark;
import com.bpf.dao.MarkDao;
import com.bpf.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class MarkServiceImpl implements MarkService {

    @Autowired
    private MarkDao markDao;

    @Override
    public Mark insertMark(Mark mark) {
        // mark是否为空
        if (mark == null || mark.getName() == null)
            return null;

        // 插入mark
        return markDao.saveAndFlush(mark);
    }

    @Override
    public List<Mark> getAllMark() {
        return markDao.findAll();
    }

    @Override
    public Mark getMarkById(Integer id) {
        if (id == null || id <= 0)
            return null;

        return markDao.getById(id);
    }

    @Override
    public List<Mark> getMarkByName(String name) {
        if (ObjectUtils.isEmpty(name))
            return null;

        return markDao.findMarkByName(name);
    }

    @Override
    public Mark getMarkByNameAndUserId(String name, Integer userId) {
        if (ObjectUtils.isEmpty(name))
            return null;

        if (userId == null || userId <= 0)
            return null;

        return markDao.findMarkByNameAndUserIdEquals(name, userId);
    }

    @Override
    public boolean deleteMark(Integer id) {
        if (id == null || id <= 0)
            return false;

        markDao.deleteById(id);
        return true;
    }

    /**
     * 更新标签名称
     *  用于 user - mark 是 1-n 的关系，所以可以存在不同用户的标签名相同的情况。
     * @param id
     * @param name
     * @return
     */
    @Override
    public Mark updateName(Integer id, String name) {
        // 合法性检验: id, name
        if (id == null || id <= 0)
            return null;

        if (ObjectUtils.isEmpty(name))
            return null;

        Mark mark = markDao.getById(id);
        mark.setName(name);

        return markDao.saveAndFlush(mark);
    }
}
