package com.bpf.service.impl;

import com.bpf.bean.Link;
import com.bpf.dao.LinkDao;
import com.bpf.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkDao linkDao;

    @Override
    public Link insertLink(Link link) {
        if (link == null) {
            return null;
        }
        return linkDao.saveAndFlush(link);
    }

    @Override
    public List<Link> getLinksLikeName(String name, Integer userId) {
        if (userId == null || userId <= 0)
            return null;

        if (ObjectUtils.isEmpty(name))
            return null;

        return linkDao.findLinksByNameLikeAndUserIdEquals("%"+name+"%", userId);
    }

    @Override
    public List<Link> getLinksLikeUrl(String url, Integer userId) {
        if (userId == null || userId <= 0)
            return null;

        if (ObjectUtils.isEmpty(url))
            return null;

        return linkDao.findLinksByUrlContainsAndUserIdEquals(url, userId);
    }

    @Override
    public Link getLinkByName(String name, Integer userId) {
        if (userId == null || userId <= 0)
            return null;

        if (ObjectUtils.isEmpty(name))
            return null;

        return linkDao.findLinkByNameAndUserIdEquals(name, userId);
    }

    @Override
    public Link getLinkById(Integer id) {
        if (id == null || id <= 0)
            return null;

        return linkDao.getById(id);
    }

    @Override
    public boolean deleteLinkById(Integer id) {
        if (id == null || id <= 0)
            return false;

        linkDao.deleteById(id);
        return true;
    }

    @Override
    public Link updateLink(Link link) {
        if (link == null || link.getId() == null || link.getId() <= 0)
            return null;

        return linkDao.saveAndFlush(link);
    }
}
