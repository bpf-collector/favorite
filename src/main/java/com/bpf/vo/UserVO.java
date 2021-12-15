package com.bpf.vo;

import com.bpf.bean.Link;
import com.bpf.bean.Mark;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class UserVO {

    private Integer id;
    private String name;
    private LocalDateTime createTime;
    private Byte authority;
    private Short markCount;
    private Short linkCount;
    private Set<Mark> marks;
    private List<Link> linkList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Short getMarkCount() {
        return markCount;
    }

    public void setMarkCount(Short markCount) {
        this.markCount = markCount;
    }

    public Short getLinkCount() {
        return linkCount;
    }

    public void setLinkCount(Short linkCount) {
        this.linkCount = linkCount;
    }

    public Byte getAuthority() {
        return authority;
    }

    public void setAuthority(Byte authority) {
        this.authority = authority;
    }

    public Set<Mark> getMarks() {
        return marks;
    }

    public void setMarks(Set<Mark> marks) {
        this.marks = marks;
    }

    public List<Link> getLinkList() {
        return linkList;
    }

    public void setLinkList(List<Link> linkList) {
        this.linkList = linkList;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                ", markCount=" + markCount +
                ", linkCount=" + linkCount +
                ", authority=" + authority +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserVO userVO = (UserVO) o;
        return Objects.equals(id, userVO.id) &&
                Objects.equals(name, userVO.name) &&
                Objects.equals(createTime, userVO.createTime) &&
                Objects.equals(markCount, userVO.markCount) &&
                Objects.equals(linkCount, userVO.linkCount) &&
                Objects.equals(authority, userVO.authority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createTime, markCount, linkCount, authority);
    }
}
