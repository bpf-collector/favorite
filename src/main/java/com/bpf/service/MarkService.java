package com.bpf.service;

import com.bpf.bean.Mark;

import java.util.List;

public interface MarkService {

    // 新增标签
    Mark insertMark(Mark mark);

    // 列出所有标签
    List<Mark> getAllMark();

    // 通过ID查找标签
    Mark getMarkById(Integer id);

    // 通过 name 查找标签
    List<Mark> getMarkByName(String name);

    // 查询某用户的标签
    Mark getMarkByNameAndUserId(String name, Integer userId);

    // 删除标签
    boolean deleteMark(Integer id);

    // 更新标签名称
    Mark updateName(Integer id, String name);
}
