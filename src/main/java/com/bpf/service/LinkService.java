package com.bpf.service;

import com.bpf.bean.Link;

import java.util.List;

public interface LinkService {

    // 新增链接
    Link insertLink(Link link);

    // 通过链接名称模糊查找
    List<Link> getLinksLikeName(String name, Integer userId);

    // 通过链接URL模糊查找
    List<Link> getLinksLikeUrl(String url, Integer userId);

    // 通过链接名称查询用户的链接数据
    Link getLinkByName(String name, Integer userId);

    // 通过ID查找链接
    Link getLinkById(Integer id);

    // 通过ID删除链接
    boolean deleteLinkById(Integer id);

    // 更新链接
    Link updateLink(Link link);
}
